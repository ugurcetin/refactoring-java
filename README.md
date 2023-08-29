# Refactoring Java

The code creates an information slip about movie rentals.
Rewrite and improve the code after your own liking.

Think: you are responsible for the solution, this is a solution you will have to put your name on.


## Handing in the assignment

Reason how you have been thinking and the decisions you took. 
You can hand in the result any way you feel (git patch, pull-request or ZIP-file).
Note: the Git history must be included.


## To run the test:

```
javac src/*.java
java -cp src Main
```

# Refactored by Ugur Cetin

I'd like to say that I tried to took the simplest approach.
I believe this refactored code separates concerns into separate classes, uses an enum to represent movie types, and encapsulates the calculation of rental amount and frequent points. 
It should be more modular, readable, and maintainable.

Created Skeleton such as enums, models, services. 

Services:
RentalInfo class splitted to RentalService and StatementService;
Separation of Concerns, Modularity and Reusability, Flexibility and Maintenance.

MovieType Enum:
The MovieType enum is introduced to classify different types of movies, such as Regular, New Release, and Children's. This enhances code readability and allows for easier extension if more movie types are added in the future.

StringBuilder for Result: 
Instead of concatenating strings directly in a loop, a StringBuilder is used to efficiently build the result string.

Enhanced Switch for Rental Amount: 
The switch statement now uses the MovieType enum for better readability. Each movie type's calculation is isolated within its own case.

Unit Test:
Benefits for application; quality assurance, and maintaining codebases such as Detect Bugs Early, Isolate Issues, Refactor with Confidence.

