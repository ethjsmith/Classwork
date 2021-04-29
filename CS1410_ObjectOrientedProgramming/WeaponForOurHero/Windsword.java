/*

@Author (created/edited by ) Ethan Smith
@ DATE 2/27/19 - 3/4/19
@ Assignment : Weapon for our hero
@Class : WindSword
@Favorite Color : RED

*/
// a sword that's as fast as the wind... 
public class Windsword extends Weapon {
	public Windsword() {
		super();
		name = "Wind Sword";
		damage = (int) (Math.random()*3)+4;
		special = "doublestrike";
		explaination ="Attack twice in one turn, dealing slightly less damage with both strikes";
		price = (int) (Math.random()*8)+damage;
	}
	//in the special of each weapon, control of the program is handed over, and the game actually handles that part of the fight right here
	// that makes it so you can do more interesting things than just returning a bigger( or smaller) damage number
	// for example, this method has you attack twice, which is cool, and can't really work if this method just returned a number
	public void special(Hero h1,Baddy b) {
		System.out.println("You quickly strike twice in a row with your Wind sword, marveling at how fast it moves");
		//deals between (roughly) 55% and 80% damage ( but you do it twice, so it'll be better than a single 100% attack
		int dmg = (int)((h1.getStrength() + damage)*(Math.random()*.3)+.55);
		b.changeHp(dmg*-1);
		System.out.print("You deal " + dmg + " damage on the first strike,");
		dmg = (int)((h1.getStrength() + damage)*(Math.random()*.3)+.55);
		b.changeHp(dmg*-1);
		System.out.println("and " + dmg + " damage on the second strike");
	}
}