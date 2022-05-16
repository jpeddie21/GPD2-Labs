package lab4;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

@SuppressWarnings("serial")
public class Board extends JPanel implements ActionListener {

    Image star;
    Timer timer;
    int x, y;
    int dx = 1, dy = 1;
    int width, height;

    public Board() {
        setBackground(Color.BLACK);

        ImageIcon ii =
            new ImageIcon(this.getClass().getResource("/res/star.png"));
        star = ii.getImage();
        width = ii.getIconWidth();
        height = ii.getIconHeight();

        setDoubleBuffered(true);

        x = y = 10;
        timer = new Timer(25, this);
        timer.start();
    }


    public void paint(Graphics g) {
        super.paint(g);

        Graphics2D g2d = (Graphics2D)g;
        g2d.drawImage(star, x, y, this);
        Toolkit.getDefaultToolkit().sync();
        g.dispose();
    }


    public void actionPerformed(ActionEvent e) {
 
        x += dx;
        y += dy;

        if (y > 240 - height - 35 || y < -2) 
            dy *= -1;
        else if (x > 280 - width - 10 || x < -2)  
        	dx *= -1;
        repaint();  
    }
}