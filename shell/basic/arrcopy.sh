#!/bin/bash
declare -a arr
for ((i=0;i<3;i++))
do
arr[$i]=$RANDOM
done

for j in ${arr[@]}
do
echo $j
done
echo ------------------

for j in "${arr[@]}"
do
echo $j
done

echo ------------------
for j in ${arr[*]}
do
echo $j
done

echo ------------------
for j in "${arr[*]}"
do
echo $j
done
