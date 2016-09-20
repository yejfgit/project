-- Create table
create table T_USERS
(
  USER_ID    NUMBER(10) not null,
  LOGIN_NAME VARCHAR2(128) not null,
  REAL_NAME  VARCHAR2(128) not null
)
tablespace ESMS_A
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
-- Create/Recreate primary, unique and foreign key constraints 
alter table T_USERS
  add constraint PK_USER_ID primary key (USER_ID)
  using index 
  tablespace ESMS_A
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
  tablespace ESMS_A
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );







-- Create table
create table UL_ATTACHMENT
(
  ATTACHMENT_ID      NUMBER(11) not null,
  ATTACHMENT_PATH    VARCHAR2(420),
  IS_DELETE          NUMBER(1) default 0,
  CONTENT_ID         NUMBER(10),
  SHOW_NAME          VARCHAR2(300),
  ATTACHMENT_ORDER   NUMBER(2),
  ATTACHMENT_TYPE    NUMBER(5),
  POLICY_ENTITY_ID   VARCHAR2(36),
  UPLOAD_USER        VARCHAR2(60),
  STATUS             NUMBER(2),
  NEED_GENERATE      NUMBER(1) default 6,
  NEED_SECURE        NUMBER(1) default 6,
  UPDATE_TIME        DATE default sysdate,
  ERROR_MESSAGE      VARCHAR2(500),
  PDFATTACHMENT_PATH VARCHAR2(420),
  SUEATTACHMENT_PATH VARCHAR2(420)
)
tablespace ESMS_A
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 128K
    minextents 1
    maxextents unlimited
  );
-- Create/Recreate primary, unique and foreign key constraints 
alter table UL_ATTACHMENT
  add constraint PK_UL_ATTACHMENT primary key (ATTACHMENT_ID)
  using index 
  tablespace ESMS_A
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
-- Create/Recreate indexes 
create index IDX_CONTENT_ID on UL_ATTACHMENT (CONTENT_ID)
  tablespace ESMS_A
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );







-- Create table
create table UL_COLUMN
(
  COLUMN_ID         NUMBER(5) not null,
  COLUMN_NAME       VARCHAR2(300),
  ORGAN_ID          VARCHAR2(40),
  COLUMN_LEVEL      NUMBER(1),
  PARENT_ID         NUMBER(5),
  IS_DELETE         NUMBER(1),
  INCLUDE_COLUMN    NUMBER(1),
  SHOW_TO_USER      NUMBER(1),
  INCLUDE_CONTENT   NUMBER(1),
  COLUMN_ORDER      NUMBER(2),
  SHOW_OTHERS_CLASS NUMBER(10),
  SHOW_ORGAN_CLASS  NUMBER(10),
  OPEN_COLUMN       NUMBER(1),
  COLUMN_EID        VARCHAR2(100),
  ORDER_NUM         NUMBER(5) default 0,
  CONTENT_TMPL_ID   NUMBER(10) default -1
)
tablespace ESMS_A
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
-- Create/Recreate primary, unique and foreign key constraints 
alter table UL_COLUMN
  add constraint PK_UL_COLUMN primary key (COLUMN_ID)
  using index 
  tablespace ESMS_A
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );








-- Create table
create table UL_CONFIG
(
  CONFIG_ID     NUMBER(10) default 1,
  CONSTANT_NAME VARCHAR2(40),
  COLUMN_NAME   NVARCHAR2(150),
  CONSTANT_DATA VARCHAR2(100) default 0,
  IP            VARCHAR2(15),
  UPDATE_TIME   DATE default sysdate,
  UPDATE_USER   NVARCHAR2(20),
  DESCRIPT      NVARCHAR2(200)
)
tablespace ESMS_A
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );






-- Create table
create table UL_CONTENT
(
  CONTENT_ID        NUMBER(10) not null,
  COLUMN_ID         NUMBER(5),
  CONTENT_NAME      VARCHAR2(300),
  CONTENT           CLOB,
  UPLOAD_TIME       DATE default sysdate,
  UPLOAD_USER       VARCHAR2(60),
  ORGAN_ID          VARCHAR2(40),
  IS_DELETE         NUMBER(1) default 0,
  ATTACHMENT_SUM    NUMBER(2),
  KEY_WORD          VARCHAR2(100),
  UPDATE_TIME       DATE default sysdate,
  SHOW_OTHERS_CLASS NUMBER(10) default 0,
  SHOW_ORGAN_CLASS  NUMBER(10) default 0,
  IS_QUICK_LINK     NUMBER(1) default 0,
  DOCUMENT_NUM      VARCHAR2(100) default '',
  DOCUMENT_WORD     VARCHAR2(100) default '',
  QUICK_TIME        DATE default sysdate+3,
  HAVE_CONTENT      NUMBER(1) default 1,
  ON_INDEX          NUMBER(1) default 0,
  DISPLAY_TYPE      NUMBER(1) default 0,
  QUICK_TIME_INT    NUMBER(5) default 3,
  SUB_TITLE         VARCHAR2(300) default '',
  UPLOAD_DEPT_STR   VARCHAR2(100) default '',
  UPLOAD_DEPT_INT   NUMBER(20) default 0,
  ORDER_NUM         NUMBER(5) default 0,
  IS_PROCESSING     NUMBER(1) default 0
)
tablespace ESMS_A
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 576K
    minextents 1
    maxextents unlimited
  );
-- Create/Recreate primary, unique and foreign key constraints 
alter table UL_CONTENT
  add constraint PK_UL_CONTENT primary key (CONTENT_ID)
  using index 
  tablespace ESMS_A
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );







