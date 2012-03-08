@echo off
cls

if NOT 'ALL'=='%1%' goto CLIENT
cd ../*dao
call mvn clean install
cd ../*service
call mvn clean install
cd ../*controller
call mvn clean install
:CLIENT
cd ../*client
call mvn clean tomcat:run-war