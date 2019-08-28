INSERT INTO users (userid, first_name, last_name, username, password) VALUES (1, 'Ad', 'Min', 'Admin', 'Adminus');
INSERT INTO roles (roleid, name) VALUES (1, 'User');
alter sequence hibernate_sequence restart with 25;