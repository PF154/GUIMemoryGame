package edu.wm.cs.cs301.guimemorygame.controller;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JButton;

import edu.wm.cs.cs301.guimemorygame.model.MemoryModel;
import edu.wm.cs.cs301.guimemorygame.view.MemoryFrame;

public class CardClickAction extends AbstractAction {
	
	private final MemoryFrame view;
	
	private final MemoryModel model;

	public CardClickAction(MemoryFrame view, MemoryModel model) {
		this.view = view;
		this.model = model;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		JButton button = (JButton) e.getSource();
		// Access model to see if this is first or second card
		// If it is first...
		// 		Flip card over
		//		Store symbol in model
		// IF it is second...
		//		Flip card over
		// 		Compare to symbol stored in model
		//		Keep flipped if they're the same
		//		Turn back over if they aren't
		
	}
	
}