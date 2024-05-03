# Write your MySQL query statement below
#select stock_name, sum(if(operation="Sell", price, -price)) as capital_gain_loss from Stocks group by stock_name

# Write your MySQL query statement below
select stock_name, sum(case when operation ='Sell' then price else -1*price end) capital_gain_loss
from Stocks
group by stock_name