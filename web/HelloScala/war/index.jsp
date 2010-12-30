<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head><title>Scala Servlets on AppEngine</title>
    <link rel="stylesheet" href="css/style.css" type="text/css" media="screen, projection">
    <style>
        body {
            font-family: "Lucida Grande", "Lucida Sans Unicode", Arial, Verdana, sans-serif;
            font-size: 10px;
            line-height: 155%;
            padding-left: 5px;
            margin: 5px;
            background-color: #E3E3E3; /*border-top: 1px solid #B3CCFE;*/
            color: #272727;
            padding: 0;
        }
    </style>
</head>
<body>
<div class="container ">
    <h1><a href="/" style="text-decoration: none;">Scala Servlets on Google AppEngine</a></h1>

    <h1 style="text-align:center"></h1>
    <hr>
    <div class="span-24 box">

        <p style="font-size: 14px;">A simple Scala servlet on Google AppEngine</p>

        <h3>Instructions</h3>
        <p><ol>
	<li><a href="http://www.scala-lang.org/downloads">Download Scala</a></li>
	<li><a href="http://code.google.com/appengine/downloads.html">Download AppEngine Java SDK</a></li>
	<li><a href="http://code.google.com/appengine/docs/java/tools/ant.html">Follow the Ant Instructions</a></li>
	<li><a href="http://www.frothandjava.com/2009/04/scala-on-google-appengine.html">Enhanced build.xml</a></li>

	<li>Create HelloWorld.scala in war/src/com/example
	<pre>
package com.example
import javax.servlet.http.{HttpServlet, HttpServletRequest, HttpServletResponse}

class HelloWorld extends HttpServlet {

  override def doGet(request: HttpServletRequest, response: HttpServletResponse) {
    
    response setContentType ("text/html")
    
    val out = response getWriter
    
    out println """&lt;html>
    &lt;head>
     &lt;title>Scala Servlet&lt;/title>
     &lt;/head>
    &lt;body>
    &lt;p>Hello Scala World&lt;/p>
    &lt;/body>&lt;/html>"""
  }
}
	</pre>
	<li>ant runserver</li>
	</ul></p>
    </div>
</div>
</body>
</html>