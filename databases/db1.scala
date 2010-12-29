import scala.dbc._
import scala.dbc.Syntax._
import scala.dbc.syntax.Statement._
import java.net.URI

object MysqlVendor extends Vendor {
  val uri = new URI("jdbc:mysql://localhost:3306/my_database_name")
  val user = "my_database_user"
  val pass = "my_database_password"
  
  val retainedConnections = 5
  val nativeDriverClass = Class.forName("com.mysql.jdbc.Driver")
  val urlProtocolString = "jdbc:mysql:"
}

object BulkUploadRunner extends Application {
  val db = new Database(MysqlVendor)

  val rows = db.executeStatement {
    select fields ("email_id" of characterVarying(32)) from ("bulk_uploads")
  }
  for (val r <- rows;
       val f <- r.fields) {
    Console.println(f.content.nativeValue) // or .sqlValue
  }

  db.close
}
