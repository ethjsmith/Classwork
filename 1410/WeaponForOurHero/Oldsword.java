/*

@Author (created/edited by ) Ethan Smith
@ DATE 2/27/19 - 3/4/19
@ Assignment : Weapon for our hero
@Class : Old Sword
@Favorite Color : RED

*/
public class Oldsword extends Weapon {
	public Oldsword() {
		super();
		name = "reliable old Sword";
		damage = (int) (Math.random()*4)+5;
		special = "Repair";
		explaination = "Apply some oil to the blade, and the sword is good to go again, like it wasn't even broken";
		price = (int) (Math.random()*13)+damage;
	}
	public void special(Hero h1, Baddy b) {
		// right to repair shouldn't just apply to electronics AMIRITE? 
		System.out.println("You quickly apply oil to the blade's edge, and just like that, it's almost good as new");
		durability = 12;
		if (damage > 7) {
			damage--;
		}
		name = "reliable old sword";
	}
}