package com.mcoder.quadtree.test;

import java.awt.Color;
import java.awt.Graphics2D;

import com.mcoder.quadtree.view.Showable;
import com.mcoder.quadtree.view.math.Vector;

public class Particle implements Showable {
	private Vector pos, vel;
	private int d;
	private boolean highlight;
	
	public Particle(int x, int y, int d) {
		this(new Vector(x, y), d);
	}
	
	public Particle(Vector pos, int d) {
		this.pos = pos;
		this.d = d;
	}
	
	@Override
	public void setup() {
		randomVel();
	}
	
	@Override
	public void update() {
		pos.add(vel);
		randomVel();
		highlight = false;
	}
	
	public boolean collide(Particle other) {
		double dx = other.pos.getX()-pos.getX();
		double dy = other.pos.getY()-pos.getY();
		double dist = Math.sqrt(dx*dx+dy*dy);
		return dist <= d/2+other.d/2;
	}
	
	@Override
	public void show(Graphics2D g) {
		if (highlight)
			g.setColor(Color.WHITE);
		else g.setColor(Color.GRAY);
		g.fillOval((int) pos.getX(), (int) pos.getY(), d, d);
	}
	
	private void randomVel() {
		double velX = Math.random()*6-3;
		double velY = Math.random()*6-3;
		vel = new Vector(velX, velY);
	}
	
	public void highlight() {
		highlight = true;
	}
	
	public Vector getPos() {
		return pos;
	}
}