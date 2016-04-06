insert into author(id, firstName, lastName, email, username, password) values(1, 'Nicolas', 'Quartier', 'nicolasquartier@msn.com', 'nicolasq', 'password');

insert into blog(id, author_id, title, creationDate) values(1, 1, 'My First Blog', '2016-04-01 10:30:00');

insert into blogPost(id, blog_id, title, content, creationDate, updatedDate) values(1, 1, 'My First Blog', 'My First Blog content',  '2016-04-01 10:30:00',  '2016-04-01 10:30:01');

insert into comment(id, blogPost_id, content, creationDate, authorName) values(1, 1, 'This is my first comment',  '2016-04-01 10:30:05', 'Nicolas as a comment author');

