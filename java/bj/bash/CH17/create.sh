#!/bin/bash

MYSQL=`which mysql`

mysql test -u root -p <<EOF
create table newpeople(name VARCHAR(20),sex CHAR(1),birth DATE,birthaddr VARCHAR(20));
show tables;
EOF
