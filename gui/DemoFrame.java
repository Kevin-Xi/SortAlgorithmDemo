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

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import algorithm.InsertionSort;
import algorithm.SelectionSort;
import algorithm.BubbleSort;
import algorithm.QuickSort;
import algorithm.HeapSort;
import algorithm.ShellSort;

public class DemoFrame extends JFrame {
	private Thread thread;	///////////////////////////
	private Driving driving;	/////////////////////////////
	private Drawing drawing;
	private int[] numberGroup;
	private int count;
	
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
	
	public DemoFrame(Color colorStart,Color colorEnd,Color colorHighlight,Shapes shape,Algorithms algorithm,int count){
		initDrawing(colorStart,colorEnd,colorHighlight,shape);
		
		initDriving(algorithm,count);	
		
		constructDemoFrame();
		
		addListeners();
	}	
	
	private void initDrawing(Color colorStart,Color colorEnd,Color colorHighlight,Shapes shape){
		switch(shape){
		case COLUMN:
			drawing=new Column();
			break;
		case CIRCLE:
		case TRIANGLE:
		case DIAMOND:
			drawing=new Column();
			break;
		}
		
		drawing.setColor(colorStart,colorEnd,colorHighlight);
	}
	
	private void initDriving(Algorithms algorithm,int count){
		this.count=count;
		
		switch(algorithm){
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
		driving.setArray(unsort);
	}
	
	private void constructDemoFrame(){
		jpDemo.setLayout(new BorderLayout());
		jpDemo.add(drawing,BorderLayout.CENTER);
		
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
					jbtStartOrSuspend.setText("Suspend");
					thread=new Thread(driving);
					thread.start();
				}
				else{
					thread.stop();
					jbtStartOrSuspend.setText("Start");
				}
			}
		});
		
		jbtRestart.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				thread.stop();
				jbtStartOrSuspend.setText("Start");
				int[] unsort=new int[count];
				System.arraycopy(numberGroup, 0, unsort, 0, count);
				drawing.draw(unsort);
				driving.setArray(unsort);	
			}
		});
		
		jslSpeed.addChangeListener(new ChangeListener(){
			public void stateChanged(ChangeEvent e){
				jlbShowSpeed.setText(String.valueOf(jslSpeed.getValue()));
				driving.setSleepTime((100-jslSpeed.getValue())*20);
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
