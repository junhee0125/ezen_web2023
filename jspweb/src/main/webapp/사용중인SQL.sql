drop database if exists jspweb;
create database jspweb;
use jspweb;

drop table if exists visitlog;
create table visitlog(
    vno         int auto_increment ,        -- 식별번호( 방문록번호 ) , 자동번호 부여
    vwriter     varchar(30) not null ,      -- (방문록작성자명) , 공백불가능
    vpwd        varchar(10) not null ,      -- (방문록비밀번호) , 공백불가능
    vcontent    text not null ,             -- (방문록 내용 )
    vdatetime       datetime default now() ,    -- (방문록 작성일/시간 ) , 생략시 자동날짜/시간 등록
    primary key( vno )
);



drop table if exists member;
create table member(
    mno int auto_increment ,                -- 식별번호( 회원번호 ) , 자동번호 부여
    mid varchar(50) not null unique ,       -- ( 회원아이디 ) , 공백불가능 , 중복불가능
    mpwd varchar(20) not null ,             -- ( 회원비밀번호 ) , 공백불가능
    memail varchar(50) not null unique ,    -- ( 회원이메일 )  , 공백불가능
    mfile longtext ,                         -- ( 회원 프로필의 이미지사진 이름 ) , 공백가능
    primary key( mno )
);
#도서관 좌석
drop table if exists seat;
create table seat (
   lseatno int not null,
    lisuse boolean default false,
    primary key(lseatno)
    );
# 도서관
drop table if exists library;
create table library (
   lno int auto_increment,               # 식별번호 자동번호 프라이머리키
    lname varchar(15) not null,
    lphone varchar(13) not null unique,
    lseatno int not null,
    lindate datetime default now(),
    loutdate datetime default null,
    primary key(lno) ,
    foreign key( lseatno ) references seat( lseatno )
);
# seat 테이블 좌석 정보 입력
insert into seat (lseatno) value (1);
insert into seat (lseatno) value (2);
insert into seat (lseatno) value (3);
insert into seat (lseatno) value (4);
insert into seat (lseatno) value (5);
insert into seat (lseatno) value (6);
insert into seat (lseatno) value (7);
insert into seat (lseatno) value (8);
select * from visitlog;
select * from member;
select * from seat;
select * from library;


#HRM
drop table if exists hrm;
create table hrm(
    hno int auto_increment ,                   -- 식별번호( 직원번호 ) , 자동번호 부여
    hname varchar(20) not null ,              -- ( 직원이름 ) , 공백불가능 , 중복불가능
    hphone varchar(13) not null unique ,     -- ( 직원전화번호 ) , 공백불가능 중복불가
    hrank varchar(1) not null ,               -- ( 직급 )  , 공백불가능
    hphoto text ,                               -- ( 직원사진 이름 ) , 공백가능
    hdate datetime default now() not null,    -- ( 직원등록일 ) , 공백불가능
    primary key( hno )
);
# 등록
insert into hrm(hname, hrank, hphone, hphoto) values (?,?,?,?);

# 리스트 출력
select * from hrm order by hdate desc;
insert into hrm(hname, hrank, hphone, hphoto) values ('김준희','C','010-3526-0081','default.webp');

# 게시판 카테고리
drop table if exists bcategory;
create table bcategory(
    bcno int auto_increment ,
    bcname varchar(30) not null ,
    primary key( bcno )
);
# 샘플 [ 공지사항 , 자유게시판  , 노하우 ]
insert into bcategory value ( 1 , '공지사항');
insert into bcategory value ( 2 , '자유게시판');
insert into bcategory value ( 3 , '노하우');

# 게시판
drop table if exists board;
create table board(
    bno         int auto_increment ,
    btitle      varchar(30) not null ,
    bcontent    longtext ,
    bfile       longtext ,
    bdate       datetime default now() ,
    bview       int default 0 ,
    mno         int ,
    bcno        int ,
    primary key( bno ) ,
    foreign key( mno ) references member(mno)
            on delete cascade ,  -- 회원탈퇴시 게시물도 같이 삭제 [ 제약조건 ]
    foreign key( bcno ) references bcategory( bcno )
            on delete cascade
            on update cascade   -- 카테고리 삭제시 게시물도 삭제 , 카테고리번호 변경시 fk도 같이 변경   [ 제약조건 ]
);
