package edu.wm.cs.cs301.guimemorygame.model;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import edu.wm.cs.cs301.guimemorygame.view.MemoryCardButton;

public class MemoryModel {
	
	private MemoryCard[][] memoryGrid;
	
	private Alphabet alphabet;
	
	private int rows, columns;
	
	// Final score needs to be turn - 1, since this tracks the current turn... maybe
	private int turn;
	
	private int matches;
	
	private int difficulty;
	
	private MemoryCardButton selection;
	
	private File leaderboardFile;
	private String leaderboardPath = "resources\\leaderboard.txt";
	
	private String[][] leaderboard = new String[3][2];
	
	private String playerName;
	
	public MemoryModel() {
		this.alphabet = new LatinAlphabet();
		this.rows = 4;
		this.columns = 7;
		this.selection = null;
		this.difficulty = 1;
		
		loadLeaderboard(true);
		
		initializeMemoryGrid();
	}
	
	public void initializeMemoryGrid() {
		/*
		 * Creates a shuffled character set and populates the board.
		 * Initializes some game variables.
		 */
		
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
		
		turn = 1;
		matches = 0;
	}
	
	public void setDifficulty(int d) {
		switch(d) {
		case 0:
			rows = 3;
			columns = 4;
			difficulty = 0;
			// Set leaderboard info however you want to do that here
			initializeMemoryGrid();
			break;
		case 1:
			rows = 4;
			columns = 7;
			difficulty = 1;
			// Set leaderboard info however you want to do that here
			initializeMemoryGrid();
			break;
		case 2:
			rows = 7;
			columns = 8;
			difficulty = 2;
			// Set leaderboard info however you want to do that here
			initializeMemoryGrid();
			break;
		}	
	}
	
	public void addToLeaderboard() {
		/*
		 * Add a new element to the leaderboard of the appropriate difficulty
		 */
		if (difficulty == 0) {
			if (leaderboard[0][0] != null) {
				if (turn < Integer.parseInt(leaderboard[0][1])) {
					leaderboard[0][0] = playerName;
					leaderboard[0][1] = String.valueOf(turn);
				}
			} else {
				leaderboard[0][0] = playerName;
				leaderboard[0][1] = String.valueOf(turn);
			}
		} else if (difficulty == 1) {
			if (leaderboard[1][0] != null) {
				if (turn < Integer.parseInt(leaderboard[1][1])) {
					leaderboard[1][0] = playerName;
					leaderboard[1][1] = String.valueOf(turn);
				}
			} else {
				leaderboard[1][0] = playerName;
				leaderboard[1][1] = String.valueOf(turn);
			}
		} else if (difficulty == 2) {
			if (leaderboard[2][0] != null) {
				if (turn < Integer.parseInt(leaderboard[2][1])) {
					leaderboard[2][0] = playerName;
					leaderboard[2][1] = String.valueOf(turn);
				}
			} else {
				leaderboard[2][0] = playerName;
				leaderboard[2][1] = String.valueOf(turn);
			}
		}
		
		// Update the file where the leaderboard is stored with the new information
		try {
			FileWriter lbUpdate = new FileWriter(leaderboardPath, false);
			
			lbUpdate.write("easy\n");
			if (leaderboard[0][0] != null) {
				lbUpdate.write(leaderboard[0][0] + ", " + leaderboard[0][1] + "\n");
			}
			lbUpdate.write("medium\n");
			if (leaderboard[1][0] != null) {
				lbUpdate.write(leaderboard[1][0] + ", " + leaderboard[1][1] + "\n");
			}
			lbUpdate.write("hard\n");
			if (leaderboard[2][0] != null) {
				lbUpdate.write(leaderboard[2][0] + ", " + leaderboard[2][1] + "\n");
			}
			lbUpdate.close();
			
		} catch (IOException e) {
			System.out.println("An error occured. Couldn't update leaderboard");
			e.printStackTrace();
		}
	}

	
	private void loadLeaderboard(boolean createNew) {
		/*
		 * Load the leaderboard in and assign its data to the leaderboard array
		 */
		try {
			leaderboardFile = new File(leaderboardPath);
			if(createNew == true) { // We will only run this when it is called at the start of the program, otherwise we have the file
				leaderboardFile.createNewFile();
			}
			Scanner lbRead = new Scanner(leaderboardFile);
			
			String currentDifficulty = null;
			while (lbRead.hasNextLine()) {
				String line = lbRead.nextLine();
				if(line.equals("easy") || line.equals("medium") || line.equals("hard")) { // Keep track of what subarray to add to
					currentDifficulty = line;
				} else {
					// Our line is a data entry, add it to the appropriate leaderboard
					String[] entryData = line.split(", "); // Separate name and score
					if(currentDifficulty.equals("easy")) {
						leaderboard[0][0] = entryData[0];
						leaderboard[0][1] = entryData[1];
					} else if(currentDifficulty.equals("medium")) {
						leaderboard[1][0] = entryData[0];
						leaderboard[1][1] = entryData[1];
					} else if(currentDifficulty.equals("hard")) {
						leaderboard[2][0] = entryData[0];
						leaderboard[2][1] = entryData[1];
					}
				}
			}
			lbRead.close();
		} catch (IOException e) {
			System.out.println("An error occured. Couldn't create leaderboard.");
		}
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
	
	public String getPlayerName() {
		return playerName;
	}
	
	public void setPlayerName(String name) {
		playerName = name;
	}
	
	public String[][] getLeaderboard() {
		return leaderboard;
	}
}