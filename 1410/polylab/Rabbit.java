public class Rabbit extends Racer {
	public Rabbit() {
		//super();
		name = "rabbit";
	}
	public void move(Racer r){
		// 40% chance
		if (Math.random() > .6) {
			location = location+3;
		}
		else {
			// nothing
		}
	}
}