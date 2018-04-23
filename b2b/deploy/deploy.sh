#!/bin/bash 
#copy file and restart tomcat
 
tomcat_path=/imsdata/tools/apache-tomcat
project1=b2b-data-app
project2=b2b-data-web
#war_path=http://123.207.137.250:8081/job/xhra-1.0/ws
war_path=/var/lib/jenkins/workspace/xhra
server_port=8080
file_path=/home/ubuntu/xhra/
 
now=$(date +"%Y%m%d%H%M%S")
echo "the shell execute time is ${now}"
 
${tomcat_path}/bin/shutdown.sh
echo "server shutdown"
echo `lsof -n -P -t -i :${server_port}`
tomcat_pid=`lsof -n -P -t -i :${server_port}`
echo "the tomcat_pid is ${tomcat_pid}"
 
if [ "${tomcat_pid}" != "" ]; then 
   kill -9 $tomcat_pid
   echo "kill the server"
fi 
 
cd ${file_path}

#deploy ${project1}
echo "start to deploy ${project1}"
mv ${project1}.war ${project1}.war.bak
#wget ${war_path}/${project1}/target/${project1}.war
cp ${war_path}/${project1}/target/${project1}.war .
if [ -f ${project1}.war ]; then 
   echo "rm ${tomcat_path}/webapps/${project1}.war"
   rm ${tomcat_path}/webapps/${project1}.war
   echo "rm -rf ${tomcat_path}/webapps/${project1}"
   rm -rf ${tomcat_path}/webapps/${project1}
   cp ${project1}.war ${tomcat_path}/webapps
else
   echo "${project1}.war unexists"
fi
echo "finished to deploy ${project1}"

#deploy ${project2}

echo "start to deploy ${project2}"
mv ${project2}.war ${project2}.war.bak
#wget ${war_path}/${project2}/target/${project2}.war
cp ${war_path}/${project2}/target/${project2}.war .
if [ -f ${project2}.war ]; then 
   echo "rm ${tomcat_path}/webapps/${project2}.war"
   rm ${tomcat_path}/webapps/${project2}.war
   echo "rm -rf ${tomcat_path}/webapps/${project2}"
   rm -rf ${tomcat_path}/webapps/${project2}
   cp ${project2}.war ${tomcat_path}/webapps
else
   echo "${project2}.war unexists"
fi
echo "finished to deploy ${project2}"

export JAVA_HOME=/imsdata/tools/java
export CATALINA_HOME=/imsdata/tools/apache-tomcat
export CATALINA_BASE=/imsdata/tools/apache-tomcat
${tomcat_path}/bin/startup.sh
echo "server restarted"