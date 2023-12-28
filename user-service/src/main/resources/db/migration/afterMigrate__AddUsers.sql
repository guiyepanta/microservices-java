INSERT INTO user_service.user(id, full_name, date_of_birth, last_login)
VALUES (1, 'Guillermo Pantanetti', '1978-11-25', NOW())
ON CONFLICT DO NOTHING;

INSERT INTO user_service.user(id, full_name, date_of_birth, last_login)
VALUES (2, 'Otro Usuario', '1978-01-01', NOW())
ON CONFLICT DO NOTHING;

INSERT INTO user_service.address(id, first_line, second_line, country, post_code, user_id,
                                 is_default)
VALUES (1, 'Domicilio de usuario #1', 'referencia de domicilio', 'Argentina', '11111', 1, true)
ON CONFLICT DO NOTHING;

INSERT INTO user_service.address(id, first_line, second_line, country, post_code, user_id,
                                 is_default)
VALUES (2, 'Domicilio de usuario #2', 'referencia de domicilio', 'Argentina', '11111', 1, false)
ON CONFLICT DO NOTHING;