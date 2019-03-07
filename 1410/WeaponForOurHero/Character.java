/*

@Author (created/edited by ) Ethan Smith
@ DATE 2/27/19 - 3/4/19
@ Assignment : Weapon for our hero
@Class : Character
@Favorite Color : RED

*/

//5. Character class object. Inherits from object class
//Dr. G
//10-5-18
//Edited 2-17-19


// ADD A SOUNDTRACK 
// heck yeah


public class Character extends Object
{
	//added mana to character so that enemies can have spells as well as hero
	protected int hitPoints; 
	protected int strength;
	// added some extra stats to spice things up a bit
	protected int mana;
	// I created a variable for armor, but never really ended up using it... 
	protected int armor;
	// added a third enum for undead characters ( which effects how healing effects them ) 
	protected enum STATUS {DEAD, ALIVE, UNDEAD};
	protected STATUS status;
	protected int gold;

	//6. Create this no argument constructor, but notice what happens if you don't have a
	//no argument object constructor
	public Character()
	{
		//6.1 Children do not inherit constructors 
		//call the base class no argument construtor first
		super();
		hitPoints = 0;
		strength = 0;
		mana = 10;
		armor =0;
		gold =10;
	}
	
	//7. Now comment out both constructors and watch what happens. 
	
	//a more complete constructor
	public Character(String name, Field f1, int hitPoints, int strength, int mana, int armor)
	{
		//7.1 These aren't instance variables?
		//7.2 Could we replace these with a constructor?
		this.name = name;
		this.f1 = f1; 
		//This child's instances
		this.hitPoints = hitPoints;
		this.strength = strength;
		this.mana = mana;
		this.armor = armor;
		status = STATUS.ALIVE;
		gold=10;
	}
	
	
	//8. This constructor only addresses the subclass variables. What happens to the 
	//inherited variables?
	public Character(int hitPoints, int strength)
	{
		this.hitPoints = hitPoints;
		this.strength = strength;
		status = STATUS.ALIVE;
	}
	
	//We'll need some getters for later use, but we'll "set" with damage and heal methods
	public int getHp()
	{return hitPoints;}
	
	public int getStrength()
	{
		return strength;
	}
	
	public int getGold() {
		return this.gold;
	}
	public void setGold(int gold) {
		// careful with this, you could easily reset the gold instead of just adding to it...
		this.gold  = gold;
	}
	
	//So we can test our creation
	public void showStats()
	{
	System.out.printf("Name: %s%n Hit Points: %d%n Strength: %d%n X = %d y = %d%n", name, hitPoints, strength, x, y );
	}
	
	//Is the character still alive?
	public boolean isAlive()
	{
		if (status==STATUS.DEAD) return false;
		else return true;
	}
	public void changeHp(int change) {
		// this method works for both healing and damage, for healing just pass it a negative value
		hitPoints += change;
	}
	//methods to get and set mana
	public void setMana(int mana) {
		this.mana = mana;
		//can't go above 10 mana
		if (this.mana > 10) {
			this.mana = 10;
		}
	}
	public int getMana() {
		return this.mana;
	}
	//Destroy the character and move him off the grid
	public void destroyCharacter()
	{
		x= -1;
		y= -1;
		status = STATUS.DEAD;
	}

	//MOVE TO HERO FILE
}