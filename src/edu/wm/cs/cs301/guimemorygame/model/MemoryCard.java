package edu.wm.cs.cs301.guimemorygame.model;

public interface MemoryCard {
	public boolean equals(MemoryCard other);
	public void setVisible(boolean v);
	public boolean isVisible();
	public Character getSymbol();
}