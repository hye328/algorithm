-- FOOD_FACTORY
SELECT FACTORY_ID, FACTORY_NAME, ADDRESS
FROM FOOD_FACTORY
WHERE ADDRESS LIKE '강원도%'
ORDER BY FACTORY_ID
;

-- ONLINE_SALE
/*
15, 12
119, 12

select * from ONLINE_SALE ORDER BY USER_ID, PRODUCT_ID DESC;
*/
SELECT USER_ID, PRODUCT_ID
FROM ONLINE_SALE
GROUP BY USER_ID, PRODUCT_ID
HAVING COUNT(1) > 1
ORDER BY USER_ID, PRODUCT_ID DESC
;

-- ANIMAL_INS
SELECT NAME, DATETIME FROM ANIMAL_INS
ORDER BY ANIMAL_ID DESC
;

-- sick ANIMAL_INS
SELECT ANIMAL_ID, NAME
FROM ANIMAL_INS
WHERE INTAKE_CONDITION = 'Sick';

-- aged ANIMAL_INS
SELECT ANIMAL_ID, NAME
FROM ANIMAL_INS
WHERE INTAKE_CONDITION <> 'Aged'
ORDER BY ANIMAL_ID;

-- all ANIMAL_INS
select animal_id, name from animal_ins
order by animal_id
;

-- sort animal_ins
select animal_id, name, datetime
from animal_ins
order by name, datetime desc, animal_type
;

-- animal_ins
select name from animal_ins
order by datetime
    limit 1
;

-- user_info
-- select * from user_info order by age;
select count(1) as users
from user_info
where joined like '2021%' and (age >= 20 and age <= 29)
;

select count(1) as users
from user_info
where DATE_FORMAT(joined, '%Y') = '2021' and (age >= 20 and age <= 29)
;

select count(1) as users
from user_info
where DATE_FORMAT(joined, '%Y') = '2021' and age between 20 and 29
;

-- CAR_RENTAL_COMPANY_CAR
select round(avg(daily_fee)) as AVERAGE_FEE
from CAR_RENTAL_COMPANY_CAR
where car_type = 'SUV'
;

-- union all
select *
from (
         select date_format(sales_date, '%Y-%m-%d') as SALES_DATE, PRODUCT_ID, NULL as USER_ID, SALES_AMOUNT
         from OFFLINE_SALE
         union all
         select date_format(sales_date, '%Y-%m-%d') as sales_date, product_id, user_id, sales_amount
         from ONLINE_SALE
     ) as t
where sales_date like '2022-03%'
order by sales_date, product_id, user_id
;

-- join
select flavor
from (select j.FLAVOR, (ifnull(fh.TOTAL_ORDER, 0) + ifnull(j.TOTAL_ORDER, 0)) as TOTAL_ORDER
      from JULY j left outer join FIRST_HALF fh on fh.SHIPMENT_ID = j.SHIPMENT_ID) t
group by FLAVOR
order by sum(TOTAL_ORDER) desc
    limit 3;

-- join, group by
select PRODUCT_CODE, (price * sales_amount) as SALES
from (select os.product_id, os.sales_amount, p.price, p.product_code
      from (
               select product_id, sum(sales_amount) as sales_amount
               from OFFLINE_SALE
               group by product_id) os left join PRODUCT p
                                                 on os.product_id = p.product_id
     ) t
group by product_code
order by sales desc, product_code
;