package edu.wm.cs.cs301.guimemorygame.controller;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JDialog;

import edu.wm.cs.cs301.guimemorygame.model.MemoryModel;
import edu.wm.cs.cs301.guimemorygame.view.MemoryCardButton;
import edu.wm.cs.cs301.guimemorygame.view.MemoryFrame;

public class PlayAgainAction extends AbstractAction {

	private MemoryFrame view;
	
	private MemoryModel model;
	
	private JDialog dialog;

	public PlayAgainAction(MemoryFrame view, MemoryModel model, JDialog dialog) {
		this.view = view;
		this.model = model;
		this.dialog = dialog;
	}

	@Override
	public void actionPerformed(ActionEvent event) {
//		JButton button = (JButton) event.getSource();
		
		dialog.dispose();
		model.initializeMemoryGrid();
		view.refresh();
	}
	
}
