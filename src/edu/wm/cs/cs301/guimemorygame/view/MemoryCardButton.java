package edu.wm.cs.cs301.guimemorygame.view;

import javax.swing.JButton;

import edu.wm.cs.cs301.guimemorygame.model.MemoryCard;

public class MemoryCardButton extends JButton {
	
	// IMPORTANT NOTE: symbol is NOT the same as the displayed text!
	// The displayed text will sometimes be a question mark, but symbol
	// WILL NOT change!
	private Character symbol;
	
	private String displaySymbol;
	
	private boolean visible;
	
	public MemoryCardButton(String text, MemoryCard mc) {
		super(text);
		this.symbol = mc.getSymbol();
		this.visible = mc.isVisible();
//		System.out.println("Created a card with visibility " + String.valueOf(visible));
	}
	
	public Character getSymbol() {
		return symbol;
	}
	
	public boolean getVisibility() {
		return visible;
	}
	
	public void flip() {
		if(visible) {
			visible = false;
			displaySymbol  = "?";
			setText(displaySymbol);
//			repaint();
			// Code to change displayed text to question mark
		} else {
			visible = true;
			displaySymbol  = symbol.toString();
			setText(displaySymbol);
//			repaint();
			// Code to change displayed text to symbol
		}
	}
	
}