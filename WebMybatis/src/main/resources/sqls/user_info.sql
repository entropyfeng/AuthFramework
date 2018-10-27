create table user_info
(
  id          int auto_increment
    primary key,
  user_name   varchar(20) not null,
  age         int         not null,
  sex         int(1)      not null,
  create_date date        not null
)
  engine = InnoDB
  charset = utf8;
