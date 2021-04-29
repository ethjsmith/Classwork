package vending;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class VendingMachine {
private int numItems;
private double money;
private VendingItem [] items;
	public VendingMachine(String filename) {
		try {
			
			Scanner fileScanner = new Scanner(new File(filename));
			// num items at top file so we know how big array is
			numItems = fileScanner.nextInt();
			items = new VendingItem[numItems];
			fileScanner.nextLine();
			for (int i=0; i<numItems;i++) {
				items[i] = new VendingItem(fileScanner.nextLine());
			}
			fileScanner.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	public static void main(String [] args) {
		VendingMachine vm = new VendingMachine("food.txt");
		while (true) {
			System.out.println("Welcome to vending machine, what would you like to do");
			System.out.println("1 : insert money");
			System.out.println("2 : display items");
			System.out.println("3 : purchase item");
			System.out.println("4 : get change");
			Scanner input = new Scanner(System.in);
			int choice = input.nextInt();
			switch(choice) {
			case 1:
				System.out.println("How much money do you wish to insert?");
				double moneyIn= input.nextDouble();
				vm.insertMoney(moneyIn);
				System.out.println(vm.money);
				break;
			case 2:
				vm.displayItems();
				break;
			case 3:
				System.out.println("Which item # do you wish to purchase?");
				int itemNum = input.nextInt();
				vm.purchaseItem(itemNum);
				break;
			case 4: 
				System.out.println("here's your change :" + vm.getBalance());
				vm.insertMoney(-vm.money);
				break;
			
			}
		}
	
	}
	private void displayItems() {
		// TODO Auto-generated method stub
		for (int i=0;i<numItems;i++) {
			System.out.println(i + ":" + items[i].toString());
	}
	}


	private void purchaseItem(int itemNum) {
		// TODO Auto-generated method stub
			//System.out.println(items[itemNum].getQuantity() + ": is quantity " + items[itemNum].getPrice() + ": is price" + getBalance() + ": is money");
			if (items[itemNum].getQuantity()>0 && items[itemNum].getPrice() <= money) {
				
				System.out.println("congratulations!, you now own " + items[itemNum].getKind());
				items[itemNum].setQuantity(items[itemNum].getQuantity() - 1);
				money -=items[itemNum].getPrice();
				System.out.println("your change is " + getBalance());
				
			}
			else {
				System.out.println("Can't but that right now");
			}
	}
	
	private String getBalance() {
		return money +" ";
		
	}
	private void insertMoney(double moneyIn) {
		money += moneyIn;
		
	}



}