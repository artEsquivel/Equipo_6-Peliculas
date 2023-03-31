package clases

var reseniaPeliculas = arrayListOf<resenia>()

open class resenia()  {
    var idPelicula: Int = 0
    lateinit var comentario: String
    var calificacion: String = ""
}

fun obtenerCalifiacion(idPelicula: Int): String {
    var promedio : Float
    if (reseniaPeliculas.size != 0) {
        var cont = 0
        var suma = 0
        for (item in reseniaPeliculas) {
            if (item.idPelicula == idPelicula) {
                cont++
                suma += item.calificacion.toInt()
            }
        }
        return if (cont != 0) {
            promedio = suma.toFloat() / cont.toFloat()
            promedio.toString()
        } else
            "sin calificación"

    } else {
        return "sin calificación"
    }
}

fun guardarResenia(idPelicula: Int, comentario: String, calificacion: Int) {

    var resenia = resenia()
    resenia.idPelicula = idPelicula
    resenia.comentario = comentario
    resenia.calificacion = calificacion.toString()

    reseniaPeliculas.add(resenia)
    println("Tu reseña se ha guardado con éxito")
}

