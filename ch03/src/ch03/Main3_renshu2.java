package ch03;

public class Main3_renshu2 {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
	int	fortune = new java.util.Random().nextInt(4);
	String s = switch(fortune) {
	case 1 -> "大吉";	
	case 2 -> "中吉";
	case 3 -> "吉";
	default -> "凶";
	};
	System.out.println("運勢は" + s);
	for (int i = 7; i > 0; i-- ) {
		System.out.println("現在" + i + "周目→");
	}
	}

}
