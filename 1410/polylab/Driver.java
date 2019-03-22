public class Driver {
	//Racer people[];
	public static void main(String args[]) {
		Racer [] people = new Racer[10];
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
				// if 2 animals win at the same time it prioritizes based on who is eariler in the array, sorry animals
				if (people[z].getLocation() > 100) {
					System.out.println(people[z].getName() + " Wins");
					n = false;
					break;
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
			// draws the animals at their positons
			for (int q=0;q<100;q++){
				if (q == loc) {
					System.out.print("O");
				}else {
					System.out.print("-");
				}
			}
			System.out.println("");
			//System.out.println(r[z].getName() +": "+ loc);

		}

	}

}
