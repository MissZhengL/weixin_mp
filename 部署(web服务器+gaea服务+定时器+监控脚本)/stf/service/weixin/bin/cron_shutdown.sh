#!/bin/sh

# func:自动关闭微信的定时器
# author:李振海
# date:29/10/2015

#定义环境变量
#PATH=/usr/local/sbin:/usr/local/bin:/sbin:/bin:/usr/sbin:/usr/bin:/usr/java/jdk1.8.0_20/bin
export JAVA_HOME=/opt/jdk
export CLASSPATH=$JAVA_HOME/lib:$JAVA_HOME/lib/tools.jar
export PATH=$PATH:$JAVA_HOME/bin

STFID=`ps -ef |grep java|grep stf|grep weixin |grep -v grep |awk '{print $2}'`
GAEAID=`ps -ef |grep java|grep weixin|grep gaea |grep -v grep |awk '{print $2}'`

#cd /opt/soft/tomcat_weixin/bin

if [ -z "$STFID" ]
then
  echo "微信定时器进程不存在,检查gaea是否存在..."
  if [ -z "$GAEAID" ]
  then
    echo "微信gaea进程也不存在,do nothing."
  else
    echo "微信gaea进程存在,关掉..."
    cd /opt/gaea/bin/
    /opt/gaea/bin/shutdown.sh weixin
  fi
else
  echo "微信定时器进程存在,关掉..."
  /opt/stf/service/weixin/bin/singleshutdown.sh
  sleep 5s
  if [ -z "$GAEAID" ]
  then
    echo "微信gaea进程不存在,do nothing."
  else
    echo "微信gaea进程存在,关掉..."
    cd /opt/gaea/bin/
    /opt/gaea/bin/shutdown.sh weixin
    sleep 5s
  fi
fi
