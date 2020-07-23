# CSX42: Assignment 4
**Name:** Ashmeet kaur Chhabra

-----------------------------------------------------------------------

Following are the commands and the instructions to run ANT on your project.


Note: build.xml is present in [arrayvisitors/src](./arrayvisitors/src/) folder.

## Instruction to clean:

```commandline
ant -buildfile src/build.xml clean
```

Description: It cleans up all the .class files that were generated when you
compiled your code.

## Instructions to compile:

```commandline
ant -buildfile src/build.xml all
```
The above command compiles your code and generates .class files inside the BUILD folder.

## Instructions to run:

```commandline
ant -buildfile src/build.xml run -Dinput1="input1.txt" -Dinput2="input2.txt" -Dcommonintsout="output1.txt" -Dmissingintsout="output2.txt" -Ddebug=1
```
Note: Arguments accept the absolute path of the files.


## Description:

Classes:
1. Driver.java
2. MyArray.java
3. MyArrayList.java
4. TreeHelper.java
5. FileProcessor.java
6. LineHandler.java
7. MyLogger.java
8. Results.java
9. MyLogger.java
10. PopulateMyArrayVisitor.java
11. CommonIntsVisitor.java
12. MissingIntsVisitor.java
13. DynamicArray.java

Interfaces:
1. MyArrayI.java
2. MyArrayListI.java
3. Element.java
4. Visitor.java

Description:
1. In this assignment visitor pattern is implpemented. 
2. MyArray and MyArrayList are 2 Elements and PopulateMyArrayVisitor, CommonIntsVisitor and MissingIntsVisitor are 3 Visitors. 
3. The Visitors visits the elements and perform certain tasks.
4. The Visitor PopulateMyArrayVisitor reads the 2 input files using setarray() and the accept method of Element MyArray is called which inturn calls the visit method of the PopulateMyArrayVisitor which populates MyArray.
5. MyArrayList is the List of 2 MyArray, it is also populated by PopulateMyArrayVisitor
6. The CommonIntsVisitor compares the 2 MyArray in MyArrayList and the result is stored in data structure and is printed in the output1.txt file.
7. The MissingIntsVisitor compares the 2 MyArray in MyArrayList and creates a datastructure whixh consists of the union of the 2 input files. After that missing ints between 00 to 99 (both inclusive) are evaluated and printed in output2.txt file
8. The Debug level is given by the user and on that level the lines are printed to console using MyLogger.
9. Used Dynamic Array ADT. link : https://examples.javacodegeeks.com/dynamic-array-java-example/
10. Boundary checks done
11. Exceptions are handled


## Academic Honesty statement:

"I have done this assignment completely on my own. I have not copied
it, nor have I given my solution to anyone else. I understand that if
I am involved in plagiarism or cheating an official form will be
submitted to the Academic Honesty Committee of the Watson School to
determine the action that needs to be taken. "

Date: 22 July 2020


