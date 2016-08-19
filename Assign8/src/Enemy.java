//ENEMY CLASS

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Random;


public class Enemy {
	double x;
	double y;
	double w;
	double h;
	double b=0;
	double speed;
	Random r;
	boolean stat;
	int l;
	int u;
	int lStr;
	boolean lStat = false;
	int uStr;
	boolean uStat = false;
	int endX;
	int endY;
	public Enemy(double x,double y,double w,double h){
		this.x=x;
		this.y=y;
		this.w=w;
		this.h=h;
		r = new Random();
		speed = r.nextInt(7)/10.0+.1;
	//	speed = (r.nextInt(15)+15)/10;
		if (r.nextInt(20) <1){
			stat = true;
			speed = 0;
		}
		endX = r.nextInt(600)+20;
		endY = r.nextInt(440)+20;
		
		
		
	}
	
    public void paint(Graphics g) {
	    g.setColor(Color.blue);
	    if (stat == true){
	    	g.setColor(Color.red);
	    }
		g.fillRect((int)x, (int)y, (int)w, (int)h);
		g.setColor(Color.black);
		g.drawRect((int)x, (int)y, (int)w, (int)h);
		g.setColor(Color.white); 
    	
    }
    
    public void move(int lol,int lol2,ArrayList<Enemy> en){
    	b+=1;
    	lStr = 0;
    	uStr = 0;
    	uStat = false;
    	lStat = false;
    	double mx = x+w/2;
    	double my = y+h/2;
    	double resultX = x;
    	double resultY = y;
    	boolean setX = true;
    	boolean setY = true;
    	boolean move = true;
    	boolean changing = false;
    	int Yend = lol2;
    	int Xend = lol;
    	endX = lol;
    	endY = lol2;
    	
    	
    	//CODE USED TO MAKE THE BULLETS MOVE TO A RANDOM LOCATION
    	//CHANGING ABOUT EVERY 3 SECONDS 
    	/*if (b > 500){
    		changing = true;
    		if (r.nextInt(2)== 0){
    			if (r.nextInt(2)== 0){
    				Xend = 20;
    			}
    			else{
    				Xend = 760;
    			}
    			Yend = r.nextInt(560)+20;
    		}
    		else{
    			if (r.nextInt(2)== 0){
    				Yend = 20;
    			}
    			else{
    				Yend = 560;
    			}
    			Xend = r.nextInt(760)+20;	
    		}	
    	}*/
    	
    	double xAvg = 0;
    	double yAvg = 0;
    	for (int i=0;i<en.size();i++){
    		if (en.get(i).stat == false){
	    		xAvg += endX-(en.get(i).x+en.get(i).w/2);
	    		yAvg += endY-(en.get(i).y+en.get(i).h/2);
    		}

    	}
    	xAvg = xAvg/en.size(); 
    	yAvg = yAvg/en.size();
    //	endX = (int) (endX + (xAvg*2));
    //	endY = (int) (endY + (yAvg*2));

		if (( (endX-mx)*(endX-mx)+(endY-my)*(endY-my) != 0)){
			if (endX-mx != 0){
				resultX = x+((endX-mx)/Math.abs(Math.sqrt(((endX-mx)*(endX-mx))+((endY-my)*(endY-my)))))*speed;
			}
			if (endY-my != 0){
				resultY = y+ ((endY-my)/Math.abs(Math.sqrt(((endX-mx)*(endX-mx))+((endY-my)*(endY-my)))))*speed;
			}
			
		}

    	for (int j=0;j<en.size();j++){
        	if (changing==true){
        		en.get(j).endX = Xend;
        		en.get(j).endY = Yend;
        		en.get(j).b=0;
        	}
    		if (this != en.get(j)){

				if ( (resultX+w>=en.get(j).x ) && (resultX<=en.get(j).x+en.get(j).w) && (resultY+h>=en.get(j).y ) && (resultY<=en.get(j).y+en.get(j).h )){
					move = false;
				}

				if ( (x+w>=en.get(j).x ) && (x<=en.get(j).x+en.get(j).w) && (resultY+h>=en.get(j).y ) && (resultY<=en.get(j).y+en.get(j).h )){
					setY = false;

				}
				if ( (resultX+w>=en.get(j).x ) && (resultX<=en.get(j).x+en.get(j).w) && (y+h>=en.get(j).y ) && (y<=en.get(j).y+en.get(j).h )){
					setX = false;

				}
				
    		}

		}
    	if (move == true){
    		x = resultX;
    		y = resultY;
    	}else{
    		if (setX == true){
    			x = resultX;
    		}

    		
    		if (setY == true){
    			y = resultY;
    		}
    	}

    }
    
  
    public boolean overlap(Enemy en1, Enemy en2){
    	if ( (en1.x+en1.w>en2.x ) && (en1.x<en2.x+en2.w) && (en1.y+en1.h>en2.y ) && (en1.y<en2.y+en2.h )){
    		return true;
    	}
    	else{
    		return false;
    	}
    }
    
    public boolean collide(ArrayList<Bullet> bullets){
    	ArrayList<Integer> removers = new ArrayList<Integer>();
    	Rectangle temp1 = new Rectangle ((int)x,(int)y,(int)w,(int)h);
    	Rectangle temp2;
    	boolean returner = false;
    	for (int i=0;i<bullets.size();i++){


    		temp2 = new Rectangle((int)bullets.get(i).x,(int)bullets.get(i).y,bullets.get(i).w,bullets.get(i).h);
    		if (temp1.intersects(temp2)){

    			removers.add(i);

    			if (stat == false){

    				returner = true;

    			}
    		}
    		
    		if (bullets.get(i).x<0 || bullets.get(i).y < 0 || bullets.get(i).x+bullets.get(i).w>800 || bullets.get(i).y+bullets.get(i).h >800){

    			if (!(removers.contains(i))){

    				removers.add(i);

    			}
    		}
    		
    	}

    	removers = sort(removers);

    	for (int i=0;i<removers.size();i++){

    		bullets.remove(removers.get(i)-i);

    	}
  
    	return returner;
    }
    
    public static ArrayList<Integer> sort (ArrayList<Integer> numbers){
    	int temp;
    	for (int i=0;i<numbers.size();i++){
    		for (int j=i+1;j<numbers.size();j++){
    			if (numbers.get(i) > numbers.get(j)){
    				temp = numbers.get(i);
    				numbers.set(i, numbers.get(j));
    				numbers.set(j, temp);
    			}
    		}
    	}
    	return numbers;
    }
    
}
