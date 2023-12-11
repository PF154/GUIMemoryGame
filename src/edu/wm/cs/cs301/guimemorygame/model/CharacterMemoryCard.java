package edu.wm.cs.cs301.guimemorygame.model;

import javax.swing.JButton;

public class CharacterMemoryCard implements MemoryCard {
	private final Character symbol;
	private boolean visible;
	
	public CharacterMemoryCard(char s) {
		this.symbol = s;
		this.visible = false;
	}
	
	public boolean equals(MemoryCard other) {
		if (other.getSymbol() == symbol) {
			return true;
		}
		return false;
	}
	
	public void setVisible(boolean v) {
		visible = v;
	}
	
	public boolean isVisible() {
		return visible;
	}
	
	public Character getSymbol() {
		return symbol;
	}
	
//	public JButton getButton(boolean flipped) {
//		Will return a the button corresponding to the memory card in the
//		correct state, that is, it will have a character label if it is 
//		flipped, and no label if it is not.
//	}
}