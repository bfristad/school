# this program compares the area of 2 rectangles
# declare variables
length1 = 0.0
length2 = 0.0
width1 = 0.0
width2 = 0.0
area1 = 0.0
area2 = 0.0
# ask user to input the dimensions of the rectangles
length1 = float(input('Enter the length of the first rectangle: '))
width1 = float(input('Enter the width of the first rectangle: '))
length1 = float(input('Enter the length of the second rectangle: '))
width2 = float(input('Enter the width of the second rectangle: '))
# calculate the area of the rectangles
area1 = length1 * width1
area2 = length2 * width2

if area1 == area2:
    print('The areas are the same')
elif area1 > area2:
    print('area 1 is greater than area 2')
else:
    print('area 2 is greater than area 1')
