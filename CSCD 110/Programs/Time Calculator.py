# Get the number of seconds from the user

total_seconds = float(input("Enter the total number of seconds: "))

# Calculate the hours in total seconds

hours = total_seconds // 3600

# Calculate the minutes remaining

minutes = (total_seconds // 60) % 60

#Calculate the seconds remaining

seconds = total_seconds % 60

# Display hours, minutes, and seconds

print("Hours", hours)
print("Minutes", minutes)
print("Seconds", seconds)
