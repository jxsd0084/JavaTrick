#!/bin/bash
source fun.sh
menu


case $option in
	1)
	cuttime
	;;
	2)
	ls
	;;
	*)
	echo "wrong option"
	;;
esac


