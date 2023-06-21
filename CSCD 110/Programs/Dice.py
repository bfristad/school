#This program simulates the rolling of a dice
#We need a tool that will generate a random number
import random
#We will use some constants for our minimum and maximum number
MIN = 1
MAX = 6
#Cerate a variable to control our loop
again = 'y' or 'Y'
#Simulate rolling the dice
while again == 'y' or again == 'Y':
    print("Rolling the dice...")
    print("Their values are: ")
    print(random.randint(MIN,MAX))
    print(random.randint(MIN,MAX))
    again = input("Roll them again? (y = yes)")

