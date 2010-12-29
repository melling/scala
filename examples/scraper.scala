object VisitBrightonScraper extends VisitBrightonScraper 


case class Tide(when:LocalTime, height:Metre) {
  
 override val toString = when.toString("HH:mm") + 
   " (" + height + ")"   

 def forZone(destZone:DateTimeZone) = 
   Tide( when.toDateTimeToday(DateTimeZone.forID("GMT")).
    withZone(destZone).toLocalTime(), height)  
}

class VisitBrightonScraper extends TideSource {

  def page = Source.fromURL(
    "http://www.visitbrighton.com/site/tourist-information/tide-timetables").mkString

  override def lowsFor(day:LocalDate) = {
    
    // We want the times that start with the date in this
    // format: 10th May 2009
    val date = day.ordinal + 
    DateTimeFormat.forPattern(" MMM yyyy").print(day); 
    
    val Pattern = 
      """|(?sm).*<div class="TidalDataEntry"><h3>DATE</h3><table class="TidalData"><tr>
    |<th> </th><th class="Time">Time</th><th class="Height">Height .m.</th></tr><tr>
    |<td class="Tide">High</td><td class="Time">(.+?)</td><td class="Height">(.+?)</td></tr><tr>
    |<td class="Tide">Low</td><td class="Time">(.+?)</td><td class="Height">(.+?)</td></tr>
    |</table></div>.*""".stripMargin
    .replaceAll("\n","").replaceFirst("DATE", date).r

    try  {
      val Pattern(high_times,high_heights,low_times,low_heights) = page

      // The times and heights are in separate columns;
      // multiple values separated by "<br/>"
      val tides = for ( (time_string,height) <- 
		       low_times.split("<br/>") zip low_heights.split("<br/>") )
		  yield 
		    Tide( time_string.toLocalTime, Metre(height.toDouble) )

      tides.toList
    }
    catch {
      case x:scala.MatchError => println(x)
      Nil 
    } 
  }
}
