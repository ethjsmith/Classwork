public class Driver {
	//Racer people[];
	public static void main(String args[]) {
		Racer [] people = new Racer[10];
		for (int z =0;z<people.length;z++) {
			people[z] = Racer.makeRacer();
		}
		boolean n = true;
		while (n) {
			for (int z =0;z<people.length;z++) {
				int randomanimal = (int)(Math.random()*9)+1;
				people[z].move(people[randomanimal]);
				if (people[z].getLocation() > 100) {
					System.out.println(people[z].getName() + " Wins");
					n = false;
					break;
				}
			}
		}
		
			
	}
	
}