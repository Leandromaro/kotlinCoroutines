import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

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

suspend fun delayCoroutine(message:String){
     delay(timeMillis = 5000)
    println("Tarea 3 " + Thread.currentThread().name)
}

fun suspendExample(message:String) = runBlocking{
    println("Tarea 3 " + Thread.currentThread().name)
    delayCoroutine("Tarea 4")
}