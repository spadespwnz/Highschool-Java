
public class Bug {
	private int direction;
	private int speed;
	private int pos;
	
	public Bug(){
		direction = 1;
		speed = 1;
		pos = 10;
	}
	
	public Bug(int direction, int speed, int pos){
		this.direction = direction;
		this.speed = speed;
		this.pos = pos;
	}
	public Bug(int pos){
		this.pos = pos;
		direction = 1;
		speed = 1;
	}
	
	public void turn(){
		direction = Math.abs(direction - 1);
	}
	
	public void move(){
		if (direction == 1){
			pos += speed;
		}
		else{
			pos -= speed;
		}
	}
	public int getPos(){
		return pos;
	}
}
