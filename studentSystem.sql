create table class
(
    id        int auto_increment
        primary key,
    classname varchar(30) not null,
    teacher   varchar(30) not null,
    score     varchar(4)  null
);

create table register
(
    id       int(4) auto_increment
        primary key,
    name     varchar(15) not null,
    password varchar(40) not null,
    sex      varchar(2)  null,
    email    varchar(40) null,
    constraint register_name_uindex
        unique (name)
);

create table grade
(
    id       int(4) auto_increment
        primary key,
    stu_id   int(4)     not null,
    class_id int(4)     not null,
    grade    varchar(4) null,
    constraint grade_class_id_fk
        foreign key (class_id) references class (id),
    constraint grade_register_id_fk
        foreign key (stu_id) references register (id)
);

create table title
(
    id   int(4) auto_increment
        primary key,
    head varchar(50)  not null,
    text varchar(500) null,
    time datetime     not null
);

create table user
(
    id       int(4) auto_increment
        primary key,
    username varchar(8) not null,
    password varchar(8) not null
);


