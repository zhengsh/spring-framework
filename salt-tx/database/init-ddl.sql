# 初始化 DDL

# 创建数据库
create database `slat-tx` character set 'utf8mb4';
use `slat-tx`;

# 创建表
drop table if exists person;
create table person
(
    id          bigint(20)  not null auto_increment comment '用户ID',
    user_name   varchar(20) not null comment '用户名称',
    type        tinyint              default '1' comment '类型（1 普通, 2 vip）',
    birthday    datetime comment '出生日期',
    create_time datetime    not null default current_timestamp comment '创建时间',
    primary key (id)
) comment = '用户信息表';

