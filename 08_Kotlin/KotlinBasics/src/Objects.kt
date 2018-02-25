object myObject {
    val item = "someitem"
    fun say () {
        println("Hello")
    }
}

fun main(args: Array<String>) {
    println(myObject.item)
    myObject.say()
}