# youthconn-demo

## 환경
- Mac
- Java 11
- IntelliJ Ultimate
- Minikube
- MySQL 8

## docker for ~~~ 설치

### Mac
https://hub.docker.com/editions/community/docker-ce-desktop-mac/

### Windows
https://hub.docker.com/editions/community/docker-ce-desktop-windows/


## Minikube 설치
[https://minikube.sigs.k8s.io/docs/start/](https://minikube.sigs.k8s.io/docs/start/)

### Mac
1. 다운로드
 - `brew install minikube`
2. 실행
 - `minikube start`

### Windows
1. 다운로드
 - https://storage.googleapis.com/minikube/releases/latest/minikube-installer.exe
2. 실행
 - `minikube start --driver=docker`
 
## 테이블 만들기
```sql
create table todo
(
    id         bigint auto_increment primary key,
    created_at datetime(6)  null,
    done       bit          not null,
    title      varchar(255) null
);
```



