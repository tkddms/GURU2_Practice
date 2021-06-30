fun main() {
    var number1:Int
    var number2:Int
    print("number1 = ")
    number1 = readLine()!!.toInt()
    print("number2 = ")
    number2 = readLine()!!.toInt()

    println("number1+number2 = ${number1+number2}")
    println("number1-number2 = ${sub(number1,number2)}")
    println("number1*number2 = ${mul(number1,number2)}")

}

//fun sum(n1:Int, n2:Int):Int = n1+n2
fun mul(a:Int, b:Int):Int = a*b
fun sub(a:Int, b:Int):Int = a-b