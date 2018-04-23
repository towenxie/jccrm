@echo off
echo 开始备份jccrm DB
set yy=%date:~0,4%  
set mm=%date:~5,2%  
set dd=%date:~8,2%
if /i %time:~0,2% lss 10 set hh=0%time:~1,1%  
if /i %time:~0,2% geq 10 set hh=%time:~0,2%  
set mn=%time:~3,2%  
set ss=%time:~6,2%  
set date=%yy%%mm%%dd%  
set time=%hh%%mn%%ss%
set filename=%date%_%time%  
set filename=%filename: =%
echo %filename%

"C:/Program Files/MySQL/MySQL Server 5.6/bin/mysqldump.exe" -uroot -proot --host=localhost --port=3306 --default-character-set=utf8 --events "jccrm" > D:/db_backup/jccrm%filename%.sql  
  
echo 备份已经完成  
rem pause  