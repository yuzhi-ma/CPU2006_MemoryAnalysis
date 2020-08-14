
# Overview:
This java program is designed to do fast memory analysis of CPU2006 in terms of page comparison and block comparison. The program will save all the data it reads from the memory dumps and do fast sorting in order to save running time. Then, it will calculate the percentage of equal blocks or the percentage of equal pages between two memory dumps.

# Compile:
	$ javac ./Main.java

# Run:
count number of identical pages between two memory dumps:

	$ java -Xmx13G Main -cp memoryDump1 memoryDump2

count number of identical blocks between two memory dumps:

	$ java -Xmx13G Main -cb memoryDump1 memoryDump2
	
count number of identical pages within one memory dump:

	$ java -Xmx13G Main -p memoryDump
	
count number of identical blocks within one memory dump:

	$ java -Xmx13G Main -b memoryDump

Note: -Xmx13G is the system command that allows your program to allocate 13GB   memory at maximum. Make sure you have enough memory before running it.

# Example1:
Suppose you have two memory dumps, 400.1.txt and 400.2.txt and want to do the comparison analysis of pages:

	$ javac Main.java
	
 	$ java -Xmx13G Main -cp 400.1.txt 400.2.txt
	
The java program will print the results like below:

Start loading memory dump: 400.1.txt  400.2.txt

Sorting:

Start comparison:

The number of non-empty page in dump 1 is:355

total equal Page: 

Percentage: 2%

It shows that those two memory dumps have 8 equal pages and the percentage of equal pages is 2%.

# Example2:
Suppose you have one memory dump 400.1.txt and want to calculate similarity of blocks within it:

	$ javac Main.java

	$ java -Xmx13G Main -b 400.1.txt

The java program will print the results like below:

Start dump files:400.1.txt

Sorting:

Start comparison:

total non-zero block in first dump: 22720

total equal block in first dump: 415

Percentage equal block: 1%

It shows that the memory dump has 415 equal blocks and the percentage of equal blocks is 1%.
