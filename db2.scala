/* Save this file as db2.scala
 *  mkdir classes
 *  scalac  -d classes db2.scala
  *  scala -classpath '/export/home/melling/lib/java/mysql-connector-java-5.1.7-bin.jar:classes:.' BulkUploadRunner
  *
  */

import scala.dbc._
import scala.dbc.Syntax._
import scala.dbc.syntax.Statement._
import java.net.URI

object MysqlVendor extends Vendor {
  val uri = new URI("jdbc:mysql://qa:3306/cig")
  val user = "cig_user"
  val pass = "h4isql"

  val retainedConnections = 5
  val nativeDriverClass = Class.forName("com.mysql.jdbc.Driver")
  val urlProtocolString = "jdbc:mysql:"
}

object BulkUploadRunner extends Application {
  val db = new Database(MysqlVendor)

  val rows = db.executeStatement {
    select fields ("title" of characterVarying(32)) from ("document")
  }
  for (val r <- rows;
       val f <- r.fields) {
    Console.println(f.content.nativeValue) // or .sqlValue
  }

  db.close
}
