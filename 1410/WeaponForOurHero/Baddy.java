/*

@Author (created/edited by ) Ethan Smith
@ DATE 2/27/19 - 3/4/19
@ Assignment : Weapon for our hero
@Class : Baddy
@Favorite Color : RED

*/

//12. We need a character for our hero to fight. What are the similarities and differences
//between this and the hero file?
//Dr. G
//10-5-18
//Edited: 2-17-19

import java.security.SecureRandom;
import java.util.Scanner;

public class Baddy extends Character
{

	public Baddy()
	{
	//12.1 call the parent constructor
	super();
	}
	public Baddy(Hero h1) {
		//creates a baddy based on the hero's stats... this is the one that's most often used
		super();
		randomize(h1);
	}

	public Baddy(String name, Field f1, int hitPoints, int strength)
	{
	SecureRandom sr = new SecureRandom();

	this.name = name;

	//place him randomly on the map, but not at 0,0
	while (x==0 & y==0)
		{
		x = sr.nextInt(f1.getWidth());
		y = sr.nextInt(f1.getHeight());
		}

	//Give him a status of alive
	status = status.ALIVE;

	//only allow for a max of 300 hit points
	if (hitPoints > 300) this.hitPoints = 300;
	else this.hitPoints = hitPoints;

	//only allow for a max of 100 strength
	if (strength > 100) this.strength =100;
	else this.strength = strength;

	//12.2 How could we have accomplished the above with a parent constructor?
}
private void randomize(Hero h1) {
	int nam = (int) (Math.random()*22)+1;
	// trying a switch statement... might be my first time writing one, I usually just use if / elseif
	switch (nam) {
		case 1:
			name = "Goblin";
			break;
		case 2:
			name = "Troll";
			break;
		case 3:
			name = "Wolf";
			break;
		case 4:
			name = "Theif";
			break;
		case 5:
			name = "Country music fan";
			break;
		case 6:
			name = "Orc";
			break;
		case 7:
			name = "Used car salesman";
			break;
		case 8:
			name = "Bandit";
			break;
		case 9:
			name ="Large Spider";
			break;
		case 10:
			name = "Even Larger Spider";
			break;
		case 11:
			name = "Largest Spider";
			break;
		case 12:
			name = "Obnoxious Child";
			break;
		case 13:
			name = "Zombie";
			break;
		case 14:
			name = "Skeleton";
			break;
		case 15:
			name = "Generic bad person";
			break;
		case 16:
			name = "Rodent of unusual size";
			break;
		case 17:
			name = "Art Major";
			break;
		case 18:
			name = "Three Dwarves in a single trenchcoat, pretending to be one Orc";
			break;
		case 19:
			name = "Three Orcs in a single trenchcoat, pretending to be one giant Dwarf";
			break;
		case 20:
			name = "Chaotic Neutral Bard";
			break;
		case 21:
			name = "Witch";
			break;
		case 22:
			name = "Time traveling Nazi";
			break;
		default:
			name = "Innocent Civilian";
			// if theres an error in my code, you as the player get to fight some random innocent person
			break;
	}
	this.hitPoints = (int) (h1.getHp() * (Math.random()*.7)+.2);
	if (this.hitPoints < 5) {
		this.hitPoints = 5;
	}
	this.maxHp = this.hitPoints;
	this.strength = (int) (h1.getStrength() * (Math.random()*.6)+.3);
	if (this.strength < 2) {
		this.strength = 2;
		this.f1 = h1.getField();
	}
}
// here is the logic for the actual fight... it's here so that you can start a fight from anywhere, just by having a baddy
public void fight(Hero h1) {
	boolean ran = false;
	//Scanner s = new Scanner(System.in);
	//generates a monster and handles the fight against the monster
	//originall it did this, but now it just uses the monster that this method is running from 
	
	
	System.out.println("As you travel, you encounter a " + this.getName());
	System.out.println("It seems a fight is inevitable");
	System.out.println("");
	while (this.getHp() > 0 && h1.getHp() > 0) {
		System.out.println("You have "+h1.getHp()+"/"+h1.getMaxHp()+":HP, "+h1.getStrength()+":Strength, and "+h1.getMana()+"/"+h1.getMaxMana()+":Mana");
		System.out.println(this.getName() + " Has "+this.getHp()+"/"+this.getMaxHp()+":Hp, and "+this.getStrength()+":Strength");
		System.out.println("-----------------");
		System.out.println("what would you like to do? ");
		// a counter to keep track of options
		int r = 0;
		// sets up combat options based on hero's inventory ( weapons )
		for (int z =0;z<h1.getInventory().length;z++) {
			// well that's pretty complicated, isn't it ?
			if (!h1.getInventory()[z].getName().equals("EMPTY")){
				r++;
				System.out.println(r + ": use " + h1.getInventory()[z].getName() + "'s Normal attack (+" + h1.getInventory()[z].getDamage() +" DMG)("+h1.getInventory()[z].getDurability()+" DUR)");
				r++;
				System.out.println(r + ": use " + h1.getInventory()[z].getName() + "'s Special attack, ");
			}
		}
		r++;
		System.out.println(r + ": Attack with your fists ( no weapon )");
		r++;
		System.out.println(r + ": Attempt to run away like a coward");

		//int x = s.nextInt();
		int x = validnumber(1,r);

		// this was probably the hardest part... im not sure if I can explain it, other than "it's magic, but it relates the users choice with the dynamic list of weapons"
		// uses the weapon that you select, or your fists if you so choose.
		if (x == r) {
			System.out.println("you run away");
			// sets a flag so you don't get loot for running away from enemies
			ran = true;
			this.changeHp(this.getHp()*-1);
		}
		else if (x ==r-1) {
			//normal fist attack
			System.out.println("You attack for " + h1.getStrength());
			this.changeHp(h1.getStrength()*-1);


		}
		else if (x > r || r < 1) {
			System.out.println("INVALID");
		}
		else {
			// count x down one, because arrays start at 0, but player input starts at 1 
			x--;
			// this basically dynamiclly uses the weapon that you choose with choice.
			if (x % 2 == 0) {
				int total= h1.getStrength() + h1.getInventory()[x/2].attack();
				System.out.println("You attack for " + total + " Using " +h1.getInventory()[x/2].getName());
				this.changeHp(total*-1);
			}
			else {
				x--;
				if (h1.getInventory()[x/2].trySpecial(h1)) {
					//special handles it's self instead of returning a value, because that allows you to do more interesting things, other than just returning a bunch of bigger numbers
					h1.getInventory()[x/2].special(h1,this);
				}
				else {
					// this is the worst thing that can happen in a fight... only time you deal no damage...
					System.out.println("You are out of mana, so your special attack failed");
				}


			}
						}
						// here your enemy attacks.
			System.out.println(this.getName() + " attacks for " + this.getStrength());
			h1.changeHp(this.getStrength()*-1);
			//System.out.println("You have " + h1.getHp()+" HP Remaining");
			//checks if you ran away
			//if (!ran) {
			//	System.out.println(this.getName() + " has "+ this.getHp()+"HP Remaining");
			//}
			System.out.println("-----------------");

	}
	handleDeath(h1,ran);

}
public void handleDeath(Hero h1,boolean ran){
	if (h1.getHp() <= 0) {
		System.out.println("You Died" );
		Scanner z = new Scanner(System.in);
		String r = z.nextLine();
		// leaves the screen open while you come to terms with the fact that you died...
		System.exit(0);
	}
	// running away is counted as death, (because it kills the monster, so you don't get any loot(gold) for "killing" it)
	// you can use this to beat dungeons really easily ( and get the loot at the end) ... this is a bug I guess
	else if (this.getHp() <= 0) {
		if (!ran) {
			System.out.println(this.getName() + " Died");
			int g = (int) (Math.random()*4)+1;
			System.out.println("You found " + g + " Gold pieces on his corpse");
			h1.setGold(h1.getGold() + g);
			System.out.println(".");
			System.out.println(".");
		}
		else {
			System.out.println("you managed to escape with your life");
		}
	}
}

	//13. What other functions would we need to give our villain?
	//13.1 Are the hero and baddy sufficiently different to require two classes?

	//NOW GO CHECK OUT THE DRIVER FILE
}
