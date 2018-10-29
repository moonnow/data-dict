/*==============================================================*/
/* Name:<数据字典> Table: PRO_DATA_DICT                          */
/*==============================================================*/
/*
mysqldump -hlocalhost -P3306 -uroot -pmoonnow empire PRO_DATA_DICT > PRO_DATA_DICT.sql
*/
drop table if exists PRO_DATA_DICT;
create table PRO_DATA_DICT (
  DATA_DICT_ID                    varchar(36)         character set utf8 collate utf8_bin  not null comment '数据字典编号',
  DATA_DICT_NAME                  varchar(64)         character set utf8 collate utf8_bin  not null comment '数据字典名称',
  DATA_DICT_KEY                   varchar(64)         character set utf8 collate utf8_bin  not null comment '数据字典标识',
  primary key (DATA_DICT_ID),
  unique key (DATA_DICT_KEY)
)ENGINE=INNODB DEFAULT CHARSET=utf8 comment '数据字典';

/*==============================================================*/
/* Name:<数据字典值> Table: PRO_DATA_DICT_VALUE                  */
/*==============================================================*/
/*
mysqldump -hlocalhost -P3306 -uroot -pmoonnow empire PRO_DATA_DICT_VALUE > PRO_DATA_DICT_VALUE.sql
*/
drop table if exists PRO_DATA_DICT_VALUE;
create table PRO_DATA_DICT_VALUE (
  DATA_DICT_VALUE_ID              varchar(36)         character set utf8 collate utf8_bin  not null comment '数据字典值编号',
  CODE                            varchar(64)         character set utf8 collate utf8_bin  not null comment '代码',
  DISPLAY_NAME                    varchar(64)         character set utf8 collate utf8_bin  not null comment '显示名称',

  DATA_DICT_ID                    varchar(36)         character set utf8 collate utf8_bin  not null comment '数据字典编号',
  primary key (DATA_DICT_VALUE_ID),
  unique key (CODE, DATA_DICT_ID)
)ENGINE=INNODB DEFAULT CHARSET=utf8 comment '数据字典值';
alter table PRO_DATA_DICT_VALUE add constraint FK_PRO_DICT_VALUE_DATA_DICT_ID foreign key (DATA_DICT_ID) references PRO_DATA_DICT(DATA_DICT_ID);
