#1/22/20
#A2

#Prompt the user to enter a number (1-7)
day = int(input("Enter a number (1-7) for the day of the week: "))

#create an if-else statement to display the weekday that corresponds to the given number
if day == 1:
    print("Monday")
elif day == 2:
    print("Tuesday")
elif day == 3:
    print("Wednesday")
elif day == 4:
    print("Thursday")
elif day == 5:
    print("Friday")
elif day == 6:
    print("Saturday")
    print("Happy Weekend!")
elif day == 7:
    print("Sunday")
    print("Happy Weekend!")

#Display an error message if the the number is not within the range
elif day < 1 or day > 7:
    print("Error: Please enter a number within the range 1-7")
