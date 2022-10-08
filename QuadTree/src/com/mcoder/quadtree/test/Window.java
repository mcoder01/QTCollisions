package com.mcoder.quadtree.test;

import javax.swing.JFrame;

import com.mcoder.quadtree.view.Screen;

public class Window {
	public static final String appName = "QuadTree - Particle Collision System";
	public static final int width = 720, height = 720;
	private static JFrame frame;

	public static void main(String[] args) {
		frame = new JFrame(appName);
		Application application = new Application();
		frame.add(application);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setVisible(true);
		Screen.getInstance().start();
	}
	
	public static JFrame getFrame() {
		return frame;
	}
}