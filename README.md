# chat-be

## 채팅앱(가제)

2023.12.18~

📊[ERD](https://dbdiagram.io/d/FOW-65837c2256d8064ca06aa79e)

| 항목 | 내용 |
| --- | --- |
| 프로젝트 이름 | 채팅앱(가제) |
| 개발 기간 | 2023-12 ~ (개발중) |
| 한 줄 설명 | Spring Boot 를 사용한 리액티브 애플리케이션 |
| 프로젝트 상세 설명 | Spring Boot, RSocket, JsonWebToken, Oauth 를 사용한 채팅 애플리케이션 |
| 다운로드 및 설치 방법 | - |
| 팀 구성 | 개인 프로젝트 |
| 프로젝트 깃허브 저장소 | 프론트엔드 깃허브저장소: [https://github.com/YubinShin/chat-fe](https://github.com/YubinShin/chat-fe)<br/>백엔드 깃허브저장소: [https://github.com/YubinShin/chat-be](https://github.com/YubinShin/chat-be) |
| 기술 스택 | - 기획: Figma<br/>- 프론트엔드: TypeScript, Next.js, Recoil, TailWind, sockjs, stompjs<br/>- 백엔드: Spring Boot, MySQL, JPA,  Spring Security, JWT, OAUTH2, WebSocket, RSocket, STOMP, Redis pub/sub, log4j, Grafana<br/>- DevOps: OpenAPI, Hal explorer, Actuator, REST API, Docker, K8S |
| 담당 분야 및 역할 | - 전체 서비스 아키텍처 설계  |
| 프로젝트 결과 | - |
| 연락처 | - 이메일 : shin.yubin18@gmail.com |

## 기능 명세 및 개발일지

### 12/18 ~ 12/20 

- 기획

### 12/21 

- 프로젝트 초기화
- 스키마 확정
- DB 설정(Mysql, Redis)
- Actuator 설정('/health', '/info')
- 모니터링 설정(prometheus, grafana)
- RequestLogging, FailureAnalyzer
- 스프링 시큐리티 초기 설정 

### 진행 예정

- 스프링 시큐리티(JWT)
- 유저 CRUD 비즈니스 로직
- 채팅방 CRUD 비즈니스 로직
- 메세지 CR 비즈니스 로직
- OpenAPI 설정
- API 버저닝
- ExceptionHandler
- 속도 제한(Rate Limiter)
- 웹소켓(STOMP, SockJS)
- Docker, K8S(GKE) 배포
- REST API 단위 테스트 작성

### 추가 기능

- OAUTH
- 리액티브, R소켓
- 데이터베이스 최적화 및 인덱싱(Master, Slave 로 분리)
