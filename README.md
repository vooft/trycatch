trycatch
========

TryCatch.us assessment

Summary:
* This program uses simple bruteforce to find a solution. Maybe there's a "right" way to do it, but I couldn't fild it
* It supports threading, the last parameter specifies number of threads
* Implemented tests for some classes
* There's some kind of abstraction level (there are a lot of chess boards variations), but I'm not sure are they usable or not

To compile program run:
mvn compile

To run program and see help invoke:
mvn exec:java

Example: 
mvn -q compile && mvn -q exec:java -Dexec.args="7 7 2 2 2 0 1 4"
