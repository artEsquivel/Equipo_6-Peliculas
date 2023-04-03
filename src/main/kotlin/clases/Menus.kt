package clases

import objects.MOVIES
import kotlin.system.exitProcess


open class Menu(var options: Array<String>, var header: String) {
    private var table = generateTable(options)
    private var indication = "\nINGRESE EL NÚMERO DE LA OPCIÓN CORRESPONDIENTE\n"
    private var errorMsg:String = "\n\nINGRESE UNA OPCIÓN VALIDA"
    var selected:Int = 0

    private fun generateTable(values: Array<String>):String {
        var table = ""
        // Calcular el ancho de la tabla
        val width = values.map { it.length }.maxOrNull()?.plus(4) ?: 10 // 4 espacios adicionales para el margen

        // Imprimir la primera fila con los títulos
        table = "N#".padEnd(4) + "OPCIONES".padEnd(width) + "\n"

        // Imprimir el separador entre la primera fila y los datos
        table += "-".repeat(3) + " " + "-".repeat(width) + "\n"

        // Imprimir cada fila con los datos
        values.forEachIndexed { index, data ->
            val id = (index + 1).toString().padEnd(3)
            val options = data.padEnd(width)
            table += "$id $options \n"
        }
        return table
    }

    open fun showMenu(){
        showInfo()
        chooseOption()
    }
    fun showInfo(){
        println("\n\n\n\n\n\n\n\n")
        println(this.header)
        println(this.indication)
        println(this.table)
    }

    fun chooseOption(){
        try {
            print("OPCIÓN > ")
            var option: Int = readln().toInt()
            println("\n\n\n\n")
            if (option > options.size) {
                println("\n\n\n\n")
                println(errorMsg)
                println(table)
                chooseOption()
            } else {
                this.selected = option
            }
        } catch (e: Exception){
            println("\n\n\n\n")
            println(errorMsg)
            println(table)
            chooseOption()
        }
    }
}

class MenuMovie(options: Array<String>, header: String): Menu(options, header){
    val peliculas = arrayListOf<pelicula>()

    override fun showMenu(){
        showInfo()
        chooseOption()
        when(MOVIES.selected){
            1 -> MOVIES.verTodas()
            2 -> MOVIES.buscarPorTitulo()
            3 -> MOVIES.buscarPorCategoria()
            4 -> MOVIES.buscarPorCalificacion()
            else -> {
                println("***** Hasta luego *****")
                exitProcess(0)
            }
        }
    }

    fun reload(){
        Thread.sleep(1_500)
        println("REGRESANDO AL MENU...")
        Thread.sleep(1_500)
        showMenu()
    }

    fun buscarPorCalificacion() {

        println("Ingresa la calificación que deseas buscar (1-5):")
        print("CALIFICACION > ")
        val calificacion = readLine() ?: ""
        val pelicula = obtenerPelicula(calificacion, 4)
        if (pelicula != null) {
            println(pelicula.toString())
        } else {
            println("No se encontró ninguna película con la calificación ingresada.")
            reload()
        }
    }

    fun buscarPorCategoria() {
        println("Ingresa la categoría de la película que deseas buscar:")
        print("CATEGORIA > ")
        val categoria = readLine() ?: ""
        val pelicula = obtenerPelicula(categoria, 3)
        if (pelicula != null) {
            println(pelicula.toString())
        } else {
            println("No se encontró ninguna película en la categoría ingresada.")
            reload()
        }
    }

    fun buscarPorTitulo() {

        println("Ingresa el título de la película que deseas buscar:")
        print("TITULO > ")
        val titulo = readLine() ?: ""
        val pelicula = obtenerPelicula(titulo, 2)
        if (pelicula != null) {
            println(pelicula.toString())
        } else {
            println("No se encontró ninguna película con el título ingresado.")
            reload()
        }

    }

