### This program will read a fasta file that contains all the sequences and a file that only have desired sequences to be
##pulled from the fasta file. It will extract all the desired sequences from the fasta file and print them in terminal
#This is v .2(contains minor fixes, and error handling)


#This program was made by Saqlain Amin at Institute of Genome Sciences at University of Maryland Baltimore County


#import from the library Biopython to use Seq IO
from Bio import SeqIO



#Set default values and inititate empty list to be used in imorting and exporting data
d=1
second_list = list()
out_list = list()

#Read the file with error handling, if the file name was not right or was not found, rerun the while loop to keep asking until a file name is provided or you can abort the script
while d == 1:
	try:
                #Get the file name that for the fasta file that contains all the fasta sequences
		get_name_file = open(str(raw_input("Enter the file name for fasta: ")),'r')
		#Get the file name that has list of all the sequences to be pulled
		get_name_seq = str(raw_input("Enter the file that contains the seqs: "))

		#Open the file and add all the sequences to a list
		with open(get_name_seq) as f:
                        list_of_seq = f.read().splitlines()
                #some of the lists might contain ">" so get rid of that so we can search the sequences in fasta file and add to new list
                for d in list_of_seq:
                        second_list.append(d.strip(">"))
                d=0
        #Error handling for providing the wrong name or extension of file given
	except IOError:
		print "The last file entered was not found, please make sure to enter extension also","\n"
	

t = 0

#Read the sequence file via biopython module SeqIO and parse it for the sequences which are in the second_list
for seq_record in SeqIO.parse(get_name_file, "fasta"):
        for i in second_list:
                #This search each sequence in the fasta sequence file and prints it out on the screen if found
                if i in seq_record.id:
                        print "\n"
                        print seq_record.description + "\n" + seq_record.seq
                        print "\n"
                        
