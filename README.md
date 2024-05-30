# 경기대학교 웹프로그래밍 팀프로젝트

경기대학교 웹프로그래밍 팀프로젝트 과제입니다. 이 프로젝트는 브랜드 룩북을 소개하고, 로그인 기능을 통해 마이페이지에서 브랜드별 찜목록을 구현하는 웹 애플리케이션입니다.

## 필수 조건 (Prerequisites)

이 프로젝트를 실행하기 위해서는 다음이 필요합니다:

- Java 21
- Spring Boot 3.2.4
- MySQL 데이터베이스
- 비밀번호 찾기 기능 구현 ,전송을 위한  Gmail 계정

## 라이선스 (License)
이 프로젝트는 MIT 라이선스 하에 배포됩니다.

## Bootstrap 라이선스
이 프로젝트는 Bootstrap을 사용하며, MIT 라이선스에 따라 배포됩니다. Bootstrap의 라이선스에 대한 자세한 내용은 [MIT 라이선스](https://opensource.org/licenses/MIT)를 참조하세요.

## 이미지 및 로고
이 프로젝트에서는 Zara, H&M, Topten, Musinsa Standard, Cos, Uniqlo의 로고 및 룩북 이미지를 사용합니다. 이들 로고 및 이미지는 각 브랜드의 소유로서, 저작권 법에 따라 보호됩니다. 이 이미지들은 교육 목적으로만 사용되며, 상업적 사용은 금지됩니다.

- [Zara](https://www.zara.com/)
- [H&M](https://www.hm.com/)
- [Topten](https://www.topten10.co.kr/)
- [Musinsa Standard](https://store.musinsa.com/app/brand/musinsastandard)
- [Cos](https://www.cosstores.com/)
- [Uniqlo](https://www.uniqlo.com/)

## 구성 (Configuration)

프로젝트를 실행하기 전에 `application.yml` 파일을 설정해야 합니다. 아래 예시를 참고하여 각자의 환경에 맞게 수정하세요:

```yaml
server:
  port: 8123  # 임의의 포트번호로 변경 가능합니다.

spring:
  datasource:
    driver-class-name: com.mysql.cj.jdbc.Driver
    url: jdbc:mysql://localhost:3306/web  # 자신의 MySQL URL로 변경하세요.
    username: your_mysql_username  # 자신의 MySQL username으로 변경하세요.
    password: your_mysql_password  # 자신의 MySQL password로 변경하세요.
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
    username: your_gmail_username  # 자신의 Gmail 주소로 변경하세요.
    password: your_gmail_app_password  # 자신의 Gmail 앱 비밀번호로 변경하세요.
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
