# Задание №2

* Нужно сгенерировать файл, содержащий 2000 48-битных случайных целых чисел, каждое число на отдельной строке.

* Посчитать, какое суммарное количество простых множителей присутствует при факторизации всех чисел. Например, пусть всего два числа: 6 и 8. 6 = 2 * 3, 8 = 2 * 2 * 2. Ответ 5.

* Реализовать подсчет:
    * простым последовательным алгоритмом
    * многопоточно, с использованием примитивов синхронизации
    * с помощью Akka (или аналога)
    * c помощью RxJava (или аналога)

* Измерить время выполнения для каждого случая. Использовать уровень параллельности в соответствии с числом ядер вашего CPU.

# Результат

* <i>Результаты на 1000</i>
    Simple result: 4456; time: 38154
    4 CompletableFuture result: 4456; time: 27408
    Akka result: 4456; time: 19632
    RxObservable result: 4456; time: 48709

* <i>Результаты на 2000</i>
    Simple result: 9205; time: 63686
    4 CompletableFuture result: 9205; time: 51929
    Akka result: 9205; time: 37842
    RxObservable result: 9205; time: 92043

* <i>Результаты на 4000</i>
    Simple result: 18038; time: 177606
    4 CompletableFuture result: 18038; time: 223414
    Akka result: 18038; time: 109527
    RxObservable result: 18038; time: 385290