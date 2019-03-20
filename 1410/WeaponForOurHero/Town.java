/*

@Author (created/edited by ) Ethan Smith
@ DATE 3/14/19
@ Assignment : Weapon for our hero
@Class : Character
@Favorite Color : RED

*/
public class Town extends Object {
	Merchant m = new Merchant();
	boolean townsman;
	int price;
	public Town() {
		super();
		price = (int)(Math.random()*10)+7;
		townsman = false;
	}
	public void nameGenerate() {
		//it would be cool to have a random town name for every town... sounds like a bit of a pain tho
		// if there is code in this method it means that I decided to do it
	}
	public void PrintTownOptions() {
		//townsman is a  variable that basically checks if you've already done a special event in town... 
		// you can only do 1 special event per town, otherwise it wouldn't make sense lore-wise, if you kept getting mugged by the same group of thugs
		if (!townsman) {
		System.out.println ("You come to a small town, with a shopkeeper, and an inn");
		System.out.println("1: Go check what the merchant has for sale");
		System.out.println("2: Go check the price to stay at the inn");
		System.out.println("3: Talk to the civilians in the town");
		System.out.println("4: Check stats/inventory");
		System.out.println("5: Discard Item");
		System.out.println("6: Leave the town");
		}
		else {
		System.out.println ("You come to a small town, with a shopkeeper, and an inn");
		System.out.println("1: Go check what the merchant has for sale");
		System.out.println("2: Go check the price to stay at the inn");
		System.out.println("3: Check stats/inventory");
		System.out.println("4: Discard Item");
		System.out.println("5: Leave the town");	
		}
		
	}
	public void merchant(Hero h1) {
		// calls the merchant... wow how complicated
		m.buyloop(h1);
	}
	// probably this should be it's own object, but it's only ever used in town, so its probably fine
	public void inn(Hero h1) {
		System.out.println("You head to the INN, where you can stay the night");
		System.out.println ("1: Pay ("+ price +" GOLD) to stay and rest for the night(HEAL ALL HP and MANA)");
		System.out.println("2: Leave the INN");
		int choice = this.validnumber(1,2);
		if (choice == 1) {
			if (h1.getGold() >= price) {
				System.out.println("You pay the innkeeper for a room, where you rest the night, quickly healing from your wounds");
				// this is hackish... it relies on input validation on the other end, and if you somehow get above a million hp you wont fully heal, which is bad, because enemies scale just like you
				
				h1.changeHp(100000);
				h1.setMana(10000);
				h1.setGold(h1.getGold()-price);
			}
			else {
				System.out.println("Sorry, you don't have enough money to stay here");
			}
		}
		else {
			System.out.println("You decide not to stay this time");
		}
	}
	public void HandleTown(Hero h1) {
		//handles the town... 
		boolean intown = true;
		//townsman = false;
		while (intown) {
			PrintTownOptions();
			if (!townsman) {
				int choice = this.validnumber(1,6);
				if (choice ==1 ) {
					merchant(h1);
				}
				else if (choice == 2) {
					inn(h1);
				}
				else if (choice ==3 ) {
					people(h1);
					System.out.println("");
					System.out.println("");
				}
				else if (choice ==4) {
					h1.showStats();
					h1.showInventory();
				}
				else if (choice ==5) {
					h1.showInventory();
					System.out.println("Enter the number for the item you wish to discard!");
					h1.removeItemFromInventory(Object.validnumber(1,h1.getInventory().length+1));
				}
				else {
					// leave the town
					intown = false;
					
				}
			}else {
				int choice = this.validnumber(1,5);
				if (choice ==1 ) {
					merchant(h1);
				}
				else if (choice == 2) {
					inn(h1);
				}
				else if (choice ==3) {
					h1.showStats();
					h1.showInventory();
				}
				else if (choice ==4) {
					h1.showInventory();
					System.out.println("Enter the number for the item you wish to discard!");
					h1.removeItemFromInventory(Object.validnumber(1,h1.getInventory().length+1));
				}
				else {
					// leave the town
					intown = false;
					
				}
			}
		}
	}
	//if you pick to talk to the townspeople it picks a random "story method"
	// everything below this point is basiclly just a bunch of if/elseif/else statement trees to add some RPG elements to the game
	// some interesting stuff can happen here... it's kind of inbalanced, because most of the time you're going to loose (money or hp, or weapons), 
	// and most of the rewards aren't great ( although there is some stuff that you can only get here ) 
	public void people (Hero h1) {
		int who = (int)(Math.random()*4)+1;
		if (who == 1) {
			encounter1(h1);
		}
		else if (who == 2) {
			encounter2(h1);
		}
		else if (who == 3) {
			encounter3(h1);
		}
		else {
			encounter4(h1);
		}
		townsman = true;
	}
	public void encounter1 (Hero h1) {
		int price = (int)(Math.random()*10)+5;
		System.out.println("You meet a villager to claims to have a potion that can increase your health and strength");
		System.out.println("He offers to sell it to you for only " + price + " Gold pieces");
		System.out.println("You have " + h1.getGold() + "GOLD");
		System.out.println("1: Buy the potion for " + price + " GOLD");
		System.out.println("2: Decline the offer");
		int choose = validnumber(1,2);
		if (choose == 1) {
			//drink the potion
			if (h1.getGold() >= price) {
				h1.setGold(h1.getGold()-price);
				System.out.println("You buy the potion, and immediatly drink it");
				if (Math.random() > .5) {
					System.out.println ("You feel yourself get stronger... that town'smans potion was legit!");
					System.out.println("");
					System.out.println("");
					h1.setMaxHp(h1.getMaxHp()+5);
					h1.setStrength(h1.getStrength()+3);
				}else {
					System.out.println("Your vision immediately goes dark");
					System.out.println("You wake up laying in a bathtub filled with Ice");
					System.out.println("There is a scar in your stomache, and it feels like something was cut out of you");
					System.out.println("you feel permanently weaker");
					System.out.println("");
					System.out.println("");
					h1.setMaxHp(h1.getMaxHp()-5);
					h1.setStrength(h1.getStrength()-1);
				}
			}
			else {
				System.out.println("You don't have enough money!");
			}
		}
		else {
			// don't purchase the potion
			System.out.println("You Decide not to purchase it, it seems like a risk");
		}
	}
	public void encounter2(Hero h1) {
		// Yo dawg, I heard you liked complicated RPG quests
		
		System.out.println("you meet a fair maiden who seems down for a tumble in the bushes");
		System.out.println("1: Go with her, and indulge in some sinful unmarried sex");
		System.out.println("2: Save yourself for marriage, like a good servant of God");
		int choose = validnumber(1,2);
		if (choose == 1) {
			double result = Math.random();
			if (result > .6) {
				System.out.println("You head into the woods, when suddenly you're surrounded by a bunch of thugs... It was a setup");
				System.out.println("The thugs take all of your money, and leave you half naked in the bushes");
				System.out.println("");
				System.out.println("");
				h1.setGold(0);
			}
			else if (result > .35) {
				System.out.println("you head into the woods, and things start to get heated... suddenly the maiden starts to cry");
				System.out.println("You ask her what's wrong, and she says that she shouldn't be doing such sinful things");
				System.out.println("But she's so taken with an attractive adventurer like you");
				System.out.println("1: tell her you understand, and suggest you just head back to the village");
				System.out.println("2: Tell her that it's not a big deal, and there's actually no god, so she shouldn't feel bad about this");
				int c2 = validnumber(1,2);
				if (c2 == 1) {
					System.out.println("The maiden thanks you for being so honorable, and rewards you with a kiss, which increases your strengh");
					h1.setStrength(h1.getStrength()+1);
					System.out.println("You head back to the village, and enjoy the rest of your evening in solitude");
					System.out.println("");
					System.out.println("");
				}else {
					System.out.println("That was the wrong thing to say, you realize, as the young woman starts screaming about heresy... you probably should have gotten to know her a bit better before coming out here");
					System.out.println("Suddenly, she whips out a small knife, and starts stabbing you in the chest repeatedly");
					h1.setMaxHp(h1.getMaxHp()-5);
					h1.changeHp(-15);
					System.out.println("You draw your sword to defend yourself...");
					System.out.println("1: Attack");
					System.out.println("2: Run away");
					int c3 = validnumber(1,2);
					if (c3 == 1) {
						System.out.println("you quickly cut down the girl... hopefully you weren't RP-ing as Lawful good");
						System.out.println("suddenly a bunch of townpeople who heard the commotion come running into the clearing where you are!");
						System.out.println("you have no choice but to defend yourself. luckily these people aren't much for fighting, and you cleave through them easily");
						System.out.println(" you end up back in the town center, having killed anyone who witnessed your crimes... You still probably shouldn't stick around much longer");
						System.out.println("");
						System.out.println("");
					}else {
						System.out.println("You run away, leaving the girl unhurt... really this is your fault, so it's not fair to attack a young maid");
						System.out.println("");
						System.out.println("");
					}
				}
			}
			else if (result > .25) {
				System.out.println("You find a nice clearing in the woods near the village, when suddenly something hits you over the head");
				System.out.println("when you wake up you find that the girl stole all of your weapons, and ran off");
				h1.initInventory();
				System.out.println("Luckily she left the frying pan that she attacked you with");
				Weapon z = new FryingPan();
				h1.addItemToInventory(z);
				System.out.println("");
				System.out.println("");
			}
			else {
				System.out.println("You find a nice clearing , when suddenly a bunch of cultists jump out and grab you");
				System.out.println("This was all just a trap to get a human sacrifice for a twister ritual");
				System.out.println("The head cultist offers you a choice... face the wrath of their god, or become the cult's champion");
				System.out.println("1: Face their god");
				System.out.println("2: Claim you will become their champion");
				int c3 = validnumber(1,2);
				if (c3 ==1) {
					System.out.println("you decide to face their god");
					if (Math.random() > .5) {
						System.out.println("you suddenly see their god. He is impressed with your boldness, and grants you great strength");
						System.out.println("The cult leader praises you, saying you are blessed. he apologizes for the inconvience, and wishes you well");
						h1.setStrength(h1.getStrength()+7);
						System.out.println("1: Attack the cultists now that they don't suspect you");
						System.out.println("2: Thank the cult, and continue on your way");
						int c4 = validnumber(1,2);
						if (c4 ==1 ) {
							System.out.println("You suddenly attack the cultists, your newfound strength makes it trivial to conqure them");
							System.out.println("you find a Special ritual sword among their corpses");
							Weapon z = new Ritualsword();
							if (h1.canAddItem()) {
								System.out.println("It will serve you well");
								h1.addItemToInventory(z);
							}
							else {
								System.out.println("unforunately you can't carry anything else");
							}
							System.out.println("");
							System.out.println("");
						}else {
							System.out.println("you thank the cult, and leave the clearing, enjoying your new strength");
							System.out.println("");
							System.out.println("");
						} 
					}else {
						System.out.println("Their god suddenly appears before you... He laughs, and calls you pathetic, and with a snap of his fingers, he burns away much of your lifeforce");
						System.out.println("The cultists laugh and kick your significantly weakened body around, before leaving you in the forest.");
						h1.setMaxHp((int) (h1.getMaxHp() * .66));
						// triggers the check if your hp gets too high, setting it to the max
						h1.changeHp(1);
						System.out.println("");
						System.out.println("");
					}
				}else {
					System.out.println("You promise to become the cults champion.");
					System.out.println("The cult leader gives you a slip of paper with orders to do many nasty things, like assassinate various townsmen, and steal things");
					System.out.println("You head back into the village, and throw the paper into the fire");
					System.out.println("It would probably be best if you got out of here fast, before the cult realizes that you're skipping out on them");
					System.out.println("");
					System.out.println("");
				}
			}
		}else {
			System.out.println("you tell the girl you're flattered, but you're saving yourself for marriage");
			if (Math.random() > .5) {
				System.out.println("She laughs, and says that she's trying to find some comfort outside her marriage");
				System.out.println("You make a quick getaway, glad to have dodged that bullet");
				System.out.println("");
				System.out.println("");
			}else {
				System.out.println("She knods in respect, and claims that she is actually a nun, out in the world testing the resolve of men");
				System.out.println("She gives you a few gold pieces as a reward for virtue");
				h1.setGold(h1.getGold()+3);
				System.out.println("");
				System.out.println("");
			}
		}
	}
	public void encounter3(Hero h1) {
		System.out.println("As you stroll around the town you see a house with an open window... nobody seems to be home");
		System.out.println("1: Close the window");
		System.out.println("2: Sneak in and see if there's anything valuable");
		int c1 = validnumber(1,2);
		if (c1 == 1) {
			System.out.println("you close the window... wouldn't want any potential theives to get the wrong idea");
		}else {
			System.out.println("you sneak inside, and start to look around");
			if (Math.random() > .5) {
				System.out.println("you are searching some cubbords when you hear a noise from the other room... you only have time to check one more place");
				System.out.println("1: Check the chest near the table");
				System.out.println("2: Check the closet");
				int notaChoicelol = validnumber(1,2);
				double num = Math.random();
				if (num > .75) {
					System.out.println("you find a Frying Pan... apparently they make decent weapons!");
					if (h1.canAddItem()) {
						Weapon z = new FryingPan();
						h1.addItemToInventory(z);
						System.out.println("you make a quick escape with your loot");
					}else {
						System.out.println("but you can't carry anything else, so you run away empty handed");
					}
				}else if (num > .3) {
					System.out.println("you find a handful of gold coins, which you grab on the way out the window");
					h1.setGold(h1.getGold()+(int)(Math.random()*4)+2);
				}
				else {
					System.out.println("you find nothing of value, but it's too late to check anything else, so you scurry out the window");
				}
			}else {
				int g = (int) (Math.random()*10)+3;
				Weapon w = Weapon.MakeWeapon();
				System.out.println("Without anyone to bother you, you loot the entire place, stealing " + g + "Gold, and a " + w.getName());
				if (h1.canAddItem()) {
					h1.addItemToInventory(w);
				}
				else {
					System.out.println("you can't carry any more weapons, so you leave it");
				}
			}
		}
	}
	public void encounter4(Hero h1) {
		// yo dawg I heard you liked quests that are based entirely on RNG 
		// good luck on that 50 gold quests
		
		// also this one is a bit buggy, because of the 50 gold one only showing up if you have 50 gold...
		// and I think you can still pick 4, even when it's not on the list... whoops
		System.out.println("you come across a begger, who asks for a coin so that he can buy some bread for the night");
		System.out.println("1:Give him nothing");
		System.out.println("2: Give him 1 Gold");
		System.out.println("3: Give him 10 Gold");
		if (h1.getGold() > 50) {
			System.out.println("4: Give him 50 gold");
		}
		int c1 = validnumber(1,4);
		if (c1 == 1) {
			System.out.println("you say no, and the begger flips you the bird");
		}else if (c1 == 2) {
			if (h1.getGold() > 1) {
				h1.setGold(h1.getGold()-1);
				System.out.println("You give the begger 1 gold. He thanks you, and offers you a lucky charm that he's carried for a long time... apparently it makes you slightly stronger");
				System.out.println("You thank him for this gift, and put it on, feeling yourself become slightly stronger");
				h1.setMaxHp(h1.getMaxHp()+3);
			}else {
				System.out.println("You apologize, saying that you can't afford to give anything");
			}
		}else if (c1 == 3) {
			if (h1.getGold() > 10) {
				h1.setGold(h1.getGold()-10);
				System.out.println("the begger thanks you, and offers you an old amulet, which he claims will increase your max mana");
				System.out.println("you take it, and feel your mind expand");
				h1.setMaxMana(h1.getMaxMana()+1);
				if (Math.random() > .55) {
					System.out.println("Later that night you see the begger laying in the street again. You go to ask him why he is still outside(after all you gave him a fair sum), but when you reach him you realize that he is dead");
					System.out.println("You see a pile of white poweder on the ground next to him... seems that a sum of money that great was dangerous for the man");
				}
			}else {
				System.out.println("You apologize, saying that you can't afford to give anything");
			}
		}else {
			if (h1.getGold() > 50) {
				h1.setGold(h1.getGold()-50);
				if (Math.random() > .5) {
					System.out.println("The begger spits in your face, and calls you a moron for spending that much gold on one person, then runs off before you can react");
				}else {
					System.out.println("the begger thanks you, and pulls from his bag a potion, which he claims gives marvelous powers, and he's been saving it for if he was truely desparate");
					System.out.println("He warns that it could be dangerous, and to be careful");
					System.out.println("1:Drink the potion");
					System.out.println("2: Don't Drink it");
					int pot = validnumber(1,2);
					if (pot ==1 ) {
						System.out.println("you drink the potion... you feel some of your stats change, some for the better, and some for the worse");
						System.out.println("you think it was probably worth it to drink this, in the end");
						h1.setMaxHp((int)(h1.getMaxHp()*(Math.random()*1.4)+.90));
						h1.setStrength(h1.getStrength() + (int)(Math.random()*5)-2);
					}else {
						System.out.println("you decide not to drink the potion, and instead feed it to a nearby goat");
						if (Math.random() > .5) {
							System.out.println("The goat dies instantly, and you decide that there's a reason the begger had something which seemed so valuable");
						}else {
							System.out.println("the goat suddenly swells up, becoming instantly super muscular, and healthy, and you feel very foolish for not drinking the potion");
							System.out.println("in an act of petty vengance, you kill the goat, and eat it's meat... which heals you back to full... A nice consulation prize");
							h1.changeHp(1000);
						}
					}
				}
			}else {
				System.out.println("You apologize, saying that you can't afford to give anything");
			}
		}
	}
}
