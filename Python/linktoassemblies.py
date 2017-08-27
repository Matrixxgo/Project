#!/usr/bin/env python
##This script just removes the old linkage id's to new ones by matching in dictionary
##This will only work if the ID saved are in the correct order, which the script download
##the data accomplishes



#import proper libraries
import json
import unittest
import os



def main():
    #open the two saved filees that should be created by the script uploading the wgs_assm files
    new = [line.rstrip('\n') for line in open('new_ids_wgs_assm_ihmp.txt')]
    old = [line.rstrip('\n') for line in open('old_ids_wgs_assm_ihmp.txt')]

    ##just some initial values to be used in loop
    i = 1
    w = 1
    dna = "annotation"

    #run the loop 2082 times(the amount of files there are)
    while i <= 2082:
        #open the each dna file(from dna1 to dna 2082
        file = open(dna+str(i)+".json", 'r')
        json_data = json.load(file)

        ##load the linkage into a variable so it can be changed
        linkage = json_data["linkage"]

        #get the id of prepared from the list of linkage(the id which is linked to the old file)
        prepared_from = linkage["computed_from"]
        id1 = prepared_from[0]

        #now replace the old ID with the new one by using a simple replace method by indexing
        for j in old:
            if j == id1:
                w = w+1
                index = old.index(j)
                prepared_from[0] = new[index]

        #open the file and write the new files onto file in the new stage folder
        with open("/Users/saqlain/Downloads/annotation/Seperate/Stage1/Stage2/"+dna+str(i)+".json",'+w') as f:
                f.write(json.dumps(json_data, indent = 3, sort_keys = True))
                f.close()
        i = i+1
    print (w)


main()
