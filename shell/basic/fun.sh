#!/bin/bash
function cuttime(){
 echo `date +%Y-%m-%d`
}


function menu(){
clear
echo -e "\t\t\tsys admin menu"
echo -e "\t1:get current time"
echo -e "\t2:ls command"
echo -en "\t\tentry option:"
read option

}
