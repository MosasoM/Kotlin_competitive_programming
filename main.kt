import kotlin.math.*
fun inone(): Int{
    return readLine()!!.toInt();
}

fun inmap():  List<Int>{
    return readLine()!!.split(" ").map({ it.toInt() })
}

class Grid{
    /**
    *
    * グリッド上でhogeする問題を扱う予定のクラスです。
    * @param[search_type]:4近傍探索か8近傍探索をそれぞれ4,8で指定します。デフォルト4です。
    * @constructor 盤面高さ[hwight]、盤面幅[width],盤面を表す文字列[texts],障害物を表すchar[barrierchar]で盤面を初期化します。
     */
    var isfree:Array<BooleanArray>
    var unvisited:Array<BooleanArray>
    var pos_h = 0
    var pos_w = 0
    var search_type:Int = 4

    val freechar:Char = '.'
    val barrierchar:Char 
    val height:Int
    val width:Int
    val movecommand = mapOf(
        "LU" to Pair(-1,-1),
        "U" to Pair(-1,0),
        "RU" to Pair(-1,1),
        "L" to Pair(0,-1),
        "R" to Pair(0,1),
        "LD" to Pair(1,-1),
        "D" to Pair(1,0),
        "RD" to Pair(1,1)
    )

    val four_move = listOf(movecommand["U"],movecommand["L"],movecommand["R"],movecommand["D"])
    val eight_move = listOf(movecommand["U"],movecommand["L"],movecommand["R"],movecommand["D"],
                            movecommand["LU"],movecommand["RU"],movecommand["LD"],movecommand["RD"])


    constructor(height:Int,width:Int,texts:MutableList<String>,barrierchar:Char){
        this.barrierchar = barrierchar
        this.isfree = Array<BooleanArray>(height,{BooleanArray(width,{false})})
        this.unvisited = Array<BooleanArray>(height,{BooleanArray(width,{true})})
        this.width = width
        this.height = height
        for (i in 0 until height){
            for (j in 0 until width){
                this.isfree[i][j] = if(texts[i][j] == barrierchar) false else true
            }
        }
    }
    fun isinside(th:Int,tw:Int):Boolean{
        /**
        [th],[tw]が盤面内かを判定。
         */
        return if(th>-1 && th < height && tw >-1 && tw < width) true else false
    }

    fun bfs(start:Pair<Int>,goal:Pair<Int>){
        /**
        [start]から[goal]までのbfs。戻り地は手数で到達不可のときは-1
         */
        var que = mutableListOf(0 to start)
        var reach_step = -1
        while (que.size > 0){
            val (step,pos) = que.first()
            if (pos == goal){
                reach_step = step
                break
            }
            que.drop(1)
            val nextfree = getNextFree(pos)
            for (free in nextfree){
                que.add(step+1 to free)
            }
        }
        return reach_step
    }

    fun getNextFree(now_h:Int,now_w:Int):MutableList<Pair<Int,Int>>{
        /**
        近傍探索をして、動ける場所を返します。
         */
        var buf:MutableList<Pair<Int,Int>> = mutableListOf()
        val tosearch = if(search_type==4) four_move else eight_move
        for (hw in tosearch){
            val th = now_h + hw!!.first
            val tw = now_w + hw!!.second
            if (isinside(th,tw)){
                if (unvisited[th][tw] && isfree[th][tw]){
                    buf.add(th to tw)
                }
            }
        }
        return buf
    }

    fun getNextFree():MutableList<Pair<Int,Int>>{
        return getNextFree(pos_h,pos_w)
    }
    fun getNextFree(hw:Pair<Int,Int>):MutableList<Pair<Int,Int>>{
        return getNextFree(hw.first,hw.second)
    }

    fun setPos(pos_h:Int,pos_w:Int){
        this.pos_h = pos_h
        this.pos_w = pos_w
    }

    fun printField(){
        /**
        デバッグ用、フィールドを文字列として標準出力に返します。
         */
        var ret = ""
        for (line in isfree){
            var temp = CharArray(width)
            for (j in 0 until width){
                temp[j] = if(line[j]) freechar else barrierchar
            }
            ret += temp.joinToString("")+"\n"
        }
        println(ret)
    }
}

fun main(args: Array<String>) {
    var buf:MutableList<String> = mutableListOf()
    for (i in 0 until 3){
        buf.add(readLine()!!)
    }
    var g = Grid(3,3,buf,'#')
    g.printField()

    for (i in 0 until 3){
        for (j in 0 until 3){
            println("%d , %d".format(i,j))
            println(g.getNextFree(i,j).joinToString())
        }
    }
}