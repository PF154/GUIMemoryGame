package edu.wm.cs.cs301.guimemorygame.view;

import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

import edu.wm.cs.cs301.guimemorygame.controller.CardClickAction;
import edu.wm.cs.cs301.guimemorygame.model.MemoryCard;
import edu.wm.cs.cs301.guimemorygame.model.MemoryModel;

public class MemoryGridPanel extends JPanel {
	
	private final MemoryFrame view;
	
	private final MemoryModel model;
	
	private final CardClickAction cardClickAction;
	
	public MemoryGridPanel(MemoryFrame frame, MemoryModel model) {
		this.view = frame;
		this.model = model;
		
		this.cardClickAction = new CardClickAction();
	}
	
	private JPanel createRow(int width, int rowNum) {
		JPanel panel = new JPanel(new FlowLayout());
		panel.setBorder(BorderFactory.createEmptyBorder(0, 5, 0, 5));
		
		MemoryCard[] symbolSet = model.getMemoryGrid()[rowNum];
		
		for (int index = 0; index < width; index++) {
			JButton button = new JButton();
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
}