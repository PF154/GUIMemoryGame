package edu.wm.cs.cs301.guimemorygame.view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import edu.wm.cs.cs301.guimemorygame.model.MemoryCard;

public class MemoryCardButton extends JButton {
	
	// IMPORTANT NOTE: symbol is NOT the same as the displayed text!
	// The displayed text will sometimes be a question mark, but symbol
	// WILL NOT change!
	private Character symbol;
	
	private String displaySymbol;
	
	private boolean visible;
	
	private MemoryCard memoryCard;
	
	public MemoryCardButton(String text, MemoryCard mc) {
		super(text);
		this.memoryCard = mc;
		this.symbol = mc.getSymbol();
		this.visible = mc.isVisible();
//		System.out.println("Created a card with visibility " + String.valueOf(visible));
	}
	
	public Character getSymbol() {
		return symbol;
		// These functions should probably modify the MC as well to keep it updated
	}
	
	public boolean getVisibility() {
		return visible;
	}
	
	public void flip() {
		if(visible) {
			visible = false;
			displaySymbol  = "?";
			// Need to do something here to repack the buttons with new size
			// Code to change displayed text to question mark
		} else {
			visible = true;
			displaySymbol  = symbol.toString();
			// Code to change displayed text to symbol
		}
		setText(displaySymbol);
	}
	
	public MemoryCard getMemoryCard() {
		return memoryCard;
	}
	
}