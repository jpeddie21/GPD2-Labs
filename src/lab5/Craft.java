package lab5;

import java.awt.Image;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;

public class Craft {

    private String craft = "/res/craft-a.png";
    private String craftMoving = "/res/craft-1.png";

    private int dx;
    private int dy;
    private int x;
    private int y;
    private Image image;
    private Image image2;
    private boolean isMoving;

    public Craft() {
        ImageIcon ii = new ImageIcon(this.getClass().getResource(craft));
        ImageIcon ii2 = new ImageIcon(this.getClass().getResource(craftMoving));
        image = ii.getImage();
        image2 = ii2.getImage();
        x = 40;
        y = 60;
    }


    public void move() {
        x += dx;
        y += dy;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Image getImage() {
    	if(isMoving)
    		return image;
    	else
    		return image2;
    }

    public void keyPressed(KeyEvent e) {

        int key = e.getKeyCode();
        isMoving = true; 
        
        if (key == KeyEvent.VK_LEFT) {
            dx = -1;
        }

        if (key == KeyEvent.VK_RIGHT) {
            dx = 1;
        }

        if (key == KeyEvent.VK_UP) {
            dy = -1;
        }

        if (key == KeyEvent.VK_DOWN) {
            dy = 1;
        }
    }

    public void keyReleased(KeyEvent e) {
    	
        int key = e.getKeyCode();
        if(dx == 0 || dy == 0)
        	isMoving = false;

        if (key == KeyEvent.VK_LEFT) {
            dx = 0;
        }

        if (key == KeyEvent.VK_RIGHT) {
            dx = 0;
        }

        if (key == KeyEvent.VK_UP) {
            dy = 0;
        }

        if (key == KeyEvent.VK_DOWN) {
            dy = 0;
        }
    }
}
