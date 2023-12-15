package edu.wm.cs.cs301.guimemorygame.view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import edu.wm.cs.cs301.guimemorygame.model.MemoryModel;

public class MemoryFrame {
	
	private JFrame frame;
	
	private final MemoryModel model;
	
	private MemoryGridPanel memoryGridPanel;
	
	private TurnPanel turnPanel;
	
	private FeedbackPanel feedbackPanel;
	
	private InstructionsWindow instructions;
	
	private PlayAgainWindow playAgainWindow;
	
	public MemoryFrame(MemoryModel model) {
		this.model = model;
		this.memoryGridPanel = new MemoryGridPanel(this, model);
		this.turnPanel = new TurnPanel(model);
		this.feedbackPanel = new FeedbackPanel(model);
		this.frame = createAndShowGUI();
		
		this.instructions = new InstructionsWindow(this);
	}
	
	private JFrame createAndShowGUI() {
		JFrame frame = new JFrame("Memory");
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frame.setJMenuBar(createMenuBar());
		frame.setResizable(false);
		frame.addWindowListener(new WindowAdapter() {
			@Override
			 public void windowClosing(WindowEvent event) {
				shutdown();
			}
		});
		
		frame.add(memoryGridPanel.getPanel(), BorderLayout.CENTER);
		frame.add(lowerPanel(), BorderLayout.SOUTH);

		
		frame.pack();
		frame.setLocationByPlatform(true);
		frame.setVisible(true);
		
		//System.out.println("Frame size: " + frame.getSize());
		
		return frame;
	}
	
	private JMenuBar createMenuBar() {
		JMenuBar menuBar = new JMenuBar();
				
		JMenu difficultyMenu = new JMenu("Difficulty");
		menuBar.add(difficultyMenu);
		
		JMenuItem easyItem = new JMenuItem("Easy");
		easyItem.addActionListener(event -> setDifficulty(0));
		difficultyMenu.add(easyItem);
		
		JMenuItem mediumItem = new JMenuItem("Medium");
		mediumItem.addActionListener(event -> setDifficulty(1));
		difficultyMenu.add(mediumItem);
		
		JMenuItem hardItem = new JMenuItem("Hard");
		hardItem.addActionListener(event -> setDifficulty(2));
		difficultyMenu.add(hardItem);

		
		return menuBar;
	}
	
	private void setDifficulty(int difficulty) {
		model.setDifficulty(difficulty);
		
		refresh();
	}


	
	private JPanel lowerPanel() {
		JPanel panel = new JPanel(new GridLayout(0, 1, 0, 0));
		panel.setBorder(BorderFactory.createEmptyBorder(3, 3, 3, 3));
		
		panel.add(turnPanel.getPanel(), BorderLayout.NORTH);
		panel.add(feedbackPanel.getPanel(), BorderLayout.SOUTH);
		
		return panel;
	}
	
	public void shutdown() {
		// Should save leaderboard file here eventually
		frame.dispose();
		System.exit(0);
	}

	public JFrame getFrame() {
		return frame;
	}
	
	public TurnPanel getTurnPanel() {
		return turnPanel;
	}
	
	public FeedbackPanel getFeedbackPanel() {
		return feedbackPanel;
	}
	
	public void loadPlayAgainWindow() {
		playAgainWindow = new PlayAgainWindow(this, model);
	}
	
	public void refresh() {
		memoryGridPanel = new MemoryGridPanel(this, model);
		frame.dispose();
		frame = createAndShowGUI();
		turnPanel.updateLabel("Turn: " + String.valueOf(model.getTurn()));
	}

}