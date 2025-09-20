# Write your MySQL query statement below
select p.product_name, year, price
from product p
JOIN sales s
on p.product_id  = s.product_id