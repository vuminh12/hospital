use `HospitalManagement`;

#Trigger cho rang buoc *Mot benh nhan chi duoc dieu tri duy nhat boi 1 y ta trong 1 qua trinh dieu tri*
DELIMITER //
Create Trigger checkNursetreatment before INSERT on treatment FOR EACH ROW
		BEGIN
		DECLARE inputID_Nurse varchar(10);
		SET inputID_Nurse :='';
        
        SELECT distinct ID_Nurse into inputID_Nurse
        FROM treatment
        where  ID_Examination = new.ID_Examination and  Name_Disease = new.Name_Disease and ID_Patient = new.ID_Patient ;
        
        IF new.ID_Nurse != inputID_Nurse and inputID_Nurse != '' then begin signal sqlstate '45000' set message_text ='*A patient has to stick to ONLY ONE NURSE during the treatment process* OR *Re-check (ID_Examination,Name_Disease,ID_Patient)*';
        end;
        end if;
end//

#Trigger cho rang buoc *Mot benh nhan chi duoc dieu tri duy nhat boi 1 bac si trong 1 qua trinh dieu tri*
DELIMITER //
Create Trigger checkDoctortreatment before INSERT on treatment FOR EACH ROW
		BEGIN
		DECLARE inputID_Doctor varchar(10);
		SET inputID_Doctor :='';
        
        SELECT distinct ID_Doctor_Cure into inputID_Doctor
        FROM treatment
        where  ID_Examination = new.ID_Examination and  Name_Disease = new.Name_Disease and ID_Patient = new.ID_Patient ;
        
        IF new.ID_Doctor_Cure != inputID_Doctor and inputID_Doctor != '' then begin signal sqlstate '45001' set message_text ='*A patient has to stick to ONLY ONE DOCTOR during the treatment process* HOAC *Re-check (ID_Examination,Name_Disease,ID_Patient)*';
        end;
        end if;
end//
#drop trigger kiemTraBStreatment;

#Trigger cho rang buoc *Mot benh nhan chi duoc dieu tri duy nhat boi 1 bac si trong 1 qua trinh dieu tri*
DELIMITER //
Create Trigger checkPatienttreatment before INSERT on treatment FOR EACH ROW
		BEGIN
		DECLARE checkStatus bool;
		SET checkStatus := 0;
        
        SELECT Status into checkStatus
        FROM treatment
        where ID_Treatment = ( SELECT MAX(ID_Treatment) FROM treatment where ID_Examination = new.ID_Examination and Name_Disease = new.Name_Disease and ID_Patient = new.ID_Patient);
        
        IF checkStatus = 1  then begin signal sqlstate '45001' set message_text ='This patient is cured => the treatment process is ended';
        end;
        end if;
end//

#Trigger cho rang buoc *Mot benh nhan chi duoc dieu tri duy nhat boi 1 bac si trong 1 qua trinh dieu tri*
DELIMITER //
Create Trigger checkdisease_Examine before INSERT on disease_Examine FOR EACH ROW
		BEGIN
		DECLARE checkStatus bool;
		SET checkStatus := 1;
        
        SELECT Status into checkStatus
        FROM treatment
        where ID_Treatment = ( SELECT MAX(ID_Treatment) FROM treatment where Name_Disease = new.Name_Disease and ID_Patient = new.ID_Patient);
        
        IF checkStatus = 0  then begin signal sqlstate '45001' set message_text ='This patient disease is not cured yet => cannot add into examination record';
        end;
        end if;
end//

#drop trigger kiemTradisease_Examine;

