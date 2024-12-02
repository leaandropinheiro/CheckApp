FROM openjdk:21-jdk AS backend

WORKDIR /check-app

#copia o jar
COPY build/libs/check-app.jar .

#inicia a aplicação
ENTRYPOINT ["java", "-jar", "check-app.jar"]

#expoe a porta 8080 da aplicação
EXPOSE 8080