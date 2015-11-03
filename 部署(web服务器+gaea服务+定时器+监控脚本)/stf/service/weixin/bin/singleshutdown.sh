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

#get server name
absexe=`readlink -f $0`
server=`dirname $absexe`
server=`dirname $server`
server_name=`basename $server`
echo $server_name

$server/../../bin/singleshutdown.sh $server_name 
