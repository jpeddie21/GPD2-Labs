package lab3;

public class Ellipse {

    protected int a;
    protected int b;
    
    public Ellipse(int a, int b) {
    	
    	this.a = a;
    	this.b = b;
    	
    } // Ellipse

    public double area() {
        
        return a * b * Math.PI;
        
    } // area
    
    public double getWidth() {
    	
    	return this.a;
    	
    } // getWidth
    
    public double getHeight() {
    	
		return this.b;
    
    } // getHeight
    
    
    @Override
    public String toString() {
    	
    	return getClass().getSimpleName() + " (a="+a+", b="+b+")";
    	
    } //toString
    
} // Ellipse
