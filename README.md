File Structure:
program5.java
BST.java
Report.java
accidents.csv

Methods
Void main()
Accepts command line arguments of a .CSV file. 
BInarySearchTree readReports() -
	Creates BST nodes of reports
Class myBST - one tree per state
Sorted based on start date
Nodes 
Data
Left/Right
Left/right children counters
If two reports have the same date, the new report gets put to the right



Menu
Enter a date and state and calculate how many reports are on and after that date.

getInput()
calculateNumberOfRecords()
Uses number of children count fields
Sample input: IL 2022-09-08

calculateNumberOfRecords (recursive)
Recursive 


README file



Expected run commands and outputs:
command: java program5 accidents.csv
outputs:
xx seconds to build the binary search trees
Enter the state (e.g., IL): IL
Enter the date (e.g., 2022-09-08): 2022-09-08
xx reports are available for IL on and after the date 2022-09-08
xx seconds to calculate this using children count fields
xx reports are available for IL on and after the date 2022-09-08
xx seconds to calculate this using recursive method

Tasks:

Phil
BST
Program 5 - main and reader methods
AccidentRecord - Provided

Charles
search
recursive search
menu

Time Complexity:

Phil:
Reader - O(N)
AddRecur - O(log(N))
GetRecur - O(log(N))

Charles:
search - worst case: O(N)  best case: 0(1)  average case: O(log(N))
    Worst case would be a chain where each record is before its parent.
    Best case would be all records are after their parent and the summation is done for us during insert.
    Average is traversing the height of the tree in Nodes in a complete binary tree.

recurSearch - worst case: O(N)  best case: O(log(N))  average case: O(N)
    Average case involves visiting about half of the nodes in the tree to check if they are null or before date.

