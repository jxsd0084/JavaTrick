# mail

import smtplib
from email.mime.text import MIMEText

sender = "wuzhanwei@youku.com"
receiver = "wzhwei@126.com"
smptserver = "mail.youku.com"

username = "wuzhanwei"
password = "WSWZW!!)2"

smtp = smtplib.SMTP()
smtp.connect(smptserver)
smtp.login(username, password)

##
msg = MIMEText('<html>hello</html>', 'html', 'utf-8')
msg['Subject'] = 'sub'
##

smtp.sendmail(sender, receiver, msg.as_string())

smtp.quit()
