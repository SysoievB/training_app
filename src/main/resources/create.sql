create table programs
(
    id     bigint not null auto_increment,
    length varchar(255),
    name   varchar(255),
    status varchar(255),
    primary key (id)
) engine = InnoDB;

create table roles
(
    id   bigint not null auto_increment,
    name varchar(255),
    primary key (id)
) engine = InnoDB;

create table users
(
    id       bigint not null auto_increment,
    password varchar(255),
    username varchar(255),
    primary key (id)
) engine = InnoDB;


create table users_roles
(
    user_id bigint not null,
    role_id bigint not null,
    constraint role_fk foreign key (role_id) references roles(id),
    constraint user_fk foreign key (user_id) references users(id)
) engine = InnoDB;
