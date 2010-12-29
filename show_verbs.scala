/* Save this file as show_verbs.scala
 *  mkdir classes
 *  scalac  -d classes show_verbs.scala
  *  scala -classpath '/opt/lib/java/mysql-connector-java-5.1.10-bin.jar:classes:.' BulkUploadRunner
  *
  */

import scala.dbc._
import scala.dbc.Syntax._
import scala.dbc.syntax.Statement._
import java.net.URI

object MysqlVendor extends Vendor {
  val uri = new URI("jdbc:mysql://localhost:3306/mmellinger66")
  val user = ""
  val pass = ""

  val retainedConnections = 5
  val nativeDriverClass = Class.forName("com.mysql.jdbc.Driver")
  val urlProtocolString = "jdbc:mysql:"
  println(user)
  println(pass)
}

object BulkUploadRunner extends Application {
  val db = new Database(MysqlVendor)

  val rows = db.executeStatement {
    select fields ("spanish_verb" of characterVarying(30)) from ("import_verbs")
  }
  for (val r <- rows;
       val f <- r.fields) {
    Console.println(f.content.nativeValue) // or .sqlValue
  }

  db.close
}
