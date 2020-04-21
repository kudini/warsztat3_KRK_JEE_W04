create table exercises
(
    id          int auto_increment
        primary key,
    title       varchar(255) null,
    description text         null
);

create table solutions
(
    id          int auto_increment
        primary key,
    created     datetime null,
    updated     datetime null,
    description text     null,
    exercise_id int      null,
    users_id    int      null,
    constraint solutions_ibfk_1
        foreign key (exercise_id) references exercises (id)
);

create index exercise_id
    on solutions (exercise_id);

create index users_id
    on solutions (users_id);

create table users_groups
(
    id   int auto_increment
        primary key,
    name varchar(255) null
);

create table users
(
    id             int auto_increment
        primary key,
    username       varchar(255) null,
    email          varchar(255) not null,
    password       varchar(245) not null,
    users_group_id int          not null,
    constraint email
        unique (email),
    constraint users_group_id
        foreign key (users_group_id) references users_groups (id)
);
