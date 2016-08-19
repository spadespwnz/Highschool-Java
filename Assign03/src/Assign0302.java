import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import javax.swing.JComponent;
import javax.swing.JFrame;

public class Assign0302 extends JComponent{
	double x = 5;

	
	public void paintComponent(Graphics g){
		Graphics2D g2 = (Graphics2D) g;
		Rectangle box = new Rectangle(10,10,(int)x,10);
		g2.draw(box);
	}
	/*public void setRectX(int x){
		box.x = x;
	}*/


	
	
}

