create table blog_BlogEntry (
	entryId LONG not null primary key,
	userId LONG,
	groupId LONG,
	companyId LONG,
	title VARCHAR(75) null,
	entryText VARCHAR(75) null,
	entryDate DATE null
);