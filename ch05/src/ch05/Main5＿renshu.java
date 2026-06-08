package ch05;

public class Main5＿renshu {
	public static void main(String[] args) {
		hulu(89,67,77);
		hulu(21,43,66);
		hulu(99,34,63);
	}public static void hulu(int x, int y, int z) {
		int nom = x - y - z;
		System.out.println(x + "-" + y + "-" + z + "=" + nom);
	}
}
