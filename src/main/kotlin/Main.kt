import kotlin.math.sqrt

class Punto(identifier:String){

    var x:Int = 0
    var y:Int = 0
    var identifier = identifier

    constructor(identifier:String,x: Int,y: Int): this(identifier){
        this.x = x
        this.y = y
    }

    //RA2.d
    override fun toString(): String {
        return "$identifier -> [$x,$y]"
    }


    companion object {

        //RA2.e,f
        fun componenteDeVector(pa: Punto, pb: Punto): Punto {
            return Punto(pa.identifier + pb.identifier, pb.x - pa.x, pb.y - pa.y)
        }

        //RA2.e,f OPCIONAL
        fun distancia(pa: Punto, pb: Punto): Double {
            return sqrt(((pb.x - pa.x) * (pb.x - pa.x) + (pb.y - pa.y) * (pb.y - pa.y)).toDouble())
        }

        //RA6.a,c
        fun localizacionGeograficaNS(arrayPuntos: Array<Punto>): Map<String, MutableList<Punto>> {
            val listaNorte = mutableListOf<Punto>(); val listaSur = mutableListOf<Punto>() ; val Map = mapOf("Norte" to listaNorte, "Sur" to listaSur)
            arrayPuntos.forEach { if (it.y >= 0) { listaNorte.add(it) } else {listaSur.add(it)}}
            return Map
        }
    }

    //RA2.C
    fun obtenerCoordenadas(): Pair<Int,Int>
    {
        val Coordenadas = Pair(x,y)
        return Coordenadas
    }

}

fun main() {

    //(RA2.b,d,h). Creo dos puntos y el tercero es el resultado de aplicarle el método
    val a = Punto("66",3,2)
    val b = Punto ("68",1,3)
    val c = Punto.componenteDeVector(a,b)

    println("")
    println(c)
    println("")

    //RA6.a,c. Creo varios puntos y los meto en un array para usarlos con el método
    val punto1 = Punto("Punto 1",7,1)
    val punto2 = Punto("Punto 2",1,-5)
    val punto3 = Punto("Punto 3",63,50)
    val punto4 = Punto("Punto 4",82,21)
    val punto5 = Punto("Punto 5",65,-7)


    val arrayPuntos = arrayOf<Punto>(punto1,punto2,punto3,punto4,punto5)
    println("Lista de puntos: ")
    for (i in 0..4) {print(arrayPuntos[i], )}

    println("")

    println("Localización Geográfica NS: ")
    println(Punto.localizacionGeograficaNS(arrayPuntos))

}