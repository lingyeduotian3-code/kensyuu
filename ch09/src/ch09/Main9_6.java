package ch09;

public class Main9_6 {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
Hero h1 =new Hero();
h1.name = "れいや";
h1.hp = 100;
Hero h2 = new Hero();
h2.name = "せいや";
h2.hp = 89;
Wizard w = new Wizard();
w.name = "タチカワ";
w.hp = 50;
w.heal(h1);
w.heal(h2);
w.heal(h2);
	}

}
