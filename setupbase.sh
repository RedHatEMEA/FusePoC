#!/usr/bin/env bash


echo "install Java 1.7"
yum -y install java-1.7.0-openjdk-devel

echo "install unzip"
yum -y install unzip

echo "install maven"
wget http://repos.fedorapeople.org/repos/dchen/apache-maven/epel-apache-maven.repo -O /etc/yum.repos.d/epel-apache-maven.repo
yum -y install apache-maven
