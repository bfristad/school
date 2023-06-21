num1 = int(input('Enter the a number: '))
num2 = int(input('Enter another number: '))
remainder = 0
while num2 != 0:
    remainder = num1 % num2
    num1 = num2
    num2 = remainder
print('The GCD is', num1)
