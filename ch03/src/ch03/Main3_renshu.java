package ch03;

public class Main3_renshu {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
System.out.println("あなたの運をみますよー");
int fortune = new java.util.Random().nextInt(4) + 1;
switch(fortune) {
case 1 -> System.out.println("大吉");
case 2 -> System.out.println("中吉");
case 3 -> System.out.println("吉");
default -> System.out.println("凶");
}
}
}
	


