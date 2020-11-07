+ オプションの -include-runtimeはKotlinのruntimeを含めるかどうかで、含めると純粋なJavaの環境でも動く。

+ Kotlinのjarへのコンパイルは滅茶苦茶遅い

+ kotlinc -script hoge.ktsでスクリプトっぽく実行できる。スクリプトっぽく実行するときはmainが必ずしも必要ってわけじゃない(まさにスクリプトっぽく振る舞うらしい。)

+ 動作確認なら、kotlinc hoge.ktでclassファイルとしてコンパイルして、そのままkotlinで実行するのが良いらしい。そして、この実行のときは.classは要らないっぽい(つけるとエラーが出る)

+ valはconst,varは変数

+ var hoge:Intみたいな書き方、型名の先頭は大文字。

+ fun 関数名(変数名: 型名): 戻り値の型名 {
    //処理
    return hoge
}

+ !!はnull非許容演算子というらしく、nullableな型をnon-nullな型に変換することができる。

+ kotlinはわざわざpublic classとstaticなメソッドとして実装しなくても関数をstatic風に扱うことができる、

+ constructor内では外変数と内変数の区別のためにthisが必要だけど、ソレ以外の場所では要らない？→単純にlocal変数にかぶってるのがなければ大丈夫っぽい

+ 余談だが、javaでsetter getterを設定するのは、fieldを継承やオーバーライドによって変更することは出来ないからっぽい

+ Kotlinは val hoge: Int get(){func}でプロパティに関数を置けるので、プロパティにわざわざgetter setterをいつも設定する必要はない

+ 継承をOverride刷る場合はkotlinはOverRideが修飾子扱いで必須になっている。

+ ジェネリクスは所謂関数テンプレートっすね。ただ変性はよくわからん。

+ List,MutableList,Arrayが全部別で用意されている。

+ splitのreturunはListっぽい。どうやってmutableに変換するんだろう。→.toMutableList()がありました。

+ val (a,b) みたいなかっこでくくんだ宣言とかをすると、戻り地のiterableを分解して格納することができる。

+ 競プロではIntは滅茶苦茶おーばーふろーする

+ iterableを分解するときは型指定出来ないので、関数の方の戻り値をうまいことしておく必要がある。

+ ２進数変換はtoString(2),.padStart(10, '0')で指定した桁になるまでpaddingしてくれる。

+ Arrayの基本は、IntArrayみたいなのを除いてArray<type>(size,{initializer関数})の形、inititalizer関数はitでどうこうできるが正直、初期挙動がわかりにくいので、{IntArray(3,{0})}みたいな感じで二次元配列とか、その他の値で初期化するときに使うことが多そう。

+ Kotlinの==は値比較、object比較をする場合は===を使う。

+ Listのtakeは先頭からn要素取れるが、非破壊的操作で新しいリストが返る。

+ 頭だけ見るならlist.first()が良いと思う。

+ 頭から捨てるならdrop(n)→これも非破壊操作

+ removeAt(n)がn番目を破壊的に操作してなおかつその値を返してくれるみたい。