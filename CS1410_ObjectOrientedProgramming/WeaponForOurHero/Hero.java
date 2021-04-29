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

	// if you whine about my choice to let the player use any weapon they have, then this variable is for you
	private int numberOfArms;

	//10. Constructors for hero object
	public Hero()
		{
		//10.1 Call the parents constructor and follow what happens
		super();
		inventory = null;
		numberOfArms = 2;
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
		// this is a unique weapon, there are no others like it in the game
		Katana k = new Katana("Starting Katana");
		//Shortsword s = new Shortsword();
		inventory[0] = k;
		//inventory[1] = s;
		this.maxHp = hitPoints;
		this.hitPoints = hitPoints;
		this.maxMana = 10;
		this.mana = 10;
		this.strength = strength;
		//see look, number of arms is enough to use all of the weapons at the same time... the character must be pretty tall to have this many...
		numberOfArms = 10;
		}
		public void changeHp(int change) {
// this is an overridden version of the method, which checks if you are dead whenever your hp changes

			// this method works for both healing and damage, for healing just pass it a negative value
			hitPoints += change;
			// can't heal above the max
			if ( hitPoints > maxHp) {
				this.hitPoints = maxHp;
			}
			// you can live with 0 HP lol nice
			if (hitPoints < 0) {
				death();
				// end the fakken game lel

			}
		}
		public void death() {
			System.out.println("You Died!");
			System.out.println("Enter 0 to agknowledge that you are dead");
			int z = validnumber(0,0);
			System.exit(0);
		}


	//11. What other functions would we need to give our hero?

	//NOW GO TAKE A LOOK AT THE VILLIAN FILE.
}
