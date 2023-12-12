package edu.wm.cs.cs301.guimemorygame.view;

import javax.swing.JButton;

import edu.wm.cs.cs301.guimemorygame.model.MemoryCard;

public class MemoryCardButton extends JButton {
	
	private Character symbol;
	
	private boolean visible;
	
	public MemoryCardButton(String text, MemoryCard mc) {
		super(text);
		this.symbol = mc.getSymbol();
		this.visible = mc.isVisible();
	}
	
}