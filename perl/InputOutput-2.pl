 #!/usr/bin/perl

use warnings;
use strict;

my $input = $ARGV[0];

open(NUC, '<', $input) or
	die "Unable to open '$input' for reading: $!";
	
my @sub_line2 = <NUC>;

chomp @sub_line2;
my $gh = [@sub_line2];
print STDOUT 
my @sub_line = split(//,$gh);
my $sub_line = [@sub_line];




if (index($sub_line, "B") != -1 || index($sub_line, "D") != -1 || index($sub_line, "E") != -1 || index($sub_line, "F") != -1|| index($sub_line, "H") != -1
|| index($sub_line, "I") != -1|| index($sub_line, "J") != -1|| index($sub_line, "K") != -1|| index($sub_line, "L") != -1|| index($sub_line, "M") != -1|| index($sub_line, "N") != -1
|| index($sub_line, "O") != -1|| index($sub_line, "P") != -1|| index($sub_line, "Q") != -1|| index($sub_line, "R") != -1|| index($sub_line, "S") != -1|| index($sub_line, "U") != -1
|| index($sub_line, "V") != -1|| index($sub_line, "W") != -1|| index($sub_line, "X") != -1|| index($sub_line, "Y") != -1|| index($sub_line, "Z") != -1)
{
	print "Invalid file\n";
	}
my @array = split(//, $sub_line);

while (<NUC>){
	my @subline = <NUC>;
	my @chararray = split(//,@subline); 
	chomp @chararray;
	foreach my $nuc(@chararray){
	if ("$nuc" eq "A"){
		print STDOUT "T";}
	if ("$nuc" eq "C"){
		print STDOUT "G";}
	if ("$nuc" eq "T"){
		print STDOUT "A";}
	if ("$nuc" eq "G"){
		print STDOUT "C";}
	}
	
	}



close NUC;