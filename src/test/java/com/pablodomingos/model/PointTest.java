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

import static org.junit.Assert.assertThat;

import static org.hamcrest.Matchers.equalTo;
import org.junit.Before;
import org.junit.Test;


public class PointTest {

	private static final Double X = 10.0;
	private static final Double Y = 1.0;
	Point point;
	
	@Before
	public void setUp() throws Exception {
		point = new Point(10.0, 1.0);
	}

	@Test
	public void shouldSetX() {
		assertThat(point.getX(), equalTo(X));
	}
	
	@Test
	public void shouldSetY() {
		assertThat(point.getY(), equalTo(Y));
	}
	
	@Test
	public void shouldCalculateDistance() {
		Point pointTest = new Point(0.0, 0.0); 
		assertThat(point.distance(pointTest), equalTo(10.04987562112089));
	}
	
	@Test
	public void shouldBeEquals() {
		Point pointTest = new Point(10.0, 1.0); 
		assertThat(point.equals(pointTest), equalTo(true));
	}
	
	@Test
	public void shouldChangeX() {
		point.setX(11.0);
		assertThat(point.getX(), equalTo(11.0));
	}
	
	@Test
	public void shouldChangeY() {
		point.setY(2.0);
		assertThat(point.getY(), equalTo(2.0));
	}
	
}