#23-08-04
# -------------------------------------------------------------------------- #
drop database if  exists sqldb4web;
create database sqldb4web;
use sqldb4web;

# 회원번호 아이디 비밀번호 이름 전화번호 저장하는 member테이블 생성
# 테이블과 비슷하게memberDto클래스 설계

drop table if exists member;
create table member(
	mno int not null unique auto_increment,
    mid varchar(20) not null unique,
    mpw varchar(20) not null,
    mname varchar(20) not null,
    mphone  varchar(15) not null unique,
    primary key(mno)
);
select * from member;

