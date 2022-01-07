# RestAssured_BDD
This is very simple project for RestAssured using BDD approach. We can perfom all operations GET,POST,PUT,PATCH,DELETE.

We have two endpoints.
1. /users
2. /department

All out test are under /src/test/java/restassured_BDD/.

CRUD_On_Local_Server.java --> this java file has code for all the CRUD opertions on our local REST API. Added assertion to validate the response.
GET_Request.java  --> this java file is a GET call but validated different scenarios.

I have used json-server which is used to create demo REST JSON services within a short span of minutes.

Steps to start the json-server:

NOTE:
db.json file will be created in your working project directory and you can modify the content present in there.

1.Steps to start the json-server:

    Install npm and json-server: npm install -g json-server

    Start json-server: json-server --watch db.json

NOTE: db.json file will be created in your working project directory and you can modify the content present in there.
2.To create mock data I have used Mockaroo. https://www.mockaroo.com/ Mockaroo is a free test data generator and API mocking tool.

    Open your browser and navigate to http://localhost:3000/, once your json-server is up and running you will be able to see JSON Server home page and under Resources our endpoint will displayed.

    Access the endpoint : http://localhost:3000/users & http://localhost:3000/department

Thanks,

Learn,Code and Earn :)
and Stay Safe
