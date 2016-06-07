# iter
print('-> list = [\'name\', \'adress\', \'name2\', \'adress2\', \'name3\', \'adress3\']')
list = ['name', 'adress', 'name2', 'adress2', 'name3', 'adress3']

print('-> for item in list')
for item in list:
    print item

print('-> for i, v in enumerate(list)')
for i, v in enumerate(list):
    print i, v

print('list[1:4]', list[1: 4])
print('list[-3:-1]', list[-3: -1])
print('list[0::2]', list[0::2])
print('list[1:]', list[1:])
print('list[:4]', list[:4])

print('\n')

print('-> dict = {\'a\': \'A\', \'b\': \'B\', \'c\': \'C\'}')
dict = {'a': 'A', 'b': 'B', 'c': 'C'}

print('-> for item in dict')
for item in dict:
    print item

print('-> for item in dict.values()')
for item in dict.values():
    print item

print('-> for k, v in dict.items()')
for k, v in dict.items():
    print k, v

print('-> for i, k in enumerate(dict)')
for i, k in enumerate(dict):
    print i, k

print('\n')

print('s = set([2, 2, 3, 4])')
s = set([2, 2, 3, 4])

print('for item in s')
for item in s:
    print item

print('for i, v in enumerate(s)')
for i, v in enumerate(s):
    print i, v
