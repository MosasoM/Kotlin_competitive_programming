import kotlin.math.*
fun inone(): Int{
    return readLine()!!.toInt();
}

fun inmap():  List<Int>{
    return readLine()!!.split(" ").map({ it.toInt() })
}


fun main(args: Array<String>) {
    val (h,w) = inmap()
    val (s,t) = inmap()
    val start = s-1 to t-1
    val (gh,gw) = inmap()
    val goal = gh-1 to gw-1

    var buf:MutableList<String> = mutableListOf()
    for (i in 0 until h){
        buf.add(readLine()!!)
    }
    var g = Grid(h,w,buf,'#')
    println(g.bfs(start,goal))
}