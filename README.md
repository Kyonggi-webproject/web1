# 경기대학교 웹프로그래밍 팀프로젝트

경기대학교 웹프로그래밍 팀프로젝트 과제입니다. 이 프로젝트는 브랜드 룩북을 소개하고, 로그인 기능을 통해 마이페이지에서 브랜드별 찜목록을 구현하는 웹 애플리케이션입니다.

## 필수 조건 (Prerequisites)

이 프로젝트를 실행하기 위해서는 다음이 필요합니다:

- Java 21
- Spring Boot 3.2.4
- MySQL 데이터베이스
- 메일 전송을 위한 Gmail 계정

## 설치 (Installation)

1. 이 저장소를 클론합니다:
    ```sh
    git clone https://github.com/username/project-name.git
    ```
2. 프로젝트 디렉토리로 이동합니다:
    ```sh
    cd project-name
    ```
3. 필요한 의존성을 설치합니다 (예: Gradle 또는 Maven 사용):
    ```sh
    ./gradlew build
    ```

## 구성 (Configuration)

`application.yml` 파일을 다음과 같이 설정합니다:

```yaml
server:
  port: 8123

spring:
  datasource:
    driver-class-name: com.mysql.cj.jdbc.Driver
    url: jdbc:mysql://localhost:3306/web
    username: bs_web
    password: Rhdqudtjs1@
    hikari:
      maxLifetime: 1800000  # 30분
      idleTimeout: 600000   # 10분
      maxPoolSize: 10
      connectionTimeout: 30000
      validationTimeout: 5000
      connectionTestQuery: SELECT 1
  thymeleaf:
    cache: false
  mail:
    host: smtp.gmail.com
    port: 587
    username: kongbyeongsun@gmail.com
    password: bxpysaiubgwmwiko
    properties:
      mail:
        smtp:
          auth: true
          starttls:
            enable: true
            required: true
  jpa:
    database-platform: org.hibernate.dialect.MySQL8Dialect
    open-in-view: false
    show-sql: true
    hibernate:
      ddl-auto: update

logging:
  level:
    org:
      springframework:
        security: debug
