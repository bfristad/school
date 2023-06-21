# Ben Fristad
# Mr. Lemelin
# CSCD 110
# 1/31/20
# A3
# this program will display a menu that shows different ways of counting

# define menu choices
QUIT = 0
OPTION_1 = 1
OPTION_2 = 2
OPTION_3 = 3
OPTION_4 = 4
OPTION_5 = 5
# initalize the choice variable
choice = None
# create loop that contain the menu
while choice != QUIT:
    print("1. Count from one number to another in increments of 5")
    print("2. Count from one number to another in increments of 7")
    print("3. Add the numbers 210 to 235")
    print("4. Print the phrase with one letter per line")
    print("5. Print a list of integers within a range")
    print("[Press 0 to end the program]") 
# prompt the user for their choice
    choice = int(input("Please enter a choice between 0 and 5: "))
# create a while loop that counts from one number to another in increments of 5
    if choice == OPTION_1:
        num1 = int(input("Enter the starting number: "))
        MAX = int(input("Enter the ending number: "))
        while num1 <= MAX:
            print(num1)
            num1 = num1 + 5
# create a while loop that counts from one number to another in increments of 7
    if choice == OPTION_2:
        num1 = int(input("Enter the starting number: "))
        MAX = int(input('Enter the ending number: '))
        while num1 <= MAX:
            print(num1)
            num1 = num1 + 7
# create a while loop that adds the numbers from 210 to 235
    if choice == OPTION_3:
        num1 = 210
        while num1 <= 235:
            print(num1)
            num1 += 1

# create a for loop that prints a phrase one letter per line
    if choice == OPTION_4:
        word = input("Enter a word: ")
        for char in word:
            print(char)
# create a for loop that prints all integers in the range that the user inputs
    if choice == OPTION_5:
        MIN = int(input("Enter the starting number: "))
        MAX = int(input("Enter the ending number: ")) + 1
        for num in range(MIN,MAX):
            print(num)
# create an error message if the user enters a number out of the domain
    if choice < 0 or choice > 5:
        print("Error: Please enter a number within the domain")
            
                
                 
   


