//class Car{
//    var color: String = ""
//    var speed: Int = 0
//
//    companion object{
//        var carCount: Int = 0
//        const val MAXSPEED: Int = 200
//        const val MINSPEED: Int = 0
//        fun currentCarCount(): Int{
//            return carCount
//        }
//    }
//
//    constructor(color:String, speed:Int){   // 생성자
//        this.color = color
//        this.speed = speed
//        carCount++          // Car.carCount (o) / Car1.carCount (x)
//    }
//
//    constructor(speed: Int){
//        this.speed = speed
//    }
//
//    constructor(color: String){
//        this.color = color
//    }
//
//    constructor(){
//    }
//
//    fun upSpeed(value:Int){
//        if (speed+value >= 200){
//            speed = 200
//        }else{
//            speed = speed + value
//        }
//    }
//    fun downSpeed(value: Int){
//        if (speed-value<=0){
//            speed=0
//        }else{
//            speed = speed - value
//        }
//    }
//}

fun main() {
    var myCar1: Car = Car()
    myCar1.color = "RED"
    myCar1.speed = 0

    var myCar2: Car = Car()
    myCar2.color = "BLUE"
    myCar2.speed = 0

    var myCar3: Car = Car()
    myCar3.color = "GREEN"
    myCar3.speed = 0
}
