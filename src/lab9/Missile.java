package lab9;

import java.awt.Image;

import java.awt.Rectangle;

import javax.swing.ImageIcon;

import lab7.Missile.State;
import sf.Sound;
import sf.SoundFactory;
import lab7.Explosion;

public class Missile {

    private int x, y;
    private Image image;
    private int width, height;

    private final int BOARD_WIDTH = 390;
    private final int MISSILE_SPEED = 2;
    
    private State state = State.NONE;
    
    private Explosion explosion = new Explosion();
    
    private long start;

    public final static String DIR = "src/res/";
    public final static String SOUND_EXPLOSION = DIR + "Explosion+1.wav";
    
    public Missile(int x, int y) {

        ImageIcon ii =
            new ImageIcon(this.getClass().getResource("/res/missile.png"));
        image = ii.getImage();
        state = State.VISIBLE;
        width = image.getWidth(null);
        height = image.getHeight(null);
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
    	if(state != State.DONE)
    		return true;
    	else
    		return false;
    }

    public void setVisible(Boolean visible) {
        if(visible == true)
        	state = State.VISIBLE;
        else
        	state = State.DONE;
    }

    public Rectangle getBounds() {
    	if(state == State.EXPLODING)
    		return new Rectangle(width, height, image.getWidth(null), image.getHeight(null));
    	else
    		return new Rectangle(x, y, width, height);
    }

    public void move() {
    	if(state == State.VISIBLE) {
    		x += MISSILE_SPEED;
    		if (x > BOARD_WIDTH)
    			state = State.DONE;
    	}
    	else if(state == State.EXPLODING) {
    		int elapsed, k;
    		elapsed = (int) (System.currentTimeMillis() - start);
    		k = elapsed/50;
    		if(explosion.has(k))
    			image = explosion.getFrame(k);
    		else
    			state = State.DONE;
    	}
    }
    
    public void explode() {
    	if(state == State.EXPLODING)
    		return;
    	else {
    		state = State.EXPLODING;
    		y -= explosion.FRAME_HEIGHT/2;
    		start = System.currentTimeMillis();
    		Sound sound = SoundFactory.getInstance(SOUND_EXPLOSION);
    		SoundFactory.play(sound);
    	}
    }//*/
}