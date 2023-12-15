package edu.wm.cs.cs301.guimemorygame.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.Timer;

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
			view.getFeedbackPanel().updateLabel("");
			view.getFrame().pack();
//			System.out.println("Clicked button with visibility false");
			button.flip();
			view.getFrame().pack();
			System.out.println("Flipped over button");
			if (model.getSelection() == null) {
				model.setSelection(button);
			} else {
				if (model.getSelection().getSymbol() == button.getSymbol()) {
					// Match!
					// Keep cards flipped
					// increment match counter
					model.incrementMatches();
					if (model.winState()) {
						String finalTurn = String.valueOf(model.getTurn());
						view.getTurnPanel().updateLabel("You won in " + finalTurn + " turn(s)!");
						view.getFrame().pack();
					}
				} else {
					// No match :(
					// Flip cards back over after 2 secs
					MemoryCardButton button2 = model.getSelection();
					Timer timer = new Timer(2000, new ActionListener() {
	                    public void actionPerformed(ActionEvent e) {
	                    	Thread t = new Thread(new DoubleFlipRunnable(button, button2));
	                    	t.start();
	                    };
	                });
					timer.setRepeats(false);
					timer.start();

					model.incrementTurn();
					view.getTurnPanel().updateLabel("Turn: " + String.valueOf(model.getTurn()));
					view.getFrame().pack();
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
		} else {
			view.getFeedbackPanel().updateLabel("Please choose a card that is not flipped");
			view.getFrame().pack();
		}
		
	}
	
}