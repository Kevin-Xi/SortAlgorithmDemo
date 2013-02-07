package algorithm;

import engine.Driving;

public class HeapSort extends Driving {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		heapSort();
	}

	private void heapSort(){
		int count=unsort.length;
		BuildMaxHeap(unsort,count);
		for(int i=count-1;i>0;i--){
			int temp=unsort[0];
			unsort[0]=unsort[i];
			unsort[i]=temp;
			
			/*
			 * repaint the histogram and sleep
			 */
			drawing.draw(unsort);

			try{
				Thread.sleep(sleepTime);
			}catch(Exception ex){
				ex.printStackTrace();
			}
			
			count--;
			MaxHeapify(unsort,0,count-1);
		}
	}
	
	private void MaxHeapify(int unsort[],int i,int count){
		int l=2*i+1; //left
		int r=2*i+2; //right
		int largest;
		if((l<=count)&&(unsort[l]>unsort[i]))
			largest=l;
		else
			largest=i;
		if((r<=count)&&(unsort[r]>unsort[largest]))
			largest=r;
		if(largest!=i){
			int temp=unsort[i];
			unsort[i]=unsort[largest];
			unsort[largest]=temp;
			
			/*
			 * repaint the histogram and sleep
			 */
			drawing.highlight(r, largest);
			drawing.draw(unsort);

			try{
				Thread.sleep(sleepTime);
			}catch(Exception ex){
				ex.printStackTrace();
			}
			
			MaxHeapify(unsort,largest,count-1);
		}
	}

	private void BuildMaxHeap(int unsort[],int count){
		for(int i=count/2+1;i>=0;i--)
			MaxHeapify(unsort,i,count-1);
	}
}
