import javax.swing.JFrame;


public class Assign0301 {
	public static void main(String[] args){
		double running = 1;
		JFrame frame = new JFrame();
		frame.setSize(300,400);
		frame.setTitle("Random frame");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Assign0302 component = new Assign0302();
		frame.setVisible(true);
		
	    while (running != 0){
	    	component.x += 0.01;
	    	System.out.println(component.x);
	    	frame.add(component);
	    	frame.repaint();
	    	frame.setVisible(true);
	    	frame.remove(component);
			
		}	
	}
}
