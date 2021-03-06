#!/usr/bin/perl

use warnings;
use strict;


#Save the input into a string.
my $input = $ARGV[0];

#Create the dictionary to store the conversion of codons to amino acids.
my %legend = ("UUU" => "F", "UUC" => "F", "UUA" => "L", "UUG" => "L", "CUU" => "L", "CUC" => "L", "CUA" => "L", "CUG" => "L", "AUU" => "I", "AUC" => "I", "AUA" => "I", "AUG" => "M", "GUU" => "V", "GUC" => "V", "GUA" => "V", "GUG" => "V", "UCU" => "S", "UCC" => "S", "UCA" => "S", "UCG" => "S", "CCU" => "P", "CCC" => "P", "CCA" => "P", "CCG" => "P", "ACU" => "T", "ACC" => "T", "ACA" => "T", "ACG" => "T", "GCU" => "A", "GCC" => "A", "GCA" => "A", "GCG" => "A", "UAU" => "Y", "UAC" => "Y", "UAA" => "<STOP>", "UAG" => "<STOP>", "CAU" => "H", "CAC" => "H", "CAA" => "Q", "CAG" => "Q", "AAU" => "N", "AAC" => "N", "AAA" => "K", "AAG" => "K", "GAU" => "D", "GAC" => "D", "GAA" => "E", "GAG" => "E", "UGU" => "C", "UGC" => "C", "UGA" => "<STOP>", "UGG" => "W", "CGU" => "R", "CGU" => "R", "CGA" => "R", "CGG" => "R", "AGU" => "S", "AGC" => "S", "AGA" => "R", "AGG" => "R", "GGU" => "G", "GGC" => "G", "GGA" => "G", "GGG" => "G");

#Covert the string to an array.
my @array = $input;

#Save the length of the array into $length
my $length = scalar(@array);

#If length of input is not divisible by 3, print an error message
#If it is divisible by 3, match the input to the dictionary to yield the output.
if (($length%3) !=0) {
	print "$length is not evenly divisible by 3\n";
} 	else {
		my $aminoacid = $legend{@array};
	

#Print to STDOUT
print STDOUT "$variable";
