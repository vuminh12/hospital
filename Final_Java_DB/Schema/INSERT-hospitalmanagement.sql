
use HospitalManagement;

#doctor
insert into doctor value('BS01', 'Identity_Number01_BS', 'Ninh Xuan Huan', '1998-05-20','Ha Noi',5,'DaiHoc','Than Kinh','Bac Si');
insert into doctor value('BS02', 'Identity_Number02_BS', 'Nguyen HaiPhuong', '1994-07-31','Ha Noi',10,'DaiHoc','Tim','Truong Khoa');
insert into doctor value('BS03', 'Identity_Number03_BS', 'Bui Thi Thu Huong', '1994-12-31','Ha Noi',15,'DaiHoc','Phoi','Truong Phong');
insert into doctor value('BS04', 'Identity_Number04-BS', 'Nguyen Si Dinh', '1996-05-20','Ha Noi',4,'DaiHoc','Than Kinh','Bac Si');
insert into doctor value('BS05', 'Identity_Number05-BS', 'Vu Manh Cuong', '1996-07-31','Ha Noi',7,'DaiHoc','Tim','Truong Phong');
insert into doctor value('BS06', 'Identity_Number06-BS', 'Nguyen Huong Giang', '1991-12-31','Ha Noi',15,'DaiHoc','Phoi','Truong Khoa');
insert into doctor value('BS07', 'Identity_Number07-BS', 'Nguyen Duc Truong', '1994-05-20','Ha Noi',5,'DaiHoc','Than Kinh','Truong Khoa');
insert into doctor value('BS08', 'Identity_Number08-BS', 'Trinh Van Dai', '1999-07-31','Ha Noi',10,'DaiHoc','Tim','Bac Si');
insert into doctor value('BS09', 'Identity_Number09-BS', 'Nguyen Hong Thom', '1996-12-31','Ha Noi',15,'DaiHoc','Phoi','Bac Si');
insert into doctor value('BS10', 'Identity_Number10-BS', 'Le Duc Nam', '1998-12-31','Ha Noi',15,'DaiHoc','Tim','Bac Si');
#patient
insert into patient value('BN01', 'Identity_Number11_BN', 'Pham Phuong Nam ', '1997-12-31','Ha Noi','123456789');
insert into patient value('BN02', 'Identity_Number12_BN', 'Nguyen Dang Trua', '1999-12-31','Ha Noi','123456787');
insert into patient value('BN03', 'Identity_Number13_BN', 'Do Tien Dat', '1998-12-31','Ha Noi','123456788');
insert into patient value('BN04', 'Identity_Number14_BN', 'Tran Thanh Binh', '1996-12-31','Ha Noi','123456789');
insert into patient value('BN05', 'Identity_Number15_BN', 'Tran Van Phuong', '1998-12-31','Ha Noi','123456787');
insert into patient value('BN06', 'Identity_Number16_BN', 'Le Minh Tien', '1997-12-31','Ha Noi','123456788');
insert into patient value('BN07', 'Identity_Number17_BN', 'Vu Ngoc Sang', '1998-12-31','Ha Noi','123456789');
insert into patient value('BN08', 'Identity_Number18_BN', 'Tran Thu Nguyet', '1998-12-31','Ha Noi','123456787');
insert into patient value('BN09', 'Identity_Number19_BN', 'Pham The Duy', '1998-12-31','Ha Noi','123456788');
insert into patient value('BN10', 'Identity_Number20_BN', 'Nguyen Duc Hieu', '1998-12-31','Ha Noi','123456788');

