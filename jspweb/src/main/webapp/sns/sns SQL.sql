use jspweb;
drop table if exists sns;
create table sns(
    sno int auto_increment ,                   	-- 식별번호( 게시물번호 ) , 자동번호 부여
    sfile text not null ,              			-- ( 사진파일 ) , 공백불가능 ,
    scontent longtext not null  ,     			-- ( sns내용 ) , 공백불가능 중복불가
	spwd varchar(20) not null,  				-- ( 비밀번호 ) , 공백불가능
    sdate datetime default now() not null,      -- ( 등록일 )  , 공백불가능
    primary key( sno )
);


select * from sns order by sdate desc;
insert into sns(sfile, scontent, spwd) values ('test.jpg','기북부내륙과 강원북부내륙, 전남서해안 곳곳에 오후부터 저녁까지 5~40㎜ 소나기가 내 ','12345678' );
select sno from sns where sno = 14 and spwd = '11111111';



drop table if exists reply;
create table reply(
    rno int auto_increment ,                   	-- 식별번호( 댓글번호 ) , 자동번호 부여
    rcontent text not null ,              		-- ( 댓글내용 ) , 공백불가능 ,
    rpwd varchar(20) not null,  				-- ( 댓글비밀번호 ) , 공백불가능
    rdate datetime default now() not null,      -- ( 등록일 )  , 공백불가능
    sno int  ,     								-- ( sns번호 ) , 공백불가능 중복불가
    primary key( rno ),
    foreign key( sno) references sns(sno)
);