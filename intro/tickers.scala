/*

 scala tickers.scala

*/

def hr() = {println("====================")};

val tickers = List("AAPL","MSFT","CSCO","ORCL","C", "T");

def tup1(x: Int, y: Int, z: Int) = {
    (x+1,y+1,z+1)
}
println(tickers.exists(s => s == "AAPL"));
println(tickers.exists(s => s == "CSC"));
tickers.foreach(println)
hr();
println(tickers.last)
val exch_ticker = tickers.map(s => "NASDAQ:" + s);
exch_ticker.foreach(println)
hr();
val short_tickers = tickers.remove(s=> s.length > 3);
short_tickers.foreach(println)
hr();
val s = "Perl"

val t1 = tup1(1,2,3);
println(t1)



