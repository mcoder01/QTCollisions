package com.mcoder.quadtree.structure;

import java.awt.Graphics;
import java.util.LinkedList;

import com.mcoder.quadtree.view.math.Vector;

public class QuadTree<T> {
	private static final int rows = 2, cols = 2;
	private static int capacity = 16;
	
	private Rectangle bounds;
	private LinkedList<DataPoint<T>> points;
	private LinkedList<QuadTree<T>> children;
	
	public QuadTree(Rectangle bounds) {
		this.bounds = bounds;
		points = new LinkedList<>();
		children = null;
	}
	
	public boolean insert(DataPoint<T> point) {
		if (bounds.contains(point)) {
			if (points.size() < capacity) {
				points.add(point);
				return true;
			}
			
			if (children == null) {
				children = new LinkedList<>();
				Rectangle[] newBounds = bounds.subdivide(rows, cols);
				for (int i = 0; i < rows*cols; i++)
					children.add(new QuadTree<T>(newBounds[i]));
			}
			
			for (QuadTree<T> child : children)
				if (child.insert(point))
					return true;
		}
		
		return false;
	}
	
	public void update() {
		LinkedList<DataPoint<T>> savedPoints = new LinkedList<>();
		selectAll(savedPoints);
		points.clear();
		children = null;
		
		for (DataPoint<T> point : savedPoints)
			insert(point);
	}
	
	public void selectAll(LinkedList<DataPoint<T>> selection) {
		for (DataPoint<T> point : points)
			selection.add(point);
		
		if (children != null)
			for (QuadTree<T> child : children)
				child.selectAll(selection);
	}
	
	public void query(Vector v, LinkedList<DataPoint<T>> found) {
		if (bounds.contains(v)) {
			if (children == null)
				for (DataPoint<T> p : points)
					found.add(p);
			else
				for (QuadTree<T> child : children)
					child.query(v, found);
		}
	}
	
	public void show(Graphics g) {
		bounds.show(g);
		if (children != null)
			for (QuadTree<T> child : children)
				child.show(g);
	}
}