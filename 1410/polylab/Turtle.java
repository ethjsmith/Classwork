public class Turtle extends Racer {
	public Turtle() {
		//super();
		name = "turtle";
	}
	public void move(Racer r){
		setLocation(getLocation()+1);
	}
}
