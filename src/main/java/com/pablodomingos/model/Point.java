/**
 * The MIT License
 * Copyright (c) 2016 Pablo Pacheco
 * <p>
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * <p>
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 * <p>
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package com.pablodomingos.model;

public class Point {
	private Double x;
	private Double y;
	private String name;

	public Point(Double x, Double y) {
		this.x = x;
		this.y = y;
	}

	public Point(int x, int y) {
		this.x = (double) x;
		this.y = (double) y;
	}
	
	public Point(Double x, Double y, String name) {
		this.x = x;
		this.y = y;
		this.name = name;
	}
	
	public Point(int x, int y, String name) {
		this.x = (double) x;
		this.y = (double) y;
		this.name = name;
	}
	
	// Verificando a distância entre 2 pontos
	public double distance(Point p) {
		return (Math.sqrt(Math.pow(x - p.x, 2) + Math.pow(y - p.y, 2)));
	}

	public Double getX() {
		return this.x;
	}

	public Double getY() {
		return this.y;
	}

	public void setX(Double vx) {
		this.x = vx;
	}

	public void setY(Double vy) {
		this.y = vy;
	}

	public String getName() {
		return this.name == null ? this.getX() + ", " + this.getY() : this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean equals(Point p){
		return Double.compare(x, p.getX()) == 0 && Double.compare(y, p.getY()) == 0 ? true : false;
	}
}
