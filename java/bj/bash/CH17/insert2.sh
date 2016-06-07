#!/bin/bash

MYSQL=`which mysql`

if [ $# -ne 4 ]
then
  echo "Usage:insert2.sh name sex birth birthaddr"
else
  statement="insert into newpeople values ('$1','$2','$3','$4');"
mysql test -u root -p <<EOF
$statement
#select * from newpeople;
EOF
 if [ $? -eq 0 ]
 then
  echo "Data sucessfully added."
else
 echo "Problem adding data"
 fi
fi
