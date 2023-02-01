--liquibase formatted sql

--changeset alex:1
create table if not exists bikes (
    id bigint primary key ,
    product_name varchar(25),
    color varchar(15),
    frame_size varchar(15),
    price bigint
    );

--rollback drop table bikes;
