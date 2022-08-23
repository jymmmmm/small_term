select distinct u.id, u.status,i.lac,i.lon
from Tb_user as u
left join 
Tb_info as i
where u.id = i.user_id;