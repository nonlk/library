INSERT INTO books
VALUES(1, 'Маленькие женщины', 'Л.М. Олкотт', 32) ON CONFLICT DO NOTHING;
INSERT INTO books
VALUES(2, 'Маленький принц', 'А. Де Сент-Экзюпери', 13) ON CONFLICT DO NOTHING;
INSERT INTO books
VALUES(3, 'Смерть Ивана Ильича', 'Л.Н. Толстой', 21) ON CONFLICT DO NOTHING;
INSERT INTO books
VALUES(4, 'Мертвые души', 'Н.В. Гоголь', 45) ON CONFLICT DO NOTHING;
INSERT INTO books
VALUES(5, 'Кому на руси жить хорошо', 'Н.А. Некрасов', 18) ON CONFLICT DO NOTHING;



