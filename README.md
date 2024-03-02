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
TBD

Charles
TBD
