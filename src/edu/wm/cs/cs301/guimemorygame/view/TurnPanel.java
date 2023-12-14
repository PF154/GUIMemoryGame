package edu.wm.cs.cs301.guimemorygame.view;

import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

import edu.wm.cs.cs301.guimemorygame.model.MemoryModel;

public class TurnPanel extends JPanel {
	
	private JPanel panel;
	
	private MemoryModel model;
	
	private JLabel label;
	
	public TurnPanel(MemoryModel model) {
		this.model = model;
		this.panel = createTurnPanel();
	}
	
	public JPanel createTurnPanel() {
		JPanel panel = new JPanel(new GridLayout(0, 1, 0, 0));
		panel.setBorder(BorderFactory.createEmptyBorder(10, 5, 0, 5));
		
		String text = "Turn: " + String.valueOf(model.getTurn());
		label = new JLabel(text);
		panel.add(label);

		
		return panel;
	}
	
	public void updateLabel(String text) {
		label.setText(text);
	}
	
	public JPanel getPanel() {
		return panel;
	}
}