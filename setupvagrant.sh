#!/usr/bin/env bash

echo "update Fedora"
yum -y update

echo "install Java 1.7"
yum -y install java-1.7.0-openjdk java-1.7.0-openjdk-devel

set JAVA_HOME=/usr/lib/jvm/java-1.7.0-openjdk

echo "install 7zip"
yum -y install p7zip

FUSEINSTALL=jboss-fuse-full-6.0.0.redhat-024

echo "change to the vagrant shared folder"
cd /vagrant

if [ -f $FUSEINSTALL.zip ];
then
	echo "File $FUSEINSTALL.zip exists"
else
	echo "File $FUSEINSTALL.zip does not exists"
	exec wget http://download.jboss.org/jbossfuse/6.1.0.Alpha1/$FUSEINSTALL.zip
fi

echo "unzip the Fuse distribution" 
7za x $FUSEINSTALL.zip -aoa

echo "copy the user.properties into Fuse"
cp users.properties jboss-fuse-6.0.0.redhat-024/etc

echo "launch Fuse"
#jboss-fuse-6.0.0.redhat-024/bin/fuse

echo "create the Fabric"
#fabric:create

echo "add the Management Console"
#profile-edit --features fabric-webui fabric


