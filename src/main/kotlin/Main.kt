import clases.*
import objects.*
import kotlin.system.exitProcess

fun main() {
    println("███████╗ ██████╗ ██╗   ██╗██╗██████╗  ██████╗      ██████╗               ██████╗ ███████╗██████╗ ██╗   ██╗\n" +
            "██╔════╝██╔═══██╗██║   ██║██║██╔══██╗██╔═══██╗    ██╔════╝               ██╔══██╗██╔════╝██╔══██╗██║   ██║\n" +
            "█████╗  ██║   ██║██║   ██║██║██████╔╝██║   ██║    ███████╗     █████╗    ██████╔╝█████╗  ██║  ██║██║   ██║\n" +
            "██╔══╝  ██║▄▄ ██║██║   ██║██║██╔═══╝ ██║   ██║    ██╔═══██╗    ╚════╝    ██╔══██╗██╔══╝  ██║  ██║██║   ██║\n" +
            "███████╗╚██████╔╝╚██████╔╝██║██║     ╚██████╔╝    ╚██████╔╝              ██████╔╝███████╗██████╔╝╚██████╔╝\n" +
            "╚══════╝ ╚══▀▀═╝  ╚═════╝ ╚═╝╚═╝      ╚═════╝      ╚═════╝               ╚═════╝ ╚══════╝╚═════╝  ╚═════╝ \n" +
            "                                                                                                          ")
    println("CARGANDO EL MEJOR PROYECTO...")
    Thread.sleep(1_500)



    //Muestra el Menu Principal
    MENU.showMenu()


    //Selección en menu MENU
    when(MENU.selected){
        1 -> LOGIN.load(MOVIES)
        else -> SIGNUP.load(MOVIES)
    }


    //Menu correindo hasta que eligan salir
    while(true){
        MOVIES.showMenu()
    }

}

