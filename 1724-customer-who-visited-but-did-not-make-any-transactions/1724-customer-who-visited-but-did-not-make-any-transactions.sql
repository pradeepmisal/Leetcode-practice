# Write your MySQL query statement below
select v.customer_id , COUNT(v.visit_id) as count_no_trans
FROM visits v
Left join Transactions t
on v.visit_id = t.visit_id
where t.transaction_id is null
group by v.customer_id