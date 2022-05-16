package lab3.p1;
import lab3.Ellipse;
import lab3.Circle;

public class main {

	public static void main(String[] args) {
		
		Ellipse[] ellipses;
		
		ellipses = new Ellipse[2];
		ellipses[0] = new Ellipse(5, 7);
		ellipses[1] = new Circle(6);
		
		for(int i = 0; i < ellipses.length; i++)
			
			System.out.println(ellipses[i].toString() + " Area=" + ellipses[i].area());
		
	} // main

} // main
