#!/bin/bash
for ((j=0;j<5;j++))
do
echo j=${j}

	for ((i=0;i<10;i++))
	do
		if [ $i -eq 3 ]
		then
		break
		fi
	echo $i
	done

done
