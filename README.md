# Computer Simulator
Technical Assignment for Application to Tenten

## Requirement
Create a computer simulator app that would support the execution of the following code:
```
def print_tenten
print(multiply(101, 10))
end
print(1009)
print_tenten()
# 1009 
# 1010
```

## Built With
* Android (min SDK: 16, target SDK: 28)
* Java (JDK7)

## Implementation Decisions
Unfortunately, there were a lot of corners cut 
in the interest of time since the Android and Java review 
took me longer than expected.
Still, it was fun :D

### Attempted architecture pieces:
* MVP
* Dependency injection
* Entities

### Other notes:
* Input is currently hard coded into the ```Input > ProgramRunner``` class
* Commands were implemented as children of Instructions class 
* Computer which contains the program counter and stack was implemented as a singleton
* UI is updated through Event Emitter

### TODO
* Write unit tests
* Put more comments and error handling
* Have better input handling
* Make use of Fragments
