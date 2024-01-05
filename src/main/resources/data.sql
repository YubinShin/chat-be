-- DELETE FROM user;
DELETE FROM authorities;

INSERT INTO user(user_username, user_password, user_created_at, user_updated_at) VALUES ('test-user', 'test', NOW(), NOW());
INSERT INTO user(user_username, user_password, user_created_at, user_updated_at) VALUES ('test-admin', 'test', NOW(), NOW());

INSERT INTO authorities(authorities_username, authorities_authority) values ("test-user", "USER");
INSERT INTO authorities(authorities_username, authorities_authority) values ("test-admin", "ADMIN");