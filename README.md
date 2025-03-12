## Information about the Tree Shop Web Application

The tree shop web application is a tree registration website that allows users to register for trees, which they later get planted at their property.
The application takes a recipients address and then uses OpenStreetMap API to covert it into lat and long coordinates. The lat and long coordinates that 
are generated for the recipients address, are later used in a function that verifies whether the recipient lives within the city limits of Salem.
The address verification function uses a Ray Casting algorithm to determine if the lat and long point falls inside or outside a polygon.
The polygon of Salem used is from a GeoJSON object that was downloaded from the open data website data.cityofsalem.net. 
