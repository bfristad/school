# We are going to write files
# When you do this, BE CAREFUL! you can lose data.
readFile  = 'myFile.txt'
outFile = open(readFile, 'w')
#Add some content
i = 0
while i < 100:
    outFile.write("This is a line " + str(i) + '.\n')
    print("This is line " + str(i))
    i += 1
outFile.close()
#read the file
inputFile = open(readFile, 'r')
for mystr in inputFile:
    print(mystr.rstrip())
inputFile.close()
# We can add to out file by using the append mode 'a'
appendFile = open(readFile, 'a')
i = 1
while i < 5:
    appendFile.write("This is append line " + str(i + 10) + '\n')
    print(i)
    i += 1
appendFile.close()
# Read the file again
inputFile = open(readFile, 'r')
for myStr in inputFile:
    print(myStr.strip())
inputFile.close()
