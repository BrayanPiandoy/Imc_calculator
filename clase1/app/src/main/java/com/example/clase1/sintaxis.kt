package com.example.clase1
    //variables
    var name1 = "HOLA."

    //varialble -----------------

    //constantes
    val name:String = "Franklin"
    val age:Int = 30
    val age2:Long = 30

fun main(){


    //println("hola mundo!!$name")
    //println(add(23,200))
    //ifAnidado()
    //getMonth(12)
    getTrimester(4)
}

fun add(x:Int, y:Int=50):Int = x+y

fun ifAnidado() {
    val animal = "perro"
    val city = "pasto"

    if (animal == "dog"&& city == "pasto"){
        println("es un perro pastuso")
    }else if(animal == "cat"){

        println("es un gato")
    }else if(animal == "bird"){
        println("es un pajaro")
    }else{

        println("no es un animal esperado")
    }

}

fun getMonth(month:Int){
    when(month){
        1 -> print("Enero")
        2 -> print("Febrero")
        3 -> print("Marzo")
        12 -> print("Dicimebre")
        else ->print("no es un mes valido")
    }
}

fun getTrimester(month:Int){
    when(month){
        1,2,3 -> print("Primer Trimestre")
        4,5,6 -> print("Segundo Trimestre")
        7,8,9 -> print("Tercer Trimestre")
        10,11,12 -> print("cuarto Trimestre")
        else -> print("mes no valido")
    }


}

