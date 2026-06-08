package ch05;

public class Main5_11 {

	public static int add(int x, int y) {
		return x + y;
	}

	public static int add(int x, int y, int z) {
		return x + y + z;
	}

	public static void main(String[] args) {
		System.out.println("x+y=" + add(56, 29));
		System.out.println("x+y+z=" + add(58, 35, 89));

	}

}
