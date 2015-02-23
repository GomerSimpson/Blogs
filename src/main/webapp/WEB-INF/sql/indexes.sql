create index IX_AA2DB60F on blog_BlogEntry (companyId);
create index IX_69FA6CD7 on blog_BlogEntry (entryDate);
create index IX_4E7E2CCF on blog_BlogEntry (entryDate, userId, groupId, companyId);
create index IX_187A7451 on blog_BlogEntry (groupId);
create index IX_98E647B3 on blog_BlogEntry (userId);
create index IX_E5AC5171 on blog_BlogEntry (userId, groupId, companyId);