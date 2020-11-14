class Zahlen{
    /*
    整数問題系を扱う予定のクラス。
     */
     var mod = 1000000007

    fun isprime(x:Int):Boolean{
        /*
        素数判定。簡単な例でdebug済み
         */
        for (i in 2 until min(sqrt(x.toDouble()).toInt()+1,x-1)){
            if (x%i == 0){
                return false
            }
        }
        return true
    }

    fun sieveOfErat(upper:Int):Array<Boolean>{
        /*
        エラトステネスの篩,primeがtrue
        簡単な例でデバッグ済み
         */
        var ret = Array<Boolean>(upper+1,{true})
        var index = 2
        while (index < upper+1){
            if (!ret[index]){
                index += 1
                continue
            }
            var st = index+index
            while (st < upper+1){
                ret[st] = false
                st += index
            }
            index += 1
        }
        ret[0] = false
        ret[1] = false //0と1は例外なのでここで処理しちゃう。upperが1より小さいとエラーになるけど、それは入力しない前提で…
        return ret
    }

    fun factorize(in_x:Int):MutableMap<Int,Int>{
        /*
        素因数分解
        簡易には確認したが、ちょっと不安
         */
        var x = in_x
        var ret = mutableMapOf<Int,Int>()
        for (i in 2 until min(sqrt(in_x.toDouble()).toInt()+1,in_x-1)){
            while (x%i==0){
                if (ret.containsKey(i)){
                    ret[i] = ret[i]!! + 1
                }else{
                    ret[i] = 1
                }
                x /= i
            }
        }
        return ret
    }
}