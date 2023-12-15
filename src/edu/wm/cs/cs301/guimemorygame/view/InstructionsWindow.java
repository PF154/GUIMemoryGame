package edu.wm.cs.cs301.guimemorygame.view;

import java.awt.BorderLayout;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.swing.BorderFactory;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class InstructionsWindow extends JDialog {
	
	public InstructionsWindow(MemoryFrame view) {
		super(view.getFrame(), "Instructions", true);
		
		add(instructionsPanel(), BorderLayout.CENTER);
		
		pack();
		setLocationRelativeTo(view.getFrame());
		setVisible(true);
	}
	
	private JPanel instructionsPanel() {
		JPanel panel = new JPanel(new BorderLayout());
		panel.setBorder(BorderFactory.createEmptyBorder(0, 5, 5, 5));
		
		JLabel instructionsText = new JLabel();
		
		String sourceText;
		try {
			sourceText = Files.readString(Paths.get("resources\\instructions.htm"), StandardCharsets.UTF_8);
			
			instructionsText.setText(sourceText);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			instructionsText.setText("Couldn't get instructions");
		}
		
		panel.add(instructionsText);
		
		return panel;
	}
}