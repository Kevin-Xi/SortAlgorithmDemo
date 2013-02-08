package gui;

import engine.Driving;
import gui.SettingFrame.Algorithms;
import gui.SettingFrame.Shapes;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import algorithm.BubbleSort;
import algorithm.HeapSort;
import algorithm.InsertionSort;
import algorithm.QuickSort;
import algorithm.SelectionSort;
import algorithm.ShellSort;

public class DemoFrame extends JFrame {
	//private Thread thread;	///////////////////////////
	private ExecutorService executor=Executors.newCachedThreadPool();
	private Driving driving;	/////////////////////////////
	private Drawing drawing0;
	private Drawing drawing1;
	private Drawing drawing2;
	private Drawing drawing3;
	private Drawing drawing4;
	private Drawing drawing5;
	private int[] numberGroup;
	private int count;
	private int demoNumber=0;
	private LinkedList<Driving> drivingList=new LinkedList<Driving>();
	private LinkedList<JPanel> jpSubDemoList=new LinkedList<JPanel>();
	
	private JPanel jpDemo=new JPanel();
	
	private JLabel jlbComparisonTime=new JLabel("Comparison Time: ");
	
	private JButton jbtStartOrSuspend=new JButton("Start");
	private JButton jbtRestart=new JButton("Restart");
	private JButton jbtStepForward=new JButton("Step Forward");
	private JButton jbtStepBackward=new JButton("Step Backward");
	private JPanel jpControlButtons=new JPanel();
	
	private JSlider jslSpeed=new JSlider(JSlider.HORIZONTAL);
	private JLabel jlbSpeed=new JLabel("Speed:");
	private JLabel jlbShowSpeed=new JLabel("50");
	private JPanel jpSpeed=new JPanel();
	
	private JPanel jpControl=new JPanel();
	
	public DemoFrame(Color colorStart,Color colorEnd,Color colorHighlight,Shapes shape,String algorithmSelectedStatus,int count){
		initDrawing(colorStart,colorEnd,colorHighlight,shape);
		
		initDriving(algorithmSelectedStatus,count);	
		
		constructDemoFrame();
		
		addListeners();
	}	
	
	private void initDrawing(Color colorStart,Color colorEnd,Color colorHighlight,Shapes shape){
		switch(shape){
		case COLUMN:
			drawing0=new Column();
			drawing1=new Column();
			drawing2=new Column();
			drawing3=new Column();
			drawing4=new Column();
			drawing5=new Column();
			break;
		case CIRCLE:
		case TRIANGLE:
		case DIAMOND:
			drawing0=new Column();
			drawing1=new Column();
			drawing2=new Column();
			drawing3=new Column();
			drawing4=new Column();
			drawing5=new Column();
			break;
		}
		
		drawing0.setColor(colorStart,colorEnd,colorHighlight);
		drawing1.setColor(colorStart,colorEnd,colorHighlight);
		drawing2.setColor(colorStart,colorEnd,colorHighlight);
		drawing3.setColor(colorStart,colorEnd,colorHighlight);
		drawing4.setColor(colorStart,colorEnd,colorHighlight);
		drawing5.setColor(colorStart,colorEnd,colorHighlight);
	}
	