#examination
insert into examination(ID_Doctor_Examination,ID_Patient,At_Time) value('BS01', 'BN01', '2020-07-31');
insert into examination(ID_Doctor_Examination,ID_Patient,At_Time) value('BS01', 'BN02', '2020-07-03');
insert into examination(ID_Doctor_Examination,ID_Patient,At_Time) value('BS02', 'BN03', '2020-07-31');
insert into examination(ID_Doctor_Examination,ID_Patient,At_Time) value('BS02', 'BN04', '2020-07-03');
insert into examination(ID_Doctor_Examination,ID_Patient,At_Time) value('BS03', 'BN05', '2020-07-31');
insert into examination(ID_Doctor_Examination,ID_Patient,At_Time) value('BS03', 'BN06', '2020-07-03');
insert into examination(ID_Doctor_Examination,ID_Patient,At_Time) value('BS04', 'BN07', '2020-07-31');
insert into examination(ID_Doctor_Examination,ID_Patient,At_Time) value('BS04', 'BN08', '2020-07-03');
insert into examination(ID_Doctor_Examination,ID_Patient,At_Time) value('BS01', 'BN01', '2020-07-05');
insert into examination(ID_Doctor_Examination,ID_Patient,At_Time) value('BS05', 'BN09', '2020-06-05');
insert into examination(ID_Doctor_Examination,ID_Patient,At_Time) value('BS05', 'BN05', '2020-05-05');
insert into examination(ID_Doctor_Examination,ID_Patient,At_Time) value('BS06', 'BN10', '2020-04-05');
insert into examination(ID_Doctor_Examination,ID_Patient,At_Time) value('BS04', 'BN04', '2020-06-15');
insert into examination(ID_Doctor_Examination,ID_Patient,At_Time) value('BS02', 'BN10', '2020-06-05');



#disease_Examine
insert into disease_Examine value(1, 'BS01','BN01','Tam than phan liet');
insert into disease_Examine value(1, 'BS01','BN01','Tim');
insert into disease_Examine value(2, 'BS01','BN02','Soi than');
insert into disease_Examine value(3, 'BS02','BN03','Tieu duong');
insert into disease_Examine value(4, 'BS02','BN04','Roi loan tien dinh'); 
insert into disease_Examine value(5, 'BS03','BN05','Roi loan tien dinh'); 


