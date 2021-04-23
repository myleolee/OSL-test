import java.util.*;

public class Rules {
	int atv = 0;
	int ipd = 0;
	int mbp = 0;
	int vga = 0;

	public double apply(double t, ArrayList<String> items) {
		double total = t;
		for (int i = 0; i < items.size(); i++) {
			if (items.get(i) == "atv")
				atv++;
			else if (items.get(i) == "ipd")
				ipd++;
			else if (items.get(i) == "mbp")
				mbp++;
			else if (items.get(i) == "vga")
				vga++;
		}
		if (atv >= 3)
			total = discount1(total, atv);
		if (ipd > 4)
			total = discount2(total, ipd);
		if (mbp >= 1)
			total = discount3(total, items, vga, mbp);
		return total;
	}

	public double discount1(double t, int atv) {
		return t - (atv / 3) * 109.50;
	}

	public double discount2(double t, int ipd) {
		return t - ipd * 50;
	}

	public double discount3(double t, ArrayList<String> items, int vga, int mbp) {
		double r_value = t - (vga * 30.00);
		while (mbp > vga) {
			vga++;
			this.vga++;
			items.add("vga");
		}
		return r_value;
	}
}
