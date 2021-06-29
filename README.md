# Spring
Spring Foundation 

### Spring Boot - https://start.spring.io/
- [Maven vs Gradle](#maven-vs-gradle)
- [Spring Boot Library](#spring-boot-library)
- [Test Library](#test-library)
- [Dependencies](#dependencies)
- [Embedded server](#embedded-server)
- [Business Requirement](#business-requirement)

## Maven vs Gradle
### Maven - Ant의 불편 해소 + 부가기능 추가
- 빌드를 쉽게 수행.
- pom.xml을 이용한 정형화된 빌드 시스템을 제공.
### Gradle - Ant와 Maven의 장점 공유
- Maven을 사용할 수 있는 변환 가능 컨벤션 프레임 워크.
- 멀티 프로젝트에 적합.
- Groovy 문법 사용.

## Spring Boot Library
- spring-boot-starter-web
    - spring-boot-starter-tomcat : 톰캣(WAS)
    - spring-webmvc : 스프링 웹 MVC
- spring-boot-starter-thymeleaf : 타임리프 템플릿 엔진(View)
- spring-boot-starter(공통) : 스프링 부트 + 스프링 코어 + 로깅
    - spring-boot
        - spring-core
    - spring-boot-starter-logging
        - logback, slf4j

## Test Library
- spring-boot-starter-test
    - junit : 테스트 프레임워크
    - mockito : 목 라이브러리
    - assertj : 테스트 코드를 좀 더 편하게 작성하게 도와주는 라이브러리
    - spring-test : 스프링 통합 테스트 지원

## Dependencies
- Spring web : Build web, including RESTful, applications using Spring MVC. Uses Apache Tomcat as the default embedded container.
- Thymeleaf : A modern server-side Java template engine for both web and standalone environments. Allows HTML to be correctly displayed in browsers and as static prototypes.

## Embedded server
Tomcat(WAS) : Apache Tomcat이라고도 불리는 오픈소스 Web Application Server입니다. 
<p align="center"><img src="images/tomcat.png" width="70%"></p>

## Business Requirement
- 데이터 : 회원ID, 이름
- 기능 : 회원 등록, 조회
- 아직 데이터 저장소가 선정되지 않은 상태
- **Web Application Architecture**
<p align="center"><img src="images/architecture.png" width="70%"></p>

    1. 컨트롤러 : 웹 MVC의 Controller
    2. 서비스 : 핵심 비즈니스 로직 구현(e.g. 중복 가입 불가)
    3. 리포지토리 : DB 접근, 도메인 객체를 DB에 저장하고 관리
    4. 도메인 : 비즈니스 도메인 객체(e.g. 회원, 주문, 쿠폰 등 주로 DB에 저장하고 관리)

- **Class Dependency**
<p align="center"><img src="images/cd.png" width="70%"></p>

    1. DB가 선정되지 않았기 때문에 Interface로 구현 클래스를 변경할 수 있도록 설계
    2. DB는 RDB, NoSQL 등을 고려중인 상황.
    3. 초기 개발 단계에서는 구현체로 가벼운 메모리 기반의 DB 사용.