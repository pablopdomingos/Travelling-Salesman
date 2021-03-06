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

package com.pablodomingos.branches;

import java.util.ArrayList;
import java.util.LinkedList;

import com.pablodomingos.interfaces.IBranch;
import com.pablodomingos.model.Node;

public class QueueImpl implements IBranch {

	public QueueImpl() {
		super();
	}

	private LinkedList<Node> q = new LinkedList<>();
	
	@Override
	public boolean empty() {
		return q.isEmpty();
	}

	@Override
	public Node removeFirst() {
		return q.poll();
	}

	@Override
	public Node first() {
		return q.peek();
	}

	@Override
	public void insert(Node node) {
		q.add(node);
	}

	@Override
	public void insertAll(ArrayList<Node> nodes) {
		q.addAll(nodes);
	}
}
