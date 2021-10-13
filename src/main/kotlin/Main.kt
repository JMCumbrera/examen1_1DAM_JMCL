package examen1
import kotlin.system.exitProcess

// #####################################
// DEFINICIÓN DEL CUERPO DEL PROGRAMA
// #####################################

fun edadMes(edad: Byte, mes: Byte): List<Int> {
    // Estas variables son las listas, que representan las tablas que se deberán mostrar
    // por pantalla, según la edad y mes introducidos
    val tablas0 = listOf(0)     // Esta variable en concreto se usa para ponerla al final de la función,
                                // debido a que si al final de esta no hay un return, no funcionará
    val tablas1 = listOf(1, 3, 5)
    val tablas2 = listOf(2, 4)
    val tablas3 = listOf(6, 8, 10)
    val tablas4 = listOf(7, 9)
    val tablas5 = listOf(11, 12, 13)

    // La siguiente cadena de if funciona de la siguiente manera, si la edad es correcta y el mes es correcto,
    // se devolverá la lista con las tablas de multiplicar pertinentes, si la edad es incorrecta,
    // pero el mes es correcto, se devolverá el mensaje de error advirtiendo de la edad incorrecta, si la
    // edad es correcta, pero el mes es incorrecto, se devolverá el mensaje de error advirtiendo del mes
    // incorrecto
    if (edad in 6..8) {
        if (mes < 1 || mes > 12) {
            println("Mes: $mes. El mes es erróneo")
            println("_".repeat(80))
            println("*".repeat(80))
            exitProcess(-1) // Gracias a esta función, podemos salir del programa una vez que hemos
                                  // recibido el mensaje de error, y que así, no muestre ninguna tabla de
                                  // multiplicar por pantalla
        } else {
            println("Edad: $edad. El alumno está dentro del rango [6-8]")
            if (mes % 2 == 0) {
                println("Mes: $mes. El mes es par, corresponden las tablas siguientes: {2,4}")
                return tablas2
            } else if (mes % 2 != 0) {
                println("Mes: $mes. El mes es impar, corresponden las tablas siguientes: {1,3,5}")
                return tablas1
            }
        }
    } else if (edad in 9..10) {
        if (mes < 1 || mes > 12) {
            println("Mes: $mes. El mes es erróneo")
            println("_".repeat(80))
            println("*".repeat(80))
            exitProcess(-1)
        } else {
            println("Edad: $edad. El alumno está dentro del rango [9-10]")
            if (mes % 2 == 0) {
                println("Mes: $mes. El mes es par, corresponden las tablas siguientes: {6,8,10}")
                return tablas3
            } else if (mes % 2 != 0) {
                println("Mes: $mes. El mes es impar, corresponden las tablas siguientes: {7,9}")
                return tablas4
            }
        }
    } else if (edad in 11..12) {
        if (mes < 1 || mes > 12) {
            println("Mes: $mes. El mes es erróneo")
            println("_".repeat(80))
            println("*".repeat(80))
            exitProcess(-1)
        } else {
            println("Edad: $edad. El alumno está dentro del rango [11-12]")
            if (mes % 2 == 0) {
                println("Mes: $mes. El mes es par, corresponden las tablas siguientes: {11,12,13}")
                return tablas5
            } else if (mes % 2 != 0) {
                println("Mes: $mes. El mes es impar, corresponden las tablas siguientes: {11,12,13}")
                return tablas5
            }
        }
    } else if (edad < 6 || edad > 12) {
        println("Edad: $edad. No se contempla esa edad")
        println("_".repeat(80))
        println("*".repeat(80))
        exitProcess(-1)
    }
    return tablas0
}

fun tablasDeMultiplicar(tablas: List<Int>) {
    println()
    tablas.forEach {
        println("TABLA DEL $it")
        println("*".repeat(11))
        for (i in 1..10) {      // Aquí el for usará los números del 1 al 10 para la tabla de multiplicar
            println("$it * $i = ${it*i}")   // Y aquí, en cada línea, mostrará cada multiplicación
        }
        println()
    }
}

fun main() {
    // Declaración de variables

    val edad: Byte
    val mes: Byte
    val miNombre = "Juan Manuel Cumbrera López"
    val tablas: List<Int>   // Esta variable la relacionaremos con la función edadMes, y según la edad
                            // y el mes del alumno/a devolverá una lista (de tablas de multiplicar a mostrar)
                            // o un mensaje de error

    // Leo desde teclado la edad del alumno y el mes actual

    println("Introduzca la configuración del programa en este formato: <edadDelAlumno>,  <mesActual>")
    val entrada: String = readLine() ?: ""
    val listaEntrada: List<String> = entrada.split(",")

    // Linea Inicial de programa
    println("*".repeat(80))
    println("PROGRAMA DE GENERACIÓN DE TABLAS: $miNombre")

    // Linea inicio cabecera
    println("_".repeat(80))

    if (listaEntrada.size != 2) //Compruebo el tamaño de la lista, si es != 2, finaliza el programa
    {
        println("La entrada no es correcta")
        println("_".repeat(80))
    }
    else { // Si no, leo edad y mes. Asigno -1 si hay error en la lectura.
        edad = try {listaEntrada[0].trim().toByte()} catch (_: Exception) {-1}
        mes = try {listaEntrada[1].trim().toByte()} catch (_: Exception) {-1}

        if ((edad <= 0) || (mes <= 0)) // Si alguno es menor que -1, finaliza el programa
        {
            println("La entrada no es correcta")
            println("_".repeat(80))
        }
        else //Si no, continuo
        {
            tablas = edadMes(edad,mes)  // Como explicábamos en la sección de la declaración de variables,
                                        // aquí relacionamos la variable tablas con la función edadMes

            //Edad: 8. El alumno está dentro del rango [6-8]
            //Mes: 12. El mes es par, corresponden las tablas siguientes: {2,4}
            //println("La edad es $edad y el mes es $mes")

            // Linea final cabecera
            println("_".repeat(80))

            //Imprime las tablas en función de la edad y el mes
            tablasDeMultiplicar(tablas)     // Aquí le pasamos la variable tablas a la función
                                            // tablasDeMultiplicar, de modo que solo mostrará por pantalla
                                            // las tablas de multiplicar pertinentes
        }

    }
    // Linea final de programa
    println("*".repeat(80))

}