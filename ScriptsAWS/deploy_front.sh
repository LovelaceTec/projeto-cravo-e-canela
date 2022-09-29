#!/bin/bash
rm -Rf /tmp/projeto-cravo-e-canela 
cd /tmp 
git clone https://github.com/LovelaceTec/projeto-cravo-e-canela.git 
rm -Rf /var/www/html/* 
cp -R /tmp/projeto-cravo-e-canela/frontend/* /var/www/html/ 
rm -Rf /tmp/projeto-cravo-e-canela 
chmod +x /var/deploy_front.sh