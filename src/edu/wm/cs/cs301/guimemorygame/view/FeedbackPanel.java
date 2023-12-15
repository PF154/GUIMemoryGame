package edu.wm.cs.cs301.guimemorygame.view;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

import edu.wm.cs.cs301.guimemorygame.model.MemoryModel;

public class FeedbackPanel extends JPanel {
	
	private JPanel panel;
	
	private MemoryModel model;
	
	private JLabel label;
	
	public FeedbackPanel(MemoryModel model) {
		this.model = model;
		this.panel = createFeedbackPanel();
	}
	
	public JPanel createFeedbackPanel() {
		JPanel panel = new JPanel(new GridLayout(0, 1, 0, 0));
		panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		
		String text = "";
		label = new JLabel(text);
		label.setForeground(Color.RED);
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