	private void initDriving(String algorithmSelectedStatus,int count){
		this.count=count;
		
		numberGroup=UnsortGenerator(count);
		/*switch(algorithm){
		case SELECTION:
			driving=new SelectionSort();
			break;
		case INSERTION:
			driving=new InsertionSort();
			break;
		case BUBBLE:
			driving=new BubbleSort();
			break;
		case QUICK:
			driving=new QuickSort();
			break;
		case HEAP:
			driving=new HeapSort();
			break;
		case SHELL:
			driving=new ShellSort();
			break;	
		}
		
		driving.setDrawing(drawing);
		driving.setSleepTime((100-jslSpeed.getValue())*20);
		
		numberGroup=UnsortGenerator(count);
		int[] unsort=new int[count];
		System.arraycopy(numberGroup, 0, unsort, 0, count);
		drawing.draw(unsort);
		driving.setArray(unsort);*/
		
		if(algorithmSelectedStatus.charAt(0)=='1'){
				demoNumber++;
				Driving driving0=new SelectionSort();
				
				driving0.setDrawing(drawing0);
				driving0.setSleepTime((100-jslSpeed.getValue())*20);
				
				int[] unsort=new int[count];
				System.arraycopy(numberGroup, 0, unsort, 0, count);
				drawing0.draw(unsort);
				driving0.setArray(unsort);
				drivingList.add(driving0);
				
				JPanel jpSubDemo0=new JPanel();
				jpSubDemo0.setBorder(new TitledBorder("Selection Sort"));
				jpSubDemo0.setLayout(new BorderLayout());
				jpSubDemo0.add(drawing0,BorderLayout.CENTER);
				jpSubDemoList.add(jpSubDemo0);
		}
		
		if(algorithmSelectedStatus.charAt(1)=='1'){
			demoNumber++;
			Driving driving1=new InsertionSort();
			
			driving1.setDrawing(drawing1);
			driving1.setSleepTime((100-jslSpeed.getValue())*20);
			
			int[] unsort=new int[count];
			System.arraycopy(numberGroup, 0, unsort, 0, count);
			drawing1.draw(unsort);
			driving1.setArray(unsort);
			drivingList.add(driving1);
			
			JPanel jpSubDemo1=new JPanel();
			jpSubDemo1.setBorder(new TitledBorder("Insertion Sort"));
			jpSubDemo1.setLayout(new BorderLayout());
			jpSubDemo1.add(drawing1,BorderLayout.CENTER);
			jpSubDemoList.add(jpSubDemo1);
	}
		
		if(algorithmSelectedStatus.charAt(2)=='1'){
			demoNumber++;
			Driving driving2=new BubbleSort();
			
			driving2.setDrawing(drawing2);
			driving2.setSleepTime((100-jslSpeed.getValue())*20);
			
			int[] unsort=new int[count];
			System.arraycopy(numberGroup, 0, unsort, 0, count);
			drawing2.draw(unsort);
			driving2.setArray(unsort);
			drivingList.add(driving2);
			
			JPanel jpSubDemo2=new JPanel();
			jpSubDemo2.setBorder(new TitledBorder("Bubble Sort"));
			jpSubDemo2.setLayout(new BorderLayout());
			jpSubDemo2.add(drawing2,BorderLayout.CENTER);
			jpSubDemoList.add(jpSubDemo2);
	}
		
		if(algorithmSelectedStatus.charAt(3)=='1'){
			demoNumber++;
			Driving driving3=new QuickSort();
			
			driving3.setDrawing(drawing3);
			driving3.setSleepTime((100-jslSpeed.getValue())*20);
			
			int[] unsort=new int[count];
			System.arraycopy(numberGroup, 0, unsort, 0, count);
			drawing3.draw(unsort);
			driving3.setArray(unsort);
			drivingList.add(driving3);
			
			JPanel jpSubDemo3=new JPanel();
			jpSubDemo3.setBorder(new TitledBorder("Quick Sort"));
			jpSubDemo3.setLayout(new BorderLayout());
			jpSubDemo3.add(drawing3,BorderLayout.CENTER);
			jpSubDemoList.add(jpSubDemo3);
	}
		
		if(algorithmSelectedStatus.charAt(4)=='1'){
			demoNumber++;
			Driving driving4=new HeapSort();
			
			driving4.setDrawing(drawing4);
			driving4.setSleepTime((100-jslSpeed.getValue())*20);
			
			int[] unsort=new int[count];
			System.arraycopy(numberGroup, 0, unsort, 0, count);
			drawing4.draw(unsort);
			driving4.setArray(unsort);
			drivingList.add(driving4);
			
			JPanel jpSubDemo4=new JPanel();
			jpSubDemo4.setBorder(new TitledBorder("Heap Sort"));
			jpSubDemo4.setLayout(new BorderLayout());
			jpSubDemo4.add(drawing4,BorderLayout.CENTER);
			jpSubDemoList.add(jpSubDemo4);
	}
		
		if(algorithmSelectedStatus.charAt(5)=='1'){
			demoNumber++;
			Driving driving5=new ShellSort();
			
			driving5.setDrawing(drawing5);
			driving5.setSleepTime((100-jslSpeed.getValue())*20);
			
			int[] unsort=new int[count];
			System.arraycopy(numberGroup, 0, unsort, 0, count);
			drawing5.draw(unsort);
			driving5.setArray(unsort);
			drivingList.add(driving5);
			
			JPanel jpSubDemo5=new JPanel();
			jpSubDemo5.setBorder(new TitledBorder("Shell Sort"));
			jpSubDemo5.setLayout(new BorderLayout());
			jpSubDemo5.add(drawing5,BorderLayout.CENTER);
			jpSubDemoList.add(jpSubDemo5);
	}

	}
	
