# dpmt-java

『[増補改訂版 Java 言語で学ぶデザインパターン入門 マルチスレッド編](https://www.hyuki.com/dp/dp2.html)』第 12 章のサンプルプログラムを写経したものです。
また、教科書のサンプルプログラムをベースとしていくつかの変種を実装しました。

## 動作環境

プログラムは Java 1.8 で動作を確認しています。
ビルド、実行例を以下に示します。

```
$ cd src/Chapter12
$ javac Main.java
$ java Main
displayString: Chris 0
Alice: value =
Bobby: value =
Alice: value = A
Bobby: value = B
displayString: Chris 1
Alice: value = AA
displayString: Chris 2
Bobby: value = BB
```

## プログラムのディレクトリ構成

src 以下の各ディレクトリの内容は以下のとおりです。

| ディレクトリ名        | 内容 |
|-----------------------|-|
| Chapter12             | サンプルプログラム 1 を書き写したもの |
| Chapter12_Guard       | サンプルプログラム 1 にガード条件を加えてみたもの |
| Chapter12_WoScheduler | サンプルプログラム 1 を Future パターンで実現したもの |
| Chapter12_JUC         | サンプルプログラム 2 を書き写したもの |
| Chapter12_JUC_ReImpl  | サンプルプログラム 2 で利用される java.util.concurrent パッケージのクラスを独自に実装したもの |

### Chapter12

教科書に記載されているサンプルプログラム 1 を書き写したものです。

### Chapter12_Guard

教科書 420 ページで、ActivationQueue の中でガード条件を満たしたリクエストを実行する方式に触れられています。
この方式を実装してみました。

Servant 役の displayString メソッドに「makeString メソッドの実行後でなければ処理できない」という制約を課したうえで、
これをガード条件としてマルチスレッド環境でも正しく動作するように実装しました。

### Chapter12_WoScheduler

教科書の Servant クラスはスレッド間で共有される状態を持たないので、Future パターンを実装するだけで正しく動作します。
実際に実装して、このことを確認してみました。

SchedulerThread と ActivationQueue を用いず、教科書の Future パターンと同様にリクエストごとにスレッドを生成して処理します。

### Chapter12_JUC

教科書に記載されているサンプルプログラム 2 を書き写したものです。

### Chapter12_JUC_ReImpl

サンプルプログラム 2 で利用されている java.util.concurrent パッケージの各クラスを独自の実装に置き換えてみたものです。

concurrent ディレクトリ以下に、必要なクラス、インタフェースを実装しました。
java.util.concurrent パッケージ内のクラスを import せずに concurrent パッケージの独自実装を利用して動きます。

## オリジナルのプログラムに関する表示

オリジナルのサンプルプログラムは The zlib/libpng License で公開されており、以下の URL から入手できます。

https://www.hyuki.com/dp/dp2.html#download

```
Copyright (C) 2002,2006 Hiroshi Yuki.
http://www.hyuki.com/dp/dp2.html
hyuki@hyuki.com

This software is provided 'as-is', without any express or implied warranty.
In no event will the authors be held liable for any damages
arising from the use of this software.

Permission is granted to anyone to use this software for any purpose,
including commercial applications, and to alter it and redistribute it freely,
subject to the following restrictions:

1. The origin of this software must not be misrepresented; you must not claim
that you wrote the original software. If you use this software in a product,
an acknowledgment in the product documentation would be appreciated but is not
required.

2. Altered source versions must be plainly marked as such, and must not be
misrepresented as being the original software.

3. This notice may not be removed or altered from any source distribution.

（以下、参考訳）
このソフトウェアは現状のまま提供されるものであり、
明示的にあるいは暗黙のうちにどんな保証もしない。
このソフトウェアを使うことによって生じるいかなる損害に対しても、
作者はまったく責任を負わない。

以下の制限を守る限りにおいて、誰であっても、
このソフトウェアを商用アプリケーションを含む任意の目的に使用すること、
このソフトウェアを変更すること、そして自由に再配布することができる。

1. このソフトウェアの起源を誤って提示してはならない。すなわち、
あなたは元のソフトウェアを自分が書いたと主張してはならない。
もしもこのソフトウェアを製品の中で使用するときには、製品の文書中で
謝意を示すことは歓迎する。しかしそれは必須ではない。

2. 変更したソースの版ははっきりとそれがわかるようにしなければならず、
元のソフトウェアと混同されるようにしてはいけない。

3. いかなるソース配布からも、この注意書きは削除したり変更したりしてはならない。
```
