# pro
import ConfigParser

cp = ConfigParser.ConfigParser()
cp.read('demo.txt')

'''
print(cp.sections())

print(cp.options('db'))
print(cp.items('db'))

print(type(cp.get('prp','prp.hu')))
print(cp.getint('db','db.name'))
'''

# cp.add_section('dbnew')
# cp.set('dbnew','dbnew.ip','192.168.1.1')


# cp.remove_option('dbnew','dbnew.ip')
cp.remove_section('dbnew')

cp.write(open('demo.txt', 'w'))
print(cp.sections())
