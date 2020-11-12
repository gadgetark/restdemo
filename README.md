# restdemo


# To Build
1. cd into the project root directory
    * cd restdemo
2. build
    * ./gradlew clean build

# To Run the Spring Boot Application
1. cd into the project root directory
    * cd restdemo
2. build
    * ./gradlew bootRun
    
# To interact with the Applicaiton through Web API
1. Perform a Http GET with the username using curl
    * curl --request GET 'http://localhost:8000/users/octocat'