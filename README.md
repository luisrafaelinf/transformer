# Transformer Battle

To build and run the project you need to have Java 8+ and Maven 3.6+ installed in your system. After the build, a `transformer/target/` directory is generated for you with a jar file named **transformer.jar** in it. 
Run the jar with the nexts commands:


``` shell
# Clone the source code.
 git clone https://github.com/luisrafaelinf/transformer.git

# Enter the project directory.
cd transformer

# Compile the project.
mvn clean package

or

mvn clean install

# Use the following commands to test the application with the included test files.
java -jar target/transformer.jar 

```

## URL Rest Services:

by default the service url and port is: http/localhos:9023/

- Transformer CRUD:

List all transformers (GET)
> /v1/transformers/

Get information from specific transformer by database ID (GET)
> /v1/transformers/{id}

Create a new transformer (POST)
> /v1/transformers/

Update a transformer (PUT)
> /v1/transformers/{id}

Update a transformer (DELETE)
> /v1/transformers/{id}


- Transformers Battle:

Fight with a list of transformers (GET)
> /v1/transformers/battle

-The above operations are available into a postman file collection located into the directory postman with data to test. This collection file was exported with the version v2.1

<img src="postman/postman.png" alt="collection" width="300"/>

As well you will find a enviropment file.

<img src="postman/enviropment.png" alt="collection" width="700"/>

## Database Installation

This project is configurated with H2 database in memory.

## Data for sample

When you run the project there is a Data Loader integrated that populate the tables for you with data for sample.

## Assumptions

When the battle ends with the teams tied, the world begins a new era of peace based on an agreement to end the war.
