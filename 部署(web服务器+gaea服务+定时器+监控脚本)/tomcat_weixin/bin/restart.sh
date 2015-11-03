#!/bin/sh
killpid=` ps -ef |grep java|grep tomcat_sp2  |grep -v grep |awk '{print $2}'`
kill -9 $killpid
sleep 1s

/opt/tomcat_sp2/bin/startup.sh
