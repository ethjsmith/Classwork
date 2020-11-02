/*
@ Author Ethan Smith
@ DATE 3/22/19
@ Project: Polymorphism Lab
@ File: Rabbit
*/
public class Rabbit extends Racer {
	public Rabbit() {
		//super();
		name = "rabbit";
	}
	public void move(Racer r){
		// 40% chance
		if (Math.random() > .6) {
			setLocation(getLocation()+3);
		}
		//otherwise nothing happens, mr rabbit just sits there on the track
	}
}
