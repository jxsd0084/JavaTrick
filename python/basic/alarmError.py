#!/usr/bin/env python
# -*- coding: utf-8 -*-

import smtplib, sys
from email.MIMEText import MIMEText

import MySQLdb as mysql
import ConfigParser

import time
from datetime import date

'''
 邮件发送
'''


class Mail(object):
    def __init__(self):
        pass

    def mailConfig(self,
                   mailHost="mail.youku.com",
                   mailUser="",
                   mailPass="",
                   mailSubfix="youku.com"
                   ):
        self._mailHost = mailHost
        self._mailUser = mailUser
        self._mailPass = mailPass
        self._mailSubfix = mailSubfix

        return self

    def sendMail(self,
                 subject="subject",
                 message="message",
                 mailList=["kouzhigang@youku.com", "daixun@youku.com", "wangqiao@youku.com", "wuzhanwei@youku.com"]
                 ):
        self._message = message
        self._mailList = mailList

        self._msg = MIMEText(self._message, 'html')
        self._msg["Subject"] = subject
        self._msg['From'] = self._mailUser + "<" + self._mailUser + "@" + self._mailSubfix + ">"
        self._msg['To'] = ";".join(self._mailList)

        try:
            s = smtplib.SMTP()
            s.connect(self._mailHost)
            s.login(self._mailUser, self._mailPass)
            s.sendmail(self._msg['From'], self._mailList, self._msg.as_string())
            s.close()
            return True
        except Exception, e:
            print str(e)
            return False


# 数据库操作
class Db(object):
    def __init__(self):
        try:
            self._config = ConfigParser.ConfigParser()
            self._config.read("/opt/cafe/shell/conf/python_conf/python_mysqlconn.conf")
            self._databaseHost = self._config.get("database_online", "stat_ipaddr")
            self._databasePort = self._config.get("database_online", "stat_port")
            self._databaseUser = self._config.get("database_online", "stat_uname")
            self._databasePass = self._config.get("database_online", "stat_upwd")
            self._databaseName = self._config.get("database_online", "stat_dbname")

            print self._databaseHost, self._databasePort, self._databaseUser, self._databasePass, self._databaseName
        except Exception, e:
            print e.message
            exit()

    def connect(self):
        try:
            self._link = mysql.connect(host=self._databaseHost, user=self._databaseUser, passwd=self._databasePass,
                                       db=self._databaseName, port=int(self._databasePort))
            self._conn = self._link.cursor(cursorclass=mysql.cursors.DictCursor)
        except Exception, e:
            print e.message
            exit()
        return self

    def query(self, date, hour):
        sql = "SELECT * FROM t_result_nginx_hour_item_stat WHERE stat_date = '" + str(date) + "' AND hour in(" + str(
            hour) + ") order by channel_id,pv desc"
        print sql
        try:
            self._conn.execute(sql)
            rows = self._conn.fetchall()
            self._conn.close()
        except Exception, e:
            print e.message
            exit()

        return rows


# 解析数据
class ParseData(object):
    def __init__(self):
        pass

    def parseData(self, data):

        message = '''
        <html xmlns="http://www.w3.org/1999/xhtml">
            <head>
                <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
                <title></title>
                <style>
                    #customers
                    {
                        font-family:"Trebuchet MS", Arial, Helvetica, sans-serif;
                        width:100%;
                        border-collapse:collapse;
                    }
                    #customers td, #customers th
                    {
                        font-size:1em;
                        border:1px solid #3583FF;
                        padding:3px 7px 2px 7px;
                    }
                    #customers th
                    {
                        font-size:1.1em;
                        text-align:left;
                        padding-top:5px;
                        padding-bottom:4px;
                        background-color:#4286F4;
                        color:#ffffff;
                    }
                    #customers tr.alt td
                    {
                        color:#000000;
                        background-color:#EAF2D3;
                    }
                    </style>
            </head>
            <body>
                <table id="customers">
                    <tr>
                        <th>error_code</th>
                        <th>url</th>
                        <th>create_time</th>
                        <th>stat_date</th>
                        <th>hour</th>
                        <th>pv</th>
                    </tr>
    '''
        if len(data) > 0:
            for m in data:
                message += "<tr><td>" + str(m['channel_id']) + "</td><td>" + str(m['item']) \
                           + "</td><td>" + str(m['create_time']) + "</td><td>" + str(m['stat_date']) + "</td><td>" + m[
                               'hour'] \
                           + "</td><td>" + str(m['pv']) + "</td></tr>"

        message += '''
            </table>
            </body>
        '''
        return message


class Client(object):
    def __init__(self):
        # self._executeMin = 17
        # self._sleep = 10
        self._hourList = [0, 1, 2, 3, 4, 5, 6]

        self._today = date.today()
        self._nowTime = str(time.strftime("%H:%M:%S"))
        # self._nowHour = 14
        self._nowHour = int(time.strftime("%H")) - 1
        self._nowMin = int(time.strftime("%M"))

    def execute(self):
        """
        while self._executeMin != self._nowMin:
            self._today = date.today()
            self._nowTime = str(time.strftime("%H:%M:%S"))
            self._nowHour = int(time.strftime("%H"))
            self._nowMin = int(time.strftime("%M"))

            time.sleep(self._sleep)
        """
        if self._nowHour not in self._hourList:

            print "execute begin"

            self._db = Db()
            data = self._db.connect().query(self._today, self._nowHour)

            parse = ParseData()
            message = parse.parseData(data)
            print message

            subject = "nginx_hour_error-" + time.strftime("%Y-%m-%d %H:%M:%S")

            mail = Mail()
            mail.mailConfig().sendMail(subject, message)

        elif 6 == self._nowHour:

            print "today first execute"

            self._db = Db()
            hourList = ""
            for h in self._hourList:
                hourList += str(h) + ","

            data = self._db.connect().query(self._today, hourList[0:-1])

            parse = ParseData()
            message = parse.parseData(data)
            print message

            subject = hourList[0:-1] + "-nginx_hour_error-" + time.strftime("%Y-%m-%d %H:%M:%S")

            mail = Mail()
            mail.mailConfig().sendMail(subject, message)

    def send(self):
        pass


if __name__ == '__main__':
    client = Client()
    client.execute()
