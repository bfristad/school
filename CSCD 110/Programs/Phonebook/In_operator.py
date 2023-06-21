# Will you be my friend?
def main():
    friends = ['Harry', 'Emily', 'Bob', 'Jeanann']
    print(friends)
    # We can add items to the list
    friends.insert(1, 'Mary')
    # If you want to know whether an element is in a list, you can use the in operator.
    friends.pop(3)
    if 'bob' in friends:
        print('They are our friend')
    else:
        print('We may not be friends, but we can surely be friendly')
    # Sometimes you may want to know the position of an item in a list
    # The index method yields the index of the first match
    n = friends.index('Emily')
main()