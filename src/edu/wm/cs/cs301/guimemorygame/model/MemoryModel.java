package edu.wm.cs.cs301.guimemorygame.model;

public class MemoryModel {
	
	private MemoryCard[][] memoryGrid;
	
	private Alphabet alphabet;
	
	private int rows, columns;
	
	public MemoryModel() {
		this.alphabet = new LatinAlphabet();
		this.rows = 3;
		this.columns = 4;
		
		intitializeMemoryGrid();
	}
	
	private void intitializeMemoryGrid() {
		MemoryCard[][] memoryGrid = new MemoryCard[rows][columns];
	}
	
	public MemoryCard[][] getMemoryGrid() {
		return memoryGrid;
	}
	
}