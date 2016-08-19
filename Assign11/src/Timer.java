public class Timer {
	long startTime;
	long endTime;
	
	public Timer(){
		startTime = 0;
		endTime = 0;
	}
	
	public void start(){
		startTime = System.nanoTime();
	}
	public void stop(){
		endTime = System.nanoTime();
	}
	public long getTime(){
		return endTime-startTime;
	}
	public void reset(){
		startTime = 0;
		endTime = 0;
	}
}
