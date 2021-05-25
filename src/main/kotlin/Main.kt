fun main(args: Array<String>){
    blockingWithMessage()
}

fun longTaskWithMessage(message:String){
    Thread.sleep(5000)
    println(message + Thread.currentThread().name)
}

fun blockingWithMessage(){
    println("Tarea 1 " + Thread.currentThread().name)
    longTaskWithMessage("Tarea 2")
}