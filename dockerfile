# 빌드 스테이지
FROM maven:3.8.4-openjdk-11 as build 
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

# 실행 스테이지
FROM tomcat:9.0-jdk11
# target경로의 WAR파일 경로를 적어준다.(확인!)
WORKDIR /usr/local/tomcat/webapps
COPY --from=build /app/target/aak-1.0.0-BUILD-SNAPSHOT.war ./all_about_knowledge.war

EXPOSE 8080 1521

# 필요한 경우 아래 두 줄 중 하나를 사용합니다.
#ENTRYPOINT ["java","-jar","/app.war"]
CMD [ "catalina.sh","run" ]

# 디버깅을 위해 필요할 때 사용
# CMD ["tail", "-f", "/dev/null"]
