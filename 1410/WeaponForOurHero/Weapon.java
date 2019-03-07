/*

@Author (created/edited by ) Ethan Smith
@ DATE 2/27/19 - 3/4/19
@ Assignment : Weapon for our hero
@Class : Weapon
@Favorite Color : RED

*/
public class Weapon extends Object {
	protected int damage;
	protected int durability;
	protected int price;
	// variables for subtypes of weapons, and their abilities
	protected String type;
	protected String special;
	protected String explaination;
	public Hero h1;
	// no args constructor
	public Weapon() {
		super();
		damage = 0;
		durability = 20;
		price = 10;
		h1 = null;
		special = "";
		explaination = "";
	}
	public Weapon(String name) {
		super(name);
		damage = 0;
		price = 10;
		durability = 0;
		h1 = null;
		special = "";
		explaination = "";
	}
	// all args contructor
	public Weapon(int damage, int durability) {
		super();
		this.damage = damage;
		price = 0;
		this.durability = durability;
		if (this.durability > 20) {
			this.durability = 20;
		}
		h1 = null;
	}
	// try to do a normal attack
	public boolean tryAttacking() {
		if (durability >= 0) {
			durability--;
			return true;
		}
		if (!this.name.contains("(BROKEN)")) {
			this.name = this.name + "(BROKEN)";
		}
		return false;
	}
	// try to use your special attack
	public boolean trySpecial(Hero h) {
		if (h.getMana() > 0) {
			h.setMana(h.getMana()-1);
			return true;
		}
		return false;
	}
	public void special(Hero h1,Baddy b) {
		// this is only here so that it can get overridden by a specific weapon ability, because otherwise all the special abilities would be unusable
		System.out.println("this is the nonoverloaded method and should never run, this is for testing");
	}
	public int attack(){
		if (tryAttacking()) {
			return (int) (Math.random() * damage)+1;
		}
		else {
			System.out.println("Your weapon is out of durability!");
			// you deall less damage with a broken weapon than with your fists
			return -1;
		}
	}
	public int getDamage() {
		return this.damage;
	}
	public int getDurability(){
		return this.durability;
	}
	public String getSpecial(){
		return this.special;
	}
	public String getExplaination(){
		return this.explaination;
	}
	public int getPrice() {
		return this.price;
	}
}