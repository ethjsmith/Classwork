public class Weasel extends Racer {
	public Weasel() {
		//super();
		name = "weasel";
	}
	public void move(Racer r){
		if (Math.random() > .66) {
			location++;
	}else {
		changeOther(r);
	}
	}
	public void changeOther(Racer r) {
		if (r instanceof Weasel) {
			// I don't know how ! works
		}
		else {
			r.setLocation(r.getLocation()-1);
		}
	}
}