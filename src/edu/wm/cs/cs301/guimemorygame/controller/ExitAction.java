package edu.wm.cs.cs301.guimemorygame.controller;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JDialog;

import edu.wm.cs.cs301.guimemorygame.view.MemoryCardButton;
import edu.wm.cs.cs301.guimemorygame.view.MemoryFrame;

public class ExitAction extends AbstractAction {

	private MemoryFrame view;
	
	private JDialog dialog;

	public ExitAction(MemoryFrame view, JDialog dialog) {
		this.view = view;
		this.dialog = dialog;
	}

	@Override
	public void actionPerformed(ActionEvent event) {
//		JButton button = (JButton) event.getSource();
		
		dialog.dispose();
		view.shutdown();
	}
	
}
