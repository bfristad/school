#This program will create a menu with choices for the user
#Define our menu choices
#Fun list of winter activities
QUIT = 0
go_to_movies = 1
snowboard = 2
stay_home = 3
bowl = 4
#Initailize our choice variable so our menu displays at least once
choice = 7

while choice != QUIT:
    print("please enter a choice a from the menu\n"\
          "1. Go to the movies")
    print("2. Go snowboarding")
    print("3. Stay home")
    print("4. Go bowling")
    print("To end the program, press 0")
    
#Prompt the user for their choice
    choice = int(input("Please enter a choice between 0 and 4: "))
    if choice == go_to_movies:
        print("Get yah popcorn")
    elif choice == snowboard:
        print("Don't fall down the mountain.")
    elif choice == stay_home:
        print("Get a life.")
    elif choice == bowl:
        print("Bring a flask")
    elif choice == QUIT:
        print("see you later!")
    else:
        print("Error: please enter a number from 0 to 4")
    