    fun verTodas() {

        var pelicula1 = pelicula(1, "Jhon Wick", "Acción", 2014,
            "La ciudad de Nueva York se llena de balas cuando John Wick, un exasesino a sueldo, \n" +
                    "regresa de su retiro para enfrentar a los mafiosos rusos, liderados por Viggo Tarasov, \n" +
                    "que destruyeron todo aquello que él amaba y pusieron precio a su cabeza.\n".trimIndent(), obtenerCalifiacion(1))
        var pelicula2 = pelicula(2, "Gladiador", "Acción",  2000,
            "El general romano Máximo es el soporte más leal del emperador Marco Aurelio, \n" +
                    "que lo ha conducido de victoria en victoria. Sin embargo, Cómodo, el hijo de Marco Aurelio, \n" +
                    "está celoso del prestigio de Máximo y aún más del amor que su padre siente por él. \n" +
                    "Cuando Cómodo llega al poder ordena el arresto del general y su asesinato. Máximo escapa de sus asesinos, \n" +
                    "pero no puede evitar la muerte de su familia. Entonces se convierte en gladiador para llevar a cabo su venganza.\n".trimIndent(), obtenerCalifiacion(2))
        var pelicula3 = pelicula(3, "Mi villano favorito", "Infantil", 2010,
            "Mientras intenta cumplir su diabólico plan para robarse a la luna, el acto criminal más increíble de la Historia, \n" +
                    "un supervillano enfrenta su reto más grande, tres pequeñas huérfanas que desean convertirlo en su papá. \n" +
                    "La visión de este supervillano, y de sus secuaces, irá cambiando poco a poco gracias a esas tres pequeñas \n" +
                    "que llegarán a su corazón.\n".trimIndent(), obtenerCalifiacion(3))

        peliculas.add(pelicula1)
        peliculas.add(pelicula2)
        peliculas.add(pelicula3)

        println("\nSi deseas salir de la aplicación ingresa la opción 0")
        println("¿Cuál película deseas ver?: ")
        print("PELICULA > ")
        var opcionPelicula = readln().toInt()

        if(opcionPelicula > peliculas.size){
            println("No hay ninguna película con ese número\n\n\n")
            reload()
        }
        verResenia(opcionPelicula)
    }


    fun obtenerPelicula(criterio: String, opcion: Int): pelicula? {
        return when (opcion) {
            2 -> peliculas.find { it.nombrePelicula == criterio }
            3 -> peliculas.find { it.generoPelicula == criterio }
            4 -> peliculas.find { it.calificacion == criterio }
            else -> null
        }
    }

    fun verResenia(idPelicula: Int) {
        println("\n\n")
        for (item in peliculas) {
            if (idPelicula == item.idPelicula) {
                println("${item.nombrePelicula}\n${item.resumen}\n")
                break;
            }
        }
        if (reseniaPeliculas.size != 0) {
            var cont = 0
            for (item in reseniaPeliculas) {
                if (item.idPelicula == idPelicula) {
                    cont++

                    println("\rComentario $cont")
                    println("${item.comentario}\n")
                }
            }
            if (cont == 0)
                println("Aun no existen comentarios para ésta película\n")
        } else {
            println("Aun no existen comentarios para ésta película\n")
        }
        menuResenia(idPelicula)
    }

    fun menuResenia(idPelicula: Int) {
        println("1. Agregar un comentario")
        println("2. Regresar al menú principal")
        print("OPCIÓN > ")
        var opcionSubmenu = readln().toInt()

        when(opcionSubmenu){
            1 -> {
                println("\nEscribe el comentario:")
                print("COMENTARIO > ")
                var comentario = readln().toString()

                println("Escribe la calificación que le das a la película (del 1 al 10):")
                print("CALIFICACION > ")
                var calificacion = readln().toInt();

                guardarResenia(idPelicula, comentario, calificacion)
                verResenia(idPelicula)
            }
            2 -> reload()
        }
    }
}
