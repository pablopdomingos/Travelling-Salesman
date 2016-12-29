Travelling Salesman implemented in Java
====
[![Build Status](https://api.travis-ci.org/pablopdomingos/Travelling-Salesman.svg?branch=master)](https://travis-ci.org/pablopdomingos/Travelling-Salesman)


## Requeriments

- To generate Gif you need [Graphviz](http://www.graphviz.org/) installed


## Usage

```
Point initialPoint = new Point(48.853303, 2.354544, "Paris");
		
ArrayList<Point> upcoming = new ArrayList<Point>();
		
upcoming.add(new Point(52.516557, 13.408746, "Berlin"));
upcoming.add(new Point(52.237060, 21.051575, "Warsaw"));		
upcoming.add(new Point(41.897041, 12.491685, "Rome"));

Tree tree = new Tree.Builder()
			.explainCode()
			.generateGif()
			.withGifDelay(1.0)
			.build();
		
Solution solution = tree.searchInTree(upcoming, initialPoint, new StackImpl());
		
solution.print();

```

## Generates Gif

Generates a Gif to show how the program solved the problem **step-by-step**

### PriorityQueueImpl()
![Result](/gif/graph.gif)

### StackImpl()
![Result](/gif/graph2.gif)

## Three search methods 

- **StackImpl()** - Depth-first search
- **QueueImpl()** - Breadth-first search 
- **PriorityQueueImpl()** - Breadth-first search with a priority queue


## Explaining step-by-step what happening

```
Removing from branch node 0
Expanding node 0
======================================
Creating node... 
Node id: 1
State: (Berlin)
Node parent: 0
Action: Go to point (Berlin)
Cost: 11.645377268483834
Depth: 1
======================================
======================================
Creating node... 
Node id: 2
State: (Warsaw)
Node parent: 0
Action: Go to point (Warsaw)
Cost: 19.00075734411684
Depth: 1
======================================
======================================
```
