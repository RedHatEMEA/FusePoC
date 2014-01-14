FusePoC
=======

1. Install Vagrant - http://www.vagrantup.com/
2. At the command line go to the main directory of this repository and then type:

> vagrant up

3. Wait a bit, You will now have a fully configured vm image running locally. To connect to it type:

> vagrant ssh

4. You will now be ssh'ed into your vm. If you go to /vagrant you will find that the project directory is all there.


Not using Vagrant
=================

1. Uncomment the admin user in user.properties under $FUSE_HOME/etc

2. Ensure running from a fresh Fuse install by deleting 
	$FUSE_HOME/data
	$FUSE_HOME/instances
	
3. Launch Fuse $FUSE_HOME/bin/fuse

4. To create from scratch run the following
	source mvn:com.mycompany/fuse-poc-features/1.0.0-SNAPSHOT/karaf/create
	
5. To recreate the container and profile run
	source mvn:com.mycompany/fuse-poc-features/1.0.0-SNAPSHOT/karaf/recreate




 