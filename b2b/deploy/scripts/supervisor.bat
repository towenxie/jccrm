@echo off
color 1f
title ���ڼ��Tomcat

set yy=%date:~0,4%  
set mm=%date:~5,2%  
set dd=%date:~8,2%
set tdate=%yy%%mm%%dd%
set filename=%tdate%
set filename=%filename: =%

echo ���ڼ��Tomcat_8080...
echo ���ڼ��Tomcat_8080...>>C:\logs\%filename%_Tomcat_8080.log

:loop
set "httpcode="
cd /d D:\softwares\curl\I386
for /f "delims=" %%r in ('curl.exe -sL -w "%%{http_code}" "http://127.0.0.1:8080/" -o nul') do (
  set httpcode=%%r
)
echo %httpcode%
if not "%httpcode%"=="200" (
	echo ��%date% %time:~0,5% �޷��������ʣ�������...
	echo ��%date% %time:~0,5% �޷��������ʣ�������...>>C:\logs\%filename%_Tomcat_8080.log
	taskkill /F /FI  "WINDOWTITLE eq Tomcat"
	rem ping -n 3 127.0.0.1>nul
	set CATALINA_HOME=D:\softwares\apache-tomcat-8.0.36
	set EXECUTABLE=%CATALINA_HOME%\bin\catalina.bat
	rem call "%EXECUTABLE%" start && exit
	call "%EXECUTABLE%" start
) else (
	echo ��%date% %time:~0,5% �����ɹ�
	echo ���ڼ��Tomcat_8080...
	echo ��%date% %time:~0,5% �����ɹ�>>C:\logs\%filename%_Tomcat_8080.log
	echo ���ڼ��Tomcat_8080...>>C:\logs\%filename%_Tomcat_8080.log
)
ping -n 60 127.0.0.1>nul

rem sleep 60
goto loop
