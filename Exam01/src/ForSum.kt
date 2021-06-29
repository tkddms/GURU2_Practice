fun main() {
    var sum = 0
    for (x in 1..10){
        sum+= x
    }
    println("sum: $sum")
    for (x in 1..10 step 1){
        sum += x
    }
    println("sum: $sum")
}