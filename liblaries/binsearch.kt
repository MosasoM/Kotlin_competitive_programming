/*
C++におけるlowerbondとupperbondと同じ、以上の最初のインデックス/超えるの最初のインデックスを返す。
upperbondは検証済み　https://atcoder.jp/contests/abc077/submissions/17932672
logic自体は同一なのでlowerbondも多分大丈夫
ListとArray両対応するジェネリクスの書き方がわからず、こんな感じになっている。
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