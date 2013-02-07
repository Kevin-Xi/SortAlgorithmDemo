package algorithm;

import engine.Driving;

public class ShellSort extends Driving {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		shellSort();
	}

	private void shellSort(){
		int inner,outer;
		int h=1;
		while(h<=unsort.length/3)
			h=h*3+1;
		while(h>0){
			for(outer=h;outer<unsort.length;outer++){
				int temp=unsort[outer];
				inner=outer;
				while((inner>h-1)&&(unsort[inner-h]>=temp)){
					unsort[inner]=unsort[inner-h];
					inner-=h;
					
					/*
					 * repaint the histogram and sleep
					 */
					drawing.highlight(inner-h,outer);
					drawing.draw(unsort);

					try{
						Thread.sleep(sleepTime);
					}catch(Exception ex){
						ex.printStackTrace();
					}
					
				}
				unsort[inner]=temp;
				
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
			h=(h-1)/3;
		}
	}
}
