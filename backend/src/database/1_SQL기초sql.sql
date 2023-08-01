/*여러줄 주석*/
#한줄주석
-- 한줄주석
#확대축소 : ctrl+ 마우스 휠
/*
	데이터베이스 : 데이터[자료] , 베이스[모임, 구역, ,,,] => 자료들의 모임 
		- 종류 
			1. 계층형 데이터 베이스 : 트리형태
            2. 네트워크형 데이터베이스 : 양방향 형태 
            3. *관계형 데이터 베이스 : 행/열 구성된 테이블[표] 형태
            4. NoSQL 데이터 베이스 : Key-value (JSON 같은) 의 형태로 /규모가 작은 경우에는 가능하지만...
    - 용어 
			DBA[데이터베이스관리자] - 개발자alter
            DBMA[ 데이터베이스관리 시스템] 
				- MYSQL, ORACLE(1),MARIADB, SQLSERVER - 각회사별
				- 표준SQL[구조화된 질의 언어]
	- 관계
		DBA 개발자 ---------------> DB 기계어							(X)
        DBA 개발자 ---------------> DBMS관리시스템 -----------> DB기계어	(O)
			|					(MYSQL, ORACLE)
		(SQL 언어학습 필요)
    -SQL : DB조작 관리제어할때 사용하는 언어 문법
		1. DDL : 데이터베이스 정의어 
			- create	:[ 생성 ] 데이터베이스, 테이블  
				- create database db명;
                - create table member ( 필드명 속성명, .. , 필드명 속성명 );
            - drop	 	:[ 삭제 ] 데이터베이스, 테이블
				drop database sqldb1; 	# sqldb1 데이터베이스를 삭제함.
                drop database if exists sqldb1;  #만약에 데이터베이스가 존재하면 삭제 [* 만약에 데이터베이스없을때 삭제 명령어 사용하면 오류발생]
                drop table 테이블명;

            - alter		:[ 수정 ] 테이블(표) 속성 수정
            - truncate	:[ 초기화/삭제 ] 테이블(표)내 데이터 싹!다 초기화 삭제
            - rename	:[ 이름변경 ] 테이블(표) 의 이름변경
            - show		:
				show databases;  # show 	databases : 모든 데이터베이스들이 보여짐alter
				show variables like 'datadir'; 	# 데이터베이스가 저장된 로컬pc경로 / 탐색기에서 [보기]에서 숨긴항목 표시하게 체크하고 쭉쭉 들어가다보면 찾을 수 있을거얌.
			- use 
				use db명
        2. DML : 데이터베이스 조작어
			- insert	[ 삽입 ] 테이블(표)에 레코드 삽입
            - select	[ 검색 ] 테이블(표)에 레코드 검색'
				- select * from 테이블명 : 테이블내 모든 레코드를 (행) 검색)  [*] : 와일드카드, 모든이란 의미를 가짐 
            - update	[ 수정 ] 테이블(표)에 레코드 수정
            - delete	[ 삭제 ] 테이블(표)에 레코드 삭제
        3. DCL : 데이터베이스 제어어
			- grant		[ 권한 부여 ] 사용자권한 부여
            - revoke	[ 권한 취소 ] 사용자권한 취소
        4. TCL : 트랜잭션 제어어
			- commit	[ 명령 완료 ] 트랜잭션(명령어단위) 완료
            - rollback	[ 명령 취소 ] 트랜잭션(명령어단위) 취소
		
        - 테이블 용어
			테이블 [표]
					(컬럼) =	(열) = (column) 		= (필드)	
					학번  	학생명	전화번호			주소
                    1010	김현수	010-4444-3333	안산
			1. column = 열 = 필드 = 속성 : 테이블 표의 열 
				예) 학번필드, 학생명필드....
			2. row = 행 = 레고드 : 테이블[표의] 행 
				1번 레코드, 2번 레코드, 3번 레코드
            3. 행과 열의 관계로 구성된 테이블이 다른 테이블과 연결/관계를 맺는 : 데이터베이스를 관계형데이터베이스라고 함    
            
		- 데이터 필드 타입(바이트) [Mysql기준 - dbms마다 조금씩 다름]
			1. 정수
				tinyint (1)		:	-128~127: , 
                smallint(2)		: 	+-3만정도, 
                mediumint(3)	: 	+-800만정도
                int(4), 		:	+-21억정도
                biginㅅ(8)		:	+-21억이상:
			2. 실수
				float(4), double(8)
			3. 문자 
				char(문자길이) 	
					- 고정길이 	char(3) -> 'ab' -> 3바이트 (바뀌지 않음)	
                    - 저장할 데이터 글자수가 정해져있을때
                    - (최소 1~ 최대 255자까지)
                varchar(문자길이)	
					-변길이	varchar(3) -> 'ab' -> 2바이트 (바뀜) 	
                    - 저장할 데이터의 글자수가 정확하지 않을때 
                    - 글자수 1 ~ 65535까지
			4.대용량
				text 		: 최소 1 ~ 최대65535
				mediumtext  : 1~16000,000
                long (4GB) 	: 긴글 게시물내용물, 첨부파일, 이미지
                
                text
			5. 날짜
				date (YYYY-MM-DD), time(HH:MM:SS) , datetime(YYYY-MM-DD HH:MM:SS)
			6.논리 
				boolean(1)	:0 or 1
				
*/

