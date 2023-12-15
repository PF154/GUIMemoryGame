package edu.wm.cs.cs301.guimemorygame.view;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

import edu.wm.cs.cs301.guimemorygame.model.MemoryModel;

public class LeaderboardWindow extends JDialog {
	
	private MemoryModel model;
	
	public LeaderboardWindow(MemoryFrame view, MemoryModel model) {
		super(view.getFrame(), "Leaderboard", true);
		
		this.model = model;
		
		add(leaderboardPanel(), BorderLayout.CENTER);
		
		pack();
		setLocationRelativeTo(view.getFrame());
		setVisible(true);
	}
	
	private JPanel leaderboardPanel() {
		String name;
		String score;
		
		JPanel panel = new JPanel(new GridLayout(8, 1));
		panel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		
		JLabel headerLabel = new JLabel();
		headerLabel.setText("Leaderboard");
		panel.add(headerLabel);
		
		JLabel dividerLabel = new JLabel();
		dividerLabel.setText("------------------");
		panel.add(dividerLabel);
		
		JLabel easyLabel = new JLabel();
		easyLabel.setText("Easy:");
		panel.add(easyLabel);
		
		if(model.getLeaderboard()[0][0] != null) {
			name = model.getLeaderboard()[0][0];
			score = model.getLeaderboard()[0][1];
			JLabel easyEntry = new JLabel();
			easyEntry.setText(name + "    " + score);
			panel.add(easyEntry);
		}
		
		JLabel mediumLabel = new JLabel();
		mediumLabel.setText("Medium:");
		panel.add(mediumLabel);
		
		if(model.getLeaderboard()[1][0] != null) {
			name = model.getLeaderboard()[1][0];
			score = model.getLeaderboard()[1][1];
			JLabel mediumEntry = new JLabel();
			mediumEntry.setText(name + "    " + score);
			panel.add(mediumEntry);
		}
		
		JLabel hardLabel = new JLabel();
		hardLabel.setText("Hard:");
		panel.add(hardLabel);
		
		if(model.getLeaderboard()[2][0] != null) {
			name = model.getLeaderboard()[2][0];
			score = model.getLeaderboard()[2][1];
			JLabel hardEntry = new JLabel();
			hardEntry.setText(name + "    " + score);
			panel.add(hardEntry);
		}
		
		return panel;
	}
}