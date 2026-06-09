package ch09;

public class Hero {
String name;
int hp;
Sword sword;
public void attack() {
	System.out.println(this.name + "は、攻撃した！");
	System.out.println("敵に５ポイントのダメージを与えた！");
}


public Hero(String name) {
	this.hp = 100;
	this.name = name;
}
public Hero() {
	
this ("ダミー");
}
}
