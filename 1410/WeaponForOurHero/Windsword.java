/*

@Author (created/edited by ) Ethan Smith
@ DATE 2/27/19 - 3/4/19
@ Assignment : Weapon for our hero
@Class : WindSword
@Favorite Color : RED

*/
public class Windsword extends Weapon {
	public Windsword() {
		super();
		name = "Wind Sword";
		damage = (int) (Math.random()*3)+4;
		special = "doublestrike";
		explaination ="Attack twice in one turn, dealing slightly less damage with both strikes";
		price = (int) (Math.random()*8)+damage;
	}
	public void special(Hero h1,Baddy b) {
		System.out.println("You quickly strike twice in a row with your Wind sword, marveling at how fast it moves");
		int dmg = h1.getStrength() + damage;
		int dmg2 = dmg-2;
		System.out.println("You deal " + dmg + " damage on the first strike, and " + dmg2 + " damage on the second strike");
		b.changeHp(((dmg*2)-2)*-1);
	}
}