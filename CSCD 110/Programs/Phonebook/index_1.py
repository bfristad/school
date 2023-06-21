# We are going to read the contents of a file
# We will write those contents to three different file
# Last Name, First Name, Phone Number
def main():
    myFile = open("entries.txt", "r")
    # We want to initialize our lists
    lname = []
    fname = []
    phone = []
    count = 1 # The count variable keeps track of the lines
    for line in myFile.read().splitlines():
        if count % 3 == 1: # We are reading the last name fields
            lname.append(line) # Write to file
        elif count % 3 == 2:
            fname.append(line) # Write the first name to the line
        else:
            phone.append(line)
        count += 1
    myFile.close()
    print(lname)
    print(fname)
    print(phone)
main()