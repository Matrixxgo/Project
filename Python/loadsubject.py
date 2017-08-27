#!/usr/bin/env python

#This script will retrieve all the ID's from the subjects in the hmp namespace
#by using the open source OSDF dataframe



#import json and osdf from the OSDF module
import json
import unittest
import os
from osdf import OSDF


def main():
    #get a server, username and password input for connecting to database
    server = "osdf-devel.igs.umaryland.edu"
    username = str(input("Provide a username: "))
    password = str(input("Provide a password: "))
    #the default port
    port = 8123

    #Get the query of subjects which are a "node type" defined in JSON documents
    query = '"subject"[node_type]'

    #a namespace defined for the project to access the data
    namespace = "hmp"
    schema_name = "subject"

    #Takes the username,password, server and port and connects to the database
    osdf = OSDF(server, username, password, port)


    #query all the data and add to list, makesure that it queries all pages so no page is left behind
    info = [osdf.oql_query_all_pages(namespace, query)]

    #Get all the results(which are in a dictionary) to a list
    info = info[0]
    results = info["results"]
    list_id = []

    #open the file for writting the ID's to be retrieved by another script
    file = open("subjectid", 'w')
    for i in results:
        iid = i["id"]
        file.write(iid+"\n")        
        list_id.append(iid)

    #close the file and print the list
    file.close()
    print len(list_id)
    

    
main()
