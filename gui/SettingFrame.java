package gui;

import gui.DemoFrame;
import javax.swing.*;
import javax.swing.border.TitledBorder;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.*;

/**
 * SettingFrame include setting panel "Run" and setting panel "Appearance", 
 * jbtStart call DemoFrame.
 * @author Kevin
 *
 */
public class SettingFrame extends JFrame {
	/* Setting Panel "Run" */
	private ButtonGroup bgAlgorithm=new ButtonGroup();
	private JCheckBox jcbSelection=new JCheckBox("Selection");
	private JCheckBox jcbInsertion=new JCheckBox("Insertion");
	private JCheckBox jcbBubble=new JCheckBox("Bubble");
	private JCheckBox jcbQuick=new JCheckBox("Quick");
	private JCheckBox jcbHeap=new JCheckBox("Heap");
	private JCheckBox jcbShell=new JCheckBox("Shell");
	private JLabel jlbAlgorithm=new JLabel("Algorithm:");
	private JPanel jpAlgorithm=new JPanel();
	
	private JLabel jlbCount=new JLabel("Count:");
	private JTextField jtfCount=new JTextField("30");
	private JPanel jpCount=new JPanel();
	
	private JPanel jpRun=new JPanel();
	
	
	/* Setting Panel Appearance */
	private ButtonGroup bgShape=new ButtonGroup();
	private JCheckBox jcbColumn=new JCheckBox("Column");
	private JCheckBox jcbCircle=new JCheckBox("Circle");
	private JCheckBox jcbTriangle=new JCheckBox("Triangle");
	private JCheckBox jcbDiamond=new JCheckBox("Diamond");
	private JLabel jlbShape=new JLabel("Shape:");
	private JPanel jpShape=new JPanel();

	private JButton jbtColor=new JButton("Element Color Setting");
	private Color colorStart=Color.YELLOW;	//
	private Color colorEnd=Color.BLUE;	//
	//private JCheckBox jcbHighlight=new JCheckBox("Highlight current comparing number");
	private JButton jbtHighlight=new JButton("Highlight Color Setting");
	private JPanel jpColor=new JPanel();
	private Color colorHighlight=Color.RED;	//
	
	private JPanel jpAppearance=new JPanel();
	
	/* Call DemoFrame */
	private JButton jbtStart=new JButton("Start!");
	private DemoFrame demoFrame=null;
	private SettingFrame settingFrame=this;	//use as component frame in gui.SettingFrame.addListeners()
	
	
	/**
	 * Construct SettingFrame, add jbtStart listener to call DemoFrame
	 */
	public SettingFrame(){
		constructRunPanel();
		
		constructAppearancePanel();
				
		constructSettingFrame();
		
		addListeners();
	}
	
	/**
	 * Setting panel "Run"
	 */
	private void constructRunPanel(){		
		/* Button group of algorithm selection panel */
		bgAlgorithm.add(jcbSelection);
		bgAlgorithm.add(jcbInsertion);
		bgAlgorithm.add(jcbBubble);
		bgAlgorithm.add(jcbQuick);
		bgAlgorithm.add(jcbHeap);
		bgAlgorithm.add(jcbShell);
		jcbSelection.setSelected(true);
		
		/* Construct algorithm selection panel */
		jpAlgorithm.setLayout(new GridLayout(1,7));
		jpAlgorithm.add(jlbAlgorithm);
		jpAlgorithm.add(jcbSelection);
		jpAlgorithm.add(jcbInsertion);
		jpAlgorithm.add(jcbBubble);
		jpAlgorithm.add(jcbQuick);
		jpAlgorithm.add(jcbHeap);
		jpAlgorithm.add(jcbShell);
		
		/* Count panel */
		jpCount.setLayout(new GridLayout(1,2));
		jpCount.add(jlbCount);
		jpCount.add(jtfCount);
		
		jpRun.setLayout(new GridLayout(2,1));
		jpRun.add(jpAlgorithm);
		jpRun.add(jpCount);
		jpRun.setBorder(new TitledBorder("Run"));
	}
	