# 예1. 데이터베이스( 여러개 테이블들이 저장되는 공간) 생성alter
create database sqldb1;
	# create 	: 생성한다.
    # database 	: 데이터베이스를 
    # sqldb1	: 생성할 데이터베이스의 이름 [ 아무거나, 대소문자구분안해, ]
    # ; 		: 명령어 끝마침
		#해당 명령어 줄에 커서 위치한 상태에서 ctrl + 엔터
        # navigator 새로고침alter
create database sqldb2;
create database sqldb3;
create database sqldb4;
create database sqldb5;

show databases;
	# show 	databases : 모든 데이터베이스들이 보여짐alter
show variables like 'datadir';
	# 데이터베이스가 저장된 로컬pc경로 / 탐색기에서 [보기]에서 숨긴항목 표시하게 체크하고 쭉쭉 들어가다보면 찾을 수 있을거얌.
drop database sqldb1;
	# sqldb1 데이터베이스를 삭제함.
drop database sqldb2;
drop database sqldb3;
drop database sqldb4;
drop database sqldb5;

	#만약에 데이터베이스가 존재하면 삭제 [* 만약에 데이터베이스없을때 삭제 명령어 사용하면 오류발생]
drop database if exists sqldb1;

create database sqldb1;
use sqldb1;

# 활용1 : 데이터베이스를 새롭게 생성하세요~alter
#1. 데이터베이스 존재하면 삭제처리
drop database if exists test1;
#2. 데이터베이스 생성
create database test1;
#3. 데이터베으스 사용준비
use test1;

/* --------------------------- 테이블(표 )만들기  ----------------------------- */
# 테이블(표) 는 데이터베이스 안에 저장 [무슨 데이터베이스에 생성할건지  === > use 데이터베이스명;]
use sqldb1; -- 테이블 생성할 데이터베이스 선택
create table member (
	아이디 text, 비밀번호 text
);
	# create : 생성한다.
    # table : table을
    # 테이블명 이름정의 [아무거나, 대소문자구분, 키워드 x ]
    # ( 필드명 타입, 필드명, 타입,.....,필드명 타입 ) : 테이블(표) 제목 속성 열 필드 정의
select * from member; -- 테이블의 모든 레코드 검색

# 테이블삭제 
drop table member;


#활용
/*
	문제1 : 
		1. 웹개발하는데 db저장소 'sqldbweb' 이라는 이름으로 db생성
        2. 해당db에 member 테이블 생성alter	
			id ( 문자열 최대 20)
            password ( 문자열 최대 10)
*/
 drop database if exists sqldbweb; 
 create database sqldbweb;
 use sqldbweb;
 create table member( id varchar(20), password varchar(10)); -- drop table if exists member; // 이렇게 한번 해주는게 좋음.. 왜냐믄 난중에는 sql문을 한번에 실행하기때문에...
 select * from member;
 
 /*
	문제1 : 
		1. 웹개발하는데 db저장소 'sqldb1web2' 이라는 이름으로 db생성
        2. 해당db에 board 테이블 생성alter	
			no 			(최대 21억)				# 게시물번호
			title 		( 문자열 최대 100) 		# 게시물제목
            content 	( 문자열 최대 65000상)  	# 게시물내용
            view		(최대 21억정도)			# 게시물조회수
            datetime 	(날짜시간)				# 게시물작성일
*/

drop database if exists sqldb1web2;
create database sqldb1web2;
use sqldb1web2;
drop table if exists board;
create table board (		# 필드명은 키워드가 쓰이면 좋지 않아서 테이블이랑 조합하기도.. bno, btitle..
	no int,
    title varchar(100),
    content mediumtext,
    view int,
    datetime datetime
    
);
select * from board;


