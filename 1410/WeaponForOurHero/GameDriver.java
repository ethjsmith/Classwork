/*

@Author (created/edited by ) Ethan Smith
@ DATE 2/27/19 - 3/4/19
@ Assignment : Weapon for our hero
@Class : Driver
@Favorite Color : RED

*/

//Game driver for testing inheritance demonstration files
//Dr. G
//10-5-18
//Edited 2-17-19

//14. Now let's test our set up so far

import java.security.SecureRandom;
import java.util.Scanner;

public class GameDriver
{
	public static void main(String [] args)
	{
		// scanner for getting user input
		Scanner s = new Scanner(System.in);
		Field f1 = new Field(20,20);
		//Create a 20 x 20 field
		
		//We are going to create a test fight scenario involving a hero and a bad guy
		//For now, we'll ignore moving around the field. 
		//Can you see how this is related to your 1400 semester long project?
		
		//15. 
		//Add the ability to take damage and to heal to our hero and bad guy
		Hero loser = new Hero("Idiot",f1,200,10);
		//Baddy g1 = new Baddy("goblin2", f1,25,1);
		//Baddy g2 = new Baddy("goblin1",f1,25,1);
		//Baddy g3 = new Baddy("Goblin69",f1,23,2000);
		//moveSomeone(loser);
		//fight(loser,g1);
		//Create a Hero with strength 10 and hit points 100

		//Create a 3 Bad guys with strength 5 and hit points 200
		
		//Create a fight function that accepts a hero and a bad guy let them fight it out
		while (true) {
			//makes it clear what is being printed on the screen
			System.out.println("===============================================");
			System.out.println("");
			System.out.println("");
			System.out.println("");
			travel(loser,f1,s);
		}
	}
	public static int validnumber (int min,int max) {
		//this method returns a verified number between min and max, for use with all those choices you have to make
		int num =0;
		Scanner s = new Scanner(System.in);
		boolean valid = false;
		while (!valid) { 
			try {
				num = s.nextInt();
				if (num >= min && num <= max) {
					valid = true;
				}else {
					throw new Exception("wrong number");
				}
			}
			catch (Exception E) {
				s.nextLine();
				System.out.println("please enter an INT between " + min  +" and " + max);

			}
		}
		return num;
	}
	public static void moveSomeone(Hero c, int x, int y,Field f1) {
		// sets the new coordinates
		c.setX(c.getX()+x);
		c.setY(c.getY()+y);
		// random encounter, pokemon style, you have a chance to run into an enemy
		// if you don't see an enemy, something else might happen...
		if ((int) (Math.random()*2)+1 == 1) {
			randomencounter(c);
		}
		else if ((int) (Math.random()*2)+1 == 1) {
			shopkeeper(c);
		}
		else {
			System.out.println("you come to a quiet field... seems like those are rare these days");
		}
		
		// lets your character wrap on the map, going to the top, or the bottom.
		if (c.getX() < 0) {
			c.setX(f1.getWidth()-1);
		}
		else if (c.getX() > f1.getWidth()-1){
			c.setX(0);
		}
		if (c.getY() < 0) {
			c.setY(f1.getHeight()-1);
		}
		else if (c.getY() > f1.getHeight()-1) {
			c.setY(0);
		}
	}
	// randomly come across a shopkeeper...
	public static void shopkeeper(Hero h1) {
		Weapon ary[] = new Weapon[3];
		Scanner s = new Scanner (System.in);
		System.out.println("As you are walking, you come across a traveling merchant. He has many weapons for sale");
		System.out.println("He shows you a few, and asks if you would like to purchase any");
		System.out.println("You have " + h1.getGold() + " Gold pieces");
		//creates a random inventory for the shopkeeper
		for (int z=0;z<3;z++){
			int r = (int) (Math.random()*5)+1;
			if (r == 1) {
				ary[z] = new Katana();
			}
			else if (r ==2 ) {
				ary[z] = new Ritualsword();
			}
			else if (r==3) {
				ary[z]= new Windsword();
			}
			else if (r==4) {
				ary[z] = new Shortsword();
			}
			else {
				ary[z] = new Oldsword();
			}
		}
			int temp = 0;
			for (int z=0;z<3;z++){
				temp = z+1;
				System.out.println(temp + ": Purchase " + ary[z].getName() +"["+ ary[z].getDamage()+" DMG] For " + ary[z].getPrice() + " Gold pieces");
			}
			temp++;
			System.out.println(temp + ": Leave without buying anything");
			//int choice = s.nextInt();
			int choice = validnumber(1,temp);
			if (choice == temp) {
				System.out.println("you shrug your shoulders, and continue on your journey");
			}
			else {
				if (h1.getGold() >= ary[choice-1].getPrice()) {
					h1.addItemToInventory(ary[choice-1]);
					h1.setGold(h1.getGold() - ary[choice-1].getPrice());
					System.out.println("You have aquired the " + ary[choice-1].getName());
					System.out.println("The merchant thanks you for your business, and continues on his way");
				}
				else {
					System.out.println("You don't have enough money");
					System.out.println("Stop wasting my time, curses the merchant, as he continues down the road...");
				}
			}
			
	}
	//creates a monster for you to fight against, which is both random, and near you in stats

