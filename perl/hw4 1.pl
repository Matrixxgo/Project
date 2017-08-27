 #!/usr/bin/perl

use warnings;
use strict;
#read the file
my $input = $ARGV[0];
my $output = $ARGV[1];

if ($#ARGV > 1){
	print "You specified more than two arguments, please try again.\n";
	exit;

}

elsif ($#ARGV < 0){
	print "No arguments were specified please try again.\n";
	exit;

}

#open the file
open(NUC, '<', $input) or
	die "Unable to open '$input' for reading: $!";



	
#convert the file into an array	
my $number_line = 0;
my @output_array = ();
my @temp_array = ();
while (my $line = <NUC>){
	$line =~s/^\s+//;
	my @sub_line = $line;
	my $word = join('',@sub_line);
	my @array = split('',$word);
	if (grep{$_ eq ">" } @array){
		my $str = join("",@temp_array);
		print "$str";
		push (@output_array, @temp_array);
		push (@output_array,@sub_line);
		@temp_array = ();

		
	}
	else {
		my $nuc_line = join('',@sub_line);
		$nuc_line =~ s/T/U/g;
		$nuc_line =~ s/^\s+//;
		push (@temp_array,$nuc_line);	
	}

}


push (@output_array, @temp_array);








if ($#ARGV == 1){
open(my $out_file, '>', $output) or
	die "Unable to open '$output' for reading: $!";
printf $out_file $_ for @output_array;
	}
elsif ($#ARGV == 0) {
print STDOUT "@output_array\n";
}
	
print "Finished!\n";