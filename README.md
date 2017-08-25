# OS-scheduler
Data structure: 
HEAP; 
TREE; 
PRIORITY QUEUE

Applications request OS scheduler for computational resources (some interval of CPU time). Simple scheduler is based on binary max-heap (which you have to implement :) ). It provides all requested resources at a time to a process, based on process' priority (1 is the smallest priority, 17 is the biggest). In input.csv you are given CSV table: application name, time when event happens (when application requests time, ms), amount of CPU time it requests (ms) and priority (1..17). 

Unfortunately your laptop battery is only charged for 2 minutes of work! Your task is to print into output.txt the name of the last application that was able to finish. 
