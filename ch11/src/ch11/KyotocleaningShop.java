package ch11;

public class KyotocleaningShop implements CleaningService {
	String ownername;
	String adres;
	String phone;
	public Shirt washShirt(Shirt s) {
		return s;
	}public Towl washtowl(Towl t) {
		return t;
	}public Coat washcoat(Coat c) {
		return c;
	}

}
