@echo off
color 1f
title 正在监控Tomcat_8080

set yy=%date:~0,4%  
set mm=%date:~5,2%  
set dd=%date:~8,2%
set tdate=%yy%%mm%%dd%  
set filename=%tdate%
set filename=%filename: =%

echo 正在监控Tomcat_8080...
echo 正在监控Tomcat_8080...>>C:\%filename%_Tomcat_8080.log

:loop
set "httpcode="
cd /d D:\Myworks\curl\I386
for /f "delims=" %%r in ('curl.exe -sL -w "%%{http_code}" "http://127.0.0.1:8080/" -o nul') do (
  set httpcode=%%r
)
echo %httpcode%
if not "%httpcode%"=="200" (
	echo 在%date% %time:~0,5% 无法正常访问，重启中...
	echo 在%date% %time:~0,5% 无法正常访问，重启中...>>C:\%filename%_Tomcat_8080.log
	taskkill /F /FI  "WINDOWTITLE eq Tomcat_8080"
	rem ping -n 3 127.0.0.1>nul
	set CATALINA_HOME=D:\Myworks\Tomcat\apache-tomcat-8.0.22
	set EXECUTABLE=%CATALINA_HOME%\bin\catalina.bat
	rem call "%EXECUTABLE%" start && exit
	call "%EXECUTABLE%" start
) else (
	echo 在%date% %time:~0,5% 重启成功
	echo 正在监控Tomcat_8080...
	echo 在%date% %time:~0,5% 重启成功>>C:\%filename%_Tomcat_8080.log
	echo 正在监控Tomcat_8080...>>C:\%filename%_Tomcat_8080.log
)
rem ping -n 30 127.0.0.1>nul

sleep 10
goto loop
