FROM openjdk:21-jdk AS backend

#diretorio onde esta a aplicação
WORKDIR /check-app

#copia o jar
COPY build/libs/check-app.jar .

#expoe a porta 8080 da aplicação
EXPOSE 8080

#inicia a aplicação
ENTRYPOINT ["java", "-jar", "check-app.jar"]