# QuadTree
QuadTree Collision Detection System

QuadTree is a data structure that uses a top-down strategy to subdivide a 2D rectangular space into 4 smaller rectangles. In this project, the QuadTree data structure is used to improve the performances of a collision detection system, where the amount of collisions to manage is huge.
In QuadTrees, each node is either a leaf or an internal node with four children. In this project, each leaf node can be represented as a sub-rectangle of the whole 2D space, and collisions are detected only between objects in the same area. So we can subdivide a rectangle into 4 smaller ones to reduce the covered area and to improve the performances.
The only disadvantage of this system is that not all the collisions can be detected and managed due to the composition of the data structure. Indeed, collisions between objects placed in different rectangles are ignored. This happens when the two objects relays on one side of the respective rectangle.
