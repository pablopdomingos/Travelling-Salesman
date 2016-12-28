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

import java.util.ArrayList;

import com.pablodomingos.interfaces.IAction;
import com.pablodomingos.interfaces.IState;


public class StateImpl implements IState{

	private Point actual;
	private ArrayList<Point> upcoming = new ArrayList<>();

	public StateImpl() {
		super();
	}

	public StateImpl(Point actual) {
		super();
		this.actual = actual;
	}

	public StateImpl(ArrayList<Point> upcoming, Point initialPoint) {
		super();
		this.upcoming = upcoming;
		this.actual = initialPoint;
	}

	@Override
	public boolean imObjective() {
		return upcoming.isEmpty() ? true : false;
	}

	public Point getActual() {
		return actual;
	}

	public void setActual(Point actual) {
		this.actual = actual;
	}

	@Override
	public IState execute(IAction a) {
		ActionImpl action = (ActionImpl) a;
		StateImpl state = new StateImpl(action.getPoint());

		for (Point p : upcoming) {
			if(!p.equals(action.getPoint())){
				state.upcoming.add(p);
			}
		}
		return (IState) state;
	}

	@Override
	public ArrayList<IAction> getSuccessors() {
		ArrayList<IAction> successors = new ArrayList<>();
		for(Point p: upcoming){
			ActionImpl a = new ActionImpl();
			a.setPoint(p);
			a.setCost(actual.distance(p));
			successors.add(a);
		}
		return successors;
	}

	public ArrayList<Point> getUpComing() {
		return upcoming;
	}

	public void setUpComing(ArrayList<Point> upcoming) {
		this.upcoming = upcoming;
	}

}
