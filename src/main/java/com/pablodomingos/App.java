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

package com.pablodomingos;

import java.util.ArrayList;

import com.pablodomingos.branches.PriorityQueueImpl;
import com.pablodomingos.model.Point;
import com.pablodomingos.model.Solution;
import com.pablodomingos.model.Tree;

public class App {

	
	public static void main(String[] args){
		
		Point initialPoint = new Point(48.853303, 2.354544, "Paris");
		
		ArrayList<Point> upcoming = new ArrayList<Point>();
		
		upcoming.add(new Point(52.516557, 13.408746, "Berlin"));
		upcoming.add(new Point(52.237060, 21.051575, "Warsaw"));		
		//upcoming.add(new Point(41.897041, 12.491685, "Rome"));	
		//upcoming.add(new Point(51.502344, -0.131591, "London"));	
		
		Tree tree = new Tree.Builder()
							.explainCode()
							.generateGif()
							.withGifDelay(1.0)
							.build();

		//StackImpl() - Depth-first search
		//QueueImpl() - Breadth-first search 
		//PriorityQueueImpl() - Breadth-first search with a priority queue
		
		Solution solution = tree.searchInTree(upcoming, initialPoint, new PriorityQueueImpl());
		
		solution.print();
	}
}
