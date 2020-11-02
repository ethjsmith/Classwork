/*

@Author (created/edited by ) Ethan Smith
@ DATE 2/27/19 - 3/14/19
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

		// I guess this is more of a JRPG (heh get it ? no character creation options)
		// your name is Idiot, and there's nothing you can do about it :3
		Hero loser = new Hero("Idiot",f1,100,10);
		
		
		//Create a Hero with strength 10 and hit points 100

		//Create a 3 Bad guys with strength 5 and hit points 200

		//Create a fight function that accepts a hero and a bad guy let them fight it out
		System.out.println("I enjoyed this lab, so I went a little overboard with it");
		// heres some documentation that explains parts of the game
		System.out.println("Welcome to my RPG");
		System.out.println("===============================================");
		System.out.println("Enter anything to continue, but first read this explaination");
		System.out.println("You will be the X on the map... the T's stand for towns, and the D's stand for dungeons");
		System.out.println("There isn't a goal, or way to win, just go out and explore the world... ");
		System.out.println("Whenever you stand in a place where there is no town of dungeon you have a chance of a random encounter");
		System.out.println("This is where the fighting happens... you can use weapons, and their special abilites in combat");
		System.out.println("Dungeons are really just a chain of fights in a row, with some treasure at the end");
		System.out.println("towns have a place to rest and restore your HP and mana (for a cost), as well as a merchant, and some random events");
		System.out.println("so be sure to check that out");
		System.out.println("Your HP and MANA slowly regen as you move around the map, so don't worry too much about resting");
		System.out.println("Anyways, get out there, and explore the world, and admire all my objects");
		
		
		//special thanks to my roommate drew for playtesting, back when the game was even less fun to play...
		String z = s.nextLine();
		//makes it clear what is being printed on the screen
		//really this just prints a ton of blank lines
		Object.clearScreen();
		while (true) {
			System.out.println("===============================================");
			System.out.println("");
			travel(loser,f1,s);
		}
	}
	
	public static void moveSomeone(Hero c, int x, int y,Field f1) {
		// sets the new coordinates
		c.setX(c.getX()+x);
		c.setY(c.getY()+y);
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
		Object currentPos = f1.WhereAmI(c.getX(),c.getY());
		//System.out.println(c.getX() + ", "+c.getY());
		//System.out.println(currentPos);
		
		// checks if you're in a town, and runs the town handler for that town,
		// then checks if youre in a dungeon, and runs that handler
		// finally , if you're in neither of those places, youre in the wild, and can randomly encounter enemies or merchants
		if (f1.WhereAmI(c.getX(),c.getY()) instanceof Town) {
			((Town)f1.WhereAmI(c.getX(),c.getY())).HandleTown(c);
		}
		else if (f1.WhereAmI(c.getX(),c.getY()) instanceof Dungeon) {
			((Dungeon)f1.WhereAmI(c.getX(),c.getY())).enterdungeon(c);
		}
		else {
			// this is the random encounters , random chance to find an enemy
			if ((int) (Math.random()*2)+1 == 1) {
				Baddy b = new Baddy(c);
				b.fight(c);
			}
			//randomly encounter a traveling weapon merchant
			else if ((int) (Math.random()*2)+1 == 1) {
				System.out.println("As you are walking, you come across a traveling merchant. He has many weapons for sale");
				Merchant m = new Merchant();
				m.buyloop(c);
			}
			else {
				//nothing happens
				System.out.println("you come to a quiet field... seems like those are rare these days");
			}
		}
	}

	public static void travel (Hero h1, Field f1,Scanner s) {
		//prints the field, and asks the player where to go
		printField(f1,h1);
		System.out.println("where do you want to go?");
		System.out.println("1: Up");
		System.out.println("2: Down");
		System.out.println("3: Left");
		System.out.println("4: Right");
		System.out.println("5: Check stats/Inventoy");
		System.out.println("6: Discard Item");
		// validnumber validates your input... it's a static method in object so that all objects inherit it... very conventient
		int x = Object.validnumber(1,6);
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
		//print out your current stats.
		else if (x==5) {
			h1.showStats();
			System.out.println("~~~ Inventory: ~~~");
			h1.showInventory();
		}
		//method to get rid of a broken item
		else if (x==6) {
			discardItems(h1);
		}
		// passive regeneration... you heal 1hp&1M every time you move
		// #hiddenMechanics
		h1.changeHp(1);
		h1.setMana(h1.getMana() + 1);
	}
	// this maybe would be better as a method in character...
	public static void discardItems(Hero h1) {
		h1.showInventory();
		System.out.println("Enter the number for the item you wish to discard!");
		h1.removeItemFromInventory(Object.validnumber(1,h1.getInventory().length+1));
	}

	//draws a visual representation of the field
	public static void printField(Field f1,Hero h1) {
		for (int i=0;i<f1.getWidth();i++) {
			for (int j = 0; j<f1.getHeight(); j++){
				if (h1.getX() == j && h1.getY()==i){
					System.out.print("X ");
				}
				else if (f1.WhereAmI(j,i) instanceof Dungeon) {
					System.out.print("D ");
				}
				else if (f1.WhereAmI(j,i) instanceof Town) {
					System.out.print("T ");
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
