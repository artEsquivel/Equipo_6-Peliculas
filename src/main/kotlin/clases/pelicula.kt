package clases

class pelicula (idPelicula: Int, nombrePelicula: String, generoPelicula: String,
                anio: Int, resumen: String, calificacion: String) {
    var idPelicula: Int = idPelicula
    var nombrePelicula: String = nombrePelicula
    var generoPelicula: String = generoPelicula
    var calificacion: String = calificacion
    var anio: Int = anio
    var resumen: String = resumen

    init {
        println(datosPelicula())
    }

    fun datosPelicula() = """${idPelicula}. Nombre de la película: $nombrePelicula
        Género : $generoPelicula
        Año: $anio
        Calificación: $calificacion
    """.trimIndent()
}