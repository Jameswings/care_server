
drop table if exists account;

drop table if exists customer;

drop table if exists customer_contact;

drop table if exists customer_details;

drop table if exists diagnosis;

drop table if exists doc_cus;

drop table if exists doctor;

drop table if exists doctor_ecg;

drop table if exists ecg_data;

drop table if exists ecg_details;

drop table if exists notice;

drop table if exists notice_history;

drop table if exists pending_request;

drop table if exists pending_response;

drop table if exists request_history;

drop table if exists response_history;

drop table if exists users;


create table account
(
   id                   char(32) not null,
   user_id              char(32),
   balance              int,
   credit               int,
   primary key (id)
);

create table customer
(
   id                   char(32) not null,
   user_id              char(32),
   name                 varchar(64),
   type                 int(2),
   iden                 char(18),
   nick_name            varchar(64),
   sex                  int(1),
   age                  int(3),
   cell_phone           varchar(20),
   phone                varchar(20),
   creation_time        datetime,
   primary key (id)
);

create table customer_contact
(
   id                   char(32) not null,
   customer_id          char(32),
   name                 varchar(64),
   relationship         varchar(32),
   phone                varchar(20),
   weight               int,
   creation_time        datetime,
   primary key (id)
);

create table customer_details
(
   id                   char(32) not null,
   customer_id          char(32),
   address              varchar(128),
   zipcode              varchar(10),
   company              varchar(128),
   primary key (id)
);

create table diagnosis
(
   id                   char(32) not null,
   ecg_id               char(32),
   customer_id          char(32),
   doctor_id            char(32),
   status               int(2),
   message              varchar(1024),
   creation_time        datetime,
   primary key (id)
);

create table doc_cus
(
   doctor_id            char(32) not null,
   customer_id          char(32) not null,
   mark                 int(2),
   note                 varchar(32),
   primary key (doctor_id, customer_id)
);

create table doctor
(
   id                   char(32) not null,
   user_id              char(32),
   name                 varchar(64),
   title                varchar(32),
   iden                 char(18),
   nick_name            varchar(64),
   sex                  int(1),
   age                  int(3),
   cell_phone           varchar(20),
   phone                varchar(20),
   creation_time        datetime,
   primary key (id)
);

create table doctor_ecg
(
   id                   char(32) not null,
   doctor_id            char(32),
   ecg_id               char(32),
   customer_id          char(32),
   type                 int(2),
   status               int(2),
   annotation           varchar(128),
   last_update          datetime,
   creation_time        datetime,
   primary key (id)
);

create table ecg_data
(
   id                   char(32) not null,
   customer_id          char(32),
   file_location        varchar(128),
   creation_time        datetime,
   primary key (id)
);

create table ecg_details
(
   id                   char(32) not null,
   ecg_id               char(32),
   primary key (id)
);

create table notice
(
   id                   char(32) not null,
   type                 int(3),
   message              varchar(1024),
   cmd                  varchar(128),
   from_type            int(2),
   from_id              char(32),
   to_type              int(2),
   to_id                char(32),
   creation_time        datetime,
   primary key (id)
);

create table notice_history
(
   id                   char(32) not null,
   type                 int(3),
   message              varchar(1024),
   cmd                  varchar(128),
   from_type            int(2),
   from_id              char(32),
   to_type              int(2),
   to_id                char(32),
   creation_time        datetime,
   status               int(2),
   deal_time            datetime,
   primary key (id)
);

create table pending_request
(
   id                   char(32) not null,
   type                 int(3),
   message              varchar(256),
   cmd                  varchar(128),
   from_type            int(2),
   from_id              char(32),
   to_type              int(2),
   to_id                char(32),
   creation_time        datetime,
   primary key (id)
);

create table pending_response
(
   id                   char(32) not null,
   message              varchar(256),
   cmd                  varchar(128),
   type                 int(3),
   target_id            char(32),
   from_type            int(2),
   from_id              char(32),
   to_type              int(2),
   to_id                char(32),
   creation_time        datetime,
   primary key (id)
);

create table request_history
(
   id                   char(32) not null,
   message              varchar(256),
   cmd                  varchar(128),
   type                 int(3),
   from_type            int(2),
   from_id              char(32),
   to_type              int(2),
   to_id                char(32),
   creation_time        datetime,
   status               int(2),
   deal_time            datetime,
   primary key (id)
);

create table response_history
(
   id                   char(32) not null,
   message              varchar(256),
   cmd                  varchar(128),
   type                 int(3),
   from_type            int(2),
   from_id              char(32),
   to_type              int(2),
   to_id                char(32),
   creation_time        datetime,
   status               int(2),
   deal_time            datetime,
   primary key (id)
);

create table users
(
   id                   char(32) not null,
   username             varchar(128),
   password             char(128),
   status               int(2),
   type                 int(2),
   primary key (id)
);

