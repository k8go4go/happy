create table tb_board_comment (
	comment_no number(6) primary key,
	no number(6) not null,
	content varchar2(200) not null,
	user_id varchar2(20) not null,
	reg_date date default sysdate
);

create sequence s_board_comment_no;