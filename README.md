## Information about the Tree Shop Web Application

The tree shop web application is a tree registration website that allows users to register for trees, which they later get planted at their property.
The application takes a recipients address and then uses OpenStreetMap API to covert it into lat and long coordinates. The lat and long coordinates that 
are generated for the recipients address, are later used in a function that verifies whether the recipient lives within the city limits of Salem.
The address verification function uses a Ray Casting algorithm to determine if the lat and long point falls inside or outside a polygon of the city.
The polygon of Salem used is from a GeoJSON object that was downloaded from the open data website from data.cityofsalem.net. 


This application has four different pages, home, registration, about page, contact page, and confirmation or error page depending on registration status.

The Home page has information about the website and a button that allows the user to go to the Registration page:

The Registration page allows the user to register for trees, and takes them to an order summary page showing order details:
[Registration Page](https://github.com/ChavezCode/tree-shop/blob/master/src/main/resources/static/demos/Registration-confirmed.mp4)

             
The Registration page also prevents users from registering if they do not live within city limits, 
and displays an error page if their address exists to prevent duplicate registrations.



## How to run this application:

1. Find or create a directory on your computer to copy the repository.
2. Clone the repository by running `git clone https://github.com/ChavezCode/tree-shop.git` in your IDE terminal, preferably on IntelliJ IDEA.
3. Once the repo has been cloned, run the application.
4. Navigate to `http://localhost:8080/` on your preferred web browser. 

