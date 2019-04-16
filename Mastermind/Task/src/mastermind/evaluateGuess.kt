package mastermind

data class Evaluation(val rightPosition: Int, val wrongPosition: Int)

fun evaluateGuess(secret: String, guess: String): Evaluation {
    if(secret.length != guess.length){
        return Evaluation(0,0)
    }

    var rightPosition = 0
    var secretOtherLetters = arrayListOf<Char>()
    var guessOtherLetters = arrayListOf<Char>()

    for(index in 0..secret.length-1){
        if(secret.get(index).equals(guess.get(index))){
            rightPosition++
        }else{
            secretOtherLetters.add(secret.get(index))
            guessOtherLetters.add(guess.get(index))
        }
    }

    var wrongPositions = 0

    secretOtherLetters.intersect(guessOtherLetters)
            .forEach { x -> wrongPositions += listOf(secretOtherLetters.count {it == x},guessOtherLetters.count {it == x})
                    .min()!! }
    return Evaluation(rightPosition, wrongPositions)
}