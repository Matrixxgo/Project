#!usr/bin/perl

use warnings;
use strict;

my $input = $ARGV[0];
$input =~ tr/ //ds;
$input = lc $input;
my @chararray = split(//, $input);
my @empty = ();

my $length = scalar(@chararray);

for (my $i = $length-1;  $i >= 0; $i--) {
	push(@empty, $chararray[$i]);

}

my $empty1 = join("", @empty);
my $chararray1 = join("", @chararray);

if ( $empty1 eq $chararray1) {
	print "Palindromic!\n";
}
else {
	print "Not a palindrome\n";
}
