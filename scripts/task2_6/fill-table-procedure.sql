delimiter | ;
create procedure fill_customer_table(in n integer)
begin
declare i integer default 0;
while i<n do
insert into customer select null,name,address,age,job from customer;
set i=i+1;
end while;
end
|
delimiter ; |
