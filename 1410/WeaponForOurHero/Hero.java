//9. Here's our hero. The hero is a ___________ which is a _____________. 
/*

@Author (created/edited by ) Ethan Smith
@ DATE 2/27/19 - 3/4/19
@ Assignment : Weapon for our hero
@Class : Hero
@Favorite Color : RED

*/
//Which is an example of ___________________.
//For placement each object has a _____________________. That's an example of 
//____________________________
//Playable hero object subclass of a Characterxs
//Dr. G 
//10-5-18
//Edited: 2-17-19


public class Hero extends Character
{
	//private Weapon inventory [];
	//protected int INVENTORY_SIZE = 10; 

	//10. Constructors for hero object
	public Hero()
		{
		//10.1 Call the parents constructor and follow what happens
		super();
		inventory = null;
		}
	
	public Hero(String name, Field f1, int hitPoints, int strength)
		{
		super();
		this.name = name;
		//Start him at position 0
		x = 1; 
		y = 1;
		//Give him a status of alive
		status = status.ALIVE;
	
		//only allow for a max of 300 hit points
		//What is this an example of?
		//if (hitPoints > 300) this.hitPoints = 300; 
		//else this.hitPoints = hitPoints;
	
		//only allow for a max of 100 strength
		//What is this an example of?
		//if (strength > 100) this.strength =100;
		//else this.strength = strength; 
	
		//create an inventory of objects for the hero to carry around
		inventory = new Weapon [INVENTORY_SIZE];
	
		//initialize inventory array
		initInventory();
		Katana k = new Katana("UgiKatana");
		Shortsword s = new Shortsword();
		inventory[0] = k;
		inventory[1] = s;
		this.maxHp = hitPoints;
		this.hitPoints = hitPoints;
		this.maxMana = 10;
		this.mana = 10;
		}
		
	//This is the reason for the name only constructor in the object class
/*	private void initInventory() {
		for (int i = 0; i< INVENTORY_SIZE; ++i){
			inventory[i] = new Weapon("EMPTY"); 
		}
		
		*/
		
		
	/*}
	public Weapon[] getInventory(){
		return this.inventory;
	}*/
	//lets you add an item to your inventory
	/*
	public void addItemToInventory(Weapon item){
		for (int z=0;z<inventory.length;z++) {
			if (inventory[z].getName().equals("EMPTY")){
				inventory[z] = item;
				break;
			}
			if (z == inventory.length && !inventory[z].getName().equals("EMPTY")) {
				System.out.println("Sorry, You can't hold anything else");
				System.out.println("If I was a better coder I'd let you drop something, but that sounds hard lol");
			}
		}	 
	}*/
	
	//11. What other functions would we need to give our hero?
	
	//NOW GO TAKE A LOOK AT THE VILLIAN FILE. 
}