create table programs
(
    id     bigint not null auto_increment,
    length varchar(255),
    name   varchar(255),
    status varchar(255),
    primary key (id)
) engine=InnoDB;

create table roles (id bigint not null auto_increment, name varchar(255), primary key (id)) engine=InnoDB;
create table users (name bigint not null auto_increment, password varchar(255), username varchar(255), primary key (name)) engine=InnoDB;
create table users_roles (user_id bigint not null, role_id bigint not null) engine=InnoDB;
alter table users_roles add constraint FKj6m8fwv7oqv74fcehir1a9ffy foreign key (role_id) references roles (id);
alter table users_roles add constraint FK2o0jvgh89lemvvo17cbqvdxaa foreign key (user_id) references users (name);
