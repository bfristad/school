# This program shows how to read text from a file.
# Create a small text file and save to the same folder as the .py file
# I use a variable to keep track of the filename
myFile = 'country_road_lyrics.txt'
# We will open the file and read some characters
fileInput = open(myFile, 'r')
myString = fileInput.read(7)
print(myString)
pause = input("We opened the file and read the first seven characters")
myString = fileInput.read(11)# The cursor wil advance
print(myString)
pause = input("The program read the next 11 characters")
# We can reset the cursor to the beginning of the document
fileInput.seek(0)
myString = fileInput.read(10)
print(myString)
print('')
print('')
fileInput.close()
# We will open the file and print by line
fileInput = open(myFile, 'r')
myString = fileInput.readline() # Reads until it finds \n
print(myString)
fileInput.close()
# We will open the file and print the whole thin
