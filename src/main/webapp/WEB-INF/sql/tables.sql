create table blog_BlogEntry (
	entryId LONG not null primary key,
	userId LONG,
	groupId LONG,
	companyId LONG,
	title VARCHAR(50) null,
	entryText VARCHAR(1000) null,
	entryDate DATE null
);