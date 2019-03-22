public class Raccon extends Racer {
	public Raccon() {
		//super();
		name = "raccon";
	}
	public void move(Racer r){
		// 50% chance to move twice
		location++;
		if (Math.random() > .5) {
			location ++;
		}
	}
}
