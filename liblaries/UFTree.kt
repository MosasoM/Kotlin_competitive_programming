/*
デバッグ済み　https://atcoder.jp/contests/atc001/submissions/17147726
経路圧縮は入れているが、Rankは入れていないのでそこまで早くない。
実行時間的に困るようだったら入れる予定。
 */

class UFTree{
    /*
    Union-Find
     */
    var parent:MutableList<Int>
    constructor(max_n:Int){
        parent = MutableList(max_n){it}
    }
    
    fun rootOf(x:Int):Int{
        val par = parent[x]
        if (par==x){
            return par
        }else{
            val rt = rootOf(par)
            parent[x] = rt
            return rt
        }
    }

    fun unite(x:Int,y:Int){
        /*
        結合
         */
        val rx = rootOf(x)
        val ry = rootOf(y)
        if (rx!=ry){
            parent[rx] = ry
        }
    }

    fun isSame(x:Int,y:Int):Boolean{
        /*
        結合しているかどうか
         */
        return if(rootOf(x)==rootOf(y)) true else return false
    }
}