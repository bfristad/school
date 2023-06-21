# This program asks the user to enter a series of 5 numbers. The program should store the numbers in a list and then display the following
# the entire list
# min
# max
# total numbers
# average
def main():
    # Declare list variable
    L = []
    # Gather numbers to populate the list
    for i in range(5):
        num = int(input("Please enter a number: "))
        L.append(num)
    # Display the entire list
    print(L)
    # Display the min
    print('The smallest number is', min(L))
    # Display the max
    print('The largest number is', max(L))
    # Display the total number of values
    print('The sum is', sum(L))
    # Display the average
    print('The average is', sum(L) / len(L))
main()
