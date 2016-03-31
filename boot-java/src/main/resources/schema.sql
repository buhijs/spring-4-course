create table animals (
  id identity,
  type varchar(30) not null,
  name varchar(50) not null
);

insert into animals(name, type) values('Shere Khan', 'Tiger');
insert into animals(name, type) values('Dumbo', 'Elephant');
insert into animals(name, type) values('Bertha', 'Hippo');
insert into animals(name, type) values('Hao Hao', 'Panda');
insert into animals(name, type) values('Xing Hui', 'Panda');
insert into animals(name, type) values('Ceasar', 'Chimp');