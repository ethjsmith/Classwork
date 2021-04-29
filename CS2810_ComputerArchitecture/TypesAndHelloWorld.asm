.data
message: .asciiz "Hello World \n" # newline ascii character 
message2: .asciiz "Message 2\n"

number: .word 69
char: .byte 'F'

numFloat: .float 1.5

dubs: .double 1.69
zerodub: .double 0.0
.text

# this is a Comment 
li $v0, 4
la $a0, message
syscall

li $v0, 4
la $a0, message2
syscall

li $v0, 1
lw $a0, number
syscall

li $v0, 4
la $a0, char
syscall

# print and load a float
li $v0, 2
lwc1 $f12, numFloat
syscall
# prints and loads a double... they take two registers instead of one 
# the registers must be even because doubles take two registers to store
ldc1 $f0, dubs
ldc1 $f2, zerodub
# double in one register, zero in another 
li $v0 3
add.d $f12,$f0,$f2
syscall