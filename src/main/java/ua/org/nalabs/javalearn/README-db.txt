створити базу даних так щоб була кирилиця (Debian, UTF-8):

CREATE DATABASE IF NOT EXISTS hiber_demo CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

GRANT ALL PRIVILEGES ON hiber_demo.* TO 'andriy'@'%';
FLUSH PRIVILEGES;

перевірити створення таблиці зі всіма параметрами:

show database create clinic;