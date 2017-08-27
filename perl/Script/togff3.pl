#!/usr/bin/perl

use warnings;
use strict;
use POSIX;
use Array::Utils qw(:all);
use List::MoreUtils qw(firstidx);






#read the files
print "Enter your reference file:\n";
my $GFF3_ref = <STDIN>;
chomp $GFF3_ref;
print "Enter your query file:\n";
my $GFF3_que = <STDIN>;
chomp $GFF3_que;
print "Enter Vars file:\n";
my $Vars = <STDIN>;
chomp $Vars;
print "Enter Rifins file:\n";
my $Rifins = <STDIN>;
chomp $Rifins;
print "Enter Stevors file:\n";
my $Stevors = <STDIN>;
chomp $Stevors;




#open the files
open(REF, '<', $GFF3_ref) or
	die "Unable to open '$GFF3_ref' for reading: ";

open(QUE, '<', $GFF3_que) or
	die "Unable to open '$GFF3_que' for reading: ";

open(VARS, '<', $Vars) or
	die "Unable to open '$Vars' for reading: ";

open(RIFINS, '<', $Rifins) or
	die "Unable to open '$Rifins' for reading: ";

open(STEVORS, '<', $Stevors) or
	die "Unable to open '$GFF3_que' for reading: ";
	


#form variables for while loop
my $just_count = 0;
my $exon_count = 0;
my $exon_length = 0;
my $gene_name;
my @gene_name;
my @gene_length;
my @exons;
my @exons_length;
my @protein_length;

#go through each line in the file
while (my $line = <REF>){
	chomp $line;
	#split each line into an array
	my @array = split(' ',$line);
	
	#Using the 3rd index of the line to find out whether it is gene or exon and if it is a gene then print the gene name
	if (defined $array[2]){
		if ($array[2] eq "gene"){
			if ($just_count != 0){
				my $protein_length = floor($exon_length/3);
				push(@exons,$exon_count);push(@exons_length,$exon_length);push(@protein_length,$protein_length);
			}
			$just_count += 1;
			$exon_count = 0;
			$exon_length = 0;
			my $des = $array[8];
			my $name = "Name=";
			my $des_var = ";description";
			my @name = $des =~ /$name(.*?)$des_var/;
			my $length = abs($array[4] - $array[3]) + 1;
			push(@gene_name, $name[0]);push(@gene_length,$length);
			#print "Gene = $name[0]   Gene Length = $length   ";
			}
		}
	#if the 3rd index is exon then add one to the counter of exon
	if (defined $array[2]){
		if ($array[2] eq "exon"){
			$exon_count += 1;
			$exon_length += abs($array[4] - $array[3]) + 1
		}
	}
	
	if ($array[0] eq "##FASTA"){
		my $protein_length = floor($exon_length/3);
		push(@exons,$exon_count);push(@exons_length,$exon_length);push(@protein_length,$protein_length);
		last;
	}	
}



#form variables for while loop
my $just_count_que = 0;
my $exon_count_que = 0;
my $gene_name_que = 0;
my $exon_length_que = 0;
my @gene_name_que;
my @gene_length_que;
my @exons_que;
my @exons_length_que;
my @protein_length_que;


#go through each line in the file
while (my $line_que = <QUE>){
	chomp $line_que;
	#split each line into an array
	my @array_que = split(' ',$line_que);
	
	#Using the 3rd index of the line to find out whether it is gene or exon and if it is a gene then print the gene name
	if (defined $array_que[2]){
		if ($array_que[2] eq "gene"){
			if ($just_count_que != 0){
				my $protein_length_que = floor($exon_length_que/3);
				push(@exons_que,$exon_count_que);push(@exons_length_que,$exon_length_que);push(@protein_length_que,$protein_length_que);
			}
			$just_count_que += 1;
			$exon_count_que = 0;
			$exon_length_que = 0;
			my $des_que = $array_que[8];
			my $name_que = "Name=";
			my $des_var_que = ";";
			my @name_que = $des_que =~ /$name_que\s*(.+)$/;
			my $length_que = abs($array_que[4] - $array_que[3]) + 1;
			push(@gene_name_que, $name_que[0]);push(@gene_length_que,$length_que);
			
			}
		}
	#if the 3rd index is exon then add one to the counter of exon
	if (defined $array_que[2]){
		if ($array_que[2] eq "exon"){
			$exon_count_que += 1;
			$exon_length_que += abs($array_que[4] - $array_que[3]) + 1
		}
	}
		if ($array_que[0] eq "##FASTA"){
		my $protein_length_que = floor($exon_length_que/3);
		push(@exons_que,$exon_count_que);push(@exons_length_que,$exon_length_que);push(@protein_length_que,$protein_length_que);
		last;
	}	
	
}

		my $protein_length_que = floor($exon_length_que/3);
		push(@exons_que,$exon_count_que);push(@exons_length_que,$exon_length_que);push(@protein_length_que,$protein_length_que);


#Write the results file
open(my $out_file, '>', "Results.txt") or
	die "There was a permission error";
#Report the number of genes in the reference file
print $out_file "The number of genes in the reference file is: $just_count\n";
#Report the number of genes in the query file
print $out_file "The number of genes in the query file is: $just_count_que\n";
print $out_file "\n";

#Determine which genes are not present in the query file
my @minus = array_minus(@gene_name,@gene_name_que);
my $length_minus = scalar(@minus);
printf $out_file "\nGenes that are not present in the query file: $length_minus\n";

foreach my $min_var (@minus){
	print $out_file "$min_var\n";

}
printf $out_file "\n";


