public class Driver {
	public static void main(String args[]) {
		Racer [] people = new Racer[10];
		String [] winners = new String[10];
		for (int z =0;z<people.length;z++) {
			people[z] = Racer.makeRacer();
		}
		boolean n = true;
		while (n) {
			printRacers(people);
			for (int z =0;z<people.length;z++) {
				//picks a random animal to pass the move class ( this is used with Weasel)
				int randomanimal = (int)(Math.random()*9)+1;
				people[z].move(people[randomanimal]);
				//adds everyone to who wins to an array of winners, and sets a flag as false, so the race ends
				if (people[z].getLocation() > 100) {
					winners[z] = people[z].getName();
					n = false;
				}
			}
			// some code I googled to make the animation work, by making the program sleep for awhile
			try {
				Thread.sleep(500);
			}
			catch(InterruptedException e) {
				Thread.currentThread().interrupt();
			}
		}
		//loops through the winners array, and prints everyone who won
		for (int o =0;o<winners.length;o++) {
			if (winners[o] != null) {
				System.out.print (winners[o] + ", ");
			}
		}
		System.out.println("Wins");

	}
	public static void printRacers(Racer[] r){
		//clears the screen, giving the illusion of animation
		for (int k=0;k<50;k++){
			System.out.println("");
		}
		// loops through each animal
		for (int z=0;z<r.length;z++) {
			int loc = r[z].getLocation();
			System.out.print(r[z].getName() + ":");
			//draws a line 100 characters long for the animals to race on
			// draws the animals at their current locations
			for (int q=0;q<100;q++){
				if (q == loc) {
					System.out.print("O");
				}else {
					System.out.print("-");
				}
			}
			System.out.println("");

		}

	}

}
