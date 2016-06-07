# try
try:
    print 'begin try'
    i = 10
    j = i / 0
    print 'end try'

except Exception, e:
    # TODO
    print e
    print 'error'
finally:
    print 'print finally'
