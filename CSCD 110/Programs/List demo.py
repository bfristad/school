# We are working with lists
# Lists are an example of a sequence
def main():
    L = []
# We can add a topic to our list
    L.append("Zika")
    print(L)
# We can add some more gloom
    L.append("Ebola")
    print(L)
# Create a new list
    L = ["Zika", "Corona", "Ebola"]
    print(L)
# Add one more
    L.append("Corona")
    print(L)
# We can count the instances of an object
    print(L.count("Corona"))
# We can insert an object in a spot
    L.insert(2, "Spanish Flu")
    print(L)
# We can remove an object at the end of a list and return a value to a variable
    x = L.pop()
    print(L, '--', x)
# We can remove an item
    L.remove("Spanish Flu")
    print(L)
# We can sort
    L.sort()
    print(L)
# We can reverse it
    L.reverse()
    print(L)

main()
