#!/usr/bin/python
import re
import requests
import urllib
from Bio import Entrez
import xlsxwriter
import os






get_html = open("genes.txt",'r')

url_list = list()

for i in get_html:
	urls = re.search(r'href=[\'"]?([^\'" >]+)', i)
	if urls:
		url_list.append(urls.group(0))




url_set = set(url_list)

number_list = list()
all_gene_numbers = list()

for u in url_set:
	try:
		u = u.replace("?"," ")
		u = u.replace(':'," ")
		u = u.replace('+'," ")
		u2 = u.split()
		if "hsa" in u2:
			number_list=re.findall(r'\d+',u)
			for agn in number_list:
				all_gene_numbers.append(agn)
	except:
		print u
		pass
		
		
		
print len(set(all_gene_numbers))
gene_nam_loc = dict()	
gene_list = list()
location_list = list()
	
for d in all_gene_numbers:
	Entrez.email = "MSAQLAINAMIN2003@GMAIL.COM"
	handle = Entrez.efetch(db="gene", id=d , rettype="gb", retmode="text")
	read = handle.read()
	read = str(read)
	read2 = read.split()
	gene_name = re.search('and Name: (.*)\[Homo sapiens',read)
	try:
		location = re.search('Annotation: (.*)',read)
		location = location.group(1)
		location_list.append(location)
	except AttributeError:
		location = re.search('Chromosome: (.*)',read)
		location = location.group(1)
		location_list.append(location)
		
	try:
		gene = gene_name.group(1)
		gene_nam_loc[gene] = location
		gene_list.append(gene_name.group(1))
		
	except AttributeError:
		print d

print len(set(location_list))
print len(set(gene_list))
print len(gene_nam_loc)


location_file = open('location.txt','w')

for l in location_list:
        location_file.write("%s\n" % l)



workbook = xlsxwriter.Workbook("gene_name_location.xlsx")
worksheet = workbook.add_worksheet()
row = 0


for key in gene_nam_loc.keys():
	col = 0
	worksheet.write(row,col,key)
	col = 1
	worksheet.write(row,col,gene_nam_loc[key])
	row += 1
workbook.close()	
	
os.system('say "Your program has finished"')	
	
	
	
	
	
	
	
	
