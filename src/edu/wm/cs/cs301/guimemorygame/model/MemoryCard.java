package edu.wm.cs.cs301.guimemorygame.model;

import javax.swing.JButton;

public interface MemoryCard {
	public boolean equals(MemoryCard other);
	public void setVisible(boolean v);
	public boolean isVisible();
	public Character getSymbol();
}