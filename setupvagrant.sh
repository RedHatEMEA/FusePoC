#!/usr/bin/env bash

yum -y update
yum -y install java-1.7.0-openjdk java-1.7.0-openjdk-devel

FUSEINSTALL=jboss-fuse-full-6.1.0.redhat-139.zip

if [ -f $FUSEINSTALL ];
then
	echo "File $FUSEINSTALL exists"
else
	echo "File $FUSEINSTALL does not exists"
	exec wget http://download.jboss.org/jbossfuse/6.1.0.Alpha1/$FUSEINSTALL
fi
 

