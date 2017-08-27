#!usr/bin/perl

use warnings;
use strict;

#pattern matching
# =~ is a binding operator/pattern matching operator
my $hero = "superman";
if ($hero =~ /super/) {
	print "Yes, $hero is super.\n";
}

#adding the i matches the pattern in a case insensitive manner
#my $hero = "SuPeRmAn";
#if ( $hero =~ /super/i ) {
#	print "Still superduper.\n";
#}

#Does find and replace globally:
my $text = "A Man a plan a canal, Panama";
if ($text =~ s/a/o/g) {
	print "$text\n";
}

#match something followed by itself. $1 spits out the first group.
my $double = "panamapanama";
if ($double =~ /^(\w+)\1$/) {
	print "Yes: $1\n";
}

my $ssn = "123-45-6789";
if ($ssn =~ /(\d{3})-(\d{2})-(\d{4})/) {
	print "First: $1\n";
	print "Second: $2\n";
	print "Third: $3\n";
}


Assignment:
convert the nucleotides to protein codons. Use the amino acid chart.
Use global substitution to change T to U
process all of the lines of the file
Comment the code!
use proper indentation
exit the program gracefully
Open file with die, close with die.
Check to see if the file exists
