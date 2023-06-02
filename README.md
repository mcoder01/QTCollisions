# QuadTree
QuadTree Collision Checking System

QuadTree is a data structure which uses a top-down strategy which subdivides a 2D rectangular space into 4 smaller rectangles. In this project, the QuadTree data structure is used to improve the performances of a collision checking system, where the amount of collisions to manage is huge.
QuadTree is an abstract tree where each node is a leaf or has four children. In this project, each leaf node can be represented as a rectangle, and the collisions are detected only between objects located in the same area of the rectangle. So we can split out the rectangles to reduce the covered area and improve the performances.
The only disadvantage of this system is that not all the collisions can be detected and managed due to the composition of the data structure.
