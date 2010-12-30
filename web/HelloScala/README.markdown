## Scala Servlet

This example should just work.

Here are the instructions to redo from scratch:
        <p><ol>
	<li><a href="http://www.scala-lang.org/downloads">Download Scala</a></li>
	<li><a href="http://code.google.com/appengine/downloads.html">Download AppEngine Java SDK</a></li>
	<li><a href="http://code.google.com/appengine/docs/java/tools/ant.html">Follow the Ant Instructions to create directory structure, build.xml, web.xml, and appengine-web.xml</a></li>
	<li><a href="http://www.frothandjava.com/2009/04/scala-on-google-appengine.html">Enhanced build.xml</a></li>
	<li>Create HelloWorld.scala in war/src/com/example</li>

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

	<li>ant runserver</li>
	</ul></p>
