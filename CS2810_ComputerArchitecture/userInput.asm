.data
prompt: .asciiz "please enter an integer: "
output: .asciiz "You have entered: "
dprompt: .asciiz "please enter a double: "
sprompt: .asciiz "please enter your name: "
userInput: .space 20
.text

#
#	INT TIME 
#
li $v0, 4
la $a0, prompt 
syscall

# get user input here 
li $v0, 5
syscall

move $t0, $v0

li $v0, 4
la $a0, output 
syscall
li $v0, 1
move $a0, $t0
syscall
#
#	DOUBLE 
#
# double time
li $v0, 4
la $a0, dprompt 
syscall

li $v0, 7
syscall
# it's gotta be in register 12 for some reason idk lol 
add.d $f12, $f0, $f4

li $v0, 4
la $a0, output 
syscall

li $v0, 3
syscall
#
#	DOING A WORD
#
# now it's word time . . .
li $v0, 4
la $a0, sprompt 
syscall

# get 20 characters
li $v0,8 
la $a0, userInput
li $a1, 20
syscall

li $v0, 4
la $a0, output 
syscall

li $v0, 4
la $a0, userInput 
syscall