/*

@Author (created/edited by ) Ethan Smith
@ DATE 2/27/19 - 3/4/19
@ Assignment : Weapon for our hero
@Class : Object
@Favorite Color : RED

*/
//Generic game object super class file
//This class should never be instantiated
//Dr. G 
//10-5-18
//Edited 2-17-19

//4. Create an object class for something that we want to place in our field. 
//Review all of the code below. 
import java.util.Scanner;

public class Object
{
	//The object's name
	protected String name;
	//The field the object is in
	protected Field f1; 
	//The location in the field
	protected int x; 
	protected int y;
	
	public Object()//no argument constructor placing object off the field
	{
		this.name = null; 
		this.f1 = null; 
		this.x = 1;
		this.y = 1;
	}
	
	//Complete constructor
	public Object(String name, Field f1, int x, int y)
	{
		this.name = name; 
		this.f1 = f1; 
		this.x = x;
		this.y = y;
	}
	
	//Constructor for the object without putting it on the field yet
	//Maybe instead we'll put it in our hero's inventory
	public Object(String name)
	{
		this.name = name;
		x=-1; 
		y=-1;
	}
	public String getName(){
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}
	// now objects can move... how exciting is that ?
	public int getX() {
		return this.x;
	}
	public void setX(int x) {
		this.x =x;
	}
	public int getY() {
		return this.y;
	}
	public void setY(int y) {
		this.y =y;
	}
	public Field getField(){
		return this.f1;
	}
	public void setField(Field f1) {
		this.f1 = f1;
	}
	//Sometimes an object gets destroyed. 
	//Note this does not de-allocate the memory this object took up
	public void DestroyObject()
	{
		this.name = null; 
		this.f1 = null; 
		this.x = -1;
		this.y = -1;
	}
	public static int validnumber (int min,int max) {
		//this method returns a verified number between min and max, for use with all those choices you have to make
		// it also has error handling if you try to enter a word or something stupid
		int num =0;
		Scanner s = new Scanner(System.in);
		System.out.println("please enter an INT between " + min  +" and " + max);
		boolean valid = false;
		while (!valid) {
			try {
				num = s.nextInt();
				if (num >= min && num <= max) {
					valid = true;
				}else {
					throw new Exception("wrong number");
				}
			}
			catch (Exception E) {
				s.nextLine();
				System.out.println("please enter an INT between " + min  +" and " + max);

			}
		}
		clearScreen();
		return num;
	}
public static void clearScreen() {
	for (int clear=0;clear<100;clear++){
		System.out.println("");
	}
}	
	
	//MOVE TO THE CHARACTER CLASS
}