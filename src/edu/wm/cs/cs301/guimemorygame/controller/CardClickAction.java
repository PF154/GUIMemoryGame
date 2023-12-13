package edu.wm.cs.cs301.guimemorygame.controller;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JButton;

import edu.wm.cs.cs301.guimemorygame.model.MemoryModel;
import edu.wm.cs.cs301.guimemorygame.view.MemoryCardButton;
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
		MemoryCardButton button = (MemoryCardButton) e.getSource();
		if (button.getVisibility() == false) {
//			System.out.println("Clicked button with visibility false");
			if (model.getSelection() == null) {
				button.flip();
				model.setSelection(button);
			} else {
				button.flip();
				if (model.getSelection().getSymbol() == button.getSymbol()) {
					// Match!
					// Keep cards flipped
					// increment match counter
				} else {
					// No match :(
					// Flip cards back over after 2 secs
					model.getSelection().flip();
					button.flip();
				}
				model.setSelection(null);
				
			}
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
	
}