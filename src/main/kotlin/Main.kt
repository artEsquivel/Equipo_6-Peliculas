import clases.*
import kotlin.system.exitProcess

val peliculas = arrayListOf<pelicula>()

fun main() {
    do{
        println("----------------------|  BIENVENIDO |----------------------")
    }while(!login())

    menuPrincipal()
}

fun login() : Boolean {
    println("Ingrese su usuario")
    val user = readlnOrNull()
    println("Ingrese su contraseña")
    val pass = readlnOrNull()

    if(user == "usuario1" && pass == "P@sswd10."){
        println("***** Inicio de sesión exitoso *****")
        return true;
    }else
    {
        println("***** Usuario y/o contraseña incorrecto *****")
        println("***** Intenta nuevamente *****")
        return false;
    }
}

fun menuPrincipal() {
    println("\n\n")
    println("----------------------|  PELÍCULAS |----------------------")

    println("_________________| ¿Qué deseas hacer? |____________________________________")
    println("""
        "| 1 Ver todas las películas"
        "| 2 Buscar por título
        "| 3 Buscar por categoría
        "| 4 Buscar por calificación
        "| 0 Si deseas salir de la aplicación ingresa la opción
    """)

    println("Digite el número de opción deseado")
    val opt1 = readln().toInt()

    if (opt1 != 0)
        options(opt1)
    else {
        println("***** Hasta luego *****")
        exitProcess(0)
    }
}

fun options(opt: Int){

    when(opt) {
        1 -> verTodas()
        2 -> buscarPorTitulo()
        3 -> buscarPorCategoria()
        4 -> buscarPorCalificacion()

        else -> println("Opción inválida")
    }

}

fun buscarPorCalificacion() {

    println("Ingresa la calificación que deseas buscar (1-5):")
    val calificacion = readLine() ?: ""
    val pelicula = obtenerPelicula(calificacion, 4)
    if (pelicula != null) {
        println(pelicula.toString())
    } else {
        println("No se encontró ninguna película con la calificación ingresada.")
    }
}

fun buscarPorCategoria() {
    println("Ingresa la categoría de la película que deseas buscar:")
    val categoria = readLine() ?: ""
    val pelicula = obtenerPelicula(categoria, 3)
    if (pelicula != null) {
        println(pelicula.toString())
    } else {
        println("No se encontró ninguna película en la categoría ingresada.")
    }
}

fun buscarPorTitulo() {

    println("Ingresa el título de la película que deseas buscar:")
    val titulo = readLine() ?: ""
    val pelicula = obtenerPelicula(titulo, 2)
    if (pelicula != null) {
        println(pelicula.toString())
    } else {
        println("No se encontró ninguna película con el título ingresado.")
    }

}

fun verTodas() {

    var pelicula1 = pelicula(1, "Jhon Wick", "Acción", 2014,
        "La ciudad de Nueva York se llena de balas cuando John Wick, un exasesino a sueldo, " +
                "regresa de su retiro para enfrentar a los mafiosos rusos, liderados por Viggo Tarasov, " +
                "que destruyeron todo aquello que él amaba y pusieron precio a su cabeza.".trimIndent(), obtenerCalifiacion(1))
    var pelicula2 = pelicula(2, "Gladiador", "Acción",  2000,
        "El general romano Máximo es el soporte más leal del emperador Marco Aurelio, " +
                "que lo ha conducido de victoria en victoria. Sin embargo, Cómodo, el hijo de Marco Aurelio, " +
                "está celoso del prestigio de Máximo y aún más del amor que su padre siente por él. " +
                "Cuando Cómodo llega al poder ordena el arresto del general y su asesinato. Máximo escapa de sus asesinos, " +
                "pero no puede evitar la muerte de su familia. Entonces se convierte en gladiador para llevar a cabo su venganza.".trimIndent(), obtenerCalifiacion(2))
    var pelicula3 = pelicula(3, "Mi villano favorito", "Infantil", 2010,
        "Mientras intenta cumplir su diabólico plan para robarse a la luna, el acto criminal más increíble de la Historia, " +
                "un supervillano enfrenta su reto más grande, tres pequeñas huérfanas que desean convertirlo en su papá. " +
                "La visión de este supervillano, y de sus secuaces, irá cambiando poco a poco gracias a esas tres pequeñas " +
                "que llegarán a su corazón.".trimIndent(), obtenerCalifiacion(3))

    peliculas.add(pelicula1)
    peliculas.add(pelicula2)
    peliculas.add(pelicula3)

    println("\nSi deseas salir de la aplicación ingresa la opción 0")
    println("¿Cuál película deseas ver?: ")
    var opcionPelicula = readln().toInt()

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
    var opcionSubmenu = readln().toInt()

    when(opcionSubmenu){
        1 -> {
            println("\nEscribe el comentario:")
            var comentario = readln().toString()

            println("Escribe la calificación que le das a la película (del 1 al 10):")
            var calificacion = readln().toInt();

            guardarResenia(idPelicula, comentario, calificacion)
            verResenia(idPelicula)
        }
        2 -> menuPrincipal()
    }
}