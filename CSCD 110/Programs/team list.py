# Create a program that will prompt the user for their favorite teams
#Five teams
def main():
    # Declare our list variable
    favorite_team = []
    # We will use a for loop to gather the teams and populate the list
    for t in range(5):
        team = input("Please enter your favorite team: ")
        favorite_team.append(team)
    print(favorite_team)
    # We can extend one list or combine two lists
    favorite_team.extend(['Sehawks', 'Patriots', 'Knights'])
    print(favorite_team)
main()
