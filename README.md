# youthconn-demo


## 테이블 만들기
create table todo
(
    id         bigint auto_increment
        primary key,
    created_at datetime(6)  null,
    done       bit          not null,
    title      varchar(255) null
);

