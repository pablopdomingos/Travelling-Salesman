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

import com.pablodomingos.graphviz.FilesUtil;
import com.pablodomingos.interfaces.IAction;
import com.pablodomingos.interfaces.IState;
import com.pablodomingos.interfaces.IBranch;

public class Tree {

	private StringBuilder graph = new StringBuilder();
	private int countFiles = 0;
	private boolean generateGif = false;
	private boolean explainCode = false;
	private int secondsGifDelay = 200;
	
	
	public Tree(Builder builder) {
		this.generateGif = builder.generateGif;
		this.explainCode = builder.explainCode;
		this.secondsGifDelay = builder.secondsGifDelay;
	}

	public Solution searchInTree(ArrayList<Point> upcoming, Point initialPoint, IBranch branch) {
		IState e = new StateImpl(upcoming, initialPoint);
		
		Node node = new Node(null, e, null, 0, 0.0);

		if (generateGif) {
			StateImpl stateActual = (StateImpl) e;
			FilesUtil.cleanDirectory("temp");
			graph.append(node.getId() + "[label=\"(" + stateActual.getActual().getName() + ")\",shape=ellipse]");
		}

		branch.insert(node);

		while (true) {
			if (branch.empty()) {
				if (explainCode) {
					System.out.println("Branch empty... returning null");
				}
				return null;
			}
			Node n = branch.removeFirst();

			if (explainCode) {
				System.out.println("Removing from branch node " + n.getId());
			}

			if (n.getState().imObjective()) {
				if (generateGif) {
					FilesUtil.generateGifAnimated(secondsGifDelay);
				}

				if (explainCode) {
					System.out.println("Objective found... returning...");
				}
				return new Solution(n);
			}
			if (explainCode) {
				System.out.println("Expanding node " + n.getId());
			}
			branch.insertAll(expand(n));
		}
	}

	public ArrayList<Node> expand(Node nodeToExpand) {

		ArrayList<Node> descendentes = new ArrayList<>();

		for (IAction action : nodeToExpand.getState().getSuccessors()) {

			Node node = new Node();
			node.setState(nodeToExpand.getState().execute(action));
			node.setParent(nodeToExpand);
			node.setAction(action);
			node.setCost(nodeToExpand.getCost() + action.getCost());
			node.setDepth(nodeToExpand.getDepth() + 1);
			descendentes.add(node);
			StateImpl state = (StateImpl) node.getState();

			if (generateGif) {

				graph.append("\n" + node.getParent().getId() + " -> " + node.getId());
				graph.append("\n" + node.getId() + "[label=\"(" + state.getActual().getName() + ")\",shape=ellipse]");

				countFiles = FilesUtil.toFile(graph.toString(), countFiles);
			}

			if (explainCode) {
				ActionImpl nextAction = (ActionImpl) action;
				System.out.println("======================================");
				System.out.println("Creating node... ");
				System.out.println("Node id: " + node.getId());
				System.out.println("State: (" + state.getActual().getName() + ")");
				System.out.println("Node parent: " + node.getParent().getId());
				System.out.println("Action: Go to point (" + nextAction.getPoint().getName() + ")");
				System.out.println("Cost: " + node.getCost());
				System.out.println("Depth: " + node.getDepth());
				System.out.println("======================================");
			}

		}
		return descendentes;
	}

	public static class Builder {
		private boolean generateGif;
		private boolean explainCode;
		private int secondsGifDelay;
		
		public Builder() {

		}

		public Builder generateGif() {
			this.generateGif = true;
			return this;
		}

		public Builder withGifDelay(double seconds) {
			this.secondsGifDelay = (int)(seconds * 100);
			return this;
		}
		
		public Builder withGifDelay(int seconds) {
			this.secondsGifDelay = seconds * 100;
			return this;
		}
		
		public Builder explainCode() {
			this.explainCode = true;
			return this;
		}

		public Tree build() {
			return new Tree(this);
		}
	}

}
