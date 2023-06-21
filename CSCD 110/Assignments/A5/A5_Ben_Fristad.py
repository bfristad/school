# This program will open a file and read the contents
def main():
# Declare variables
    readFile = 'numbers.txt'
# Open file
    inFile = open(readFile, 'r')
# Read and store contents
    for i in inFile:
# Print contents
        print(i.rstrip())
# Close the file
    inFile.close()
# Call the main function
main()
