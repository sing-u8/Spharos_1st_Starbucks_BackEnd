# Docker 이미지를 빌드하기 위한 기본 이미지를 설정
# OpenJDK 17 버전이 포함된 슬림(경량) 이미지로, Java 애플리케이션을 실행하기 위한 Java Development Kit(JDK)가 포함
FROM openjdk:17-jdk-slim

# WORKDIR 지시어 컨테이너 내에서 작업 디렉토리를 설정
# 컨테이너 내에서 애플리케이션이 실행될 위치
# 컨테이너 내부의 루트 디렉토리에서의 /app을 지정
WORKDIR /app

# 호스트 시스템의 파일을 컨테이너 이미지로 복사
# starbucks-0.0.1-SNAPSHOT.jar -> app.jar 복사
# 컨테이너의 /app/app.jar에 빌드 파일 복사
COPY build/libs/starbucks-0.0.1-SNAPSHOT.jar app.jar

# 컨테이너가 시작될 때 /app/app.jar 파일을 실행
ENTRYPOINT ["java", "-jar", "app.jar"]