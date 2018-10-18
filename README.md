# sparse-vector
Addition, dot product, and subtraction of sparse vectors in Java.
## Usage
Input (`input`)
```
3 1.0 2500 6.3 5000 10.0 60000 5.7
1 7.5 3 5.7 2500 -6.3
add
```
## Output
```
( [3, 1.0] [2500, 6.3] [5000, 10.0] [60000, 5.7] )
+
( [1, 7.5] [3, 5.7] [2500, -6.3] )
=
( [1, 7.5] [3, 6.7] [5000, 10.0] [60000, 5.7] )
```
## Build
```
javac SV.java
javac SparseVector.java

java SV
```
