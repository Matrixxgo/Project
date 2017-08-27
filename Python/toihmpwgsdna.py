#A script to delete things from old wgs_dna to new guidelines


#required module for the conversion to occur
import json



def main():

        #initiate value for the loop and run the loop for 1630 times(the amount of files)
        t = 1
        while t <= 1630:

                #get the dna file from dna1....dna1630 and load it into a dict
                dna = "dna" + str(t)
                file = open(dna,'r')
                json_data = json.load(file)

                #add the ihmp as ns to the new loaded file
                json_data["ns"] = "ihmp"

                #change write to ihmp
                acl = json_data["acl"]
                acl["write"] = ["ihmp"]
        
                #delete composed of from linkage and change derived from to prepared from
                linkage = json_data["linkage"]
                derived_from = linkage["derived_from"]
                linkage["prepared_from"] = derived_from
                del linkage["derived_from"]
                del linkage["composed_of"]
                


                #add the required guidelines to the old files to meet the new format
                meta = json_data["meta"]
                meta["frag_size"] = 0
                meta["lib_layout"] = ""
                meta["lib_selection"] = ""
                nap_id = meta["nap_id"]
                meta["prep_id"] = nap_id
                meta["sequencing_contact"] = ""

                #a new section being added and some sub-section things to be added for required guidelines
                mims = meta["mims"]
                mims["findex"] = ""
                mims["rindex"] = ""
                mims["extrachrom_elements"] = ""
                mims["encoded_traits"] = ""


                #everything being deleted
                del meta["nap_id"]
                del meta["storage_temperature"]
                del meta["hmp_supersite"]
                del mims["mid"]
                del meta["storage_location"]
                del meta["hmp_body_site"]
                del meta["rand_subject_id"]
                del meta["health_disease_stat"]
                del meta["assembly_name"]




                #printing the files onto the terminal for assurance that everything went according to plan
                print (json.dumps(json_data, indent = 3, sort_keys = True))
                break
                t = t+1
                
#call the main function to be executed
main()
