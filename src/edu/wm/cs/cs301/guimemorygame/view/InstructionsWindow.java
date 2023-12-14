package edu.wm.cs.cs301.guimemorygame.view;

import javax.swing.JDialog;

public class InstructionsWindow extends JDialog {
	
	public InstructionsWindow(MemoryFrame view) {
		super(view.getFrame(), "Instructions", true);
		
		pack();
		setLocationRelativeTo(view.getFrame());
		setVisible(true);
	}
}