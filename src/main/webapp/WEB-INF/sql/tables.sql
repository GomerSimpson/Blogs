create table blog_BlogEntry (
	entryId LONG not null primary key,
	userId LONG,
	groupId LONG,
	companyId LONG,
	entryText VARCHAR(10000) null,
	entryDate DATE null
);