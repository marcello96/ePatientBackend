-- password is always the same as username
insert into USERS (ID, USERNAME, PASSWORD, ROLE)
   values (1, 'house123', '$2a$11$E4e0P4PaZ1hsm9bSTFKLhunHqv7HWUCiDcuCF1YnE2GdSnRY7n65G', 'DOCTOR');

insert into DOCTORS (ID, FIRSTNAME, LASTNAME)
   values (1, 'Gregory', 'House');

insert into USERS (ID, USERNAME, PASSWORD, ROLE)
   values (2, 'maja123', '$2a$11$vkPUtudigcs92LzfybXhSOO4WyXRm4B4UFFFLwpMWjU8OYf.YLdxu', 'PATIENT');

insert into PATIENTS (ID, FIRSTNAME, LASTNAME, AGE)
   values (2, 'Maja', 'Bolesna', 55);

insert into USERS (ID, USERNAME, PASSWORD, ROLE)
   values (3, 'max123', '$2a$11$70Z.CTz4Qa3TnGsP3dph8OqcF9C3llBeboHYA1DMnYZRyEQLz77ue', 'PATIENT');

insert into PATIENTS (ID, FIRSTNAME, LASTNAME, AGE)
   values (3, 'Max', 'Trepchenko', 22);

insert into USERS (ID, USERNAME, PASSWORD, ROLE)
   values (4, 'jack123', '$2a$11$7BLwWp16a4U2pcTsx5NgQu17VfyQ.O6nLlSYQy6r0WWkR/yH4XyuK', 'PATIENT');

insert into PATIENTS (ID, FIRSTNAME, LASTNAME, AGE)
   values (4, 'Jack', 'Kowalski', 46);


insert into HEART_RATE_HISTORY (ID, MEASUREMENT_TIME, VALUE, PATIENT_ID)
   values (1, '2019-06-25 18:10:00', 78, 3);

insert into HEART_RATE_HISTORY (ID, MEASUREMENT_TIME, VALUE, PATIENT_ID)
   values (2, '2019-06-25 18:11:00', 88, 3);

insert into HEART_RATE_HISTORY (ID, MEASUREMENT_TIME, VALUE, PATIENT_ID)
   values (3, '2019-06-25 18:12:00', 70, 3);

insert into HEART_RATE_HISTORY (ID, MEASUREMENT_TIME, VALUE, PATIENT_ID)
   values (4, '2019-06-25 18:13:00', 77, 3);

insert into HEART_RATE_HISTORY (ID, MEASUREMENT_TIME, VALUE, PATIENT_ID)
   values (5, '2019-06-25 18:14:00', 75, 3);

insert into HEART_RATE_HISTORY (ID, MEASUREMENT_TIME, VALUE, PATIENT_ID)
   values (6, '2019-06-25 18:15:00', 78, 3);

insert into HEART_RATE_HISTORY (ID, MEASUREMENT_TIME, VALUE, PATIENT_ID)
   values (7, '2019-06-25 18:16:00', 99, 3);

insert into HEART_RATE_HISTORY (ID, MEASUREMENT_TIME, VALUE, PATIENT_ID)
   values (8, '2019-06-25 18:17:00', 78, 3);

insert into HEART_RATE_HISTORY (ID, MEASUREMENT_TIME, VALUE, PATIENT_ID)
   values (9, '2019-06-25 18:18:00', 78, 3);

insert into HEART_RATE_HISTORY (ID, MEASUREMENT_TIME, VALUE, PATIENT_ID)
   values (10, '2019-06-25 18:15:00', 78, 4);

insert into HEART_RATE_HISTORY (ID, MEASUREMENT_TIME, VALUE, PATIENT_ID)
   values (11, '2019-06-25 18:16:00', 99, 4);

insert into HEART_RATE_HISTORY (ID, MEASUREMENT_TIME, VALUE, PATIENT_ID)
   values (12, '2019-06-25 18:17:00', 78, 4);

insert into HEART_RATE_HISTORY (ID, MEASUREMENT_TIME, VALUE, PATIENT_ID)
   values (13, '2019-06-25 18:18:00', 78, 4);

insert into HEART_RATE_HISTORY (ID, MEASUREMENT_TIME, VALUE, PATIENT_ID)
   values (14, '2019-06-25 18:15:00', 78, 2);

insert into HEART_RATE_HISTORY (ID, MEASUREMENT_TIME, VALUE, PATIENT_ID)
   values (15, '2019-06-25 18:16:00', 99, 2);

insert into HEART_RATE_HISTORY (ID, MEASUREMENT_TIME, VALUE, PATIENT_ID)
   values (16, '2019-06-25 18:17:00', 78, 2);

insert into HEART_RATE_HISTORY (ID, MEASUREMENT_TIME, VALUE, PATIENT_ID)
   values (17, '2019-06-25 18:18:00', 78, 2);

alter sequence HR_SEQ restart with 18;

alter sequence USERS_SEQ restart with 5;