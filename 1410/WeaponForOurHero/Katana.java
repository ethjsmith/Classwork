/*

@Author (created/edited by ) Ethan Smith
@ DATE 2/27/19 - 3/4/19
@ Assignment : Weapon for our hero
@Class : Katana
@Favorite Color : RED

*/
public class Katana extends Weapon{
	public Katana() {
		super();
		name = "Katana";
		damage = (int) ((Math.random() * 5) +7);
		special = "Bloody Blade";
		explaination = "You coat your blade in blood, taking 2 dmg, but dealing a critial strike";
		price = (int) (Math.random()*9)+damage;
	}
	// for testing with special names
	public Katana(String name) {
		super();
		this.name = name;
		damage = (int) ((Math.random() * 7) +1);
		special = "Bloody Blade";
		explaination = "You coat your blade in blood, taking 2 dmg, but dealing a critial strike";
	}
	public void special(Hero h1,Baddy b) {
		//damages you for 2, and then deals a crit
		h1.changeHp(-2);
		
		int z = (h1.getStrength() + damage + (int) (Math.random() * damage) +1);
		System.out.println("You coat your blade in blood, taking 2 dmg, but dealing a " + z + " Damage Critial strike");
		b.changeHp(z*-1);
	}
}