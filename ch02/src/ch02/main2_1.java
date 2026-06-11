package ch02;

public class main2_1 {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		System.out.println("ようこそ、森の館へ");
		System.out.println("あなたの名前を入力してね");
		String name = new java.util.Scanner(System.in).nextLine();
		System.out.println("次はあなたの年齢を入力してください");
		String ageString = new java.util.Scanner(System.in).nextLine();
		int age = Integer.parseInt(ageString);
		int fortune = new java.util.Random().nextInt(4);
		fortune++;
		System.out.println("占いの結果が出ましたよー");
		System.out.println(age + "歳の" + name + "さん、あなたの運気番号は" + fortune + "です！！");
		System.out.println("1;大吉 2:中吉 3:吉 4:凶");
	}

}
