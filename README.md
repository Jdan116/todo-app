# Todo REST API

* This is a simple todo REST api service that registers, update and deletes todo(s) with associated tasks. 
The api is containerized so that it could easily be tested on docker.   

## Requirement to build and deploy

* Java 11 or more
* maven 3.6.3
* Docker is installed on your machine

## Build the application
* cd to the project director: `cd todo-app`
* execute mvn build: `mvn clean install` 

## Build docker image and tun

* build docker image

  *  `docker build -f Dockerfile -t todo-app .`

* Start the container from the image created previously
    
  * `docker run -p 8080:8080 todo-app`
  
## Reaching the application

* On your favorite tool, send the needed HTTP method

  * Base URL `http://localhost:8080`
  * Support endpoint
    * `POST /v1/todos/` with one or more todos in body - creates todo(s)
    * `GET /v1/todos/` - returns all todos registered so far 
    * `PUT /v1/todos/{id}` with updated todo detail - updates the todo identified by `id`
    * `DELETE /v1/todos/{id}` - deletes the todo with identified `id`

## Persistence

* The application used in-memory H2 database there is no need to install an additional Database. 