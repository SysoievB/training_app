create table programs
(
    id     bigint not null auto_increment,
    length varchar(255),
    name   varchar(255),
    status varchar(255),
    primary key (id)
) engine=InnoDB;
