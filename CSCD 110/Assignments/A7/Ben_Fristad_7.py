# This program will open a file and read the contents
def main():
# Declare variables
    inFile = None
    while inFile is None:
        readFile = input('Enter the name of the file with extention: ')
        try:
            # Open file
            inFile = open(readFile, 'r')
        # Read and store contents
            for i in inFile:
        # Print contents
                print(i.rstrip())
        # Close the file
            inFile.close()
        except FileNotFoundError:
            print('File Not Found')
        except:
            print('An Error Has Occured')
# Call the main function
main()

