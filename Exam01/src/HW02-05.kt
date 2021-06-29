// 1부터 100사이의 홀수 누적 프로그램 - while
fun main() {
    var sum = 0
    var i = 0
    while(i<=100){
        if(i%2!=0)
            sum += i
        i++
    }
    println("sum(while) = $sum")

    sum = 0
    i = 0

    for(i in 1..100 step 2){
        sum += i
    }
    println("sum(for) = $sum")
}