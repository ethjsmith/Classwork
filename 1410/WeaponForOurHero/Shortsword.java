/*

@Author (created/edited by ) Ethan Smith
@ DATE 2/27/19 - 3/4/19
@ Assignment : Weapon for our hero
@Class : ShortSword
@Favorite Color : RED

*/
public class Shortsword extends Weapon {
	public Shortsword() {
		super();
		name = "Shortsword";
		damage = (int) (Math.random()*3)+4;
		special = "Parry";
		explaination ="Deal no damage, but reflect the next attack back on your attacker";
		price = (int) (Math.random()*6)+damage;
	}
	public void special(Hero h1,Baddy b) {
		System.out.println("Instead of attacking, you parry, reflecting " +b.getName() + "'s attack back against him");
		int dmg = b.getStrength();
		System.out.println("You reflect " + dmg +  " Damage");
		b.changeHp(dmg*-1);
		// negates damage dealt to you by just healing you for that amount secretly, before the attack lands
		// this weapon is basically a worse version of the ritual blade, unless the enemy is somehow way stronger than you...
		h1.changeHp(dmg);
	}
}