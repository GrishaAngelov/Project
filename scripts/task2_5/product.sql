create table product(id integer not null auto_increment,primary key (id),name varchar (20), quantity integer);
create table product_history (changed_at timestamp,id integer not null, name varchar(20), old_quantity integer);
insert into product values (null,"apples",20);
insert into product values (null,"chips",15);
create trigger update_product_trigger before update on product for each row insert into product_history values (current_timestamp(),LAST_INSERT_ID(),OLD.name,OLD.quantity);
update product set quantity = 5 where name = "chips";

