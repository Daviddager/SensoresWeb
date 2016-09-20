#!/bin/bash/
#!/bin/bash
mvn clean
mvn package
asadmin redeploy --name Sensores target/Sensores.war
