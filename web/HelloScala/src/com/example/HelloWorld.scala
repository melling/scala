package com.example
import javax.servlet.http.{HttpServlet, HttpServletRequest, HttpServletResponse}

class HelloWorld extends HttpServlet {

  override def doGet(request: HttpServletRequest, response: HttpServletResponse) {
    
    response setContentType ("text/html")
    
    val out = response getWriter
    
    out println """<html>
    <head>
     <title>Scala Servlet</title>
     </head>
    <body>
    <p>Hello Scala World</p>
    </body></html>"""
  }
}
