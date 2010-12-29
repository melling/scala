// http://www.grenadesandwich.com/blog/steven/2009/11/28/python-scala-27-check-your-spelling

import scala.io.Source

val alphabet = "abcdefghijklmnopqrstuvwxyz"

def train(text:String) = {
  "[a-z]+".r.findAllIn(text).foldLeft(Map[String, Int]() withDefaultValue 1) {(a, b) => a(b) = a(b) + 1}
}

val NWORDS = train(Source.fromFile("big.txt").getLines.mkString.toLowerCase)

def known(words:Set[String]) = {Set.empty ++ (for(w <- words if NWORDS contains w) yield w)}

def edits1(word:String) = {
  Set.empty ++
  (for (i <- 0 until word.length) yield (word take i) + (word drop (i + 1))) ++ // Deletes
  (for (i <- 0 until word.length - 1) yield (word take i) + word(i + 1) + word(i) + (word drop (i + 2))) ++ // Transposes
  (for (i <- 0 until word.length; j <- alphabet) yield (word take i) + j + (word drop (i+1))) ++ // Replaces
  (for (i <- 0 until word.length; j <- alphabet) yield (word take i) + j + (word drop i)) // Inserts
}

def known_edits2(word:String) = {Set.empty ++ (for (e1 <- edits1(word); e2 <- edits1(e1) if NWORDS contains e2) yield e2)}

def correct(word: String) = {
  val sets = List[String => Set[String]](
    x => known(Set(x)), x => known(edits1(x)), known_edits2
  ).elements.map(_(word))
  
  sets find { !_.isEmpty } match {
    case Some(candidates) => candidates.reduceLeft { (res, n) => if (NWORDS(res) > NWORDS(n)) res else n }
    case None => word
  }
}
