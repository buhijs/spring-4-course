drop table if exists animal_diet;
create table animal_diet(
  id int auto_increment not null primary key,
  animal_type varchar(100) not null,
  food_id int not null
);

drop table if exists food;
create table food(
  id int auto_increment not null primary key,
  name varchar(100) not null,
  calories int not null,
  food_class varchar(100) not null,
  meaty_food_type varchar(100) null,
  fruit boolean null,
  vegetables boolean null
);

drop table if exists animal;
create table animal(
  id int auto_increment not null primary key,
  name varchar(100) not null,
  type varchar(100) not null,
  age int not null,
  tag varchar(10) not null
);

alter table animal_diet add foreign key (food_id) references food(id);

insert into food(id, name, calories, food_class, meaty_food_type) values(1, 'Salmon', 208, 'MeatyFood', 'fish');
insert into food(id, name, calories, food_class, meaty_food_type) values(2, 'Steak', 277, 'MeatyFood', 'meat');
insert into food(id, name, calories, food_class, meaty_food_type) values(3, 'Chicken', 219, 'MeatyFood', 'poultry');
insert into food(id, name, calories, food_class, fruit, vegetables) values(4, 'Apple', 52, 'VegiFood', true, false);
insert into food(id, name, calories, food_class, fruit, vegetables) values(5, 'Banana', 89, 'VegiFood', true, false);
insert into food(id, name, calories, food_class, fruit, vegetables) values(6, 'Carrot', 41, 'VegiFood', false, true);
insert into food(id, name, calories, food_class, fruit, vegetables) values(7, 'Salmon', 800, 'VegiFood', false, false);

insert into animal(id, name, type, age, tag) values(1, 'Tigger', 'tiger', 5, 'T-58');
insert into animal(id, name, type, age, tag) values(2, 'Pooh', 'bear', 6, 'B-10');
insert into animal(id, name, type, age, tag) values(3, 'Eeyore', 'donkey', 7, 'D-147');

insert into animal_diet(animal_type, food_id) values('bear', 7);
insert into animal_diet(animal_type, food_id) values('bear', 6);
insert into animal_diet(animal_type, food_id) values('bear', 4);
insert into animal_diet(animal_type, food_id) values('tiger', 1);
insert into animal_diet(animal_type, food_id) values('tiger', 2);
insert into animal_diet(animal_type, food_id) values('tiger', 3);
insert into animal_diet(animal_type, food_id) values('donkey', 4);
insert into animal_diet(animal_type, food_id) values('donkey', 6);
insert into animal_diet(animal_type, food_id) values('donkey', 5);