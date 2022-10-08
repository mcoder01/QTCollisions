package com.mcoder.quadtree.structure;

import java.awt.Color;
import java.awt.Graphics;

import com.mcoder.quadtree.view.math.Vector;

public class Rectangle {
	private int x, y, w, h;
	
	public Rectangle(int x, int y, int w, int h) {
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
	}
	
	public Rectangle[] subdivide(int rows, int cols) {
		int nw = (int) ((double) w/cols);
		int nh = (int) ((double) h/rows);
		
		Rectangle[] rects = new Rectangle[rows*cols];
		for (int i = 0; i < rows; i++)
			for (int j = 0; j < cols; j++) {
				int nx = x + j*nw;
				int ny = y + i*nh;
				rects[i*cols+j] = new Rectangle(nx, ny, nw+1, nh+1);
			}
		
		return rects;
	}
	
	public boolean contains(Vector point) {
		return (point.getX() >= x && point.getY() >= y
				&& point.getX() <= x+w && point.getY() <= y+h);
	}
	
	public boolean intersects(Rectangle rect) {
		return (x+w >= rect.x && x+h >= rect.y
				&& x <= rect.x+rect.w && y <= rect.y+rect.h);
	}
	
	public void show(Graphics g) {
		g.setColor(Color.WHITE);
		g.drawRect(x, y, w, h);
	}
}