	/**
	 * Setting panel Appearance
	 */
	private void constructAppearancePanel(){
		/* Button group of shape selection */
		bgShape.add(jcbColumn);
		bgShape.add(jcbCircle);
		bgShape.add(jcbTriangle);
		bgShape.add(jcbDiamond);
		jcbColumn.setSelected(true);
		
		/* Construct a upper panel of jpAppearance */
		jpColor.setLayout(new FlowLayout());
		jpColor.add(jbtColor);
		jpColor.add(jbtHighlight);
		
		/* Construct shape panel */
		jpShape.setLayout(new GridLayout(1,5));
		jpShape.add(jlbShape);
		jpShape.add(jcbColumn);
		jpShape.add(jcbCircle);
		jpShape.add(jcbTriangle);
		jpShape.add(jcbDiamond);
		
		jpAppearance.setLayout(new BorderLayout());
		jpAppearance.add(jpColor,BorderLayout.NORTH);
		jpAppearance.add(jpShape,BorderLayout.SOUTH);
		jpAppearance.setBorder(new TitledBorder("Appearance"));
	}
	
	/**
	 * Construct SettingFrame
	 */
	private void constructSettingFrame(){
		setLayout(new BorderLayout());
		add(jpRun,BorderLayout.NORTH);
		add(jpAppearance,BorderLayout.CENTER);
		add(jbtStart,BorderLayout.SOUTH);
	}
	
	/**
	 * Add listener of jbtStart button to call DemoFrame, jbtColor button to call color chooser dialog, jcbHighlight to call color chooser dialog
	 */
	private void addListeners(){
		jbtStart.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				int count;
				try{
					count=Integer.parseInt(jtfCount.getText());
					if(count<=1){
						JOptionPane.showMessageDialog(settingFrame, "Count should be bigger than 1!", "Invalid Argument", JOptionPane.ERROR_MESSAGE);
						return;
					}
				}catch(Exception ex){
					JOptionPane.showMessageDialog(settingFrame, "Count should be a integer!", "Invalid Argument", JOptionPane.ERROR_MESSAGE);
					return;
				}
				
				
				
				demoFrame=new DemoFrame(colorStart,colorEnd,colorHighlight,getShapeSelected(),getAlgorithmSelected(),count);	//?????is that good?
				
				demoFrame.setTitle("Sort Algorithm Demo");
				demoFrame.setSize(750,550);
				demoFrame.setLocation(250,150);
				demoFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				demoFrame.setVisible(true);
				
				demoFrame.setExtendedState(Frame.MAXIMIZED_BOTH);	//Maximized the demoFrame after loading
			}
		});
		
		jbtColor.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				colorStart=JColorChooser.showDialog(settingFrame, "Choose start color", Color.YELLOW);
				if(colorStart!=null){
					colorEnd=JColorChooser.showDialog(settingFrame, "Choose end color", Color.BLUE);
				}
			}
		});
		
		jbtHighlight.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
					colorHighlight=JColorChooser.showDialog(settingFrame, "Choose highlight color", Color.RED);			
			}
		});
	}
	
	/**
	 * enum the name of algorithms
	 * @author Kevin
	 *
	 */
	public enum Algorithms{
		SELECTION,
		INSERTION,
		BUBBLE,
		QUICK,
		HEAP,
		SHELL;
	}
	
	/**
	 * enum the name of shapes
	 * @author Kevin
	 *
	 */
	public enum Shapes{
		COLUMN,
		CIRCLE,
		TRIANGLE,
		DIAMOND;
	}
	
	/**
	 * return selection statue of algorithm checkbox
	 */	
	private Algorithms getAlgorithmSelected(){
		if(jcbSelection.isSelected())
			return Algorithms.SELECTION;
		else if(jcbInsertion.isSelected())
			return Algorithms.INSERTION;
		else if(jcbBubble.isSelected())
			return Algorithms.BUBBLE;
		else if(jcbQuick.isSelected())
			return Algorithms.QUICK;
		else if(jcbHeap.isSelected())
			return Algorithms.HEAP;
		else
			return Algorithms.SHELL;
	}
	
	/**
	 * return selection statue of shapes checkbox
	 * @return
	 */
	private Shapes getShapeSelected(){
		if(jcbColumn.isSelected())
			return Shapes.COLUMN;
		return Shapes.CIRCLE;
	}
}