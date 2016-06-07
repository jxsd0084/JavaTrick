# for
print('list = [\'name\',\'address\']')
list = ['name', 'adress']

print('for item in list')
for item in list:
    print(item)

print('\n')
print('tup = (\'name\', \'adress\')')
tup = ('name', 'adress')

print('for item in tup')
for item in tup:
    print(item)

print('\n')
click = 10
while click > 0:

    click = click - 1
    if click < 5:
        continue
    print click

print('\n')

click = 10
while click > 0:

    click = click - 1
    if click < 5:
        break
    print click
