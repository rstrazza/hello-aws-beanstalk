#!/bin/bash
######################################################################################
# Simple MongoDB Install
######################################################################################

#Update packages
yum -y update

MONGODB_REPO="/etc/yum.repos.d/mongodb.repo"

if grep -q "MongoDB" "$MONGODB_REPO"; then
	echo "********************* mongodb.repo entry already exist ***************"
else
	#Add MongoDB yum repo
	echo "[MongoDB]
		name=MongoDB Repository
		baseurl=http://downloads-distro.mongodb.org/repo/redhat/os/x86_64
		gpgcheck=0
		enabled=1" | sudo tee -a $MONGODB_REPO
fi

#Install Mongo
yum install -y mongo-10gen-server mongodb-org-shell

# Start MongoDB automatically at boot
chkconfig mongod on
