package edu.wm.cs.cs301.guimemorygame.view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
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

import edu.wm.cs.cs301.guimemorygame.controller.ExitAction;
import edu.wm.cs.cs301.guimemorygame.controller.PlayAgainAction;
import edu.wm.cs.cs301.guimemorygame.model.MemoryModel;

public class PlayAgainWindow extends JDialog {
	
	private ExitAction exitAction;
	private PlayAgainAction playAgainAction;
	
	public PlayAgainWindow(MemoryFrame view, MemoryModel model) {
		super(view.getFrame(), "Play Again?", true);
		this.exitAction = new ExitAction(view, this);
		this.playAgainAction = new PlayAgainAction(view, model, this);
		
		add(buttonPanel(), BorderLayout.CENTER);
		
		pack();
		setLocationRelativeTo(view.getFrame());
		setVisible(true);
	}
	
	private JPanel buttonPanel() {
		JPanel panel = new JPanel(new GridLayout());
		panel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
		
		JButton playAgainButton = new JButton("Play Again");
		playAgainButton.addActionListener(playAgainAction);
		
		JButton exitButton = new JButton("Exit");
		exitButton.addActionListener(exitAction);
		
		panel.add(playAgainButton);
		panel.add(exitButton);
		
		return panel;
	}
}