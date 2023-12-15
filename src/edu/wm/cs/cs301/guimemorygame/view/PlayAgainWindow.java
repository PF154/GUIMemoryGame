package edu.wm.cs.cs301.guimemorygame.view;

import java.awt.BorderLayout;
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

public class PlayAgainWindow extends JDialog {
	
	public PlayAgainWindow(MemoryFrame view) {
		super(view.getFrame(), "Play Again?", true);
		
		add(buttonPanel(), BorderLayout.CENTER);
		
		pack();
		setLocationRelativeTo(view.getFrame());
		setVisible(true);
	}
	
	private JPanel buttonPanel() {
		JPanel panel = new JPanel(new BorderLayout());
		panel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
		
		JButton playAgainButton = new JButton("Play Again");
		
		return panel;
	}
}