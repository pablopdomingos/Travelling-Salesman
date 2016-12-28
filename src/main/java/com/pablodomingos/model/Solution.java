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

import java.util.Stack;

import com.pablodomingos.interfaces.IAction;

public class Solution {

	private Stack<IAction> stack = new Stack<>();
	private double cost;

	public Solution(Node n) {
		cost = n.getCost();
		while (n.getParent() != null) {
			stack.add(n.getAction());
			n = n.getParent();
		}
	}

	public IAction getNext() {
		if (!stack.empty()) {
			return stack.pop();
		} else {
			System.out.println("Objective completed");
			return null;
		}
	}

	public double getCost() {
		return cost;
	}
	
	public void print(){
		
		System.out.println("=============Solution=============");
		ActionImpl a;
		while((a= (ActionImpl)this.getNext())!=null){
			System.out.println("Go to => ("+a.getPoint().getName()+")");
		}
		System.out.println("Solution cost: " +this.getCost());
	}
}
