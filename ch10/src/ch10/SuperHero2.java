package ch10;

public class SuperHero2 extends Hero{
public void attack(Matango m) {
	super.attack(m);
	if(this.flying) {
		super.attack(m);
	}
}

}
