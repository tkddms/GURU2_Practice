// 5단부터 8단까지 구구단 출력 프로그램 -for문
fun main() {
    for (i in 5..8){
        for(j in 1..9){
            println("$i X $j = ${i*j}")
        }
    }

    for (i in 5..8){
        for(j in 1..9){
            println("$i X $j = ${i*j}")
        }
        println("*******************")
    }

}