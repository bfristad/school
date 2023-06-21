# Initalize global constants
LAST_NAME = 1
FIRST_NAME = 2
PHONE_NUMBER =3
QUIT = 0
# Create a function that searches for last names
def lname_search(lname, fname, phone):
    name = input("please enter the last name you wish to look up: ")
    name = name.rstrip().lower() # Makes it uniform
    pointer = 1 # Gives the index
    if name in lname:

        while True:
            try:
                pointer = lname.index(name,pointer)
                print(fname[pointer].title())
                print(lname[pointer].title())
                print(phone[pointer])
                pointer += 1
            except:
                break
    else:
        print('No entry found')
# Create a function that searches for first names  
def fname_search(lname, fname, phone):
    name = input("please enter the first name you wish to look up: ")
    name = name.rstrip().lower() # Makes it unifrom
    pointer = 1 # Gives the index
    if name in fname:

        while True:
            try:
                pointer = fname.index(name,pointer)
                print(fname[pointer].title())
                print(lname[pointer].title())
                print(phone[pointer])
                pointer += 1
            except:
                break
    else:
        print('No entry found')
# Create a function that searches for phone numbers
def phone_search(lname, fname, phone):
    number = input("please enter the phone number name you wish to look up: ")
    number = number.rstrip().lower() # Makes it unifrom
    pointer = 1 # Gives the index
    if number in phone:

        while True:
            try:
                pointer = phone.index(number,pointer)
                print(fname[pointer].title())
                print(lname[pointer].title())
                print(phone[pointer])
                pointer += 1
            except:
                break
    else:
        print('No entry found')
# Display a menu
def menu():
    print('________DATABASE_MENU________')
    print('1. Last Name')
    print('2. First Name')
    print('3. Phone Number')
    choice = (input('Please enter a number: '))
    return int(choice)

# Create a function that sends the data to the corresponding function
def do_user_action(choice, lname, fname, phone):
    if choice == 1:
        lname_search(lname, fname, phone)
    elif choice == 2:
        fname_search(lname, fname, phone)
    elif choice == 3:
        phone_search(lname, fname, phone)
    else:
        print("Error: invalid perameter")

# Create a function that orgainzes the data into seperate lists
def get_lists(filename):
    myFile = open(filename, 'r')
    # We want to initialize our lists
    lname = []
    fname = []
    phone = []
    count = 1 # The count variable keeps track of the lines
    for line in myFile.read().splitlines():
        if count % 3 == 1: # We are reading the last name fields
            lname.append(line.lower()) # Write to file
        elif count % 3 == 2:
            fname.append(line.lower()) # Write the first name to the line
        else:
            phone.append(line)
        count += 1
    myFile.close()
    return lname, fname, phone

# Create a main function that calls all the functions above and uses a loop to repeat the program   
def main():
    lname, fname, phone = get_lists("entries.txt")
    #print(lname)
    #print(fname)
    #print(phone)
    choice = menu()
    while choice != QUIT:
        do_user_action(choice, lname, fname, phone)
        choice = menu()
    
main()

