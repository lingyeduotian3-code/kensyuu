package ch10;

public class SuperHero {
String name ="ミナト";
int hp =100;
boolean flying;
public void attack(Matango m) {
System.out.println(this.name+"の攻撃！");
m.hp -= 5;
System.out.println("5ポイントのダメージを与えた！！");
}
public void run() {
	System.out.println(this.name+"は逃げ出した！");
}
}
