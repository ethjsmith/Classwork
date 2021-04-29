.data

noteq: .asciiz "the numbers arenten't not equal"
.text

main:
li $t0, 10
li $t1, 1

bne $t0, $t1, notequ
#beq is the opposite :^) 
li $v0, 10
syscall
notequ:
li $v0, 4
la $a0, noteq
syscall

# j jumps to a label no matter waht
#jr goes to $ra
#jal jumps and sets a link to $ra so you can go back 