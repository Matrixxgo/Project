 #!/usr/bin/perl

use warnings;
use strict;
#read the file
my $input = $ARGV[0];

#open the file
open(NUC, '<', $input) or
	die "Unable to open '$input' for reading: $!";

#convert the file into an array	
my @sub_line2 = <NUC>;
chomp @sub_line2;
my $word = join('',@sub_line2);
my @array = split('',$word);


#check whether the file contain any other words than ATCG
if (grep{$_ eq "B" || $_ eq "D"|| $_ eq "E"|| $_ eq "F"|| $_ eq "H"|| $_ eq "I"
|| $_ eq "J"|| $_ eq "K"|| $_ eq "L"|| $_ eq "M"|| $_ eq "N"|| $_ eq "O"|| $_ eq "P"
|| $_ eq "Q"|| $_ eq "R"|| $_ eq "S"|| $_ eq "U"|| $_ eq "V"|| $_ eq "W"|| $_ eq "X"
|| $_ eq "Y"|| $_ eq "Z"} @array){
	print "Invalid file\!\n";
}



#if the file does contain only ATCG then add the complementary to a list
else {
my @new_array = ();
foreach my $n (@array){
	if ($n eq "A"){
	push (@new_array, 'T');
	}
	if ($n eq "C"){
	push (@new_array, 'G');
	}
	if ($n eq "G"){
	push (@new_array, 'C');
	}
	if ($n eq "T"){
	push (@new_array, 'A');
	}
}
#my $new_word = join('',@new_array);
print "@new_array\n";
my @rev = reverse @new_array;
print STDOUT "@rev\n";
}

close NUC;