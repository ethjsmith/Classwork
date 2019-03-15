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

public class Baddy extends Character
{

	public Baddy()
	{
	//12.1 call the parent constructor
	super();
	}
	public Baddy(Hero h1) {
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
	this.hitPoints = (int) (h1.getHp() * Math.random()*.5);
	if (this.hitPoints < 5) {
		this.hitPoints = 5;
	}
	this.maxHp = this.hitPoints;
	this.strength = (int) (h1.getStrength() * Math.random()*.6);
	if (this.strength < 2) {
		this.strength = 2;
		this.f1 = h1.getField();
	}
}

	//13. What other functions would we need to give our villain?
	//13.1 Are the hero and baddy sufficiently different to require two classes?

	//NOW GO CHECK OUT THE DRIVER FILE
}
