# This one uses a while loop to populate the list with numbers
# We will cast the input as floats
def main():
    favorite_numbers =[]
    i = 1
    while i <= 5:
        number = float(input("Please enter a number: "))
        favorite_numbers.append(number)
        i += 1
    print(favorite_numbers)
main()
        
