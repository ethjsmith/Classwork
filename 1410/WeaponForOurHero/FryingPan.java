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