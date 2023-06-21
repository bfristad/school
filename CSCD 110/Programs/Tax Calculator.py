#Tax Calculator

#Get the tax rate from the user

tax = float(input("Enter tax rate:"))

#Convert the tax rate to a percentage

tax_rate = tax /100

#Get the price of the item

item_price = float(input("Enter Price of Item:"))

#Calculate the total price

total_price = tax_rate * item_price + item_price

#Display the total price

print("the total price of your purchase is", format(total_price, '.2f'))

