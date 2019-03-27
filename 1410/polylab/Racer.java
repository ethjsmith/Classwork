/*
@ Author Ethan Smith
@ DATE 3/22/19
@ Project: Polymorphism Lab
@ File: Driver
*/
public abstract class Racer {
	int location;
	String name;
	public Racer() {

	}
	//public Racer(int n,String n) {

	//}
	public abstract void move(Racer r);

	public static Racer makeRacer() {
		//makes a random racer from the types available
		double chance = Math.random();
		Racer r;
		if (chance > .75) {
			r = new Turtle();
		}
		else if (chance > .5) {
			r = new Rabbit();
		}
		else if (chance > .25) {
			r = new Weasel();
		}
		else {
			r = new Raccon();
		}
		return r;
	}
	//some getters and setters
	public void setName(String n) {
		name = n;
	}
	public String getName () {
		return name;
	}
	public void setLocation(int l) {
		location = l;
		//input validation so racers can't leave the track backwards
		if (location <= 0) {
			location = 0;
		}
	}
	public int getLocation() {
		return location;
	}
}
