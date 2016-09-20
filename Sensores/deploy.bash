#!/bin/bash/
#!/bin/bash
mvn clean
mvn package
asadmin deploy --name Sensores target/Sensores.war
