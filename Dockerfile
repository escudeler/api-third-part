FROM openjdk:jdk-oracle

WORKDIR /api-third-part
ADD target/api-third-part.jar app.jar

CMD java $JAVA_OPTS -jar app.jar
