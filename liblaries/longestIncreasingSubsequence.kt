/*
にぶたんが必要なのでそれも付いている。
デバッグ済み https://atcoder.jp/contests/chokudai_S001/submissions/17946738
 */

fun <T> lowerbond(arr:List<T>,threshold:T):Int where T: Comparable<T> {
    var left:Int = 0
    var right:Int = arr.size-1
    while (right-left > 1){
        val mid:Int = (left+right)/2
        if (arr[mid] >= threshold){
            right = mid
        }else{
            left = mid
        }
    }
    return if (arr[left]>=threshold) left else (if(arr[right] >= threshold) right else right+1)
}

fun <T> lowerbond(arr:Array<T>,threshold:T):Int where T: Comparable<T> {
    var left:Int = 0
    var right:Int = arr.size-1
    while (right-left > 1){
        val mid:Int = (left+right)/2
        if (arr[mid] >= threshold){
            right = mid
        }else{
            left = mid
        }
    }
    return if (arr[left]>=threshold) left else (if(arr[right] >= threshold) right else right+1)
}

fun <T> upperbond(arr:List<T>,threshold:T):Int where T: Comparable<T> {
    var left:Int = 0
    var right:Int = arr.size-1
    while (right-left > 1){
        val mid:Int = (left+right)/2
        if (arr[mid] > threshold){
            right = mid
        }else{
            left = mid
        }
    }
    return if (arr[left]>threshold) left else (if(arr[right] > threshold) right else right+1)
}

fun <T> upperbond(arr:Array<T>,threshold:T):Int where T: Comparable<T> {
    var left:Int = 0
    var right:Int = arr.size-1
    while (right-left > 1){
        val mid:Int = (left+right)/2
        if (arr[mid] > threshold){
            right = mid
        }else{
            left = mid
        }
    }
    return if (arr[left]>threshold) left else (if(arr[right] > threshold) right else right+1)
}


fun LongestIncSubseq(arr:List<Int>):Int{
    var dp = Array<Int>(arr.size,{2147483647})
    var ret = 0
    for (a in arr){
        val ind = lowerbond(dp,a)
        dp[ind] = a
        ret = if(ind+1>ret) ind+1 else ret
    }
    return ret
}