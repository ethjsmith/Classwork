/*

@Author (created/edited by ) Ethan Smith
@ DATE 2/27/19 - 3/4/19
@ Assignment : Weapon for our hero
@Class : Ritual Sword
@Favorite Color : RED

*/
public class Ritualsword extends Weapon {
	public Ritualsword(){
		super();
		name = "Ritual Sword";
		damage = (int) (Math.random()*12)+5;
		special = "lifesteal";
		explaination ="your next attack heals you the amount of damage it deals";
		price = (int) (Math.random()*16)+damage;
	}
	public void special(Hero h1,Baddy b) {
		System.out.println("You mutter an arcane enchantment, and strike with the blade, healing yourself for the damage you deal");
		int dmg = h1.getStrength() + damage +2;
		System.out.println("You deal " + dmg + " Damage, and heal the same amount");
		h1.changeHp(dmg);
		b.changeHp(dmg*-1);
	}

}