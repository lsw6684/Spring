# Spring
자바 언어 기반의 프레임워크로 객체 지향 언어가 가진 강력한 특징을 쉽게 활용할 수 있게 도와주는 프레임워크입니다.
- **DI(Dependency Injection, 의존성 주입, 의존 관계)** 와 **DI 컨테이너**를 제공하여 **다형성과 OCP, DIP**를 가능하도록 지원합니다.
    - **클라이언트 코드의 변경 없이 기능을 확장**할 수 있으며, 마치 부품을 교체하듯이 개발할 수 있음을 의미합니다.
- 모든 설계에 인터페이스를 부여하는 것이 권장 되지만, 도입 시 **추상화**라는 비용이 발생하는 것을 인지해야 합니다.

### 객체지향의 핵심인 다형성을 극대화
- **역할과 구현으로 구분**하기 때문에 **유연하고 변경이 용이**합니다.
- **클라이언트에게 영향을 주지 않고 서버를 변경** 할 수 있습니다.
    - 클라이언트는 대상의 역할(인터페이스)만 알면 됩니다.
    - 클라이언트는 구현 대상의 내부 구조를 몰라도 됩니다.
    - 클라이언트는 구현 대상의 내부 구조가 변경되어도 영향을 받지 않습니다.
    - 클라이언트는 구현 대상 자체를 변경해도 영향을 받지 않습니다.
        - 역할 == 인터페이스
        - 구현 == 인터페이스를 구현한 클래스, 구현 객체
- **하지만, 다형성 만으로는 OCP, DIP를 지킬 수 없습니다.**

## SOLID
클린코드로 유명한 로버트 마틴이 정리한 객체 지향 설계의 5가지 권장 원칙
- SRP, Single Responsibility Principle : 단일 책임 원칙
    - 한 클래스는 하나의 책임만 가집니다.
        - 중요한 기준은 **변경**입니다. **변경**이 있을 때 파급 효과가 적으면 SRP를 잘 따른 것입니다.
- OCP, Open/Closed Principle : 개방/폐쇄 원칙
    - 소프트웨어 요소는 **확장에는 열려**있으나 **변경에는 닫혀** 있어야 합니다.
        - **다형성**을 활용합니다. ***인터페이스를  구현한 클래스를 만들어, 새로운 기능을 구현합니다.***
- LSP, Liskov Substitution Principle : 리스코프 치환 원칙
    - 인터페이스의 규약을 지켜서 구현해야 합니다. ***엑셀을 후진으로 구현하는 경우 LSP 위반.***
- ISP, Interface Segregation Principle : 인터페이스 분리 원칙
    - **특정 클라이언트를 위한 인터페이스 여러 개**가 범용 인터페이스 하나보다 좋습니다.
- DIP, Dependeny Inversion Principle : 의존관계 역전 원칙
    - **추상화(역할)에 의존하며, 구체화(구현)에 의존하지 않습니다.**
    - ***특정 배우에 맞게 연극을 준비했기 때문에, 배우가 바뀌면 연극이 불가능 하다는 것이 DIP 위반입니다.***
