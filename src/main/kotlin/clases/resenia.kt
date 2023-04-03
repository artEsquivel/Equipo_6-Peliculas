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

fun existeResenia(idPelicula: Int): Boolean {
    for (item in reseniaPeliculas) {
        if (item.idPelicula == idPelicula) {
            return true
            break
        }
    }
    return false
}

fun eliminarResenia(idPelicula: Int, idComentario: Int) {
    var index = 0
    var indicesPelicula = intArrayOf()
    var existeComentario = false
    for (item in reseniaPeliculas) {
        if (idPelicula == item.idPelicula) {
            indicesPelicula = agregarIndice(indicesPelicula, index)
        }
        index++
    }
    var contador = 0
    for (item in indicesPelicula) {
        if ((idComentario-1) == contador) {
            reseniaPeliculas.removeAt(item)
            existeComentario = true
            break
        }
        contador++
    }
    if (existeComentario)
        println("\nSe ha eliminado el comentario seleccionado.")
    else
        println("\nNo existe el comentario ingresado. Favor de ingresar un comentario existente.")
}

fun agregarIndice(arr: IntArray, element: Int): IntArray {
    val mutableArray = arr.toMutableList()
    mutableArray.add(element)
    return mutableArray.toIntArray()
}