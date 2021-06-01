
drop database musicplayer;
CREATE DATABASE IF NOT EXISTS musicplayer ;
USE musicplayer;


drop table if exists users;
Create table users(
users_id integer  primary key,
first_name varchar(30) not null,
last_name varchar(30) not null,
users_account varchar(30) not null,
users_password varchar(30) not null,
users_sex varchar(5) not null ,
users_introduct varchar(300),
users_picture_url varchar(60) not null,
users_status integer not null default 0,
users_remove integer not null default 0,
users_identity integer not null default 0
)character set utf8 collate utf8_general_ci;
alter table users modify users_id integer auto_increment ;
 
insert into users(last_name,first_name,users_account,users_password,users_sex,users_introduct,users_picture_url,users_status,users_remove,users_identity) values ('牛','威翔','nwx123','123456','男','组长','/Users/luochengyun/Desktop',0,0,1);
insert into users(last_name,first_name,users_account,users_password,users_sex,users_introduct,users_picture_url,users_status,users_remove,users_identity) values ('黄','佳讯','hjx123','123456','男','组员','/Users/luochengyun/Desktop',0,0,1);
insert into users(last_name,first_name,users_account,users_password,users_sex,users_introduct,users_picture_url,users_status,users_remove,users_identity) values ('张','策','zc123','123456','男','组员','/Users/luochengyun/Desktop',0,0,1);
insert into users(last_name,first_name,users_account,users_password,users_sex,users_introduct,users_picture_url,users_status,users_remove,users_identity) values ('罗','成云','lcy123','123456','男','组员','/Users/luochengyun/Desktop',0,0,1);
insert into users(last_name,first_name,users_account,users_password,users_sex,users_introduct,users_picture_url,users_status,users_remove,users_identity) values ('王','后置','whz123','123456','男','组员','/Users/luochengyun/Desktop',0,0,1);
insert into users(last_name,first_name,users_account,users_password,users_sex,users_introduct,users_picture_url,users_status,users_remove,users_identity) values ('马','勃','mb123','123456','男','组员','/Users/luochengyun/Desktop',0,0,1);
insert into users(last_name,first_name,users_account,users_password,users_sex,users_introduct,users_picture_url,users_status,users_remove,users_identity) values ('张','三','zs123','123456','女','例子','/Users/luochengyun/Desktop',0,0,0);
insert into users(last_name,first_name,users_account,users_password,users_sex,users_introduct,users_picture_url,users_status,users_remove,users_identity) values ('李','四','ls123','123456','女','例子','/Users/luochengyun/Desktop',0,0,0);




drop table if exists songtype;
Create table songtype(
songtype_id  integer primary key,
songtype_name varchar(40) not null,
songtype_picture_url varchar(60) not null
)character set utf8 collate utf8_general_ci;
alter table songtype modify songtype_id integer auto_increment ;

insert into songtype(songtype_name,songtype_picture_url) values ('华语','/Users/luochengyun/Desktop');
insert into songtype(songtype_name,songtype_picture_url) values ('英语','/Users/luochengyun/Desktop');
insert into songtype(songtype_name,songtype_picture_url) values ('流行','/Users/luochengyun/Desktop');
insert into songtype(songtype_name,songtype_picture_url) values ('摇滚','/Users/luochengyun/Desktop');
insert into songtype(songtype_name,songtype_picture_url) values ('粤语','/Users/luochengyun/Desktop');
insert into songtype(songtype_name,songtype_picture_url) values ('热歌','/Users/luochengyun/Desktop');


drop table if exists singer;
Create table singer(
singer_id integer  primary key,
singer_name varchar(30) not null,
singer_sex varchar(5) not null ,
singer_introduct varchar(300) not null,
singer_picture_url varchar(60) not null
)character set utf8 collate utf8_general_ci;
alter table singer modify singer_id integer auto_increment ;

insert into singer(singer_name,singer_sex,singer_introduct,singer_picture_url) values('张杰','男','歌星','/Users/luochengyun/Desktop');
insert into singer(singer_name,singer_sex,singer_introduct,singer_picture_url) values('谢娜','女','歌星','/Users/luochengyun/Desktop');

drop table  if exists fan;
create table fan(
fan_id integer primary key,
fan_users integer ,
fan_singer integer,
foreign key (fan_users) references users(users_id),
foreign key (fan_singer) references singer(singer_id)
)character set utf8 collate utf8_general_ci;
alter table fan modify fan_id integer auto_increment ;

