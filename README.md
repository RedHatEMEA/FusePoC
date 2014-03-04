FusePoC
=======

1. Clone this repository
1. Download jboss-fuse-full-6.0.0.redhat-024.zip and save in the main directory of this repository. Don't worry about unzipping it.
1. Install Vagrant - http://www.vagrantup.com/
1. At the command line go to the main directory of this repository and then type:
> vagrant up
1. Wait a bit, You will now have a fully configured vm image running locally. To connect to it type:
> vagrant ssh
1. You will now be ssh'ed into your vm
1. Change to the Fuse bin directory
> cd /vagrant/jboss-fuse-6.0.0.redhat-024/bin
1. Start Fuse
> ./start
1. After 20-30 seconds start a Fuse client
> ./client -u admin -p admin
1. Create a Fuse fabric
> fabric:create --clean
1. Tell the fabric about the offline Maven repo
> fabric:profile-edit --pid org.fusesource.fabric.agent/org.ops4j.pax.url.mvn.repositories='file:///vagrant/fuse-poc-offline-repo/target/features-repo@snapshots@id=poc' default
1. Run the Karaf script to deploy the PoC
> source mvn:com.mycompany/fuse-poc-features/1.0.0-SNAPSHOT/karaf/fuse-poc-create


Not using Vagrant
=================

1. Uncomment the admin user in user.properties under $FUSE_HOME/etc

2. Ensure running from a fresh Fuse install by deleting 

>	$FUSE_HOME/data
>	$FUSE_HOME/instances
	
3. Launch Fuse $FUSE_HOME/bin/fuse

4. To create from scratch run the following

>	source mvn:com.mycompany/fuse-poc-features/1.0.0-SNAPSHOT/karaf/create
	
5. To recreate the container and profile run

>	source mvn:com.mycompany/fuse-poc-features/1.0.0-SNAPSHOT/karaf/recreate




 
