#addi $gp, $zero, 400

#lw $s2, 4($gp)
#lw $s3, 9($gp)
#add $s1, $s2, $s3
#sw $s1, $gp

.data
newline: .asciiz "\n"

.text

li, $s0,10
move $a0, $s0
li $v0, 1
syscall
# printing a newline LOL 
la $a0, newline
li $v0, 4
syscall

li $v0, 10
syscall
jal useS0

useS0:
#allocate stack memree  1 var 
addi $sp, $sp, -4 # allocates a space for a variable in the S T A C K 
sw $s0, 0($sp) # put whatevers in s0 into the variable space
li $s0, 20
move $a0, $s0
li $v0, 1
syscall
# printing a newline LOL 
la $a0, newline
li $v0, 4
syscall
# de allocate the memory :^)
lw $s0 , 0($sp)
addi $sp,$sp, 4 


