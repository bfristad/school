# the recpie for the design of functions

# [1] example
# what should our function do?
# type up a couple example calls
# pick a name (often a verb or verb phrase)
# what is a short anwser to "What does your function do?

# [2] type contract
# what are the parameter types?
# what type of value is returned

# [3] type up the header
# pick meaningful parameter names

# [4] write description
# mention every parameter in the description
# describe the return value

# [5] body

# [6] test the funtion

# we use functions to solve problems
# we are going to Canada.
def convert_to_celsius(fahrenheit):

    ''' (number) --> number

    return the number of degrees celsius equivalent to degrees fahrenheit

    >>>convert_to_celsius(-40)
    >>>-40.0
    >>>convert_to_celsius(32)
    >>>0.0
    >>>convert_to_celsius(212)
    >>>100.0

    '''
    return (fahrenheit - 32) * 5/9
    
