#!/usr/bin/env bash


echo "install Java 1.7"

yum -y install java-1.7.0-openjdk-devel

echo "install unzip"
yum -y install unzip

echo "install maven"
wget http://mirrors.gigenet.com/apache/maven/maven-3/3.2.1/binaries/apache-maven-3.2.1-bin.tar.gz
su -c "tar -zxvf apache-maven-3.2.1-bin.tar.gz -C /opt/" 
export PATH=/opt/apache-maven-3.2.1:/opt/apache-maven-3.2.1/bin:$PATH

FUSEINSTALL=jboss-fuse-full-6.0.0.redhat-024

echo "change to the vagrant shared folder"
cd /vagrant

if [ -f $FUSEINSTALL.zip ];
then
	echo "File $FUSEINSTALL.zip exists"
else
	echo "File $FUSEINSTALL.zip does not exists"
	exit
fi

echo "unzip the Fuse distribution" 
unzip -o -q $FUSEINSTALL.zip

echo "copy the user.properties into Fuse"
cd /vagrant
cp users.properties jboss-fuse-6.0.0.redhat-024/etc

echo "build the PoC"
mvn clean
mvn install


