package com.mcoder.quadtree.view;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;
import java.util.LinkedList;

import com.mcoder.quadtree.test.Window;

public class Screen extends Thread {
	private static Screen instance;
	
	private final int frameRate;
	private int fps;
	
	private LinkedList<Display> drawers;
	private int display;
	
	private Screen() {
		super();
		drawers = new LinkedList<>();
		frameRate = 60;
		display = 0;
	}
	
	@Override
	public void run() {
		super.run();
		setup();
		
		long prevTime = System.nanoTime();
		long unprocessedFrameTime = 0;
		long unprocessedSeconds = 0;
		double timePerFrame = 1.0E9/frameRate;
		
		int frames = 0;
		
		while(true) {
			long currTime = System.nanoTime();
			long passedTime = currTime-prevTime;
			unprocessedFrameTime += passedTime;
			unprocessedSeconds += passedTime;
			prevTime = currTime;
			
			while(unprocessedFrameTime >= timePerFrame) {
				draw();
				frames++;
				unprocessedFrameTime -= timePerFrame;
			}
			
			if (unprocessedSeconds >= 1.0E9) {
				fps = frames;
				frames = 0;
				unprocessedSeconds = 0;
			}
		}
	}
	
	private void setup() {
		for (Showable s : drawers)
			s.setup();
	}
	
	private void draw() {
		for (Showable s : drawers)
			s.update();
		
		BufferStrategy bs = drawers.get(display).getBufferStrategy();
		if (bs == null) {
			drawers.get(display).createBufferStrategy(2);
			return;
		}
		
		Graphics2D g2d = (Graphics2D) bs.getDrawGraphics();
		g2d.setColor(Color.BLACK);
		g2d.fillRect(0, 0, Window.width, Window.height);
		
		for (Showable s : drawers)
			s.show(g2d);
		
		g2d.dispose();
		bs.show();
	}
	
	public void addDrawer(Display drawer) {
		display = drawers.size();
		drawers.add(drawer);
	}
	
	public int getFPS() {
		return fps;
	}
	
	public static Screen getInstance() {
		if (instance == null)
			instance = new Screen();
		return instance;
	}
}
