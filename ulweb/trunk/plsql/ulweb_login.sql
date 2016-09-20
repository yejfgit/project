--删除ul_role_class全部记录
delete from ul_role_class;

--插入几条基本记录
insert into ul_role_class values(2, 1, 9, '', '0000', 'pdfpolicy');
insert into ul_role_class values(1, 1, 2, '172,174,176', '1107', '翁虓飞');
insert into ul_role_class values(3, 1, 9, '', '0000', '杨勇(信息管理中心)');
commit;


--建立t_users表结构
-- Create table
create table T_USERS
(
  USER_ID    NUMBER(10) not null,
  LOGIN_NAME VARCHAR2(128) not null,
  REAL_NAME  VARCHAR2(128) not null
)
tablespace UMDEVDATA
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
  
--插入几条基本记录
insert into t_users values(1, 'wengxf', '翁虓飞');
insert into t_users values(2, 'pdfpolicy', 'pdfpolicy');
insert into t_users values(3, 'yangyong', '杨勇(信息管理中心)');
commit;

-- Create/Recreate primary, unique and foreign key constraints 
alter table T_USERS
  add constraint PK_USER_ID primary key (USER_ID)
  using index 
  tablespace ULWEB
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
alter table T_USERS
  add constraint UK_USER_NAME unique (LOGIN_NAME)
  using index 
  tablespace ULWEB
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
