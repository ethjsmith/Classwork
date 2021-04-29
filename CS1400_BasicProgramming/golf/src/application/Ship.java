package application;

public class Ship {
// this is the ship object... I don't usually code objects so this might be a little rough
	private double [] coords;
	// boolean variables for checking if the ship is currently moving in any direction.
	private boolean w=false,a=false,s=false,d=false;
	
	public double [] getCoords() {
		return this.coords;
	}
	public void setCoords(double [] co) {
		this.coords = co;
	}
	public boolean getW() {
		return this.w;
	}
	public void setW(boolean w) {
		this.w = w;
	}
	public boolean getA() {
		return this.a;
	}
	public void setA(boolean a) {
		this.a = a;
	}
	public boolean getS() {
		return this.s;
	}
	public void setS(boolean s) {
		this.s = s;
	}
	public boolean getD() {
		return this.d;
	}
	public void setD(boolean d) {
		this.d = d;
	}
}
