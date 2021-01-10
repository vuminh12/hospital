use HospitalManagement;

# Trong CSDL phải thể hiện được là một bệnh nhân có thể mắc lại bệnh nào đó nhiều lần 
Create view Repeated_Disease As
select examination.ID_Patient, disease_Examine.Name_Disease, count(Name_Disease) as repeatedTimes
from examination inner join disease_Examine
on examination.ID_Examination = disease_Examine.ID_Examination
group by ID_Patient,Name_Disease;

# Liệt kê danh sách các loại bệnh được các bệnh nhân mắc phải trong tháng 7/2020, các bệnh được sắp xếp theo thứ tự số bệnh nhân đến khám giảm dần
Create view Disease_Summary As
select disease_Examine.Name_Disease, count(distinct examination.ID_Patient) as NumOfPatient
from examination inner join disease_Examine
on examination.ID_Examination = disease_Examine.ID_Examination 
where DATEDIFF ('2020-07-01 00:00:00', examination.At_Time) < 31
group by Name_Disease
order by NumOfPatient desc;

/*view tinh doanh thu*/
/*view tinh doanh thu don thuoc*/
create view med_revenue as
select med_list.ID_Patient, med_list.ID_Treatment, med_list.ID_Examination, (count(*)* A.priceMedList) as total_Revenue
from med_list left join (select med_list.ID_Treatment, med_list.ID_Examination , sum(price) as priceMedList
from med_list inner join med on med_list.name_med = med.name_med
group by med_list.ID_Treatment, med_list.ID_Examination ) as A  on med_list.ID_Treatment = A.ID_Treatment AND med_list.ID_Examination = A.ID_Examination
group by med_list.ID_Treatment, med_list.ID_Examination;

/*view tinh doanh thu don dich vu*/
create view service_revenue as
select service_list.ID_Patient, service_list.ID_Treatment, service_list.ID_Examination, (count(*)* A.priceServiceList) as total_Revenue
from service_list left join (select service_list.ID_Treatment, service_list.ID_Examination , sum(price) as priceServiceList
from service_list inner join service on service_list.name_service = service.name_service
group by service_list.ID_Treatment, service_list.ID_Examination ) as A  on service_list.ID_Treatment = A.ID_Treatment AND service_list.ID_Examination = A.ID_Examination
group by service_list.ID_Treatment, service_list.ID_Examination;

/*view tinh doanh thu buoi kham*/
create view examination_revenue as
select ID_Patient, (count(distinct ID_Examination)*300000) as total_Revenue
from examination
group by ID_Patient;

drop view examination_revenue;
/*view tong doanh thu cua phong kham tu nhan*/
create view clinic_revenue as
select sum(revenue.total_Revenue) as total_Revenue
	from (select  ID_Patient, total_Revenue from examination_revenue  
	union (select ID_Patient, total_Revenue from med_revenue) 
	union (select ID_Patient, total_Revenue from service_revenue)) as  revenue;


