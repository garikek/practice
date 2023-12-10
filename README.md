# Практического задание java
Необходимо разработать калькулятор валют, работающий из консоли.
Функционал:
•	Калькулятор должен уметь работать с двумя валютами — доллар и рубль — и позволять выполнять операции сложения и вычитания.
•	Складывать и вычитать можно только значения в одной валюте.
•	Должна быть реализована операция конвертации из одной валюты в другую по курсу, который задается во внешнем файле.
•	Необходимо реализовать поддержку дробных значений.
Замечания:
•	Значение в долларах обозначается символом $, расположенным перед числом (например, $57.75).
•	Значение в рублях — символом "р", расположенным после числа (например, 57.75р).
•	Операция конвертации долларов в рубли — toRuble($57.75), рублей в доллары — toDollar(57.75р).
•	Итоговый результат округлить до сотых.
Пример консольного ввода:
toDollar(1234р + toRuble($56.78))
