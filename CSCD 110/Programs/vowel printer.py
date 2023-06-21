#This code prints the vowels from a string
#Feeling festive
#Prompt the user for their favorite holiday
s = input("What is your favorite holiday: ")

#we need an accumulator variable
vowels = ''
for char in s:
    if char in 'aeiouAEIOU':
        vowels = vowels + char
print(vowels)
