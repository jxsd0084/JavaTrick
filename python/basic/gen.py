# gen

# list=[ x*2 for x in range(1,11) if x%2==0]
# print(list)

print(type(range(1, 11)))

# list=[ x*y for x in range(1,11)  for y in range(1,11) if x>y]
# print(list)

list = ['name', 'adress', 'name2', 'adress2', 'name3', 'adress3']

gen = (x + 'q' for x in list if x == 'name')

# print(type(gen))

# print(gen.next())
# print(gen.next())
# print(gen.next())

for g in gen:
    print g

uv = {'id': 12, 'uv': 30000, 'id': 13, 'uv': 40000, 'id': 14, 'uv': 50000}
pv = {'id': 12, 'uv': 300000, 'id': 13, 'uv': 400000, 'id': 14, 'uv': 500000}
id = [12, 13, 14]
