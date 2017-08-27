f = open('specie_names.txt','r')
f.readline()
list_species = list()
for i in f:
    if i[0] == "c" and i[1] == "o" and i[2] == "m" and i[3] == "p":
        d = i.split()
        m = d[1] + " " + d[2]
        list_species.append(m)

set_list = set(list_species)
for s in set_list:
    print (s)
