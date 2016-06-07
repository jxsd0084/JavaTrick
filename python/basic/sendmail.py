import smtplib
from email.mime.text import MIMEText

sender = "wuzhanwei@youku.com"
receiver = "wzhwei@126.com"
smptserver = "mail.youku.com"

username = "wuzhanwei"
password = "WSWZW!!)2"

msg = MIMEText('<html>ddd</html>', 'html', 'utf-8')
msg['Subject'] = 'subject'
smtp = smtplib.SMTP()
smtp.connect(smptserver)
smtp.login(username, password)
smtp.sendmail(sender, receiver, msg.as_string())
smtp.quit()
