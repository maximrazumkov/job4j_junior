create table employer (
    id serial primary key not null,
    name varchar(150),
    hired date,
    fired date,
    salary numeric
);