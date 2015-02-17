create table app_Equipment (
	equipmentId LONG not null primary key,
	modification VARCHAR(75) null,
	price LONG,
	tankId LONG
);

create table app_Tank (
	tankId LONG not null primary key,
	number_ VARCHAR(75) null,
	modification VARCHAR(75) null,
	price LONG
);