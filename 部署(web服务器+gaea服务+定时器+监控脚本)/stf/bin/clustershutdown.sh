#!/bin/sh

### ====================================================================== ###
##                                                                          ##
##                       SCF server shutdown script                         ##
##                                                                          ##
### ====================================================================== ###


USAGE="Usage: shutdown.sh <service-name> <service-name-node>"

# if no args specified, show usage
if [ $# -lt 2 ]; then
  echo $USAGE
  exit 1
fi


# get arguments
SERVICE_NAME=$1
SERVICE_NAME_NODE=$2

cd $(dirname "$0")

DIR=`dirname "$0"`
DIR=`cd "$bin"; pwd`
PID_FILE="$DIR"/../tmp/pid/"$SERVICE_NAME"_"$SERVICE_NAME_NODE"

if [ ! -e $PID_FILE ]; then
  echo "pid file($PID_FILE) not exits"
  exit 1
fi

echo "kill pid: `cat $PID_FILE`"
kill -9 `cat $PID_FILE`
rm -rf $PID_FILE

