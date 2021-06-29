fun main() {
    // 3x3 크기의 이차원 배열 선언, for문을 이용하여 값 할당
//    var arr = Array<IntArray>(3, {IntArray(3)})
//    var num = 0
//    for (i in arr){
//        for(j in i.indices){
//            i[j] = num
//            num++
//        }
//    }
//    for (i in arr){
//        for(j in i){
//            print("$j")
//        }
//        println()
//    }

    var two = Array<IntArray>(3, {IntArray(3)})
    var value : Int = 100
    for(i in 0..2 step 1){
        for(j in 0..2 step 1){
            two[i][j] = value
            value = value + 10
            println("two[$i][$j]: ${two[i][j]}")
        }
    }
}