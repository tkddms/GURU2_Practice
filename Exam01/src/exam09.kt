// Animal.kt
fun main() {
    // 다형성
    var animal: Animal
    animal = Tiger()
    animal.move()
    animal = Eagle()
    animal.move()
}