#Set up variables to determine gene duplications in query file
my $uniq_dup = 0;
my %seen_ = ();
my @dup = map { 1==$seen_{$_}++ ? $_ : () } @gene_name_que;
foreach my $du (@dup){
	$uniq_dup += 1;
}


my %seen;
printf $out_file "\nGENE DUPLICATION IN QUERY\n";
printf $out_file "Unique duplications: $uniq_dup\n";
printf $out_file "Duplicated Gene:Count \n";




my %count;
$count{$_}++ foreach @gene_name_que;
my $uniq_count = 0;
#removing the lonely strings
while (my ($key, $value) = each(%count)) {
    if ($value == 1) {
        delete($count{$key});
    }
}

#output the counts
while (my ($key, $value) = each(%count)) {
    print $out_file "$key:$value\n";    
}



printf $out_file "\n\n%-16s          %-13s %-13s %-13s %-13s\n","[gene name]","[gene length diff]","[exons diff]","[exon length diff]","[protein length diff]";

my @same_gene;
my @gene_diff;
my @exon_diff;
my @exon_length_diff;
my @protein_diff;


foreach my $gene (@gene_name){
	foreach my $gene_que (@gene_name_que){
	if (defined $gene_que){
		if ($gene eq $gene_que){
			my $index = firstidx{ $_ eq $gene} @gene_name;
            my $index_que = firstidx{ $_ eq $gene_que} @gene_name_que;
			push(@same_gene,$gene);
			my $gene_subtraction = abs($gene_length[$index] - $gene_length_que[$index_que]);
			push (@gene_diff, $gene_subtraction);
			my $exon_subtraction = abs($exons[$index]-$exons_que[$index_que]);
			push (@exon_diff,$exon_subtraction);
			my $exon_length_subtraction = abs($exons_length[$index]-$exons_length_que[$index_que]);
			push (@exon_length_diff,$exon_length_subtraction);
			my $protein_subtraction = abs($protein_length[$index] - $protein_length_que[$index_que]);
			push (@protein_diff, $protein_subtraction);
		}
		}
	}
}


foreach my $gene (@same_gene){
	my $index_ = firstidx{$_ eq $gene} @same_gene;
	printf $out_file "%-24s          %-16s %-14s %-18s %-22s\n",$gene, $gene_diff[$index_], $exon_diff[$index_], $exon_length_diff[$index_], $protein_diff[$index_];
}








#Determine how many vars are present in the query file
my @array_vars;
while (my $line_vars = <VARS>){
	$line_vars =~ s/\R//g;
	push(@array_vars,$line_vars);
}



my $vars_count = 0;
my @vars_match;
#What the heck this doesn't even make sense
foreach my $vars_all (@array_vars){
	foreach my $gene (@gene_name_que){
		if ($vars_all eq $gene){
			$vars_count += 1;
			push(@vars_match, $vars_all);
		}
	}
}



printf $out_file "\nThe number of vars present in query file = $vars_count\n";
my %count_;
$count_{$_}++ foreach @vars_match;
my $uniq_count_ = 0;
#removing the lonely strings
while (my ($key_, $value_) = each(%count_)) {
    if ($value_ == 1) {
        delete($count_{$key_});
    }
}


my $my_vars_uniq;
#output the counts
while (my ($key_, $value_) = each(%count_)) {
    print $out_file "$key_:$value_\n";  
    $my_vars_uniq += 1;  
}



print $out_file "vars unique count = $my_vars_uniq\n";





#Determine how many rifins are present in the query file
my @array_rifs;
while (my $line_rifs = <RIFINS>){
	$line_rifs =~ s/\R//g;
	push(@array_rifs,$line_rifs);
}



my $rifs_count = 0;
my @rifs_match;
#What the heck this doesn't even make sense
foreach my $rifs_all (@array_rifs){
	foreach my $gene (@gene_name_que){
		if ($rifs_all eq $gene){
			$rifs_count += 1;
			push(@rifs_match, $rifs_all);
		}
	}
}



printf $out_file "\nThe number of rifins present in query file = $rifs_count\n";
my %count__;
$count__{$_}++ foreach @rifs_match;
my $uniq_count__ = 0;
#removing the lonely strings
while (my ($key__, $value__) = each(%count__)) {
    if ($value__ == 1) {
        delete($count__{$key__});
    }
}

#output the counts
my $my_rifins_uniq;
while (my ($key__, $value__) = each(%count__)) {
    print $out_file "$key__:$value__\n";  
    $my_rifins_uniq += 1;  
}


print $out_file "rifins unique count = $my_rifins_uniq\n";







#Determine how many STEVORS  are present in the query file
my @array_stev;
while (my $line_stev = <STEVORS>){
	$line_stev =~ s/\R//g;
	push(@array_stev,$line_stev);
}



my $stev_count = 0;
my @stev_match;
#What the heck this doesn't even make sense
foreach my $stev_all (@array_stev){
	foreach my $gene (@gene_name_que){
		if ($stev_all eq $gene){
			$stev_count += 1;
			push(@stev_match, $stev_all);
		}
	}
}



printf $out_file "\nThe number of stevors present in query file = $stev_count\n";
my %count___;
$count___{$_}++ foreach @stev_match;
my $uniq_count___ = 0;
#removing the lonely strings
while (my ($key___, $value___) = each(%count___)) {
    if ($value___ == 1) {
        delete($count___{$key___});
    }
}

#output the counts
my $my_stevors_uniq;
while (my ($key___, $value___) = each(%count___)) {
    print $out_file "$key___:$value___\n";
    $my_stevors_uniq += 1;    
}


print $out_file "stevors unique count = $my_stevors_uniq\n";






























print "The output has been saved as Results.txt in the current directory.\n";


close REF;
close QUE;
close $out_file;
close VARS;
close RIFINS;
close STEVORS;

