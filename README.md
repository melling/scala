## Hello World

```scala
object HW extends App {
   println("Hello world")
}

```

```sh
scalac foo.scala
scala HW
```

## Command Line Args

```scala
args.foreach { arg => println(arg) }
```

## val vs var

```scala
val x = 3 // Immutable
x = x + 1 // Illegal
var y = 4 // Mutable
y = y + 1 // OK
```

## Loops

```scala
val range = 0.until(10) // Range type
```

##

```scala
val l = List(1,2,3,4)
l.permutations.foreach(println)
```

##

```scala
def f = 3
def g = f _ // prevent eval of f()
def g() = f // Assign function
def g = f // error
```
 

## Case Classes

### Can omit val usage: class Noun(val word: String, val gender: String) 

```scala
case class Noun(word: String, gender: String)
val w = Noun("hombre", "el")
println(w)
println(w.word)
println(w.gender)
```

## File I/O

```scala
val fileLines = io.Source.fromFile("README.org").getLines.toList
fileLines.foreach(println)
fileLines.foreach(l => println(l))
```

