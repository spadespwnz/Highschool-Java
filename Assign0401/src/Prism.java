
public class Prism {
	
	private double length;
	private double width;
	private double height;
	
	public Prism(double length, double width, double height){
		
		this.length = length;
		this.width = width;
		this.height = height;
		
	}
	public Prism(double len){
		
		this.length = len;
		this.width = len;
		this.height = len;
		
	}
	
	public Prism(){
		
		this.length = 5;
		this.width = 5;
		this.height = 5;
		
	}
	public double getLength(){
		return length;
	}
	
	public void setLength (double l){
		length = l;
	}
	
	public double getWidth(){
		return width;
	}
	
	public void setWidth (double w){
		width = w;
	}
	public double getHeight(){
		return height;
	}
	
	public void setHeight (double h){
		height = h;
	}
	
	public double getVolume(){
		return length*width*height;
	}
	
	public double getSurfaceArea(){
		return 2*length*width+2*length*height+2*height*width;
	}
	
	public boolean equals(Prism check){
		
		if ( (this.length == check.getLength()) && (this.width == check.getWidth()) &&  (this.height == check.getHeight())){
			return true;
		}
		else{
			return false;
		}
	}
}
