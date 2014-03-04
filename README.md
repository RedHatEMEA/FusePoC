FusePoC
=======

- Clone this repository
- Download jboss-fuse-full-6.0.0.redhat-024.zip and save in the main directory of this repository. Don't worry about unzipping it.
- Install Vagrant - http://www.vagrantup.com/
- At the command line go to the main directory of this repository and then type:

> vagrant up

- Wait a bit, You will now have a fully configured vm image running locally. To connect to it type:

> vagrant ssh

- You will now be ssh'ed into your vm
- Change to the Fuse bin directory

> cd /vagrant/jboss-fuse-6.0.0.redhat-024/bin

- Start Fuse

> ./start

- After 20-30 seconds start a Fuse client

> ./client -u admin -p admin

- Create a Fuse fabric

> fabric:create --clean

- Tell the fabric about the offline Maven repo

> fabric:profile-edit --pid org.fusesource.fabric.agent/org.ops4j.pax.url.mvn.repositories='file:///vagrant/fuse-poc-offline-repo/target/features-repo@snapshots@id=poc' default

- Run the Karaf script to deploy the PoC

> source mvn:com.mycompany/fuse-poc-features/1.0.0-SNAPSHOT/karaf/fuse-poc-create


Not using Vagrant
=================

- Uncomment the admin user in user.properties under $FUSE_HOME/etc

- Ensure running from a fresh Fuse install by deleting 

>	$FUSE_HOME/data
>	$FUSE_HOME/instances
	
- Launch Fuse $FUSE_HOME/bin/fuse

- To create from scratch run the following

>	source mvn:com.mycompany/fuse-poc-features/1.0.0-SNAPSHOT/karaf/create
	
- To recreate the container and profile run

>	source mvn:com.mycompany/fuse-poc-features/1.0.0-SNAPSHOT/karaf/recreate




 
