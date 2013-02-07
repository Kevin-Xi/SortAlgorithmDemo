package engine;

import gui.Drawing;

public abstract class Driving implements Runnable{
	protected int[] unsort;
	protected Drawing drawing;
	protected int sleepTime;

	public abstract void run();
	
	public void setArray(int[] unsort){
		this.unsort=unsort;
	}
	
	public void setDrawing(Drawing drawing){
		this.drawing=drawing;
	}
	
	public void setSleepTime(int sleepTime){
		this.sleepTime=sleepTime;
	}
}
