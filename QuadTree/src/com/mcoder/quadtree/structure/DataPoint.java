package com.mcoder.quadtree.structure;

import com.mcoder.quadtree.view.math.Vector;

public class DataPoint<T> extends Vector {
	private T data;
	
	public DataPoint(double x, double y, T data) {
		super(x, y);
		this.data = data;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
}