public class Merchant extends Character {
	//private Weapon inventory [];
	protected int temp=0;
	public Merchant() {
		super();
		INVENTORY_SIZE=3;
		inventory = new Weapon [INVENTORY_SIZE];
		initInventory();
		generateInventory(3);
	}
	private void generateInventory(int num) {
		for (int z=0;z<num;z++){
			Weapon wep = Weapon.MakeWeapon();
			addItemToInventory(wep);
		}
	}
	public void buyloop(Hero h1) {
		boolean buying = true;
		System.out.println("He shows you a few, and asks if you would like to purchase any");
		System.out.println("You have " + h1.getGold() + " Gold pieces");
		//lets you buy multiple items from a vendor, especially important for towns, where the merchant can't just walk away like a wandering merchant could
		while (buying) {
			int z = this.PrintInventory();
			int userinput = validnumber(1,z);
			this.attemptSale(userinput,h1);
			//breaks you out of the purchasing loop
			if (z == userinput) {
				buying = false;
			}
		}
	}
	public int PrintInventory() {
		//prints out the merchants inventory in a format that shows what he is selling ( also gives option numbers, and the option to just leave)
		//int temp = 0;
		for (int z=0;z<3;z++){
			temp = z+1;
			System.out.println(temp + ": Purchase " + inventory[z].getName() +"["+ inventory[z].getDamage()+" DMG] For " + inventory[z].getPrice() + " Gold pieces");
			}
			temp++;
			System.out.println(temp + ": Stop shopping");
			//lets the program know how many options there are
			return temp;
	}
	public void attemptSale(int choice, Hero h1) {
			if (choice == temp) {
				System.out.println("you thank the merchant, and continue on your way, and continue on your journey");
			}
			else {
				if (h1.getGold() >= inventory[choice-1].getPrice()) {
					if (h1.canAddItem()) {
						h1.addItemToInventory(inventory[choice-1]);
						h1.setGold(h1.getGold() - inventory[choice-1].getPrice());
						System.out.println("You have aquired the " + inventory[choice-1].getName());
						System.out.println("The merchant puts another weapon up for sale");
						//replaces the sold weapon with a new one for sale
						inventory[choice-1] = Weapon.MakeWeapon();
					}
					else {
						System.out.println("You can't carry any more items!");
					}
				}
				else {
					// You can only buy one item from a merchant, and if you mess it up trying to buy something you can't afford the merchant just leaves. oops
					System.out.println("You don't have enough money");
					System.out.println("Stop wasting my time, curses the merchant!");
				}
			}
	}
}
