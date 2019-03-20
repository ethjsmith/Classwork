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

	// set the max, which would be useful if leveling up was a thing in this game...
	protected int maxHp;
	protected int maxMana;
	// added some extra stats to spice things up a bit
	protected int mana;
	// I created a variable for armor, but never really ended up using it...
	protected int armor;
	// added a third enum for undead characters ( which effects how healing effects them )
	protected enum STATUS {DEAD, ALIVE, UNDEAD};
	protected STATUS status;
	protected int gold;

	// with the introduction of merchant, I want this here, so I don't have to rewrite it upstream
	protected Weapon inventory [];
	protected int INVENTORY_SIZE = 10;

	//6. Create this no argument constructor, but notice what happens if you don't have a
	//no argument object constructor
	public Character()
	{
		//6.1 Children do not inherit constructors
		//call the base class no argument construtor first
		super();
		hitPoints = 0;
		maxHp = 0;
		strength = 0;
		mana = 10;
		maxMana = 10;
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
		this.maxHp = hitPoints;

		this.strength = strength;

		this.mana = mana;
		this.maxMana = mana;

		this.armor = armor;
		status = STATUS.ALIVE;
		gold=10;
	}


	//8. This constructor only addresses the subclass variables. What happens to the
	//inherited variables?
	public Character(int hitPoints, int strength)
	{
		this.hitPoints = hitPoints;
		this.maxHp = hitPoints;
		this.strength = strength;
		status = STATUS.ALIVE;
	}

	// these inventory systems originally existed in Hero, but I moved them here so that merchant can inherit them
	// they  aren't called in the contructor like they were in hero ( because they still are in hero) because right now I don't want baddies to have inventory
	public void initInventory() {
		for (int i = 0; i< INVENTORY_SIZE; ++i){
			inventory[i] = new Weapon("EMPTY");
		}

	}
	public boolean canAddItem() {
		//checks if there is space in the inventory to add an item
		if (inventory[inventory.length-1].getName().equals("EMPTY")) {
			return true;
		}
		else {
			return false;
		}
	}
	// it might be better to combine with canAddItem, as they should always be called together anyways
	public void addItemToInventory(Weapon item){
		for (int z=0;z<inventory.length;z++) {
			if (inventory[z].getName().equals("EMPTY")){
				inventory[z] = item;
				break;
				// dont keep looping once this happens once
			}
		}
	}
	public void showStats(){
		System.out.println("Current HP:"+ getHp()+", Current Mana: "+ getMana()+", Strength:"+ getStrength());
		System.out.println("Gold:" + getGold());
	}
	public void showInventory() {
		//prints out the contents of your inventory
		for (int r =0;r<inventory.length;r++) {
			int r2 = r+1;
			System.out.println("Item #"+r2+" Name:" + inventory[r].getName() + " , Durability: " + inventory[r].getDurability() + " , Attack: " + inventory[r].getDamage());
			System.out.println("Special Ability: " + inventory[r].getSpecial() + ", Special Explaination: " + inventory[r].getExplaination());
			System.out.println("");
		}
	}
	public void removeItemFromInventory(int item) {
		//remove an item from your inventory, and moves everything else up
		// if it didn;t work like this, it would be possible for the game to think your inventory was full even when it isn't 
		// it might be easier with a linked-list (or whatever those things are called)
		item = item-1;
		System.out.println("You throw away your " + inventory[item].getName());
		// move the discardItems method from the gameDriver over to here
		for (int r=item;r<inventory.length-1;r++) {
			inventory[r] = inventory[r+1];
		}
		inventory[inventory.length-1] = new Weapon("EMPTY");
	}
	public Weapon[] getInventory(){
		return this.inventory;
	}

	//We'll need some getters for later use, but we'll "set" with damage and heal methods
	public int getHp()
	{return hitPoints;}

	public int getStrength()
	{
		return strength;
	}
	public void setStrength(int s) {
		this.strength = s;
	}

	public int getGold() {
		return this.gold;
	}
	public void setGold(int gold) {
		// careful with this, you could easily reset the gold instead of just adding to it...
		this.gold  = gold;
	}

	//So we can test our creation

	// lol I didn't even know this was here... I wrote something just like it in like 6 lines above lol
	// ill rename it so that I can leave it in , and leave this amusing comment as well
	public void showStats2()
	{
	System.out.printf("Name: %s%n Hit Points: %d%n Strength: %d%n X = %d y = %d%n", name, hitPoints, strength, x, y );
	}

	//Is the character still alive?
	// I didn't use this at all...
	public boolean isAlive()
	{
		if (status==STATUS.DEAD) return false;
		else return true;
	}
	public void changeHp(int change) {
		// this method works for both healing and damage, for healing just pass it a negative value
		hitPoints += change;
		// can't heal above the max
		if ( hitPoints > maxHp) {
			this.hitPoints = maxHp;
		}
	}
	//methods to get and set mana
	public void setMana(int mana) {
		this.mana = mana;
		//can't go above (the max num of ) mana
		if (this.mana > maxMana) {
			this.mana = maxMana;
		}
	}
	//getters and setters at the bottom again lol
	public int getMana() {
		return this.mana;
	}
	public int getMaxMana() {
		return this.maxMana;
	}
	public void setMaxMana(int max) {
		this.maxMana = max;
	}
	public int getMaxHp() {
		return this.maxHp;
	}
	public void setMaxHp(int max) {
		this.maxHp = max;
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
