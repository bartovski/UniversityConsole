create table degree
(
  id   serial  not null
    constraint degree_pkey
    primary key,
  name varchar not null
);

create table lector
(
  id        serial  not null,
  degree_id integer not null
    constraint lector_degree_id_fk
    references degree,
  name      varchar,
  salary    integer
);

create table department
(
  id      serial  not null
    constraint department_pkey
    primary key,
  name    varchar not null,
  head_id integer
    constraint department_lector_id_fk
    references lector (id)
);

create unique index department_name_uindex
  on department (name);

create table department_lector
(
  id            serial  not null
    constraint department_lector_pkey
    primary key,
  department_id integer not null
    constraint department_lector_department_id_fk
    references department,
  lector_id     integer not null
    constraint department_lector_lector_id_fk
    references lector (id)
);

create unique index lector_id_uindex
  on lector (id);

create unique index degree_id_uindex
  on degree (id);

