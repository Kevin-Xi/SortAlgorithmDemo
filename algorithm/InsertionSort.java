package algorithm;

import engine.Driving;

public class InsertionSort extends Driving {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		insertionSort();
	}

	private void insertionSort(){
		for(int j=1;j<unsort.length;j++){
			int key=unsort[j];
			int i=j-1;
			while((i>=0)&&(unsort[i]>key)){	//insert the first element of unsorted zone to the appropriate position of the sorted zone
				unsort[i+1]=unsort[i];
				i=i-1;
				
				/*
				 * repaint the histogram and sleep
				 */
				drawing.highlight(i,j);
				drawing.draw(unsort);
				try{
					Thread.sleep(sleepTime);
				}catch(Exception ex){
					ex.printStackTrace();
				}
			}
			unsort[i+1]=key;
			
			drawing.draw(unsort);
			try{
				Thread.sleep(sleepTime);
			}catch(Exception ex){
				ex.printStackTrace();
			}
		}
	}
}
