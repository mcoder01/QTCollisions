package com.mcoder.quadtree.view;

import java.awt.Canvas;

public abstract class Display extends Canvas implements Showable {
	public Display(int width, int height) {
		super();
		setSize(width, height);
		Screen.getInstance().addDrawer(this);
	}
}
