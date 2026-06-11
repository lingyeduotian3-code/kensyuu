package ch02;

public class Main2_renshu {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
System.out.println("ようこそ占いの館へ");
System.out.println("あなたの名前を入力してください");
String name = new java.util.Scanner(System.in).nextLine();
System.out.println("あなたの年齢を入力してください");
int age = new java.util.Scanner(System.in).nextInt();
int fortune = new java.util.Random().nextInt(4)+1;
System.out.println("占いの結果が出ました！");
System.out.println(age +"歳の" + name + "さん、あなたの運気番号は"+fortune +
		"です！");
System.out.println("大吉:1 中吉:2 吉:3 凶:4");
	}

}
