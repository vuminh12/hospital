create database HospitalManagement;
use `HospitalManagement`;
create table `doctor`(
	ID_Doctor varchar(10),
	Identity_Number varchar(20) not null unique,
    Name_Doctor varchar(50) not null,
    DOB date not null,
    Address varchar(255) not null,
	Exp int not null,
    Diploma varchar(20) not null,
    Field varchar(50) not null,
	Position varchar(20) not null,

    primary key(ID_Doctor)
);
create table `nurse`(
	ID_Nurse varchar(10),
	Identity_Number varchar(20) not null unique,
    Name_Nurse varchar(50) not null,
    DOB date not null,
    Address varchar(255) not null,
	Exp int not null,
    Diploma varchar(20) not null,
    Phone varchar(20) not null,
    primary key(ID_Nurse)
);

create table `patient`(
	ID_Patient varchar(10),
	Identity_Number varchar(20) not null unique,
    Name_Patient varchar(50) not null,
    DOB date not null,
    Address varchar(255) not null,
    Phone varchar(20) not null,
    
    primary key(ID_Patient)
);


create table `examination`(
	ID_Examination int AUTO_INCREMENT,	
	ID_Doctor_Examination varchar(10) not null,
    ID_Patient varchar(10) not null,
    At_Time datetime not null,
    
    primary key(ID_Examination,ID_Doctor_Examination,ID_Patient),
    
	foreign key(ID_Doctor_Examination) references `doctor`(ID_Doctor),
	foreign key(ID_Patient) references `patient`(ID_Patient)
);
create table `disease_Examine`(
	ID_Examination int not null,
    ID_Doctor_Examination varchar(10) not null,
    ID_Patient varchar(10) not null,
    Name_Disease varchar(50),
    primary key(ID_Examination,ID_Doctor_Examination,ID_Patient,Name_Disease),
    foreign key(ID_Examination,ID_Doctor_Examination,ID_Patient) references `examination`(ID_Examination,ID_Doctor_Examination,ID_Patient)
);
create table `treatment`(
    ID_Treatment int auto_increment,
	ID_Examination int not null,	
	Name_Disease varchar(50) not null,
	ID_Doctor_Examination varchar(10) not null,
    ID_Doctor_Cure varchar(10) not null,
    ID_Patient varchar(10) not null,
    ID_Nurse varchar(10) not null,
    AtTime datetime not null,
    Status bool not null,
    
    primary key(ID_Treatment,ID_Examination,Name_Disease,ID_Doctor_Examination,ID_Doctor_Cure,ID_Patient,ID_Nurse),

	foreign key(ID_Doctor_Cure) references `doctor`(ID_Doctor),
    foreign key(ID_Nurse) references `nurse`(ID_Nurse),
	foreign key(ID_Examination,ID_Doctor_Examination,ID_Patient,Name_Disease) references `disease_Examine`(ID_Examination,ID_Doctor_Examination,ID_Patient,Name_Disease)

);
create table `med`(
	Name_Med varchar(50) ,
    Price float not null,
    Used_For varchar(50) not null,
    primary key(Name_Med)
);
create table `medlist`(
    Name_Med varchar(50),
    ID_Treatment int,
	ID_Examination int ,	
	Name_Disease varchar(50) ,
	ID_Doctor_Examination varchar(10) ,
    ID_Doctor_Cure varchar(10) ,
    ID_Patient varchar(10) ,
    ID_Nurse varchar(10) ,
    primary key(Name_Med,ID_Treatment,ID_Examination,Name_Disease,ID_Doctor_Examination,ID_Doctor_Cure,ID_Patient,ID_Nurse),
    foreign key(ID_Treatment,ID_Examination,Name_Disease,ID_Doctor_Examination,ID_Doctor_Cure,ID_Patient,ID_Nurse) references `treatment`(ID_Treatment,ID_Examination,Name_Disease,ID_Doctor_Examination,ID_Doctor_Cure,ID_Patient,ID_Nurse),
    foreign key(Name_Med) references `med`(Name_Med)

);
create table `service`(
	Name_Service varchar(50),
    Price float not null ,
    primary key(Name_Service)
);

create table `servicelist`(
    Name_Service varchar(50),
	ID_Treatment int,
	ID_Examination int ,	
	Name_Disease varchar(50) ,
	ID_Doctor_Examination varchar(10) ,
    ID_Doctor_Cure varchar(10) ,
    ID_Patient varchar(10) ,
    ID_Nurse varchar(10) ,
    primary key(Name_Service,ID_Treatment,ID_Examination,Name_Disease,ID_Doctor_Examination,ID_Doctor_Cure,ID_Patient,ID_Nurse),
    foreign key(ID_Treatment,ID_Examination,Name_Disease,ID_Doctor_Examination,ID_Doctor_Cure,ID_Patient,ID_Nurse) references `treatment`(ID_Treatment,ID_Examination,Name_Disease,ID_Doctor_Examination,ID_Doctor_Cure,ID_Patient,ID_Nurse),
    foreign key(Name_Service) references `service`(Name_Service)
);

#drop database HospitalManagement;
