//BULLET CLASS
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;


public class Bullet {
	double x;
	double y;
	int w;
	int h;
	double xMove;
	double yMove;
	
	
	public Bullet(Player p, MouseEvent m){
		this.x=p.getX()+p.getWidth()/2;
		this.y=p.getY()+p.getHeight()/2;
		int endX = m.getX();
		int endY = m.getY();
		w=5;
		h=5;
		xMove = ((endX-x)/Math.abs(Math.sqrt(((endX-x)*(endX-x))+((endY-y)*(endY-y)))))*2;
		yMove = ((endY-y)/Math.abs(Math.sqrt(((endX-x)*(endX-x))+((endY-y)*(endY-y)))))*2;
	}
	
	
	public void move(){
		x+=xMove;
		y+=yMove;
	}
	
	public void paint(Graphics g){
		g.setColor(Color.black);
		g.fillRect((int)x,(int)y,(int)w,(int)h);
	}
}
