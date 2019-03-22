public abstract class Racer {
	int location;
	String name;
	public Racer() {

	}
	//public Racer(int n,String n) {
		
	//}
	public abstract void move(Racer r);
	
	public static Racer makeRacer() {
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
			r = new Raccoon();
		}
		return r;
	}
	public void setName(String n) {
		name = n;
	}
	public String getName () {
		return name;
	}
	public void setLocation(int l) {
		location = l;
	}
	public int getLocation() {
		return location;
	}
}