import java.awt.Point;
import java.io.IOException;


public class Line {
	Double m;
	Double b;
	double x;
	
	public Line (double x){
		this.x = x;
		m = (Double) null;
		
		b = (Double) null;
	}
	
	public Line(Point a, Point b){
		try{
			m = ((a.y - b.y)*1.0 / (a.x - b.x)*1.0)*1.0 ;
			this.b = a.y-m*a.x;
		}
		catch (Exception e){
			m = (Double) null;
			this.b = (Double) null;
		}

	}
	public Line (double m, double b){
		this.b =b;
		this.m=m;
	}
	public Line (Point p, double m){
		this.m = m;
		this.b = p.y-m*p.x;
	}
	public Double getM()throws IOException{
		try{
			return Math.round(m*1000)/1000.0;
		}
		catch(Exception e){
			return m;
		}
	}
	public Double getB(){
		try{
			return Math.round(b*1000)/1000.0;
		}catch (Exception e){
			return b;
		}
	}
	
	public double getX(){
		return Math.round(x*1000)/1000.0;
	}
	
	public boolean intersects (Line otherline) throws IOException{
		if (!isParallel(otherline)){
			return true;
		}
		if (equals(otherline)){
			return true;
		}
		return false;
	}
	public boolean equals (Line otherline) throws IOException{
		int test = 0;
		try{
			m.isNaN();
		}catch (Exception e){
			test += 1;
		}
		try{
			otherline.getM().isNaN();
		}catch (Exception e){
			test += 1;
		}
		if (test == 1){
			return false;
		}
		if (test == 2){
			if (x == otherline.getX()){
				return true;
			}
			else{
				return false;
			}
		}
		
		if (otherline.getM().equals(m)){
			if (otherline.getB().equals(b)){
				return true;
			}
		}
		return false;
	}
	public boolean isParallel(Line otherline) throws IOException{
		int test = 0;
		try{
			m.isNaN();
		}catch (Exception e){
			test += 1;
		}
		try{
			otherline.getM().isNaN();
		}catch (Exception e){
			test += 1;
		}
		if (test == 1){
			return false;
		}
		if (test == 2){
			return true;
		}
		
		if (m.equals(otherline.getM())){
			return true;
		}
		return false;
	}
	
	public double getXintercept(){
		try{
			return Math.round((-1.0*b)/(m*1.0)*1000)/1000.0;
		}
		catch (Exception e){
			return Math.round(x*1000)/1000.0;
		}
	}
	
}
