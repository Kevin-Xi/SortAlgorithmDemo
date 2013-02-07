package gui;

import java.awt.Color;

import javax.swing.JPanel;

public abstract class Drawing extends JPanel {
	protected int[] numberGroup;
	protected int divideColor;
	
	protected int redStart;
	protected int redEnd;
	protected int greenStart;
	protected int greenEnd;
	protected int blueStart;
	protected int blueEnd;
	protected Color colorHighlight;
	
	protected int highlight1=-1;
	protected int highlight2=-1;
		
	public void setColor(Color colorStart,Color colorEnd,Color colorHighlight){
		if(colorStart==null||colorEnd==null)
			return;
		
		redStart=colorStart.getRed();
		redEnd=colorEnd.getRed();
		
		greenStart=colorStart.getGreen();
		greenEnd=colorEnd.getGreen();
		
		blueStart=colorStart.getBlue();
		blueEnd=colorEnd.getBlue();	
		
		this.colorHighlight=colorHighlight;
	}
	
	//public abstract void setHighlight(boolean )		???in gui or in engine???
	public void draw(int[] numberGroup){
		this.numberGroup = numberGroup;
		divideColor=numberGroup.length-1;	//
		repaint();
	}

	public void highlight(int i, int key){
		this.highlight1=i;
		this.highlight2=key;
	}
}
