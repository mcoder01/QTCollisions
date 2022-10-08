# QuadTree
QuadTree Collision System

QuadTree is a data structure usually used to improve collision systems performances when the amount of collision to manage is huge. QuadTree are abstract trees where each node is a leaf or has four children. In game design, each leaf node can be represented as a rectangle, and the collisions are detected only between objects located in the same area of the rectangle. So we can split out the rectangles to reduce the covered area and improve the performances.
The only disadvantage of this system is that not every single collision can be detected and managed due to the composition of the data structure.
