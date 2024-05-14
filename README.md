# Дипломный проект. UI тесты для платформы [TrendRealty](https://msk.trendrealty.ru/)
<img alt="reqres logo" src="images/logo/TR.svg">

##  О платформе
TrendRealty B2C платформа для подбора недвижимости

## Содержание
- <a href="#stack">Стек</a>
- <a href="#testcases">Тест-кейсы</a>
- <a href="#running">Запуск автотестов</a>
- <a href="#report">Отчет Allure</a>
- <a href="#testops">Интеграция с Allure TestOps</a>
- <a href="#jira">Интеграция с Jira</a>
- <a href="#telegram">Нотификация в бот</a>
- <a href="#Selenoid">Пример запуска тестов</a>

<a id="stack"></a>
## Стек
<p  align="center">

<code><img width="5%" title="IntelliJ IDEA" src="images/logo/Idea.svg"></code>
<code><img width="5%" title="Java" src="images/logo/Java.svg"></code>
<code><img width="5%" title="Selenide" src="images/logo/Selenide.svg"></code>
<code><img width="5%" title="Selenoid" src="images/logo/Selenoid.svg"></code>
<code><img width="5%" title="Junit5" src="images/logo/Junit5.svg"></code>
<code><img width="5%" title="Gradle" src="images/logo/Gradle.svg"></code>
<code><img width="5%" title="GitHub" src="images/logo/GitHub.svg"></code>
<code><img width="5%" title="Jenkins" src="images/logo/Jenkins.svg"></code>
<code><img width="5%" title="Allure Report" src="images/logo/Allure.svg"></code>
<code><img width="5%" title="Allure TestOps" src="images/logo/Allure_TO.svg"></code>
<code><img width="5%" title="Jira" src="images/logo/Jira.svg"></code>
<code><img width="5%" title="Telegram" src="images/logo/Telegram.svg"></code>
</p>

Тесты в данном проекте написаны на языке ```Java``` с использованием фреймворка для тестирования ```Selenide```, сборщик - ```Gradle```. ```JUnit 5``` задействован в качестве фреймворка модульного тестирования.
При прогоне тестов для запуска браузеров используется ```Selenoid```.
Для удаленного запуска реализована джоба в <code>Jenkins</code> с формированием Allure-отчета и отправкой результатов в <code>Telegram</code> при помощи бота. Так же реализована интеграция с <code>Allure TestOps</code> и <code>Jira</code>.

<a id="testcases"></a>
## Тест-кейсы
- Добавление в избранное
- Удаление из избранного
- Смена города
- Проверка изменения плейсхолдера при клике
- Проверка открытия карты метро
- Проверка отображения 404 страницы


<a id="running"></a>
## Запуск автотестов из консоли
```
gradle clean owner_tests
```
## <img alt="Jenkins" src="images/logo/Jenkins.svg" width="40" height="40"/>[ Запуск автотестов из Jenkins](https://jenkins.autotests.cloud/job/024_fedyaabro_Diploma_TrendRealty/)
Build with Parameters --> Build, при необходимости можно добавить комментарий или сменить(По умолчанию установлены дефолтные значения):

- Окружение
- Браузер
- Версию браузера
- Размер окна браузера
- Url удаленного запуска

<img title="Jenkins start" src="images/attachment/jenkins_start.png">

## Параметры сборки Jenkins
```
clean owner_tests
-Denvironment=${environment}
-Dbrowser=${browser}
-DbrowserVersion=${browserVersion}
-DbrowserSize=${browserSize}
-DbrowserRemoteUrl=${browserRemoteUrl}
```



<a id="report"></a>
## <img alt="Allure Reports" src="images/logo/Allure.svg" width="40" height="40"/> [Отчеты Allure](https://jenkins.autotests.cloud/job/024_fedyaabro_Diploma_TrendRealty/allure/#)
<img title="Allure" src="images/attachment/allure_behaviors.png"> 
<img title="Allure view" src="images/attachment/allure_overview.png"> 
<img title="Allure suites" src="images/attachment/allure_suites.png"> 

<a id="testops"></a>
## <img alt="Allure TestOps" src="images/logo/Allure_TO.svg" width="40" height="40"/> [Интеграция с Allure TestOps](https://allure.autotests.cloud/project/4216/dashboards)
<img title="TestOps l" src="images/attachment/allure_to_launches.png"> 
<img title="TestOps c" src="images/attachment/allure_to_cases.png"> 

<a id="jira"></a>
## <img alt="Jira" src="images/logo/Jira.svg" width="40" height="40"/> [Интеграция с Jira](https://jira.autotests.cloud/browse/HOMEWORK-1213)
<img title="Jira" src="images/attachment/jira.png"> 

<a id="telegram"></a>
## <img alt="Telegram" src="images/logo/Telegram.svg" width="40" height="40"/>Нотификация в бот 
<img title="Telegram" src="images/attachment/tg.png">

## Пример запуска теста
<a id="Selenoid"></a>
<img title="Selenoid" src="images/attachment/selenoid.gif"> 

