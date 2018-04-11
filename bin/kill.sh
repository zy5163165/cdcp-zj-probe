#!/bin/sh

#=================================================================================================
#	Shell script used to kill running u2000 interface
#=================================================================================================

if [ ! -f interface.pid ] ; then
	echo  u2000 interface is not running yet.
	exit -1
fi

kill `cat interface.pid`

if [ $? -ne 0 ] ;  then
	exit -1
fi

echo 'U2000 interface are killed '

rm interface.pid


