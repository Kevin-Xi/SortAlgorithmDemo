package algorithm;

import engine.Driving;

public class SelectionSort extends Driving{
	public void run(){
		selectionSort();
	}
	
	private void selectionSort(){		
		int key=0;
		int count=0;
		while(count<unsort.length-1){
			for(int i=key+1;i<unsort.length;i++){	//pick up the minimum
				if(unsort[key]>unsort[i])	
					key=i;
				drawing.highlight(i,key);
				drawing.draw(unsort);
				try{
					Thread.sleep(sleepTime);
				}catch(Exception ex){
					ex.printStackTrace();
				}
			}	
			int temp=unsort[count];		//switch the minimum with the first index
			unsort[count]=unsort[key];
			unsort[key]=temp;
			
			count++;
			key=count;

			/*
			 * repaint the histogram and sleep
			 */
			drawing.draw(unsort);	

			try{
				Thread.sleep(sleepTime);
			}catch(Exception ex){
				ex.printStackTrace();
			}
		}
	}
}
