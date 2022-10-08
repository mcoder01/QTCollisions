package com.mcoder.quadtree.view;

import java.awt.Graphics2D;

public interface Showable {
	void setup();
	void update();
	void show(Graphics2D g);
}
