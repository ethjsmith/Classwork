.data
.text
addi $t0, $zero, 3 # this is g
addi $t1, $zero, 4 # this is H
#addi $t2, $zero, 5 # this is f, wait I dont need it 

addi $s0, $zero, 1 # This is I
addi $s1, $zero, 2 # This is j 

main:
bne $s0,$s1, minus
beq $s0,$s1, addem
syscall
addem:
add $t2,$t0,$t1
j exit 
minus:
sub $t2,$t0,$t1
j exit
exit:
li $v0, 1
move $a0,$t2
syscall
li $v0, 10
syscall
