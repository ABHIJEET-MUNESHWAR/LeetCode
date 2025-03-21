# Write your MySQL query statement below
select ROW_NUMBER() OVER() id, student from seat order by if(MOD(id, 2)=0, id-1, id+1)