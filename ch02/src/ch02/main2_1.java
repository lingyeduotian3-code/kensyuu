package ch02;

public class main2_1 {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		System.out.println("ようこそ、森の館へ");
		System.out.println("あなたの名前を入力してね");
		String name = new java.util.Scanner(System.in).nextLine();
		System.out.println("次はあなたの名前を入力してください");
		String ageString = new java.util.Scanner(System.in).nextLine(); 
		int age = Integer.parseInt(ageString); 
	}

}