#nurse
insert into nurse(ID_Nurse, Identity_Number, Name_Nurse, DOB, Address, Exp, Diploma, Phone) values ("YT01","Identity_Number21_YT","Vu Van Minh","1993-09-01","Dong Da","3","Dai Hoc","0983000000");
insert into nurse(ID_Nurse, Identity_Number, Name_Nurse, DOB, Address, Exp, Diploma, Phone) values ("YT02","Identity_Number22_YT","Nghiem Tuan Anh","1993-09-01","Hoan Kiem","5","Dai Hoc","0983000000");
insert into nurse(ID_Nurse, Identity_Number, Name_Nurse, DOB, Address, Exp, Diploma, Phone) values ("YT03","Identity_Number23_YT","Ha Van Chieu","1993-09-01","Ha Cau","7","Dai Hoc","0983000000");
insert into nurse(ID_Nurse, Identity_Number, Name_Nurse, DOB, Address, Exp, Diploma, Phone) values ("YT04","Identity_Number24_YT","Do Toan Thang","1993-09-01","Thanh Xuan","4","Dai Hoc","0983000000");
insert into nurse(ID_Nurse, Identity_Number, Name_Nurse, DOB, Address, Exp, Diploma, Phone) values ("YT05","Identity_Number25_YT","Luu Hai Son","1993-09-01","Van Khe","2","Dai Hoc","0983000000");
insert into nurse(ID_Nurse, Identity_Number, Name_Nurse, DOB, Address, Exp, Diploma, Phone) values ("YT06","Identity_Number26_YT","Vuong Dinh Bac","1993-09-01","Dong Da","2","Dai Hoc","0983000000");
insert into nurse(ID_Nurse, Identity_Number, Name_Nurse, DOB, Address, Exp, Diploma, Phone) values ("YT07","Identity_Number27_YT","Hoang Van Giap","1993-09-01","Hanoi","6","Dai Hoc","0983000000");
insert into nurse(ID_Nurse, Identity_Number, Name_Nurse, DOB, Address, Exp, Diploma, Phone) values ("YT08","Identity_Number28_YT","Duong Tuan Anh","1993-09-01","Van Khe","2","Dai Hoc","0983000000");
insert into nurse(ID_Nurse, Identity_Number, Name_Nurse, DOB, Address, Exp, Diploma, Phone) values ("YT09","Identity_Number29_YT","Hoang The Nam","1993-09-01","Dong Da","2","Dai Hoc","0983000000");
insert into nurse(ID_Nurse, Identity_Number, Name_Nurse, DOB, Address, Exp, Diploma, Phone) values ("YT10","Identity_Number30_YT","Hoang Anh Tu","1993-09-01","Hanoi","6","Dai Hoc","0983000000");
#med
insert into med values('ACB',12000,'uong');
insert into med values('DEF',15000,'uong');
insert into med values('GHI',17000,'tiem');
insert into med values('KLM',11000,'tiem');
#treatment
insert into treatment(ID_Examination,Name_Disease,ID_Doctor_Examination,ID_Doctor_Cure,ID_Patient,ID_Nurse,AtTime,Status) value(1,'Tam than phan liet','BS01','BS02','BN01','YT01','2020-08-12',0);
insert into treatment(ID_Examination,Name_Disease,ID_Doctor_Examination,ID_Doctor_Cure,ID_Patient,ID_Nurse,AtTime,Status) value(1,'Tam than phan liet','BS01','BS02','BN01','YT01','2020-08-12',0);
insert into treatment(ID_Examination,Name_Disease,ID_Doctor_Examination,ID_Doctor_Cure,ID_Patient,ID_Nurse,AtTime,Status) value(1,'Tam than phan liet','BS01','BS02','BN01','YT01','2020-08-12',1);
insert into treatment(ID_Examination,Name_Disease,ID_Doctor_Examination,ID_Doctor_Cure,ID_Patient,ID_Nurse,AtTime,Status) value(1,'Tim','BS01','BS03','BN01','YT03','2020-08-12',1);
insert into treatment(ID_Examination,Name_Disease,ID_Doctor_Examination,ID_Doctor_Cure,ID_Patient,ID_Nurse,AtTime,Status) value(3,'Tieu Duong','BS02','BS02','BN03','YT03','2020-08-12',1);
#medlist
insert into medlist(Name_Med,ID_Treatment,ID_Examination,Name_Disease,ID_Doctor_Examination,ID_Doctor_Cure,ID_Patient,ID_Nurse) values('ACB',1,1,'Tam than phan liet','BS01','BS02','BN01','YT01');
insert into medlist(Name_Med,ID_Treatment,ID_Examination,Name_Disease,ID_Doctor_Examination,ID_Doctor_Cure,ID_Patient,ID_Nurse) values('DEF',1,1,'Tam than phan liet','BS01','BS02','BN01','YT01');
insert into medlist(Name_Med,ID_Treatment,ID_Examination,Name_Disease,ID_Doctor_Examination,ID_Doctor_Cure,ID_Patient,ID_Nurse) values('GHI',2,1,'Tam than phan liet','BS01','BS02','BN01','YT01');
insert into medlist(Name_Med,ID_Treatment,ID_Examination,Name_Disease,ID_Doctor_Examination,ID_Doctor_Cure,ID_Patient,ID_Nurse) values('KLM',2,1,'Tam than phan liet','BS01','BS02','BN01','YT01');
#service
insert into service values('Chup X quang',120000);
insert into service values('Xet nghiem mau',150000);
#servicelist
insert into servicelist(Name_Service,ID_Treatment,ID_Examination,Name_Disease,ID_Doctor_Examination,ID_Doctor_Cure,ID_Patient,ID_Nurse) values('Chup X quang',1,1,'Tam than phan liet','BS01','BS02','BN01','YT01');
insert into servicelist(Name_Service,ID_Treatment,ID_Examination,Name_Disease,ID_Doctor_Examination,ID_Doctor_Cure,ID_Patient,ID_Nurse) values('Xet nghiem mau',1,1,'Tam than phan liet','BS01','BS02','BN01','YT01');


