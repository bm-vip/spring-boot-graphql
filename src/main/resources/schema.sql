drop table if exists author cascade;
drop table if exists book cascade;
drop sequence if exists seq_author;
drop sequence if exists seq_book;

create sequence seq_author start with 1 increment by 1;
create sequence seq_book start with 1 increment by 1;
create table author (id bigint not null, first_name varchar(255), last_name varchar(255), primary key (id));
create table book (page_count integer, author_id bigint, id bigint not null, name varchar(255), primary key (id));
alter table if exists book add constraint fk_book_author_id foreign key (author_id) references author;

