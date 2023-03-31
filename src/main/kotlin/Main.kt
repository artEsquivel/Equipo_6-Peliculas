import clases.*
import kotlin.system.exitProcess

val peliculas = arrayListOf<pelicula>()

fun main() {
    menuPrincipal()
}

fun menuPrincipal() {
    println("\n\n")
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

    if (opcionPelicula != 0)
        verResenia(opcionPelicula)
    else
        exitProcess(0)
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