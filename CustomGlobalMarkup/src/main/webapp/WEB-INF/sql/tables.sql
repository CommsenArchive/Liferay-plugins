create table CGM_Markup (
	id_ LONG not null primary key,
	companyId LONG,
	groupId LONG,
	markup VARCHAR(75) null,
	active_ BOOLEAN,
	location INTEGER
);