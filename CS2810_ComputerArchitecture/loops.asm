.data
.text
addi $t0, $zero, 3 # this is g
addi $t1, $zero, 4 # this is H
#addi $t2, $zero, 5 # this is f, wait I dont need it 

addi $s0, $zero, 1 # This is I
addi $s1, $zero, 10 # This is j 

main:

loop:
addi $s0, $zero, 1
li $v0, 1
move $a0, $s0 
syscall
bne $s0, $s1, loop