# Periodic-Task-Scheduling

The Java web application using core Java, servlet, jsp, mysql and bootstrap.

There are two ways to use this application: Individual and Organization
1) Individual: People can add their schedules and daily routine, just like Google keep
2) Admin can add tasks, and assign to particular employee

Description:
A) Individual:
1) person can add task with task title, name, label and reminder
2) view all the tasks which have reminders
3) show all the labels 
4) show all the task under particular label
5) update and delete the task

B) Organization:
6)  Follows standard organization structure : 
          Organization -> departments -> projects -> modules -> tasks
                          departments -> employee
7) Add and show department, employee, project, module, task
- employee to add in which department
- project to add in which department
- module to add in which project
- task to add in which module
8) assign task to employee -> start and end time is stored
- set deadline and priority for task
9) To-do, doing and done list in a single view
10) update and delete the task

C) Employee:
11) Details of all tasks and to-do, doing n done list in  a single view

Features to be implemented in application :
12) reminder notification as it has set
13) calender view:
- to see task done on particular day for individual 
- organization/admin can see the tasks completed by each employees

Future enhancement:
14) Generalized for different oraganizations which follows:
  i) Organization -> departments -> projects -> modules -> tasks or
  2) Organization -> departments -> projects -> tasks or
  3) Organization -> departments -> tasks or
  4) Organization -> tasks
