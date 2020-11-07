/*
bit全探索用のコード
for (str in BitExaustiveStrings(桁数))でbit全探索用の指定桁にpaddingした2進数がiterateできる。
デバッグ済み:https://atcoder.jp/contests/arc061/submissions/17924846
 */

class BitExuastiveStrings{
    val num_digit:Int
    constructor(num_digit:Int){
        this.num_digit = num_digit
    }
    operator fun iterator():BitExuastiveIterator{
        return BitExuastiveIterator(num_digit)
    }
}

class BitExuastiveIterator{
    var cnt = 0
    var upper:Int
    val num_digit:Int
    constructor(num_digit:Int){
        this.upper = 2.0.pow(num_digit).toInt()  
        this.num_digit = num_digit      
    }
    operator fun next():String{
        val ret = cnt.toString(2).padStart(num_digit,'0')
        cnt += 1
        return ret
    }
    operator fun hasNext():Boolean{
        return if (cnt < upper) true else false
    }
}