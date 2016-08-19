//PLAYER CLASS
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import javax.swing.JComponent;
import javax.swing.JFrame;

public class Player extends JComponent{
	double health;
	private double maxHealth;
	private int x;
	private int y;
	private int w;
	private int h;
	private int horDir;
	private int virDir;
	private int vpDir;
	private int hpDir;
	private int speed;
	private int shootingLightning = 0;
	public Player(){
		x = 50;
		y = 50;
		horDir=0;
		virDir=0;
		health = 100;
		maxHealth = 100;
		speed = 1;
		w=20;
		h=20;
	}

    public void paint(Graphics g) {
    	g.setColor(Color.green);
		g.fillRect(x, y, w, h);
		g.setColor(Color.black); 
    }
    public void moveRight(){
    	if (x < 780){
    		x = x+speed;
    	}
    }
    public void moveLeft(){
    	if (x > 0){
    		x = x-speed;
    	}
    }
    
    public void moveUp(){
    	if (y > 0){
    		y-=speed;
    	}
    }
    public void moveDown(){
    	if (y < 570){
    		y+=speed;
    	}
    }	
    public void setHorDir(int x){
    	horDir = x;
    }
    public void setVirDir(int y){
    	virDir = y;
    }
    public int getHorDir(){
    	return horDir;
    }
    public int getVirDir(){
    	return virDir;
    }
    public void setvpDir(int y){
    	vpDir = y;
    }
    public void sethpDir(int x){
    	hpDir = x;
    }
    public int getvpDir(){
    	return vpDir;
    }
    public int gethpDir(){
    	return hpDir;
    }
    public void shootLight(){
    	shootingLightning = 1;
    }
    public int getShootLight(){
    	return shootingLightning;
    }
    public int getX(){
    	return x;
    }
    public int getY(){
    	return y;
    }
    
    public void move(){
    	if (getHorDir() == 1){
    		moveLeft();
    	}
    	if (getHorDir() == 2){
    		moveRight();
    	}
    	if (getVirDir() == 1){
    		moveUp();
    	}
    	if (getVirDir() == 2){
    		moveDown();
    	}
    }
    
    
    
    
    
}
