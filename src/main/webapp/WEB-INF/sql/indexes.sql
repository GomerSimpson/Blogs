create index IX_124B9AA6 on app_Equipment (modification);
create index IX_71FED063 on app_Equipment (price);
create index IX_F303186F on app_Equipment (tankId);

create index IX_A46F7A3E on app_Tank (modification);
create unique index IX_DBD17D78 on app_Tank (number_);
create index IX_54B4CBCB on app_Tank (price);