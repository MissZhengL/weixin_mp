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

export VM_XMS=1024M
export VM_XMX=1024M
export VM_XMN=512M

#get server name
absexe=`readlink -f $0`
server=`dirname $absexe`
server=`dirname $server`
server_name=`basename $server`
echo $server_name

$server/../../bin/singlestartup.sh $server_name 
#$server/../../bin/test.sh $server_name $instance_name
