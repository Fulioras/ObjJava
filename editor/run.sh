#Script for compiling and running the program

javac -d bin $(find src -name "*.java")
echo ~~~~~~~~~COMPILATION COMPLETE~~~~~~~~~~~~~
java -cp bin view.EditorFrame
echo ~~~~~~~~~SCRIPT COMPLETED~~~~~~~~
