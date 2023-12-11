package edu.wm.cs.cs301.guimemorygame;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import edu.wm.cs.cs301.guimemorygame.model.MemoryModel;
import edu.wm.cs.cs301.guimemorygame.view.MemoryFrame;

public class Memory implements Runnable {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Memory());
		
		// cross-platform setup
		try {
		    UIManager.setLookAndFeel( UIManager.getCrossPlatformLookAndFeelClassName() );
		 } catch (Exception e) {
			 e.printStackTrace();
		 }

	}
	
	@Override
	public void run() {
		new MemoryFrame(new MemoryModel());
	}

}