create table menu(
  mid int auto_increment ,
  title varchar(255) not null,
  pid int not null default 0,
  primary  key   (`mid`)
);

1 '北京' -1
2 '重庆' -1
3 '天津' -1
4 '朝阳' 1
5 '西城' 1
6 '人定湖' 5

