# Our data outside is not trustworthy.
# This program will prompt the user for the filename, open the file and print content
def main():
    try:
        filename = input("Enter the name of the file: ")
        file_input = open(filename, 'r')
        content = file_input.read()
        print(content)
        file_input.close()
    except FileNotFoundError as err:
        print("Error occured")
    else:
        print("This only happens with no errors")
    finally:
        print("This always happens")


main()
