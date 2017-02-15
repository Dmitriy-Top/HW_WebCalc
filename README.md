# HW_WebCalc
<p>Требования:</p>
<ul>
<li>sdk 8</li>
<li>jdk 8</li>
<li>wildfly 10</li>
<li>postgres 9.6</li>
</ul>
<br>
<p>Порядок развертывания:</p>
<ol>
<li>Установить postgresSQL 9.6</li>
<li>Создать, либо использовать скрипт создания (/src/main/initdb/script.txt) базу данных "webcalc" </li>
<li>Ипортировать содержимое БД из дампа БД /src/main/initdb/db</li>
<li>Клонировать репозиторий https://github.com/Dmitriy-Top/HW_WebCalc</li>
<li>в файле /src/main/java/Calculator.java - 62 строка, настроить параметры доступы к бд</li>
<li>Скомплировать и собрать проект из исходников. Версия компилятора 1.8, версия maven 3</li>
<li>Запустить wildfly и задеплоить полученный war-файл</li>
</ol>
