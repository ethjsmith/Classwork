public class Merchant extends Character {
	//private Weapon inventory [];
	protected int temp=0;
	public Merchant() {
		super();
		INVENTORY_SIZE=3;
		inventory = new Weapon [INVENTORY_SIZE];
		initInventory();
		generateInventory();
	}
	private void generateInventory() {
		for (int z=0;z<3;z++){
			Weapon wep;
			int r = (int) (Math.random()*5)+1;
			if (r == 1) {
				wep = new Katana();
			}
			else if (r ==2 ) {
				wep = new Ritualsword();
			}
			else if (r==3) {
				wep= new Windsword();
			}
			else if (r==4) {
				wep = new Shortsword();
			}
			else {
				wep = new Oldsword();
			}
			addItemToInventory(wep);
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
			System.out.println(temp + ": Leave without buying anything");
			//lets the program know how many options there are
			return temp;
	}
	public void attemptSale(int choice, Hero h1) {
			if (choice == temp) {
				System.out.println("you shrug your shoulders, and continue on your journey");
			}
			else {
				if (h1.getGold() >= inventory[choice-1].getPrice()) {
					h1.addItemToInventory(inventory[choice-1]);
					h1.setGold(h1.getGold() - inventory[choice-1].getPrice());
					System.out.println("You have aquired the " + inventory[choice-1].getName());
					System.out.println("The merchant thanks you for your business, and continues on his way");
				}
				else {
					// You can only buy one item from a merchant, and if you mess it up trying to buy something you can't afford the merchant just leaves. oops
					System.out.println("You don't have enough money");
					System.out.println("Stop wasting my time, curses the merchant, as he continues down the road...");
				}
			}
	}
}