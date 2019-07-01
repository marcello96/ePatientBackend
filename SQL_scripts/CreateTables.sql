CREATE TABLE HEART_RATE_HISTORY (
    ID int IDENTITY(1,1),
    MiBand_ID varchar(255),
    Heart_Rate_Value int,
    Read_Time varchar(255),
	Created_On datetime,
	Created_By varchar(255),
	Active bit 
);