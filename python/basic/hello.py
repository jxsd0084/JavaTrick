

print("please intput something: ")
msg = raw_input()
print("hello", msg)

'''
1:wwww
2:eeee
'''
print ('zenith')

list = ['abc', "ABC", 1, True, None]

print(type(list))

'''
list.append('2')
list.pop(-2)
list[0]='cba'
print(list)
'''


'''
tuple=(111,222)
print(type(tuple))
tuple[1]=0
'''

dic = {'id': 1, "name": "zhangsan"}
# print(dic)
# print(type(dic))

print(dic['id'])
# print(dic['namee'])

# print(dic.get('namee'))
# dic.pop('id')
# print(dic)


s = set([1, 1, 1, 1, 2, 2, 3])
s.add(3)
s.remove(1)
print(s)
