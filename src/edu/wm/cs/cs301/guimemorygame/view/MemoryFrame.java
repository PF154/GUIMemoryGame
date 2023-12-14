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
	
	public MemoryFrame(MemoryModel model) {
		this.model = model;
		this.memoryGridPanel = new MemoryGridPanel(this, model);
		this.frame = createAndShowGUI();
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

}