package edu.wm.cs.cs301.guimemorygame.view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import edu.wm.cs.cs301.guimemorygame.controller.ExitAction;
import edu.wm.cs.cs301.guimemorygame.controller.PlayAgainAction;
import edu.wm.cs.cs301.guimemorygame.model.MemoryModel;

public class LeaderboardPromptWindow extends JDialog {
	
	private MemoryModel model;
	
	public LeaderboardPromptWindow(MemoryFrame view, MemoryModel model) {
		super(view.getFrame(), "Leaderboard", true);
		this.model = model;
		
		JLabel promptLabel = new JLabel("Type your name and press ENTER");
		
		add(promptLabel, BorderLayout.NORTH);
		add(entryPanel(), BorderLayout.CENTER);
		
		pack();
		setLocationRelativeTo(view.getFrame());
		setVisible(true);
	}
	
	private JPanel entryPanel() {
		JPanel panel = new JPanel(new GridLayout());
		panel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
		
		JTextField textField = new JTextField();
		panel.add(textField);
		
		textField.addActionListener(new ActionListener() {

			// Add the current score to the leaderboard and dispose of the dialog
			
            @Override
            public void actionPerformed(ActionEvent e) {
                model.setPlayerName(textField.getText());
                model.addToLeaderboard();
                dispose();
            }
        });
		
		return panel;
	}
}