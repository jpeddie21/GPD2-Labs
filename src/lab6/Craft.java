package lab6;

import java.awt.Image;
import java.awt.event.KeyEvent;

import java.util.ArrayList;

import javax.swing.ImageIcon;

@SuppressWarnings({"rawtypes", "unchecked"})
public class Craft {

    private String craftRecoil = "/res/craft.png";
    private String craft = "/res/craft-2.png";
    
    private boolean firing = false;

    private int dx;
    private int dy;
    private int x;
    private int y;
    private Image image;
    private Image imageRecoil;

    private ArrayList missiles;

    private final int CRAFT_SIZE = 20;

    public Craft() {
        ImageIcon ii = new ImageIcon(this.getClass().getResource(craft));
        ImageIcon ii2 = new ImageIcon(this.getClass().getResource(craftRecoil));
        image = ii.getImage();
        imageRecoil = ii2.getImage();
        missiles = new ArrayList();
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
        if(firing)
        	return imageRecoil;
        else
    		return image;
    }

    public ArrayList getMissiles() {
        return missiles;
    }

    public void keyPressed(KeyEvent e) {

        int key = e.getKeyCode();

        if (key == KeyEvent.VK_SPACE) {
        	firing = true;
            fire();
        }

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

    public void fire() {
        missiles.add(new Missile(x + CRAFT_SIZE, y + CRAFT_SIZE/2));
    }

    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        
        if (key == KeyEvent.VK_SPACE) {
        	firing = false;
        }

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