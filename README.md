# NumberGuessingGame
A simple Java-based console application that presents the user a number guessing game. This game ranges in 4 difficulties where the range of the answer go from 10, 100, 1,000, 10,000. Additionally, each difficulty will increase in penalities in score for each guess.
<br />
<br />
The game has a score, number of guesses, the range, the answer to guess, an error mutiplier and an indicator if the game has finished or not. Users will start off with a certain score (it increases with each difficulty). When users guesses the correct answer, the application will return a string indicting they've done so followed by the number of guesses and score.
<br />
<br />
### How to start the game ###
```
java NumberGame
```
You will then be asked to enter a difficulty, which then you can choose from: easy, medium, hard or intense.
```
Please enter a difficulty for this game: ...
```
The game then begins.
<br />
<br />
### Still to do ###
- Proper validation of inputs (as of now, the application just exits - i.e handles the throw/catch)
- Implement proper error percentage multipler as a double (proper logarithmic multiplier).
- Do the score function(s) for the game (not properly completed).
