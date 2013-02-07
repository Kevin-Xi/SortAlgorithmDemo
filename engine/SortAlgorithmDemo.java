package engine;

import javax.swing.JFrame;

import gui.SettingFrame;

public class SortAlgorithmDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SettingFrame settingFrame=new SettingFrame();
		
		settingFrame.setTitle("Sort Algorithm Setting");
		settingFrame.setSize(650,235);
		settingFrame.setLocation(200,100);
		settingFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		settingFrame.setVisible(true);
	}

}
