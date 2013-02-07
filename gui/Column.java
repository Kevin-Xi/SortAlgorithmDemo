package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

public class Column extends Drawing {
	@Override
	  protected void paintComponent(Graphics g) {
		  if (numberGroup == null) return; //No display if count is null
	
		  super.paintComponent(g);
	
		  //Find the panel size and bar width and interval dynamically
		  int width = getWidth();
		  int height = getHeight();
		  int interval=(width-40)/numberGroup.length;
		  int individualWidth = (int)(((width-40)/numberGroup.length)*0.9);
	
		  //The maximum count has the highest bar
		  int maxCount = numberGroup.length;
	
		  //x is the start position for the first bar in the histogram
		  int x = 20;
	
		  /*
		   * Draw a horizontal base line
		   */
		  g.drawLine(10,height-45,width-10,height-45);	//45 pixels from bottom
		  for (int i = 0; i < numberGroup.length; i++) {
			  //Find the bar height
			  int barHeight =(int)(((double)numberGroup[i]/(double)maxCount)*(height-55));
			
			  /*
			   * Display a rectangle bar, set color according to the height
			   */
				     
			  //g.setColor(new Color(255,128,i*25));
			  setRectColor(g,i);
		    	
			  g.fillRect(x, height - 45 - barHeight, individualWidth,barHeight);
		    	
			  //Display the number under the base line
			  g.drawString((i+1) + "", x, height - 30);
		    	
			  //Move x for displaying the next number
			  x+=interval;
		    }
	  }

	  @Override 
	  public Dimension getPreferredSize() {
		  return new Dimension(300, 300);
	  }
	  
	  public void setRectColor(Graphics g,int i){	
		  if(i==highlight1||i==highlight2){
			  g.setColor(colorHighlight);
		  }
		  else{
			  g.setColor(new Color((redEnd-redStart)*(numberGroup[i]-1)/divideColor+redStart,(greenEnd-greenStart)*(numberGroup[i]-1)/divideColor+greenStart,(blueEnd-blueStart)*(numberGroup[i]-1)/divideColor+blueStart));
		  }
	  }
}
