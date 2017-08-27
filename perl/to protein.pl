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

#read the nucleotide file and subtract all the spaces
while (my $line = <NUC>){
	$line =~s/^\s+//;
	my @sub_line = $line;
	my $word = join('',@sub_line);
	my @array = split('',$word);
	if (grep{$_ eq ">" } @array){
		my $str = join('',@temp_array);
		$str =~ tr/\n//d;
		my @nuc_array = split('',$str);
		my @final_amino = ();
		
		
		#replace the DNA with amino acid
		while (my ($i,$j,$k) = splice(@nuc_array,0,3)){
		
			my @amino_array = ();
			if ($i){
				push (@amino_array,$i);
			}
			if ($j){
				push (@amino_array, $j);
			}
			if ($k){
				push (@amino_array, $k);
			}
			my $amino_str = join('',@amino_array);
			
			
			if ($amino_str =~ /ATT/i || $amino_str =~ /ATC/i || $amino_str =~ /ATA/i){
				push (@final_amino, "I");
			}
			if ($amino_str =~ /CTT/i || $amino_str =~ /CTC/i || $amino_str =~ /CTA/i || $amino_str =~ /CTG/i || $amino_str =~ /TTA/i || $amino_str =~ /TTG/i ){
				push (@final_amino, "L");
			}
			if ($amino_str =~ /GTT/i || $amino_str =~ /GTC/i || $amino_str =~ /GTA/i || $amino_str =~ /GTG/i  ){
				push (@final_amino, "V");
			}
			if ($amino_str =~ /TTT/i || $amino_str =~ /TTC/i ){
				push (@final_amino, "F");
			}
			if ($amino_str =~ /ATG/i ){
				push (@final_amino, "M");
			}
			if ($amino_str =~ /TGT/i || $amino_str =~ /TGC/i ){
				push (@final_amino, "C");
			}
			if ($amino_str =~ /GCT/i || $amino_str =~ /GCC/i || $amino_str =~ /GCA/i || $amino_str =~ /GCG/i  ){
				push (@final_amino, "A");
			}
			if ($amino_str =~ /GGT/i || $amino_str =~ /GGC/i || $amino_str =~ /GGA/i || $amino_str =~ /GGG/i  ){
				push (@final_amino, "G");
			}
			if ($amino_str =~ /CCU/i || $amino_str =~ /CCC/i || $amino_str =~ /CCA/i || $amino_str =~ /CCG/i  ){
				push (@final_amino, "P");
			}
			if ($amino_str =~ /ACT/i || $amino_str =~ /ACC/i || $amino_str =~ /ACA/i || $amino_str =~ /ACG/i  ){
				push (@final_amino, "T");
			}
			if ($amino_str =~ /TCT/i || $amino_str =~ /TCC/i || $amino_str =~ /TCA/i || $amino_str =~ /TCG/i || $amino_str =~ /AGT/i || $amino_str =~ /AGC/i ){
				push (@final_amino, "S");
			}
			if ($amino_str =~ /TAT/i || $amino_str =~ /TAC/i ){
				push (@final_amino, "Y");
			}
			if ($amino_str =~ /GTT/i ){
				push (@final_amino, "W");
			}
			if ($amino_str =~ /CAA/i || $amino_str =~ /CAG/i ){
				push (@final_amino, "Q");
			}
			if ($amino_str =~ /AAT/i || $amino_str =~ /AAC/i ){
				push (@final_amino, "N");
			}
			if ($amino_str =~ /CAT/i || $amino_str =~ /CAC/i ){
				push (@final_amino, "H");
			}
			if ($amino_str =~ /GAA/i || $amino_str =~ /GAG/i ){
				push (@final_amino, "E");
			}
			if ($amino_str =~ /GAT/i || $amino_str =~ /GAC/i ){
				push (@final_amino, "D");
			}
			if ($amino_str =~ /AAA/i || $amino_str =~ /AAG/i ){
				push (@final_amino, "K");
			}
			if ($amino_str =~ /CGT/i || $amino_str =~ /CGC/i || $amino_str =~ /CGA/i || $amino_str =~ /CGG/i || $amino_str =~ /AGA/i || $amino_str =~ /AGG/i ){
				push (@final_amino, "R");
			}
			if ($amino_str =~ /TAA/i || $amino_str =~ /TAG/i || $amino_str =~ /TGA/i){
				push (@final_amino, "-");
			}
			
		}

		push (@output_array, @final_amino);
		
		
		if (@temp_array != 0){
				push (@output_array,"\n");
		}
		push (@output_array, "\n");
		push (@output_array,@sub_line);
		@temp_array = ();

		
	}
	else {
		my $nuc_line = join('',@sub_line);
		$nuc_line =~ s/^\s+//;
		push (@temp_array,$nuc_line);	
	}

}


