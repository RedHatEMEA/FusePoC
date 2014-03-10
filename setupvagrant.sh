#!/usr/bin/env bash

FUSEINSTALL=dist/jboss-fuse-full-6.0.0.redhat-024.zip

echo "Opening ports in the firewall"
sudo lokkit -p 9090:tcp -p 8010:tcp

echo "change to the vagrant shared folder"
cd /vagrant


if [ -d runtime/jboss-fuse-6.0.0.redhat-024 ];
then
	echo "Clearing out existing files"
	rm -fr runtime/jboss-fuse-6.0.0.redhat-024
fi

if [ -f $FUSEINSTALL ];
then
	echo "File $FUSEINSTALL exists"
else
	echo "File $FUSEINSTALL does not exists"
	exit
fi

echo "unzip the Fuse distribution" 
unzip -o -q $FUSEINSTALL -d runtime/

echo "copy the user.properties into Fuse"
cd /vagrant
cp users.properties runtime/jboss-fuse-6.0.0.redhat-024/etc

echo "build the PoC"
mvn clean
mvn install


