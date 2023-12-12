package edu.wm.cs.cs301.guimemorygame.view;

import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

import edu.wm.cs.cs301.guimemorygame.controller.CardClickAction;
import edu.wm.cs.cs301.guimemorygame.model.MemoryCard;
import edu.wm.cs.cs301.guimemorygame.model.MemoryModel;

public class MemoryGridPanel extends JPanel {
	
	private final MemoryFrame view;
	
	private final MemoryModel model;
	
	private JPanel panel;
	
	private final CardClickAction cardClickAction;
	
	public MemoryGridPanel(MemoryFrame view, MemoryModel model) {
		this.view = view;
		this.model = model;
		this.cardClickAction = new CardClickAction(this.view, this.model);
		this.panel = createMainPanel();
	}
	
	private JPanel createMainPanel() {
		JPanel panel = new JPanel(new GridLayout(0, 1, 0, 0));
		panel.setBorder(BorderFactory.createEmptyBorder(10, 5, 0, 5));
		
		int columns = model.getColumns();
		int rows = model.getRows();
		for (int i = 0; i < rows; i++) {
			panel.add(createRow(columns, i));
		}
		
		return panel;
	}
	
	private JPanel createRow(int width, int rowIndex) {
		JPanel panel = new JPanel(new FlowLayout());
		panel.setBorder(BorderFactory.createEmptyBorder(0, 5, 0, 5));
		
		MemoryCard[] cardSet = model.getMemoryGrid()[rowIndex];
		
		for (int i = 0; i < width; i++) {
			String symbol;
			if (cardSet[i].isVisible()) {
				symbol = cardSet[i].getSymbol().toString();
			} else {
				symbol = "?";
			}
			MemoryCardButton button = new MemoryCardButton(symbol, cardSet[i]);
			button.addActionListener(cardClickAction);
			//button.setFont(something...);
			panel.add(button);
		}
		
		return panel;
	}
	
	// Will be called after a card is clicked to display the correct Label
	public void setLabel(int row, int column) {
		// ? if not flipped
		// symbol if flipped
	}
	
	public JPanel getPanel() {
		return panel;
	}
}