#replace the DNA with amino acid
my $str = join('',@temp_array);
$str =~ tr/\n//d;
my @nuc_array = split('',$str);
my @final_amino = ();
		while (my ($i,$j,$k) = splice(@nuc_array,0,3)){
			my @amino_array = ();
			if ($i){
				push (@amino_array,$i);
			}
			if ($j){
				push (@amino_array, $j);
			}
			if ($k){
				push (@amino_array, $k);
			}

			my $amino_str = join('',@amino_array);
			if ($amino_str =~ /ATT/i || $amino_str =~ /ATC/i || $amino_str =~ /ATA/i){
				push (@final_amino, "I");
			}
			if ($amino_str =~ /CTT/i || $amino_str =~ /CTC/i || $amino_str =~ /CTA/i || $amino_str =~ /CTG/i || $amino_str =~ /TTA/i || $amino_str =~ /TTG/i ){
				push (@final_amino, "L");
			}
			if ($amino_str =~ /GTT/i || $amino_str =~ /GTC/i || $amino_str =~ /GTA/i || $amino_str =~ /GTG/i  ){
				push (@final_amino, "V");
			}
			if ($amino_str =~ /TTT/i || $amino_str =~ /TTC/i ){
				push (@final_amino, "F");
			}
			if ($amino_str =~ /ATG/i ){
				push (@final_amino, "M");
			}
			if ($amino_str =~ /TGT/i || $amino_str =~ /TGC/i ){
				push (@final_amino, "C");
			}
			if ($amino_str =~ /GCT/i || $amino_str =~ /GCC/i || $amino_str =~ /GCA/i || $amino_str =~ /GCG/i  ){
				push (@final_amino, "A");
			}
			if ($amino_str =~ /GGT/i || $amino_str =~ /GGC/i || $amino_str =~ /GGA/i || $amino_str =~ /GGG/i  ){
				push (@final_amino, "G");
			}
			if ($amino_str =~ /CCT/i || $amino_str =~ /CCC/i || $amino_str =~ /CCA/i || $amino_str =~ /CCG/i  ){
				push (@final_amino, "P");
			}
			if ($amino_str =~ /ACT/i || $amino_str =~ /ACC/i || $amino_str =~ /ACA/i || $amino_str =~ /ACG/i  ){
				push (@final_amino, "T");
			}
			if ($amino_str =~ /TCT/i || $amino_str =~ /TCC/i || $amino_str =~ /TCA/i || $amino_str =~ /TCG/i || $amino_str =~ /AGT/i || $amino_str =~ /AGC/i ){
				push (@final_amino, "S");
			}
			if ($amino_str =~ /TAT/i || $amino_str =~ /TAC/i ){
				push (@final_amino, "Y");
			}
			if ($amino_str =~ /GTT/i ){
				push (@final_amino, "W");
			}
			if ($amino_str =~ /CAA/i || $amino_str =~ /CAG/i ){
				push (@final_amino, "Q");
			}
			if ($amino_str =~ /AAT/i || $amino_str =~ /AAC/i ){
				push (@final_amino, "N");
			}
			if ($amino_str =~ /CAT/i || $amino_str =~ /CAC/i ){
				push (@final_amino, "H");
			}
			if ($amino_str =~ /GAA/i || $amino_str =~ /GAG/i ){
				push (@final_amino, "E");
			}
			if ($amino_str =~ /GAT/i || $amino_str =~ /GAC/i ){
				push (@final_amino, "D");
			}
			if ($amino_str =~ /AAA/i || $amino_str =~ /AAG/i ){
				push (@final_amino, "K");
			}
			if ($amino_str =~ /CGT/i || $amino_str =~ /CGC/i || $amino_str =~ /CGA/i || $amino_str =~ /CGG/i || $amino_str =~ /AGA/i || $amino_str =~ /AGG/i ){
				push (@final_amino, "R");
			}
			if ($amino_str =~ /TAA/i || $amino_str =~ /TAG/i || $amino_str =~ /TGA/i){
				push (@final_amino, "-");
			}
		}



#the last string of sequence did not get written in the above while loop so here just to add it into an array
push (@output_array, @final_amino);



#check to see if there was a second argument given, if so then print it out to a file, if not then print it out to shell
if ($#ARGV == 1){
open(my $out_file, '>', $output) or
	die "There was a permission error";
splice @output_array,0,1;
printf $out_file $_ for @output_array;
	}


elsif ($#ARGV == 0) {
my $out_str = join('',@output_array);
print STDOUT "$out_str\n";
}



#the script ran succesfully
print "\nFinished!\n";
