public class Raccon extends Racer {
	public Raccon() {
		//super();
		name = "raccon";
	}
	public void move(Racer r){
		// Racoons can move a lot, but can also move backwards
		int movement = (int)(Math.random()*8)-3;
		//they can move anywhere from -3 spaces to +5 spaces ... crazy 
		setLocation(getLocation() + movement);
	}
}
