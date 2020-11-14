/*
repcombをデバッグ済み:https://atcoder.jp/contests/abc021/submissions/18095230
repcombの計算で、comb,modpow,modinvについても使用するので、全デバッグ済みと考えて良いと思う。
 */

class Enum{
    /*
    数え上げ(組み合わせとか)を扱うクラス。
     */
    var modulo = 1000000007
    var moduloL = 1000000007L
    var fact = mutableListOf(1L)
    var invfact = mutableListOf(1L)

    fun setmod(m:Int){
        modulo = m
        moduloL = m.toLong()
    }

    fun modpow(x_in:Int,n_in:Int):Int{
        /*
        modをとるべき乗(O(log N)で計算)
         */
        var ret:Long = 1
        var n:Int = n_in
        var x:Long = x_in.toLong()
        while(n > 0){
            if ((n and 1)==1){
                ret *= x
                ret %= moduloL
            }
            x = (x*x)%moduloL
            n = n.ushr(1)
        }
        return ret.toInt()
    }

    fun prepareFact(max_n:Int){
        /*
        階乗及びその逆元の計算。max_nまで事前準備する。combやrepcombとかを呼ぶ前に呼び出さないといけない。
         */
        var x:Long = 1
        for (i in 1 until max_n+1){
            x = x*i
            x %= moduloL
            fact.add(x)
            invfact.add(modinv(x))
        }
    }
    
    fun comb(n:Int,k:Int) : Int{
        /*
        nCkを計算
         */
        val ret:Long = (((fact[n]*invfact[k])%moduloL)*(invfact[n-k]))%moduloL
        return ret.toInt()
    }

    fun repcomb(n:Int,k:Int):Int{
        /*
        nHk(重複組合せ)を計算。
         */
        return comb(n+k-1,k)
    }

    fun modinv(x:Int):Int{
        return modpow(x,modulo-2)
    }
    fun modinv(x:Long):Long{
        return modpow(x.toInt(),modulo-2).toLong()
    }
}
