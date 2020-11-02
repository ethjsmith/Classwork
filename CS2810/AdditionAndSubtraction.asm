.data
# memory access is bad, so we dont want these
#n1: .word 12
#n2: .word 13

di: .asciiz "division is :"
re: .asciiz "Remainder is :"
.text

#lw $t0, n1
#lw $t1, n2

# a registers are the arguments related to opcodes

# add them and save result in t2
# doing this avoids memory access 
addi $t0, $zero, 2
addi $t1, $zero, 8
#add $t2,$t0,$t1
# doing this saves a register, which is also faster 
add $a0,$t0,$t1

# load the opcode for "print integer" 
li $v0, 1
# load our number into the correct argument for the opcode
#add $a0, $t2, $zero
#syscall
# mars has a move thingy, dope ( not a mips instruction, but a sudocode instruction I suppose ) basically the same as adding plus zero on line 23
move $s1, $a0
sub $a0,$t0,$t1
#syscall
# MULTIPLICATION
mul $a0,$t0,$t1
#syscall
srl $a0,$t1,1
syscall

addi $s0, $zero, 10
addi, $s1, $zero, 3
div $s0, $s1 # this is different :^( 
li $v0, 4
la $a0, di
syscall
li $v0, 1
mflo $a0
syscall
li $v0, 4
la $a0, re
syscall
li $v0, 1
mfhi $a0
syscall