insert into fan (fan_users,fan_singer) values (7,1);
insert into fan (fan_users,fan_singer) values (8,1);

drop table if exists album;
Create table album(
album_id  integer  primary key,
album_name varchar(40) not null,
album_release date not null,
album_singer integer,
album_picture_url varchar(60) not null,
foreign key (album_singer) references singer(singer_id)
)character set utf8 collate utf8_general_ci;
alter table album modify album_id integer auto_increment ;

insert into album (album_name,album_release,album_singer,album_picture_url) values ('搞笑','2020-02-20',1,'/Users/luochengyun/Desktop');
insert into album (album_name,album_release,album_singer,album_picture_url) values ('忧伤','2020-02-20',1,'/Users/luochengyun/Desktop');	


drop table if exists song;
Create table song(
song_id integer  primary key,
song_name varchar(40) not null,
song_release date not null,
song_url varchar(60) not null,
song_lyric_url varchar(60) ,
song_clicks bigint default 0,
song_singer integer not null,
song_album integer ,
song_type integer,
foreign key (song_singer) references singer(singer_id),
foreign key (song_type) references songtype(songtype_id),
foreign key (song_album) references album(album_id)
)character set utf8 collate utf8_general_ci;
alter table song modify song_id integer auto_increment ;

insert into song (song_name,song_release,song_url,song_lyric_url,song_clicks,song_singer,song_album,song_type) values ('逆战','2020-02-20','/Users/luochengyun/Desktop','/Users/luochengyun/Desktop',1,1,1,1);
insert into song (song_name,song_release,song_url,song_lyric_url,song_clicks,song_singer,song_album,song_type) values ('例子','2020-02-21','/Users/luochengyun/Desktop','/Users/luochengyun/Desktop',1,1,1,1);



drop table if exists collectlist;
Create table collectlist(
collectlist_id  integer primary key,
collectlist_users integer not null,
collectlist_song integer not null,
foreign key (collectlist_users) references users(users_id),
foreign key (collectlist_song) references song(song_id)
)character set utf8 collate utf8_general_ci;
alter table collectlist modify collectlist_id integer auto_increment ;

insert into collectlist (collectlist_users,collectlist_song) values (7,1);
insert into collectlist (collectlist_users,collectlist_song) values (8,1);


drop table if exists songlist;
Create table songlist(
songlist_id  integer primary key,
songlist_name varchar(40) not null,
songlist_users integer not null,
foreign key (songlist_users) references users(users_id)
)character set utf8 collate utf8_general_ci;
alter table songlist modify songlist_id integer auto_increment ;

insert into songlist (songlist_name,songlist_users) values ('最爱',7);
insert into songlist (songlist_name,songlist_users) values ('个性',7);



drop table if exists recentlist;
Create table recentlist(
recentlist_id  integer  primary key,
recentlist_users integer not null,
recentlist_song integer not null,
recentlist_time date not null,
foreign key (recentlist_users) references users(users_id),
foreign key (recentlist_song) references song(song_id)
)character set utf8 collate utf8_general_ci;
alter table recentlist modify recentlist_id integer auto_increment ;

insert into recentlist (recentlist_users,recentlist_song,recentlist_time) values (7,1,'2020-02-20');
insert into recentlist (recentlist_users,recentlist_song,recentlist_time) values (8,1,'2020-02-20');



drop table if exists listandsong;
create table listandsong(
listandsong_id integer primary key,
listandsong_songid integer not null,
listandsong_listid integer not null,
foreign key (listandsong_songid) references song(song_id),
foreign key (listandsong_listid) references songlist(songlist_id)
)character set utf8 collate utf8_general_ci;
alter table listandsong modify listandsong_id integer auto_increment ;


insert into listandsong (listandsong_songid,listandsong_listid) values (1,1);
insert into listandsong (listandsong_songid,listandsong_listid) values (1,2);

drop table if exists record;
Create table record(
record_id integer primary key,
record_users integer not null,
record_time timestamp not null,
foreign key (record_users) references users(users_id)
)character set utf8 collate utf8_general_ci;
alter table record modify record_id integer auto_increment ;

insert into record (record_users,record_time) values (7,'2020-02-20 20:00:00');
insert into record (record_users,record_time) values (8,'2020-02-20 20:00:00');
