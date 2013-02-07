package algorithm;

import engine.Driving;

public class QuickSort extends Driving {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		quickSort(unsort,0,unsort.length-1);
	}

	private void quickSort(int unsort[],int p,int r){
		if(p<r){
			int q=Partition(unsort,p,r);
			quickSort(unsort,p,q-1);
			quickSort(unsort,q+1,r);
		}
	}
	
	private int Partition(int unsort[],int p, int r){
		int x=unsort[r];
		int i=p-1;
		for(int j=p;j<=r-1;j++){
			if(unsort[j]<=x){
				++i;
				int temp=unsort[i];
				unsort[i]=unsort[j];
				unsort[j]=temp;
				
				/*
				 * repaint the histogram and sleep
				 */
				drawing.highlight(j, r);
				drawing.draw(unsort);

				try{
					Thread.sleep(sleepTime);
				}catch(Exception ex){
					ex.printStackTrace();
				}
			}
		}
		int temp=unsort[i+1];
		unsort[i+1]=unsort[r];
		unsort[r]=temp;
		
		/*
		 * repaint the histogram and sleep
		 */
		drawing.draw(unsort);

		try{
			Thread.sleep(sleepTime);
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return i+1;
	}
}
