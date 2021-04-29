.data

.text
addi $s0, $zero, 3
addi $s1, $zero, 2
addi $s2, $zero, 1
# int d  = (a * a ) + ( b - c ) ;
mul $s0, $s0, $s0
sub $s1, $s1, $s2
add $a0, $s0, $s1
li $v0, 1
syscall
