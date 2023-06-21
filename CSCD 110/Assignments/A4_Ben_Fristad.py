# extra credit was attempted
CONVERT_FAHRENHEIT_TO_CELSIUS = 1
CONVERT_CELSIUS_TO_FAHRENHEIT = 2
CONVERT_FEET_TO_METERS = 3
CONVERT_METERS_TO_FEET = 4
REVERSE = 5
QUIT = 0
# define the main function
def main():
# create a menu
    choice = None
    while choice != QUIT:
        display_menu() #call a funtion that displays a variable
        choice = int(input('select one of the options above(1-5): '))
        if choice == CONVERT_FAHRENHEIT_TO_CELSIUS:
            temp = float(input("Please enter a temperature in Fahrenheit: "))
            print(temp, 'degrees Fahrenheit is equal to',convert_fahrenheit_to_celsius(temp), 'degrees Celsius')
        elif choice == CONVERT_CELSIUS_TO_FAHRENHEIT:
            temp = float(input("Please enter a temperature in Celsius: "))
            print(temp, 'degrees Celsius is equal to', convert_celsius_to_fahrenheit(temp), 'degrees Fahrenheit')
        elif choice == CONVERT_FEET_TO_METERS:
            distance = float(input("Please enter a measurement in feet: "))
            print(distance, 'feet is equal to', convert_feet_to_meters(distance), 'meters')
        elif choice == CONVERT_METERS_TO_FEET:
            distance = float(input("Please enter a measurement in meters: "))
            print(distance, 'meters is equal to', convert_meters_to_feet(distance), 'feet')
        elif choice == REVERSE:
            phrase = input("Please enter a word or number: ")
            print(phrase, 'printed backwords is', reverse(phrase))
        else:
            print('[ERROR] please enter a number within the domain')
def display_menu():
    print("______________[MENU]______________")
    print('1. Convert Fahrenheit to Celsius')
    print('2. Convert Celsius to Fahrenheit')
    print('3. Convert feet to meters')
    print('4. Convert meters to feet')
    print('5. Display a phrase or number backwards')
    print('[PRESS 0 TO END THE PROGRAM]')
# define the first function
def convert_fahrenheit_to_celsius(fahrenheit):
    '''
    number --> number
    This function converts a temperature measured in fahrenheit and converts it to celsius
    >>>convert_fahrenheit_to_celsius(32)
    >>>0.0
    >>>convert_fahrenheit_to_celsius(-40)
    >>>-40.0
    '''
    return (fahrenheit - 32) * (5/9)
# define the second funtion
def convert_celsius_to_fahrenheit(celsius):
    '''
    number --> number
    This function converts a temperature measured in celsius and converts it to fahrenheit
    >>>convert_celsius_to_fahrenheit(0)
    >>>32.0
    >>>convert_celsius_to_fahrenheit(-40)
    >>>-40.0'''
    return (celsius * (9/5)) + 32
# define the third function
def convert_feet_to_meters(feet):
    '''
    number --> number
    This function converts a distance measured in feet to meters
    >>>convert_feet_to_meters(1)
    >>>0.3048
    >>>convert_feet_to_meters(10)
    >>>3.048
    '''
    return feet / 3.281
# define the fourth function
def convert_meters_to_feet(meters):
    '''
    number --> number
    This function converts a distance measured in meters to feet
    >>>convert_meters_to_feet(0.3048)
    >>>1.0
    >>>convert_meters_to_feet(3.048)
    >>>10.0
    '''
    return meters * 3.281
# define the fifth function
def reverse(phrase):
    string = ""
    for i in phrase:
        string = i + string
    '''
    string or int --> string or int
    This function will print a string or int in reverse
    >>>reverse(happy)
    >>>yppah
    >>>reverse(sad)
    >>>das
    >>>123
    >>>321
    '''
    return string
main()
