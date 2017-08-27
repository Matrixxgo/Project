#!/usr/bin/env python

#This will upload all the wgs_raw files to ihmp namespace that are saved in the given directory



#import json and osdf from the OSDF module
import json
import unittest
import os
from osdf import OSDF


def main():
    #get a server, username and password input for connecting to database
    server = str(input("Please enter the server to connect to: "))
    username = str(input("Please provide the username: "))
    password = str(input("Please provide the password: "))
    #use the default port
    port = 8123
    #Takes the username,password, server and port and connects to the database
    osdf = OSDF(server, username, password, port)
    sample = "sequence"
    #initiate a value and create empty lists
    t = 1
    srs_ids = []
    link_list = []

    #since there are 1635 sample files, run the loop that many times
    while t <= 1635:
        #add different numbers onto the end of sample files to be opened
        sample1 = sample + str(t)+".json"
        try:
            #Get the path to open the sample files
            get_file = str(input("Please provide the path for the folder that contains sample files: "))
            #open the file with the subject number
            f = open(get_file+sample1, 'r')

            #load the data with json library
            data = json.load(f)
            #add node type to the sample files as one of the requirements
            data["node_type"] = "wgs_raw_seq_set"

            #Get the id numbers from the url in the data file
            urls = data["meta"]["urls"]
            urls = urls[0]
            urls = urls.replace("/"," ").replace("."," ").split()

            #load the id into a list to be copied onto a seperate file at the bottom
            for z in urls:
                if z[0] == "S" and z[1] == "R" and z[2] == "S":
                    srs_ids.append(z)

            #the id was wrong so delete it
            del data["id"]

            #insert the new node onto the new server and get the new id and append it to a list to be written onto a file later
            link = osdf.insert_node(data)
            link_list.append(link)
            
        except (OSError):
            print t
            


        t = t+1

#write the srs id's for wgs raw. The old and new in the same order so they can be used later
    d = open("srs_ids_wgs_raw.txt",'w')
    for items in srs_ids:
        d.write("%s\n"%items)
    d.close()
    g = open("new_ids_wgs_raw.txt",'w')
    for items in link_list:
        g.write("%s\n"%items)
    g.close()
        
main()
    
