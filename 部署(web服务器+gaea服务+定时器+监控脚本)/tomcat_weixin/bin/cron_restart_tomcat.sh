
#!/bin/sh

# func:自动监控tomcat_weixin,如果停掉则重启
# author:李振海
# date:22/10/2015

#定义环境变量
#PATH=/usr/local/sbin:/usr/local/bin:/sbin:/bin:/usr/sbin:/usr/bin:/usr/java/jdk1.8.0_20/bin
export JAVA_HOME=/opt/jdk
export CLASSPATH=$JAVA_HOME/lib:$JAVA_HOME/lib/tools.jar
export PATH=$PATH:$JAVA_HOME/bin

TomcatID=`ps -ef |grep java|grep tomcat_weixin  |grep -v grep |awk '{print $2}'`

cd /opt/soft/tomcat_weixin/bin

if [ -z "$TomcatID" ]
then
echo "tomcat_weixin进程不存在,开始启动..."
/opt/soft/tomcat_weixin/bin/startup.sh
echo "启动完成!"
fi



