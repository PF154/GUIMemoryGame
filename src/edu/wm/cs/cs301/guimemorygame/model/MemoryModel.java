package edu.wm.cs.cs301.guimemorygame.model;

public class MemoryModel {
	
	private MemoryCard[][] memoryGrid;
	
	private Alphabet alphabet;
	
	private int rows, columns;
	
//	private 
	
	public MemoryModel() {
		this.alphabet = new LatinAlphabet();
		this.rows = 3;
		this.columns = 4;
		
		intitializeMemoryGrid();
	}
	
	private void intitializeMemoryGrid() {
		memoryGrid = new MemoryCard[rows][columns];
		
		// dummy code to give values to grid, will be changed eventually
		for (int i = 0; i < memoryGrid.length; i++) {
			for (int j = 0; j < memoryGrid[0].length; j++) {
				memoryGrid[i][j] = new CharacterMemoryCard('X');
			}
		}
	}
	
	public MemoryCard[][] getMemoryGrid() {
		for (int i = 0; i < memoryGrid.length; i++) {
			for (int j = 0; j < memoryGrid[0].length; j++) {
				System.out.println(memoryGrid[i][j].getSymbol());
			}
		}
		return memoryGrid;
	}
	
	public int getRows() {
		return rows;
	}
	
	public int getColumns() {
		return columns;
	}
	
}