	private void constructDemoFrame(){
		if(jpSubDemoList.size()==1){
			jpDemo.setLayout(new BorderLayout());
			jpDemo.add(jpSubDemoList.removeFirst(),BorderLayout.CENTER);
		}else{
			jpDemo.setLayout(new GridLayout(2,3));
			//jpDemo.add(drawing,BorderLayout.CENTER);
			while(jpSubDemoList.size()!=0){
				jpDemo.add(jpSubDemoList.removeFirst());
			}
		}
		
		jpControlButtons.setLayout(new FlowLayout());
		jpControlButtons.add(jlbComparisonTime);	//
		jpControlButtons.add(jbtStartOrSuspend);
		jpControlButtons.add(jbtRestart);
		jpControlButtons.add(jbtStepForward);
		jpControlButtons.add(jbtStepBackward);
		
		jpSpeed.setLayout(new FlowLayout());
		jpSpeed.add(jlbSpeed);
		jpSpeed.add(jslSpeed);
		jpSpeed.add(jlbShowSpeed);
		
		jpControl.setLayout(new GridLayout(2,1));
		jpControl.add(jpControlButtons);
		jpControl.add(jpSpeed);
		
		setLayout(new BorderLayout());
		add(jpDemo,BorderLayout.CENTER);
		add(jpControl,BorderLayout.SOUTH);
	}
	
	private void addListeners(){
		jbtStartOrSuspend.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(jbtStartOrSuspend.getText().equals("Start")){
					for(int i=0;i<drivingList.size();i++)
						executor.execute(drivingList.get(i));
					jbtStartOrSuspend.setText("Suspend");
				}
				else{
					executor.shutdownNow();
					jbtStartOrSuspend.setText("Start");
				}
			}
		});
		
		jbtRestart.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				executor.shutdownNow();
				jbtStartOrSuspend.setText("Start");
				/*int[] unsort=new int[count];
				System.arraycopy(numberGroup, 0, unsort, 0, count);
				drawing.highlight(-1,-1);
				drawing.draw(unsort);
				driving.setArray(unsort);	*/
			}
		});
		
		jslSpeed.addChangeListener(new ChangeListener(){
			public void stateChanged(ChangeEvent e){
				jlbShowSpeed.setText(String.valueOf(jslSpeed.getValue()));
				for(int i=0;i<drivingList.size();i++)
					drivingList.get(i).setSleepTime((100-jslSpeed.getValue())*20);
			}
		});
	}
	
	/**
	 * Random-shuffle number group
	 */
	private int[] UnsortGenerator(int count){		
		int[] tempArray=new int[count];
		
		for(int i=0;i<count;i++){
			tempArray[i]=i+1;
		}
		
		/*
		 * generate random number group
		 */
		for(int j=0;j<count;j++){
			int index=(int)(Math.random()*count);

			int temp=tempArray[j];
			tempArray[j]=tempArray[index];
			tempArray[index]=temp;
		}
		
		return tempArray;
	}
}
