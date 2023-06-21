#BMI calculator

# User enters name

name = input("Enter name here: ")

# User enters height

print("Enter height (feet and then remaining inches)")
feet = float(input("Enter height in feet: "))
inches = float(input("Enter remaining inches: "))

# Combine feet and inches and combine into one unit

height_standard = (feet * 12) + inches

# convert height in inches to height in meters (1 inch = .0254 meters)

height_metric = height_standard * .0254

# User enters weight

weight_standard = float(input("Enter weight in lbs: "))

#convert weight in lbs to weight in kilograms (1 pound = 0.453592 kilograms)

weight_metric = weight_standard * 0.453592

# Calculate BMI (kg/m^2)

BMI = int(weight_metric / height_metric ** 2)

#Display results

if BMI < 18.5:
    print(name, "is underweight")
elif 18.5 < BMI < 25:
    print(name, "is normal weight")
else:
    print(name, "is overweight")

#Display BMI

print("Would you like to know your BMI?")
anwser = input("Enter yes or no: ")

if anwser == "yes" :
    print("your BMI is", BMI)
else:
    print("Ok, u a fat hoe.")
