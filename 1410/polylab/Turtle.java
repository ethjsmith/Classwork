/*
@ Author Ethan Smith
@ DATE 3/22/19
@ Project: Polymorphism Lab
@ File: Driver
*/
public class Turtle extends Racer {
	public Turtle() {
		//super();
		name = "turtle";
	}
	public void move(Racer r){
		setLocation(getLocation()+1);
	}
}
