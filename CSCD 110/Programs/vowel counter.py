#This program is going to count the number of vowels in a string
#"Happy Anniversary"
#Five vowels
#'xyx'
#Zero vowels
#Get the string from the user
s = input("Enter your favorite song title: ")

#Walk trhough the string and count the vowel character by character
#We need an accumulator variable
num_vowels = 0
for char in s:
    if char in "aeiouAEIOU":
        num_vowels = num_vowels + 1
print(num_vowels)
