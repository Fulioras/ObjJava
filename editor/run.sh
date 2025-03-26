#Script for compiling and running the program

javac -d bin src/shapes/*/*.java src/test/Test.java
echo ~~~~~~~~~COMPILATION COMPLETE~~~~~~~~~~~~~
java -cp bin test.Test
echo ~~~~~~~~~SCRIPT COMPLETED~~~~~~~~
