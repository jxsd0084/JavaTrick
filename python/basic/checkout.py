#! /usr/bin/env python
# coding=utf-8

import sys
import urllib
import urllib2
import json
import time


def writeLog(uid, app_from, ctime):
    file_object = open('./output_form_passport.txt', 'a')
    x = time.localtime(float(ctime))
    cdate = time.strftime('%Y-%m-%d %H:%M:%S', x)
    file_object.write(uid + "\t" + str(app_from) + "\t" + str(cdate) + "\n")
    file_object.close()


file_object = open('./user_ids.txt', 'rb');
list_of_all_the_lines = file_object.readlines()
for line in list_of_all_the_lines:
    lineArr = line.split(' ')
    uid = lineArr[0].strip()
    # url = "http://10.10.69.151:8089/passport/get_by_id"
    url = "http://10.100.188.76:80/passport/get_by_id"
    # 3451
    print url + "?ids=" + uid
    page = urllib.urlopen(url + "?ids=" + uid)
    result = page.read()
    print result
    data = json.loads(result)
    if data["errno"] == 0:
        tt = data["data"][0]["ctime"]
        writeLog(uid, data["data"][0]["app_from"], str(tt)[0:10])

print "校验结束"
sys.exit(-1)