-- Create table
create table UL_CONTENT_TMPL
(
  TMPL_ID      NUMBER(10) not null,
  TMPL_NAME    VARCHAR2(1024),
  TMPL_CONTENT CLOB
)
tablespace ESMS_A
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
-- Create/Recreate primary, unique and foreign key constraints 
alter table UL_CONTENT_TMPL
  add constraint PK_CONTMPL_ID primary key (TMPL_ID)
  using index 
  tablespace ESMS_A
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );






-- Create table
create table UL_MAIL
(
  MAIL_ID       NUMBER(10) not null,
  MAIL_SUBJECT  VARCHAR2(4000),
  MAIL_TO       VARCHAR2(4000),
  MAIL_CC       VARCHAR2(4000),
  MAIL_BCC      VARCHAR2(4000),
  MAIL_FROM     VARCHAR2(4000),
  SEND_TIME     DATE,
  IS_SUCCESS    NUMBER(1),
  CONTENT_ID    NUMBER(10),
  ATTACHMENT_ID NUMBER(10),
  MAIL_DESC     VARCHAR2(4000),
  MAIL_BODY     CLOB
)
tablespace ESMS_A
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
-- Create/Recreate primary, unique and foreign key constraints 
alter table UL_MAIL
  add constraint PK_MAIL_ID primary key (MAIL_ID)
  using index 
  tablespace ESMS_A
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );






-- Create table
create table UL_ORGAN
(
  ORGAN_ID        VARCHAR2(40) not null,
  ORGAN_NAME      VARCHAR2(60),
  ORGAN_MODEL     NUMBER(10),
  CONTENT_TMPL_ID NUMBER(10) default -1
)
tablespace ESMS_A
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
-- Create/Recreate primary, unique and foreign key constraints 
alter table UL_ORGAN
  add constraint PK_ORGAN primary key (ORGAN_ID)
  using index 
  tablespace ESMS_A
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );






-- Create table
create table UL_POLICY
(
  POLICY_ID   CHAR(36) not null,
  POLICY_NAME VARCHAR2(4000),
  POLICY_DESC VARCHAR2(4000),
  SECURE      VARCHAR2(4000),
  GROUPS      VARCHAR2(4000),
  USERS       VARCHAR2(4000)
)
tablespace ESMS_A
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
-- Create/Recreate primary, unique and foreign key constraints 
alter table UL_POLICY
  add constraint POLICYID primary key (POLICY_ID)
  using index 
  tablespace ESMS_A
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );







-- Create table
create table UL_ROLE_CLASS
(
  ROLE_ID    NUMBER(10) not null,
  ROLE_CLASS NUMBER(10),
  IS_ADMIN   NUMBER(1),
  COLUMN_ID  VARCHAR2(3000),
  ORGAN_ID   VARCHAR2(40) default '0000',
  USER_NAME  VARCHAR2(60) default 'unname'
)
tablespace ESMS_A
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
-- Create/Recreate primary, unique and foreign key constraints 
alter table UL_ROLE_CLASS
  add constraint PK_UL_ROLE_CLASS primary key (ROLE_ID)
  using index 
  tablespace ESMS_A
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );






-- Create table
create table UL_TEMPLATE
(
  TEMPLATE_ID    NUMBER(10) not null,
  TEMPLATE_NAME  VARCHAR2(300),
  TEMPLATE_PTYPE NUMBER(5),
  COLUMN_ID      NUMBER(10),
  TEMPLATE_DEPT  VARCHAR2(50),
  TEMPLATE_DESC  VARCHAR2(600),
  CSS            VARCHAR2(4000),
  SAVE_TIME      DATE,
  USER_ID        VARCHAR2(100),
  IS_DELETE      NUMBER(1),
  PAGE_SIZE      NUMBER(10),
  PIC1           VARCHAR2(200),
  PIC2           VARCHAR2(200),
  PIC3           VARCHAR2(200),
  PIC4           VARCHAR2(200),
  PIC5           VARCHAR2(200),
  PIC6           VARCHAR2(200),
  FLASH          VARCHAR2(200)
)
tablespace ESMS_A
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
-- Create/Recreate primary, unique and foreign key constraints 
alter table UL_TEMPLATE
  add constraint PK_UL_TEMPLATE primary key (TEMPLATE_ID)
  using index 
  tablespace ESMS_A
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );








-- Create sequence 
create sequence SEQ_ATTACHMENT_ID
minvalue 1
maxvalue 999999999999999999999999999
start with 1
increment by 1
cache 20;





-- Create sequence 
create sequence SEQ_COLUMN_ID
minvalue 1
maxvalue 999999999999999999999999999
start with 1
increment by 1
cache 20;





-- Create sequence 
create sequence SEQ_CONTENT_ID
minvalue 1
maxvalue 999999999999999999999999999
start with 1
increment by 1
cache 20;





-- Create sequence 
create sequence SEQ_CON_TMPL_ID
minvalue 1
maxvalue 9999999999
start with 21
increment by 1
cache 20;





-- Create sequence 
create sequence SEQ_MAIL_ID
minvalue 1
maxvalue 9999999999
start with 1
increment by 1
cache 20;






-- Create sequence 
create sequence SEQ_USER_ID
minvalue 1
maxvalue 99999999
start with 1
increment by 1
cache 20;





-- Create sequence 
create sequence SEQ_COUNT_MARKET
minvalue 1
maxvalue 999999999999999999999999999
start with 1
increment by 1
cache 20;





-- Create sequence 
create sequence SEQ_COUNT_PEIXUN
minvalue 1
maxvalue 999999999999999999999999999
start with 1
increment by 1
cache 20;






-- Create sequence 
create sequence SEQ_TEMPLATE_ID
minvalue 1
maxvalue 999999999999999999999999999
start with 1
increment by 1
cache 20;
