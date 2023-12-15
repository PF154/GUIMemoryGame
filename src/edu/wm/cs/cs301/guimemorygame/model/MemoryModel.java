package edu.wm.cs.cs301.guimemorygame.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import edu.wm.cs.cs301.guimemorygame.view.MemoryCardButton;

public class MemoryModel {
	
	private MemoryCard[][] memoryGrid;
	
	private Alphabet alphabet;
	
	private int rows, columns;
	
	// Final score needs to be turn - 1, since this tracks the current turn... maybe
	private int turn;
	
	private int matches;
	
	private MemoryCardButton selection;
	
	public MemoryModel() {
		this.alphabet = new LatinAlphabet();
		this.rows = 3;
		this.columns = 4;
		this.selection = null;
		
		intitializeMemoryGrid();
	}
	
	private void intitializeMemoryGrid() {
		memoryGrid = new MemoryCard[rows][columns];
		
		ArrayList<Character> symbolSet = new ArrayList<Character>();
		for(char c : alphabet.toCharArray()) {
			symbolSet.add(c);
		}
		Collections.shuffle(symbolSet);
		
		// Add two of however many symbols are needed to boardSymbols, then shuffle the order
		int numMatches = rows * columns / 2;
		ArrayList<Character> boardSymbols = new ArrayList<Character>();
		for (int i = 0; i < numMatches; i++) {
			boardSymbols.add(symbolSet.get(i));
			boardSymbols.add(symbolSet.get(i));
		}
		Collections.shuffle(boardSymbols);
		
		// Iterate through the board and place the symbols
		int symbolNum = 0;
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				MemoryCard newMemoryCard = new CharacterMemoryCard(boardSymbols.get(symbolNum)); 
				memoryGrid[i][j] = newMemoryCard;
				symbolNum++;
			}
		}

		
		// dummy code to give values to grid, will be changed eventually
//		for (int i = 0; i < memoryGrid.length; i++) {
//			for (int j = 0; j < memoryGrid[0].length; j++) {
//				memoryGrid[i][j] = new CharacterMemoryCard('W');
//			}
//		}
		
		turn = 1;
		matches = 0;
	}
	
	public MemoryCard[][] getMemoryGrid() {
		return memoryGrid;
	}
	
	public int getRows() {
		return rows;
	}
	
	public int getColumns() {
		return columns;
	}
	
	public MemoryCardButton getSelection() {
		return selection;
	}
	
	public void setSelection(MemoryCardButton c) {
		selection = c;
	}
	
	public int getTurn() {
		return turn;
	}
	
	public void incrementTurn() {
		turn += 1;
	}
	
	public int getMatches() {
		return matches;
	}
	
	public void incrementMatches() {
		matches += 1;
	}
	
	public boolean winState() {
		int needed = (rows * columns) / 2;
		if (matches == needed) {
			return true;
		} else {
			return false;
		}
	}
	
}