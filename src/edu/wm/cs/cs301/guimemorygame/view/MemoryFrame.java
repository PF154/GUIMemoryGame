package edu.wm.cs.cs301.guimemorygame.view;

import java.awt.BorderLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

import edu.wm.cs.cs301.guimemorygame.model.MemoryModel;

public class MemoryFrame {
	
	private JFrame frame;
	
	private final MemoryModel model;
	
	private MemoryGridPanel memoryGridPanel;
	
	private TurnPanel turnPanel;
	
	private InstructionsWindow instructions;
	
	public MemoryFrame(MemoryModel model) {
		this.model = model;
		this.memoryGridPanel = new MemoryGridPanel(this, model);
		this.turnPanel = new TurnPanel(model);
		this.frame = createAndShowGUI();
		
		this.instructions = new InstructionsWindow(this);
	}
	
	private JFrame createAndShowGUI() {
		JFrame frame = new JFrame("Memory");
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		//frame.setJMenuBar(createMenuBar());
		frame.setResizable(false);
		frame.addWindowListener(new WindowAdapter() {
			@Override
			 public void windowClosing(WindowEvent event) {
				shutdown();
			}
		});
		
		frame.add(memoryGridPanel.getPanel(), BorderLayout.CENTER);
		frame.add(turnPanel.getPanel(), BorderLayout.SOUTH);

		
		frame.pack();
		frame.setLocationByPlatform(true);
		frame.setVisible(true);
		
		//System.out.println("Frame size: " + frame.getSize());
		
		return frame;
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

}