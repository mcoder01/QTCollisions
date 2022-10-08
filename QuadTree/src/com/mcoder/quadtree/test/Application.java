package com.mcoder.quadtree.test;

import java.awt.Graphics2D;
import java.util.LinkedList;

import com.mcoder.quadtree.structure.DataPoint;
import com.mcoder.quadtree.structure.QuadTree;
import com.mcoder.quadtree.structure.Rectangle;
import com.mcoder.quadtree.view.Display;

public class Application extends Display {
	private QuadTree<Particle> tree;
	private Particle[] particles;
	
	public Application() {
		super(Window.width, Window.height);
	}
	
	@Override
	public void setup() {
		Rectangle bounds = new Rectangle(0, 0, Window.width-1, Window.height-1);
		tree = new QuadTree<>(bounds);
		particles = new Particle[5000];
		for (int i = 0; i < particles.length; i++) {
			int x = (int) (Math.random()*(Window.width-1));
			int y = (int) (Math.random()*(Window.height-1));
			DataPoint<Particle> point = new DataPoint<>(x, y, null);
			particles[i] = new Particle(point, 10);
			particles[i].setup();
			point.setData(particles[i]);
			tree.insert(point);
		}
	}
	
	@Override
	public void update() {
		for (Particle p : particles)
			p.update();
		
		tree.update();
		
		/*for (int i = 0; i < particles.length; i++)
			for (int j = i+1; j < particles.length; j++)
				if (particles[i].collide(particles[j])) {
					particles[i].highlight();
					particles[j].highlight();
				}*/
		
		for (Particle p1 : particles) {
			LinkedList<DataPoint<Particle>> found = new LinkedList<>();
			tree.query(p1.getPos(), found);
			for (DataPoint<Particle> point : found) {
				Particle p2 = point.getData();
				if (p1.collide(p2)) {
					p1.highlight();
					p2.highlight();
				}
			}
		}
	}

	@Override
	public void show(Graphics2D g) {
		tree.show(g);
		for (Particle p : particles)
			p.show(g);
	}
}