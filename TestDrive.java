
public class TestDrive {

	public static void main(String[] args) {
		Rules pricingRules = new Rules();
		Checkout co = new Checkout(pricingRules);
		//co.scan(products (e.g. vga, mbp ...);
		co.showProduct();
		co.total();
	}
}
