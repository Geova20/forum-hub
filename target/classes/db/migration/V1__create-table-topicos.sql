create table topicos(

    id bigint not null auto_increment,
    titulo varchar(100) not null,
    messagem text not null,
    dataCriacao timestamp not null,
    autor varchar(25) not null,
    curso varchar(50) not null,
    status varchar(20) not null,

    primary key(id)
);
