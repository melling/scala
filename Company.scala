

object companylist {

  case class Company(exchange: String, ticker: String, name: String, url: String)

  class CompanyList(a: Company*) {
      private val people: List[Company] = a.toList
  /** An AddressBook takes a variable number of arguments
   *  which are accessed as a Sequence
   */
    def toXHTML =
      <table cellpadding="2" cellspacing="0">
    <tr>
    <th>Name</th>
    <th>Age</th>
    </tr>
    { for (p <- people) yield
      <tr>
     <td>{ p.exchange }</td>
     <td>{ p.ticker }</td>
     <td>{ p.name }</td>
     <td>{ p.url }</td>
     </tr> 
   }
    </table>;
  }

  val header =
    <head>
  <title>
  { "Companies" }
  </title>
  <style type="text/css"> {
    """table { border-right: 1px solid #cccccc; }
    th { background-color: #cccccc; }
    td { border-left: 1px solid #acacac; }
    td { border-bottom: 1px solid #acacac;"""}
  </style>
  </head>;

  val companies = new CompanyList(
     new Company("NASDAQ", "AAPL", "Apple Computer", "www.apple.com"),
     new Company("NASDAQ", "MSFT", "Microsoft",""),
     new Company("NASDAQ", "ORCL", "Oracle", "")
   );
//   companies.findExchangeTicker("NASDAQ", "AAPL");

  val page =
    <html>
  { header }
  <body>
  { companies.toXHTML }
  </body>
  </html>;


  def main(args: Array[String]) {
      val x = 10;
      val l = List("AAPL","MSFT","CSCO","ORCL");
      println(l);
      val l2 = "MS" :: l
      println(l2);
    //println(page);
    if (x > 10) {
      println("Yes");
    }else{
      println("No");
    }
    }

}
/*
 scalac -d classes Company.scala; scala -classpath classes companylist
*/
