# Проект по автоматизации проверок для сервиса FunPay
[FunPay](https://www.funpay.com) - это сервис по покупке/продаже услуг в сфере компьютерных игр. Разделы сайта поделены на игры и услуги связанные с конкретной игрой.
## :scroll: Содержание:

- [Используемый стек](#computer-используемый-стек)
- [Список тестов проекта](#computer-список-тестов-проекта-funpay)
- [Запуск автотестов](#arrow_forward-запуск-автотестов)
- [Сборка в Jenkins](#-Автоматическая-сборка-в-Jenkins)
- [Пример Allure-отчета](#-пример-allure-отчета)
- [Интеграция с Allure TestOps](#-Обзор-результатов-проекта-с-Allure-TestOps)
- [Интеграция с Jira](#-Jira-выведение-результатов-в-таски)
- [Уведомления в Telegram](#-Telegram--отчётность-при-помощи-бота)
- [Видео примера запуска тестов в Selenoid](#-Selenoid-:-Видео-прохождения-теста-в-отчете)

## :computer: Используемый стек

<p align="center">
<img width="8%" title="Java" src="mediaReadme/logo/Java.svg">
<img width="8%" title="Selenide" src="mediaReadme/logo/Selenide.svg">
<img width="8%" title="Selenoid" src="mediaReadme/logo/Selenoid.svg">
<img width="8%" title="Allure Report" src="mediaReadme/logo/Allure_Report.svg">
<img width="8%" title="Allure TestOps" src="mediaReadme/logo/AllureTestOps.svg">
<img width="8%" title="Gradle" src="mediaReadme/logo/Gradle.svg">
<img width="8%" title="JUnit5" src="mediaReadme/logo/JUnit5.svg">
<img width="8%" title="GitHub" src="mediaReadme/logo/GitHub.svg">
<img width="8%" title="Jenkins" src="mediaReadme/logo/Jenkins.svg">
<img width="8%" title="Telegram" src="mediaReadme/logo/Telegram.svg">
<img width="8%" title="Jira" src="mediaReadme/logo/Jira.svg">
</p>

- Язык для написания тестов : [Java](https://www.java.com/ru/)
- Фреймвокр тестирования : [Selenide](https://selenide.org/) 
- Фреймворк для модульного тестирования : [Junit5](https://github.com/junit-team/junit5)
- Система автоматической сборки : [Gradle](https://github.com/gradle) 
- Для использования различных браузеров в тестировании : [Selenoid](https://aerokube.com/selenoid/).
- Удаленный запуск с выбором параметров для тестов реализован при помощи :  [Jenkins](https://www.jenkins.io/)
- Отчеты о пройденных тестах формируются при помощи : [Allure](https://github.com/allure-framework)
- Так же отчеты о тестировании отправляются в мессенджер при помощи <code>Telegram</code> бота
- Реализована интеграция  с [Allure TestOps](https://qameta.io/)
- Реализована интеграция с [Jira Software](https://www.atlassian.com/software/jira)

## :computer: Список тестов проекта FunPay
* Проверка наличия на главной странице конкретной игры
* Проверка наличия серверов у игры на главной странице
* Проверка отображения страницы игры после выбора ее в поиске сайта
* Проверка наличия раздела услуг на страницы конкретной игры
* Проверка наличия товаров на странице игры
* Проверка смены валюты на главной странице сайта

## :arrow_forward: Запуск автотестов

### Команда запуска тестов локально в IDE
```
gradle test
```

### Команда запуска тестов в Jenkins
```
gradle clean
${Task}
-Dbrowser=${browser}
-Dversion=${version}
-Dsize=${size}
-Dselenoid=${selenoid}
-DbaseUrl=${baseUrl}
```
При запуске из <code>Jenkins</code> тест будет выполняться удаленно в браузере при помощи <code>Selenide</code>


## <img width="7%" style="vertical-align:middle" title="Jenkins" src="mediaReadme/logo/Jenkins.svg"> Автоматическая сборка в Jenkins

Для запуска сборки необходимо перейти в раздел <code>Build with Parameters</code>, выбрать нужные вам параметры в <code>browser,size,version</code> и нажать кнопку <code>Build</code>.
<p align="center">
<img title="Jenkins Build" src="mediaReadme/screens/JenkinsBuild.png">
</p>
В блоке <code>Build History</code> после завершения сборки в поле с номером сборки появятся значки <code>Allure Report</code> и <code>Allure TestOps</code>, кликнув на них можно перейти в отчетность.

## <img width="7%" style="vertical-align:middle" title="Allure Report" src="mediaReadme/logo/Allure_Report.svg"> Пример Allure-отчета
### Overview

<p align="center">
<img title="Allure Overview" src="mediaReadme/screens/AllureReport.png">
</p>

## <img width="7%" style="vertical-align:middle" title="Allure TestOps" src="mediaReadme/logo/AllureTestOps.svg"> Обзор результатов проекта с Allure TestOps

На *Dashboard* в <code>TestOps</code> видна статистика тестов в общем : 
* Сколько прошли успешно
* Сколько автоматизированы
* Сколько активны и не нуждаются в доработке
* Динамика успешности прохождения в течении времени

<p align="center">
<img title="Allure TestOps DashBoard" src="mediaReadme/screens/TestOpsDashboard.png">
</p>

### Результат выполнения автотеста

В разделе *Test cases* уже можно детально посмотреть каждый кейс, там будут расписаны шаги и результаты. Так же в этом разделе можно добавить новые кейслы на проверку или оставить комментарии уже существующим для доработки.

<p align="center">
<img title="Test Results in Alure TestOps" src="mediaReadme/screens/TestOpsSteps.png">
</p>

## <img width="7%" style="vertical-align:middle" title="Jira" src="mediaReadme/logo/Jira.svg"> Jira: выведение результатов в таски

При помощи интеграции <code>Allure TestOps</code> и <code>Jira</code>, в таску можно отобразить существующие в проекте тест-кейсы и результаты их запуска.

<p align="center">
<img title="Jira Task" src="mediaReadme/screens/JiraTask.png">
</p>

### <img width="7%" style="vertical-align:middle" title="Telegram" src="mediaReadme/logo/Telegram.svg"> Telegram : отчётность при помощи бота

После выполнения тестов созданный в <code>Telegram</code> bot собирает данные с <code>AllureReports</code> и отправляет их сообщение в нужный вам чат.

<p align="center">
<img width="70%" title="Telegram Notifications" src="mediaReadme/screens/TelegramAllure.png">
</p>

### <img width="7%" style="vertical-align:middle" title="Selenoid" src="mediaReadme/logo/Selenoid.svg"> Selenoid : Видео прохождения теста в отчете

При интеграции с <code>AllureReports</code> вместе с общим результатом тест-кейса прикладываются media файлы : скриншот и видео. Вот пример видео в отчете о завершенном тесте: 
<p align="center">
  <img title="Selenoid Browser Video" src="mediaReadme/gif/testGIF.gif">
</p>
