# Define main function
def main():
    # Initialize the list
    L = []
    # Prompt the user to enter the number of values
    x = int(input("Enter the number of values: "))
    for i in range(1,x + 1):
        num = input("Enter a number: ")
        L.append(num)
    print(L)
    
main()
    
