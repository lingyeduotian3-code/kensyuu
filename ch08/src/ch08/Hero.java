package ch08;

public class Hero {

String name;
int hp;
public void sleep() {
	this.hp = 100;
	System.out.println(this.name +"は、眠って回復した！！");
}
public void sit(int sec) {
	this.hp += sec;
	System.out.println(this.name +"は、"+sec+"秒間座った！");
}
public void run() {
	System.out.println(this.name+"は、逃げ出した！");
	System.out.println("GAMEOVER");
	System.out.println("最終HPは"+this.hp+"でした");
}

}
