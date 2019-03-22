public class Raccoon extends Racer {
	public Raccoon() {
		//super();
		name = "raccoon";
	}
	public void move(Racer r){
		// 50% chance to move twice
		location++;
		if (Math.random() > .5) {
			location ++;
		}
	}
}