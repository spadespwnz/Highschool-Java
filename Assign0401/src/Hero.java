import java.awt.Point;


public class Hero {
	Point pos = new Point();
	private int health;
	
	public Hero(Point p){
		if (p.x > 0){
			pos.x = pos.x+p.x;
		}
		else pos.x = 0;
		if (p.y > 0){
			pos.y = pos.y+p.y;
		}
		else pos.y = 0;
		health = 100;
	}
	
	public Hero(){
		pos.x = 0;
		pos.y = 0;
		health = 100;
	}
	
	public Hero(int x, int y){
		if (x > 0){
			pos.x = pos.x+x;
		}
		else pos.x = 0;
		if (y > 0){
			pos.y = pos.y+y;
		}
		else pos.y = 0;
		health = 100;
	}
	
	public Hero(int x, int y, int hp){
		if (x > 0){
			pos.x = pos.x+x;
		}
		else pos.x = 0;
		if (y > 0){
			pos.y = pos.y+y;
		}
		else pos.y = 0;
		if (hp > 0){
			health = hp;
		}
		else health = 100;
	}
	
	public Hero(Point p, int hp){
		if ((p.x > 0) && (p.y > 0)){
			pos = p;
		}
		else{
			pos.x = 0;
			pos.y = 0;
		}

		if (hp > 0){
			health = hp;
		}
		else health = 100;
	}
	
	public Hero(int hp){
		pos.x  = 0;
		pos.y = 0;

		if (hp > 0){
			health = hp;
		}
		else health = 100;
	}
	
	public Point getPos(){
		return pos;
	}
	public int getX(){
		return pos.x;
	}
	public int getY(){
		return pos.y;
	}
	public void move(int x, int y){
		if (x > 0){
			pos.x = pos.x+x;
		}
		if (y > 0){
			pos.y = pos.y+y;
		}
	}
	public void hurt(int dmg){
		if (dmg > 0){
			health = health - dmg;
		}
		if (health < 0){
			health = 0;
		}
	}
	public void heal(int hp){
		if (hp > 0){
			health = health + hp;
		}
	}
	public int getHealth(){
		return health;
	}
}
