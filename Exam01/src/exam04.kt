var myVar: Int = 100

fun main() {
    var myVar: Int = 0
    println("main()'s myVar: $myVar")
    var sum: Int = addFunction(10,20)
    println(sum)
}

fun addFunction(num1:Int, num2:Int): Int{
    var hap:Int
    println("addFunction()'s myVar: $myVar")
    hap = num1 + num2 + myVar
    return hap
}