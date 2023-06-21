'''Flights are scheduled to land at a specific time
Flights are also estimated to land at a specific time
Flights can be ontime, early, or delayed.
preconcept
0.0 <= scheduled_time < 24
0.0 <= estimated_time < 24

'''
scheduled_time = float(input("Enter the scheduled time: "))
estimated_time = float(input("Enter the estimated time: "))

#ontime
if scheduled_time == estimated_time:
    print("Flight is on time")
#delayed
elif scheduled_time < estimated_time:
    print("Flight is delayed")
elif scheduled_time > estimated_time:
    print("Flight is early")
