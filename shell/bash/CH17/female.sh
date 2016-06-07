#!/bin/bash

MYSQL=`which mysql`

statement="select * from newpeople where sex='f';"

mysql test -u root -p -e "$statement" | tr "[\011]" ":"| awk -F":" '{printf ("%-8s\t%s\n",$1,$4)}'
