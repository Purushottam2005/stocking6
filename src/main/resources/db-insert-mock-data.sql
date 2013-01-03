insert into category(name, description) values ("Books", "Literature books");
insert into category(name, description) values ("Sports", "Sporting equipment");
insert into category(name, description) values ("Games", "Adventure games");

insert into item (name, description, category_id) values ("Harry potter", "Good fiction", 1);
insert into item (name, description, category_id) values ("Game of Thrones", "Nice fiction", 1);
insert into item (name, description, category_id) values ("Neuromancer", "Sci-Fi", 1);
insert into item (name, description, category_id) values ("The girl with a dragon tattoo", "Best-seller #1", 1);
insert into item (name, description, category_id) values ("Kindle reviews", "Advertising for Amazon", 1);
insert into item (name, description, category_id) values ("I, robot", "You really should read", 1);
insert into item (name, description, category_id) values ("You", "By me", 1);

insert into item (name, description, category_id) values ("Baseball bat", "Baseball stylish bat", 2);
insert into item (name, description, category_id) values ("Shorts", "Clothing for man", 2);
insert into item (name, description, category_id) values ("Dry Fit shirt", "Clothing for women", 2);
insert into item (name, description, category_id) values ("Sunglasses", "Accessory for eyes", 2);

insert into item (name, description, category_id) values ("Call of duty", "Shooter, military", 3);
insert into item (name, description, category_id) values ("Zelda", "RPG medieval", 3);
insert into item (name, description, category_id) values ("Chrono Cross", "RPG game", 3);
insert into item (name, description, category_id) values ("Street Fighter", "Fight genre game", 3);
insert into item (name, description, category_id) values ("Broken Sword", "Point and click game", 3);

insert into user (name, password) values ('admin', 'admin');