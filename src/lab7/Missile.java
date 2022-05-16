package lab7;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Missile {

    private int x, y;
    private Image image;
    
    private long start;
    
    private Explosion explosion = new Explosion();

    public enum State{NONE, VISIBLE, EXPLODING, DONE} 
    
    private State state = State.VISIBLE;
    
    private final int BOARD_WIDTH = 390;
    private final int MISSILE_SPEED = 2;

    public Missile(int x, int y) {

        ImageIcon ii =
            new ImageIcon(this.getClass().getResource("/res/missile.png"));
        image = ii.getImage();
        this.x = x;
        this.y = y;
    }
    

    public Image getImage() {
        return image;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean isVisible() {
        if(state != State.DONE);
			return true;
    }

    public void move() {
    	
    	long now = System.currentTimeMillis();
    	int elapsed, k;
    	
    	if(state == State.VISIBLE) {
    		x += MISSILE_SPEED;
    		if(x > BOARD_WIDTH - 150) {
	    		state = State.EXPLODING;
	    		y = this.getY()/2;
	    		this.start = now;
    		}
    	}
    	else if(state == State.EXPLODING) {
    		elapsed = (int) (now - this.start);
    		k = (elapsed/50);
    		if(explosion.has(k)) 
    			this.image = explosion.getFrame(k);
    		else
        		state = State.DONE;
    	} 
    }
}