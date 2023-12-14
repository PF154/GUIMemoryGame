package edu.wm.cs.cs301.guimemorygame.controller;

import edu.wm.cs.cs301.guimemorygame.view.MemoryCardButton;

public class DoubleFlipRunnable implements Runnable {
	
	private MemoryCardButton button1, button2;

	public DoubleFlipRunnable(MemoryCardButton b1, MemoryCardButton b2) {
		this.button1 = b1;
		this.button2 = b2;
	}
	
	@Override
	public void run() {
		button1.flip();
		button2.flip();
	}
	
}