# method

def my_abs(i):
    if i > 0:
        return str(i)
    else:
        return 0 - i


print(my_abs('2a'))
print(type(my_abs('2')))
print(type(my_abs(2)))


def plist(list):
    for item in list:
        print item
    return list[0]


# l=['11','222']
# print(plist(22))

'''
def no(id):
	pass


print(no(11))
'''

'''
def showlist(list):
	return 1,1,2,3

tup=showlist(1)
print tup[-1]
for item in tup:
	print item
'''


def demo(id, name=0):
    print id, name


demo(1)
