package clases

abstract class Form(var header: String, var succesMsg: String, var errorMsg:String){
    var user:String = ""
    var password:String = ""

    abstract fun validation():Boolean

    fun load(menu: Menu){
        if(validation()){
            println(succesMsg)
            println("CARGANDO...")
            Thread.sleep(1_500)
            println("\nBIENVENDIO ${this.user}")
            Thread.sleep(1000)
            menu.showMenu()
        } else {
            println("\n\n\n\n\n\n\n\n")
            println(errorMsg)
            println("INTENTELO DE NUEVO \n")
            this.load(menu)
        }
    }
}

class LogIn(header:String, succesMsg: String, errorMsg: String) : Form(header, succesMsg, errorMsg){
    override fun validation():Boolean{
        println("\n\n\n\n")
        println(header)

        println("INGRESE SU USUARIO")
        print("USUARIO: ")
        this.user = readln()!!.toString()

        println("\nINGRESE SU CONTRASEÑA")
        print("CONTRASEÑA: ")
        this.password = readln()!!.toString()

        return this.user == "user1" && this.password == "P@sswd10."
    }
}

class SignUp(header:String, succesMsg: String, errorMsg: String) : Form(header, succesMsg, errorMsg){
    override fun validation():Boolean{
        println(header)

        println("INGRESE SU USUARIO")
        print("USUARIO: ")
        this.user = readln()!!.toString()

        println("\nINGRESE SU CONTRASEÑA")
        print("CONTRASEÑA: ")
        this.password = readln()!!.toString()

        return this.user != "user1"
    }
}
