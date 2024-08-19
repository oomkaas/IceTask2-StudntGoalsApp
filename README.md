**Student Goals App**
The Student Goals App is an Android application designed to help students set, track, and achieve their academic goals.
The app allows users to create goals, view details, mark them as completed, and delete them.
It supports features such as offline storage using SQLite and easy goal management through a simple and intuitive user interface.

**Features**
Goal Management: Create, view, edit, and delete goals.

Progress Tracking: Mark goals as completed and track your progress.

Detailed Goal View: View detailed information about each goal.

Persistent Storage: Goals are stored locally on the device using SQLite.

User-Friendly Interface: Simple and intuitive UI for easy navigation and goal management.


**Installation**
Clone the repository.
Open the project in Android Studio.
Build and run the project on an Android device or emulator.

Main Screen
View Goals: All goals are displayed in a list.

Add New Goal: Click on the "Add Goal" button to create a new goal.
Add Goal

Enter the goal's title and description.
Click "Save" to add the goal to the list.

Goal Detail

View Details: View the goal's title, description, and completion status.

Mark as Completed: Check the box to mark the goal as completed.

Delete Goal: Click the "Delete" button to remove the goal from the list.

**Database Schema**
The app uses a local SQLite database with the following schema:
Table Name: goals
Columns:
id (INTEGER PRIMARY KEY AUTOINCREMENT)
title (TEXT)
description (TEXT)
is_completed (INTEGER DEFAULT 0)
