# CloudComputeHW6
Porject of Cloud Computing
1
Homework 6
CS651: SpTp: Cloud Computing
Due Date and Time: 11/25/2018 at 11:59 PM
This project is individual work. Each student must complete this assignment independently.
User Request:
“Create a simple system to add, read, search, and update restaurant data.”
Objectives:
Description:
For this project, you will create a web page, which connects to the restaurant database in google cloud
and modifies the restaurant NoSQL database dynamically according to user inputs. Both database and
webpage will be hosted by Google cloud. Your website will allow users to search entries, delete entries
and update by using desired fields. Also, new restaurant information can be entered as long as the
restaurant_id information does not exist in the NoSQL database. If the restaurant exists, the update
process must be applied.
Operational Issues:
You manually will import the restaurant.json file as a collection to a NoSQL database. Then your
website will enter a loop where it will prompt the user with five options: ‘S’ for search, ‘D’ for delete,
‘A’ for add in a suitable format if the user visits your website. Please be sure about the consistent update
Lock process if multiple users opened your site.
If the user selects search, your website will prompt the user to give options from available options to
search. Once the user enters the fields to search, your site will provide options for the user to select the
output fields options (projection, which fields users want to see and which fields users do not want to
see). If a restaurant with that searched fields is found, it will be displayed to the screen with desired
output format according to projection. If there are multiple results, at most 5 of them will be shown. If
there are more than 5, the user should be able to click next to see the next five or all. If a restaurant with
1. Use any language to read, write and user interaction from User Interface
on the website which you created by using Google Cloud.
10 Points
2. Export restaurants.json to your NoSQL database which you created in the
Google cloud and connect from the website to MongoDB in the google
cloud
10 Points
3. Searching fields in Database from a web page 15 Points
4. Updating fields in Database from a web page 15 Points
5. Adding fields to Database from a web page 15 Points
6. Deleting fields from Database by using web page 15 Points
7. Develop and use an appropriate design. 10 Points
8. Use proper documentation and formatting. 10 Points
2
those fields is not found, a message will be presented to the user to that there is no restaurant.
If the user selects delete, your webpage will prompt the user for the id of the restaurant to delete. Once
the user enters id, your webpage will perform deletion to the document with that id. If a restaurant with
that id is found, the restaurant will be displayed to the screen by your webpage, and the user will be
asked to confirmwhether that restaurant should be deleted. If the user confirms the deletion, the
restaurant should be deleted from the database. If a restaurant with that id is not found, a message will
be presented to the user to that there is no restaurant.
If the user selects add, your website will prompt the user to give options from available options to add.
Once the user enters the fields to add, your website search if the restaurant is already on the list. If it is
on the list, your website will give fields information to update the fields. If a restaurant with that
restaurant_id is not found, a message will be presented to the user to enter all the required fields (name,
id, address) with optional fields to enter more info about the restaurant. If the required fields are not
given, the user should not be able to add.
Due Date:
You must submit your web site address to blackboard. Make sure that I can access to your site to test.
No need to send any code. If you do not want to Google charge you a lot, you can submit your site
with email earlier time so that I can check and grade. I can only grade one time. Therefore, before you
submit, please make sure that it works properly. Due date is November 25, 2018, by 11:59 pm.
Notes:
A simple Java program sample (NoSQLTest.java) to connect to MongoDB is attached. You may use it as
a starting point.
