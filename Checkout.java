import java.util.*;

public class Checkout {
	Rules rules;
	ArrayList<String> items = new ArrayList<String>();
	Item[] product = { new Item("ipd", 549.99), new Item("mbp", 1399.99), new Item("atv", 109.50),
			new Item("vga", 30.00) };

	public Checkout(Rules r) {
		rules = r;
	}

	public void scan(String s) {
		items.add(s);
	}

	public void showProduct() {
		System.out.print("SKUs Scanned:");
		for (int i = 0; i < items.size(); i++) {
			if (i == items.size() - 1)
				System.out.println(" " + items.get(i));
			else
				System.out.print(" " + items.get(i) + ",");
		}

	}

	public void total() {
		double t = 0;
		for (int i = 0; i < items.size(); i++) {
			for (Item it : product) {
				if (it.name == items.get(i)) {
					t += it.price;
				}
			}
		}
		System.out.println("Total expected: $" + rules.apply(t, items));
	}
}
