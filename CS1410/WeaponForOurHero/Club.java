/*

@Author (created/edited by ) Ethan Smith
@ DATE 3/14/19
@ Assignment : Weapon for our hero
@Class : Character
@Favorite Color : RED

*/
// a generic club, which is a buyable weapon from the merchant
public class Club extends Weapon {
	public Club() {
		super();
		name = "Wooden Club";
		damage = (int) (Math.random()*10)+6;
		special = "Heavy Strike";
		explaination = "you strike as hard as you can, dealing a crit based only on strength( no weapon dmg added)";
		price = (int) (Math.random()*15)+damage;
	}
	// this is a boring, uninspired special attack....
	// I actually made club as a replacement for ritual sword ( which was originally purchasable) but it is now a rare town event item, and I wanted 
	// the merchant to sell more than like 2 things...
	public void special(Hero h1,Baddy b) {
		int dmg = h1.getStrength() * (int)(Math.random()*3)+2;
		System.out.println("You strike with your club with all your might, dealing " + dmg + " Damage");
		b.changeHp(dmg*-1);
	}
}