	public static Baddy generatemonster(Hero h1){
		String name = "";
		int nam = (int) (Math.random()*8)+1;
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
			default:
				name = "Innocent Civilian";
				// if theres an error in my code, you as the player get to fight some random innocent person
				break;
		}
		int badhp = (int) (h1.getHp() * Math.random()*.4);
		if (badhp < 5) {
			badhp = 5;
		}
		int badstrength = (int) (h1.getStrength() * Math.random()*.3);
		if (badstrength < 2) {
			badstrength = 2;
		}
		Baddy b = new Baddy(name, h1.getField(),badhp,badstrength);
		return b;
	}
	// this is the random encounter ( and fight ) handler 
	public static void randomencounter(Hero h1) {
		boolean ran = false;
		Scanner s = new Scanner(System.in);
		//generates a monster and handles the fight against the monster
		Baddy b = generatemonster(h1);
		System.out.println("As you travel, you encounter a " + b.getName());
		System.out.println("It seems a fight is inevitable");
		while (b.getHp() > 0 && h1.getHp() > 0) {
			System.out.println("what would you like to do? ");
			// a counter to keep track of options
			int r = 0;
			// sets up combat options based on hero's inventory ( weapons )
			for (int z =0;z<h1.getInventory().length;z++) {
				// well that's pretty complicated, isn't it ?
				if (!h1.getInventory()[z].getName().equals("EMPTY")){
					r++;
					System.out.println(r + ": use " + h1.getInventory()[z].getName() + "'s Normal attack");
					r++;
					System.out.println(r + ": use " + h1.getInventory()[z].getName() + "'s Special attack, ");
				}
			}
			r++;
			System.out.println(r + ": Attack with your fists ( no weapon )");
			r++;
			System.out.println(r + ": Attempt to run away like a coward");
			
			
			/* Static system *
			System.out.println("1: Normal attack(fists?)");
			System.out.println("2: Use Weapon");
			System.out.println("3: Weapon Special attack");
			System.out.println("4: Run away like a coward");
			*/
			
			
			//int x = s.nextInt();
			int x = validnumber(1,r);
			
			// this was probably the hardest part... im not sure if I can explain it, other than "it's magic, but it relates the users choice with the dynamic list of weapons"
			if (x == r) {
				System.out.println("you run away");
				// this is a bit hackish, but when you attempt to run away, it just kills the enemy...
				ran = true;
				b.changeHp(b.getHp()*-1);
			}
			else if (x ==r-1) {
				//normal fist attack
				System.out.println("You attack for " + h1.getStrength());
				b.changeHp(h1.getStrength()*-1);

				
			}
			else if (x > r || r < 1) {
				System.out.println("INVALID");
			}
			else {
			
				x--;
				if (x % 2 == 0) {
					int total= h1.getStrength() + h1.getInventory()[x/2].attack();
					System.out.println("You attack for " + total + " Using " +h1.getInventory()[x/2].getName());
					b.changeHp(total*-1);
				}
				else {
					x--;
					//System.out.println("you use your special attack, which is not yet implimented");
					//System.out.println("this is for the " + h1.getInventory()[x/2].getName());
					if (h1.getInventory()[x/2].trySpecial(h1)) {
						h1.getInventory()[x/2].special(h1,b);
					}
					else {
						System.out.println("You are out of mana, and so your special attack failed");
					}
					
					
				}
							}
				System.out.println(b.getName() + " attacks for " + b.getStrength());
				h1.changeHp(b.getStrength()*-1);
				System.out.println("You have " + h1.getHp()+" Remaining");
				if (!ran) {
					System.out.println(b.getName() + " has "+ b.getHp()+" Remaining");
				}
				System.out.println("-----------------");
				
							
							
							
			// this part of code didn't work so i commented it out to try something else, and I hate deleting commented code, because you never know if you'll want to go back to that...				
			/*else if (x==(r/2)) {
				int total= h1.getStrength() + h1.getInventory()[x].attack();
				System.out.println("You attack for " + total);
			}
			else if (x==4) {
				System.out.println("try something else for now bith");
			}
			else {
				System.out.println("INVALID");
			}*/
		}
		handleDeath(h1,b,ran);
		
	}
	public static void handleDeath(Hero h1,Baddy b,boolean ran){
		if (h1.getHp() <= 0) {
			System.out.println("You Died" );
			Scanner z = new Scanner(System.in);
			int r = z.nextInt();
			// leaves the screen open while you come to terms with the fact that you died...
			System.exit(0);
		}
		else if (b.getHp() <= 0) {
			if (!ran) {
				System.out.println(b.getName() + " Died");
				int g = (int) (Math.random()*4)+1;
				System.out.println("You found " + g + " Gold pieces on his corpse");
				h1.setGold(h1.getGold() + g);
			}
			else {
				System.out.println("you managed to escape with your life");
			}
		}
	}
	// this was the fight I made for the ICE, but I don't think Im using it anymore
	public static void fight(Hero h1,Baddy b1)
	{
		System.out.println("You encounter an enemy " + b1.getName());
		
	
		//Battle until the bad guys hit points are 0 or lower
		while (h1.getHp() > 0 && b1.getHp() > 0){
			// I've rebalanced the encounter so that hero and baddy attack at the same time... would otherwise make instakill weapons overpowered
			
			//Hero attacks
			System.out.println("You attack for " + h1.getStrength());
			b1.changeHp(h1.getStrength()*-1);
			//enemy attacks
			System.out.println("enemy attacks for " + b1.getStrength());
			h1.changeHp(b1.getStrength()*-1);
			// shows the fight progressing
			System.out.println("You have " + h1.getHp()+" Remaining");
			System.out.println(b1.getName() + " Has "+ b1.getHp()+" Remaining");
			System.out.println("-----------------");
		}
		
		//show the outcome of the battle
		if(b1.getHp() <= 0) {
				System.out.println(b1.getName() + " has died... you are victorious!");
				if (h1.getHp() < 0) {
					System.out.println("Unfortunately, you died of your wounds before you are able to enjoy your victory");
					// end the "game" here 
				}
			}
			else {
					System.out.println("YOU DIED... git gud");
					// end the "game" here
			}
				
	}
	
	public static void travel (Hero h1, Field f1,Scanner s) {
		printField(f1,h1);
		System.out.println("where do you want to go?");
		System.out.println("1: Up");
		System.out.println("2: Down");
		System.out.println("3: Left");
		System.out.println("4: Right");
		System.out.println("5: Check stats/Inventoy");
		System.out.println("6: Discard broken weapons");
		// test code to check where you currently are
		//System.out.println(h1.getX() +","+ h1.getY());
		//int x = s.nextInt();
		int x = validnumber(1,6);
		// moves your character based on your actions
		if (x == 1) {
			moveSomeone(h1,0,-1,f1);
		}
		else if (x==2) {
			moveSomeone(h1,0,1,f1);
		}
		else if (x==3) {
			moveSomeone(h1,-1,0,f1);	
		}
		else if (x==4) {
			moveSomeone(h1,1,0,f1);
		}
		else if (x==5) {
			System.out.println(h1.getHp() + ":Current HP , " + h1.getMana() + ":Current Mana , " + h1.getStrength() + ":Strength ");
			System.out.println("~~~ Inventory: ~~~");
			for (int r = 0;r<h1.getInventory().length;r++){
				System.out.println("Name:" + h1.getInventory()[r].getName() + " , Durability: " + h1.getInventory()[r].getDurability());
				System.out.println("Special Ability: " +h1.getInventory()[r].getSpecial() + ", Special Explaination: " + h1.getInventory()[r].getExplaination());
				System.out.println("");
			}
		}
		else if (x==6) {
			System.out.println("You dump your broken weapons in a bush... this is technically litering, but you don't see anyone around, so hopefully you're good");
			discardItems(h1);
		}
		// I don't think this ever gets called anymore, because I wrote a better (less mean) input validation method right when the variable gets called in
		else {
			// dont cause invaid unput please
			System.out.println("if you're too dumb to pick a valid number Ill pick one for you");
			System.out.println("also I'm dealing 1 dmg to you, because that should teach you to input invalid input");
			h1.changeHp(-1);
			moveSomeone(h1,0,1,f1);
		}
		// passive regeneration... you heal 1hp&1M every time you move 
		// #hiddenMechanics
		h1.changeHp(1);
		h1.setMana(h1.getMana() + 1);
	}
	public static void discardItems(Hero h1) {
		//removes broken weapons from your inventory
		// be careful to not accidentally purge your Oldsword if you don't repair it after a battle...
		for (int h=0;h<h1.getInventory().length;h++) {
			if (h1.getInventory()[h].getDurability() < 0) {
				for (int r=h;r<h1.getInventory().length-1;r++) {
					h1.getInventory()[r] = h1.getInventory()[r+1];
				}
				h1.getInventory()[h1.getInventory().length-1] = new Weapon("EMPTY");
			}
		}
	}
	
	//draws a visual representation of the field 	
	public static void printField(Field f1,Hero h1) {
		for (int i=0;i<f1.getWidth();i++) {
			for (int j = 0; j<f1.getHeight(); j++){
				if (h1.getX() == j && h1.getY()==i){
					System.out.print("X ");
				}
				else {
					System.out.print(". ");
				}
			}
			System.out.println("");
		}
		System.out.println("");
	}
	
	
}