/*

@Author (created/edited by ) Ethan Smith
@ DATE 3/14/19
@ Assignment : Weapon for our hero
@Class : Character
@Favorite Color : RED

*/
//frying pan weapon, which you can only get via some special events in the town ... the special attack is probably a little OP
public class FryingPan extends Weapon {
	public FryingPan() {
		super();
		name = "Frying Pan";
		damage = (int) (Math.random()*4)+3;
		special = "overhand strike";
		explaination = "Hit your opponent on the head, knocking them out instantly, and allowing you to kill them, or steal all of their items";
		price = 69; // lol
	}
	public void special(Hero h1, Baddy b) {
		System.out.println("you suprise the" + b.getName() + "With a sudden quick overhand blow, hitting them in the head, and instantly knocking them unconsious");
		System.out.println("Then you easily finish them off... not very nice, but very efficent");
		b.changeHp(b.getHp()*-1);
	}
}