### Spring Boot - https://start.spring.io/
- [Maven vs Gradle](#maven-vs-gradle)
- [Spring Boot Library](#spring-boot-library)
- [Test Library](#test-library)
- [Dependencies](#dependencies)
- [Embedded server](#embedded-server)
- [Business Requirement](#business-requirement)
- [Spring Bean](#spring-bean)
- [Access to the Database](#access-to-the-database)
- [스프링 설정 이미지](#스프링-설정-이미지)
- [스프링 통합 테스트](#스프링-통합-테스트)
- [스프링 JdbcTemplate](#스프링-jdbctemplate)
- [JPA](#jpa)
- [AOP](#aop)

## Maven vs Gradle
### Maven - Ant의 불편 해소 + 부가기능 추가
- 빌드를 쉽게 수행.
- pom.xml을 이용한 정형화된 빌드 시스템을 제공.
### Gradle - Ant와 Maven의 장점 공유
- Maven을 사용할 수 있는 변환 가능 컨벤션 프레임 워크.
- 멀티 프로젝트에 적합.
- Groovy 문법 사용.

## Spring Boot Library
스프링을 편하게 사용할 수 있도록 하는 라이브러리로, 최근엔 기본으로 사용될 정도로 보편화되어있습니다. 별도의 웹 서버를 설치 안 해도 되며 외부 라이브러리 버전 또한 자동으로 맵핑해 줍니다.
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

## Spring Bean
Spring IoC 컨테이너가 관리하는 자바 객체를 의미합니다. new로 생성하는 객체를 의미하는 것이 아닌 ApplicationContext.getBean()으로 얻어질 수 있는 객체를 의미합니다.
- 생성자에 `@Autowired`가 있으면 스프링이 연관된 객체를 스프링 컨테이너에서 찾아서 넣어줍니다. 이렇게 객체 의존관계를 외부에서 넣어주는 것을 DI(Dependency Injection), 의존성 주입이라 합니다.

### 컴포넌트 스캔 원리
`@Component` 애노테이션이 있으면 스프링 빈으로 자동 등록됩니다.
`@Controller` 컨트롤러가 스프링 빈으로 자동 등록된 이유도 컴포넌트 스캔 때문입니다.
`@Component`를 포함하는 다음 애노테이션도 스프링 빈으로 자동 등록됩니다.
- `@Controller`
- `@Service`
- `@Repository`

## Access to the Database
- H2 Database <br />
별도의 설치 과정 없이 사용하는 RDBMS로 JDBC API를 지원하며 표준 SQL을 사용합니다. 개발 단계의 테스트 DB로 이용되곤 합니다.
    - https://www.h2database.com
    - H2 console
- 순수 JDBC
    - build.gradle 파일에 jdbc, h2 DB 관련 라이브러리 추가
        ```
        implementation 'org.springframework.boot:spring-boot-starter-jdbc'
        runtimeOnly 'com.h2database:h2'
        ```

- 스프링 JDBC Template
- JPA
- Spring Data JPA

## 스프링 설정 이미지
<p align="center"><img src="images/tomcat.png" width="60%"></p>

- 개방-폐쇄 원칙(OCP, Open-Closed Principle)
    - 확장에는 열려있고 수정, 변경에는 닫혀있습니다.
- 스프링의 DI(Dependencies Injection)을 사용하면 **기존 코드를 전혀 손대지 않고 설정만으로 구현 클래스를 변경할 수 있습니다.**

## 스프링 통합 테스트
- @SpringBootTest : 스프링 컨테이너와 테스트를 함께 실행합니다.
- @Transactional : 테스트 케이스에 해당 애노테이션이 있다면, 테스트 시작 전에 트랜잭션을 시작하고, 테스트 완료 후에 **롤백**으로 DB를 복구하여 다음 테스트에 영향을 주지 않습니다.
- @Commit : 테스트 완료 후, 트랜잭션을 Commit합니다.

## 스프링 JdbcTemplate
- 순수 Jdbc와 동일한 환경설정을 하면 됩니다.
- 스프링 JdbcTemplate과 MyBatis같은 라이브러리는 JDBC API에서 본 반복 코드를 대부분 제거해 주지만, SQL은 직접 작성해야 합니다.

## JPA
- JPA는 기존의 반복 코드는 물론이고, 기본적인 SQL도 JPA가 직접 만들어서 실행합니다.
- JPA를 사용하면 SQL과 데이터 중심의 설계에서 객체 중심의 설계로 패러다임을 전환할 수 있습니다.
- JPA를 사용하면 개발 생산성을 크게 높일 수 있습니다.
- dependency
    ```java
    	implementation 'org.springframework.boot:spring-boot-starter-data-jpa'
    // JPA, JDBC 등을 포함    
    ```
1. Entity를 매핑합니다. - `@Entity`
2. PK를 매핑합니다.
3. IDENTITY를 설정하여 자동으로 ID가 매핑 되도록 합니다. - `@Id @GeneratedValue(strategy = GenerationType.IDENTITY)`
4. 서비스 계층에 트랜잭션을 적용합니다. - `@Transactional`
### 스프링 데이터 JPA
반복 개발해온 기본 CRUD기능을 포함하여 Repository에 구현 클래스 없이 인터페이스 만으로 개발이 가능합니다.

## AOP
Aspect Oriented Programming, 관점 지향 프로그래밍
### AOP가 필요한 상황
- 모든 메소드의 호출 시간을 측정할 때
- 공통 관심 사항(cross-cutting concern) vs 핵심 관심 사항(core concern)
- 회원 가입 시간, 회원 조회 시간 측정