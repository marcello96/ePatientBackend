insert into PATIENT (ID, USERNAME)
   values (1, 'admin');

insert into HEART_RATE_HISTORY (ID, MEASUREMENT_TIME, VALUE, PATIENT_ID)
   values (1, '2019-06-25 18:10:00', 78, 1);

insert into HEART_RATE_HISTORY (ID, MEASUREMENT_TIME, VALUE, PATIENT_ID)
   values (2, '2019-06-25 18:11:00', 88, 1);

insert into HEART_RATE_HISTORY (ID, MEASUREMENT_TIME, VALUE, PATIENT_ID)
   values (3, '2019-06-25 18:12:00', 70, 1);

insert into HEART_RATE_HISTORY (ID, MEASUREMENT_TIME, VALUE, PATIENT_ID)
   values (4, '2019-06-25 18:13:00', 77, 1);

insert into HEART_RATE_HISTORY (ID, MEASUREMENT_TIME, VALUE, PATIENT_ID)
   values (5, '2019-06-25 18:14:00', 75, 1);

insert into HEART_RATE_HISTORY (ID, MEASUREMENT_TIME, VALUE, PATIENT_ID)
   values (6, '2019-06-25 18:15:00', 78, 1);

insert into HEART_RATE_HISTORY (ID, MEASUREMENT_TIME, VALUE, PATIENT_ID)
   values (7, '2019-06-25 18:16:00', 99, 1);

insert into HEART_RATE_HISTORY (ID, MEASUREMENT_TIME, VALUE, PATIENT_ID)
   values (8, '2019-06-25 18:17:00', 78, 1);

insert into HEART_RATE_HISTORY (ID, MEASUREMENT_TIME, VALUE, PATIENT_ID)
   values (9, '2019-06-25 18:18:00', 78, 1);

alter sequence HIBERNATE_SEQUENCE restart with 10