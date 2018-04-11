#!/bin/sh

#
#================================================================================================
#                       Shell script used to start  tnb alcatel interface server.
#                       @author        Pan ling
#                       @created        2013/05/17
#================================================================================================
#

#Path where we install alcatel interface.
INTERFACE_BASE=/opt/adapter/probe

#Path where we can find the library used by huawei interface.
LIB_PATH=$INTERFACE_BASE/lib



#PD
PD=:

# set the classpath
MYCLASSPATH=$(echo ${LIB_PATH}/*.jar ${LIB_PATH}/commonlib/*.jar ${LIB_PATH}/mule3.2lib/*.jar| tr ' ' ':')
MYCLASSPATH=$INTERFACE_BASE/conf:${MYCLASSPATH}:$INTERFACE_BASE

#======================================
#echo  ${MYCLASSPATH}
#======================================



#
#=========================================================================
#       End of setting for log
#=========================================================================
#



#
# The command for connecting real EMS
#
nohup \
java -Xms512m -Xmx756m  \
-cp $MYCLASSPATH  org.asb.mule.probe.framework.main.probeService  &

echo $! > $INTERFACE_BASE/bin/interface.pid
