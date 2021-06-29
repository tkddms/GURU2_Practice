fun main() {
    var score : Int = 85
    if(score >= 90){
        println("A")
    }else if(score >= 80){
        println("B")
    }else if(score >= 70){
        println("C")
    }else if(score >= 60){
        println("D")
    }else {
        println("F")
    }

    when(score){
        in 90 .. 100 -> println("A")
        in 80 .. 89 -> println("B")
        in 70 .. 79 -> println("C")
        in 60 .. 69 -> println("D")
        else -> println("F")
    }
}