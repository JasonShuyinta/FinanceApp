# Budget-Finance App

This application serves as a basic example on how to use a Graph type DB in a CRUD REST API.

I created this project to use and implement some new technologies I came across, so that this repository would also
serve as a reminder for future projects on how to use this technologies. Please feel free to use or interact with this
repository as you wish.

#### Tech Stack

The tech stack used for this project is as follows:
- [Java 17](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)
- [Spring 3.0.2](https://spring.io/quickstart)
- [Spring Security](https://docs.spring.io/spring-security/reference/index.html) 
- [JWT](https://jwt.io/)
- [MapStruct](https://mapstruct.org/)
- [Neo4j](https://neo4j.com/)
- [Swagger](https://swagger.io/)
- [Docker](https://www.docker.com/)
- [Jenkins](https://www.jenkins.io/)

In order to use Neo4j as the GraphDB, java 17 is required.

### Implementation

#### Spring Security
First off the Spring Security side needs to be implemented. As you can see, I created a User entity
that implements UserDetails from Spring Security. This is needed as we are going to retrieve from the UserRepository
the user based of the email with which he/she registers to our backend.

In this way, the user can then obtain a JWT token signed with his credentials and an expiration date that
Spring will check everytime before making a REST call. 

All the configuration is basically boilerplate code and it follows best practices in terms of security.
The only endpoints I whitelisted from Spring Security are the "/auth" and "/swagger-ui/**" endpoints.

You can find this code under the ***config*** package. 

After the Spring Security is created, and we can successfully retrieve a token, we then proceed in creating
the other API's. 

#### Neo4j
We followed the MVC model and created first the Repositories, then the Services and finally the Controllers.
As you can see the Entities need to be annotated with ***@Node*** and no @GeneratedValue needs to be included, as
we are going to manually set id's for our Neo4j nodes, as the official documentation recommends.

We then define a **@Relationship** towards the entity we want to tie with. For instance the User entity has a 
relationship called *OWNS* towards the Budget entity.

To define custom queries we need to use Cypher Query language, as you can see in *BudgetRepository*.

Remember to define your application as a *@EnableNeo4jRepositories* in your main class.

#### MapStruct
When passing data to and from your backend it is important that you hide useless information from the outside world,
that is why you need to use DTO's when transferring data. To do so I used this library I came across,
named MapStruct. 

All you have to do is define an interface and annotate it with ***@Mapper(componentModel = "spring")***.
It is important to use the componentModel attribute, because we need to compile the project so that MapStruct
will create the mapper classes that will map from an object to another. In this case, take for instance the UserMapper
interface, we are mapping from a User entity to a UserResponse entity, and from a UserRequest entity to a User entity.

Remember to always **mvn clean install** when creating or modifying one of these interfaces. 

#### Swagger
We used Swagger 3 for this project, and to do so you need to create a SwaggerConfig file and basically copy the
boilerplate code there is. 
Given that we are using Spring Security for every API you need to tell Swagger that this API's are authorized through
JWT, and once done so you will see an "Authorize" button appear in Swagger-UI where you will need to input a 
valid JWT token in order to use your endpoints.

You also need to define ***@SecurityScheme(name = SWAGGER_AUTHORIZATION, scheme = "bearer", type = SecuritySchemeType.HTTP, in = SecuritySchemeIn.HEADER)***
in your main class and then for every Controller class you need to add ***@SecurityRequirement(name = SWAGGER_AUTHORIZATION)***.
(SWAGGER_AUTHORIZATION is a String you can choose but that you need to use across the controllers you want to be authorized).

#### Docker
To develop this project I used docker-compose.
You can see the docker-compose.yml file at the root of the project. I basically have 2 services, one is the 
app itself, that we are building from the Dockerfile and connect to it through port 8080.
As you can see the pass also some environment variables such as uri and password. 
The uri you need to use when running on Docker is "bolt://host.docker.internal:7687" while you can simply use
"bolt://localhost:7689" when running as a normal Spring app.

I then pull the neo4j image from Docker Hub, give it the default ports and pass in the NEO4J_AUTH environment
variables which correspond to username/password.

Both of these services need to run on the same network, in my case the **budget-network**.

#### Jenkins
We created a basic Jenkinsfile to build and deploy the docker image to ECR on AWS. 
Given that you cannot deploy a docker-compose stack, I simply pull the neo4j image on my AWS Linux machine
and than built and deployed the App file as a Java jar, uploaded it to ECR and then pulled it on the same machine.
Remember to pass in the environmental variables when running the **docker run** command.

### Author
Jason Shuyinta