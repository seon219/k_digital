create table if not exists article(
	id int not null auto_increment,
	title varchar(100) not null,
	content varchar(1000) not null,
	primary key (id)
);