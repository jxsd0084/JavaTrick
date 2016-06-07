# file


'''
f=open('demo.txt','r')
#print(f.read())
#print('see')

print(f.readline())
print(f.readline())
print(f.readline())
print(type(f.readline()))



while True:
	line=f.readline().strip()
	if (line):
		print line
	else:
		break
	

#print('ss')

fa=open('demo.txt','a')
fa.write('newadress')
fa.close()

'''

fw = open('demo.txt', 'w')
fw.write('one two')
fw.close()
print('finished !')
