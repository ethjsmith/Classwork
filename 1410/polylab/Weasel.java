/*
@ Author Ethan Smith
@ DATE 3/22/19
@ Project: Polymorphism Lab
@ File: Driver
*/
public class Weasel extends Racer {
	public Weasel() {
		//super();
		name = "weasel";
	}
	public void move(Racer r){
		if (Math.random() > .66) {
			setLocation(getLocation()+1);
	}else {
		changeOther(r);
	}
	}
	public void changeOther(Racer r) {
		if (!(r instanceof Weasel)) {
			// I don't know how ! works
			r.setLocation(r.getLocation()-1);
		}
	}
}
