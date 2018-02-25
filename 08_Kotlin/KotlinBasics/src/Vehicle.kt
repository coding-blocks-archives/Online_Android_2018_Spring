class Vehicle(var wheels: Int) {
    fun getAxles (): Int {
        return wheels / 2
    }
}

fun main(args: Array<String>) {
    val v = Vehicle(4)
    println(v.wheels)
    println(v.getAxles())
}