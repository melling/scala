object Foo with Application {
  val x = scala.xml.XML.loadFile("myfile.xml");
  Console.println(x);
}
