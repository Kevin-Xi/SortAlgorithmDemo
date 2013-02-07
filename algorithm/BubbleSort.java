package algorithm;

import engine.Driving;

public class BubbleSort extends Driving {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		bubbleSort();
	}

	public void bubbleSort(){
		for(int i=0;i<unsort.length;i++){
			for(int j=0;j<unsort.length-i-1;j++){
				if(unsort[j]>unsort[j+1]){
					int temp=unsort[j];
					unsort[j]=unsort[j+1];
					unsort[j+1]=temp;

					/*
					 * repaint the histogram and sleep
					 */
					drawing.highlight(j, j+1);
					drawing.draw(unsort);

					try{
						Thread.sleep(sleepTime);
					}catch(Exception ex){
						ex.printStackTrace();
					}
				}
			}
		}
	}
}
