1. How to run the application
The application is a mvn project and in order to compile the project, please run "mvn clean package" under the project root directory "stores".
After the compilation is completed, the application can be started by running below command in CLI under "stores/target" folder:

java -jar stores-0.0.1-SNAPSHOT.jar

The REST endpoints can be access using browser or tools like curl, for example: http://localhost:8080/stores

The application can also be imported into IDE and run within IDE directly.


2. RESTful endpoint exposed:
a. Get a list of all stores:
GET /stores

b. Get a list of all stores assigned to a user:
GET /users/{userId}/stores

For example: GET http://localhost:8080/users/1/stores

c. Mark a store as a favourite for a user:
PUT /users/{userId}/stores/{storeId}

For example: PUT http://localhost:8080/users/2/stores/2

d. Unmark a favourite store for a user:
DELETE /users/{userId}/stores/{storeId}

For example: DELETE http://localhost:8080/users/2/stores/2