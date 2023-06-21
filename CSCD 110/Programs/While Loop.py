#We need 3 things to sucessfully use a loop

#1 We initiate the sentinal value --> x = 5
x = 5
#2 We need a reachable sentry statement --> x<= 10
while x <= 10:
    print(x)
#3 Morph our sentinal value toward our sentry statement --> x = x + 1
    x = x + 1 
#If we do not have those things
# * Crashes
# * Code in the loop could skip
# * infinite program could be created
