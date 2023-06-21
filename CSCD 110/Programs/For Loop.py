# For loops are count controlled loops
# iterates a specific number of times
# We use a for statement to write the loop
# For loops work with a sequence of data or a collection of data items
# Collection is a data type that contains individual members
# A string is a collection of characters (which are 1 character strings)
#
#General format
# for variable in [val1, val2, val3, etc]:
#   Statements
name = "Bob"
for char in name:
    print(char)
#List of collections are:
#strings
#lists
#tuples
#dictionary
#range
word = input("enter a word: ")
for letter in word: #letter is the target variable
    print(letter)
    print("*")
#range: generates a sequence of numbers

nums = range(1,11,1)
print(list(nums))
nums = range(10)
print(list(nums))
nums = range(100,105)
print(list(nums))
for num in range(100,120,4):
    print(num)

total = 0
for num in range(1,101):
    total += num
    print(total)
