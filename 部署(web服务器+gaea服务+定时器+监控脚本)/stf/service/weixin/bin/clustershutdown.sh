#!/bin/sh

### ====================================================================== ###
##                                                                          ##
##                       STF SERVICE START SCIRPT                           ##
##                                                                          ##
### ====================================================================== ###

#
#get server name
#
#server=$(cd "$(dirname "$0")"; pwd)
#server=$(cd "$(dirname "$server")"; pwd)
#server_name=$(basename "$server")
#echo $server_name

NODE=node

#get server name
absexe=`readlink -f $0`
server=`dirname $absexe`
server=`dirname $server`
server_name=`basename $server`
echo $server_name

count=`ps -ef|grep $server_name$NODE |grep java |wc -l`
count=`expr $count - 1`
echo "$count"

instance_name=$server_name$NODE$count
echo $instance_name

$server/../../bin/clustershutdown.sh $server_name $instance_name
#$server/../../bin/test.sh $server_name $instance_name
