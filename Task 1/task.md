# Задание №1

* Нужно написать две программы: Первая генерирует бинарный файл (min 2Гб), состоящий из случайных 32-рязрядных беззнаковых целых чисел (big endian). Вторая считает сумму этих чисел (с применением длинной арифметики), находит минимальное и максимальное число.

* Реализуйте две версии - 1. Простое последовательное чтение (~ 125.2s) 2. Многопоточная + memory-mapped files (~ 71s). Сравните время работы.

# Результат

<i>На моем копьютере результат при последовательном чтении почти в 1.7 раз дольше, чем многопоточный (используя 8 потоков)</i>