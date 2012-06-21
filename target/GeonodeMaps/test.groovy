import groovy.json.JsonSlurper

if (!session) {
  session = request.getSession(true);
}

if (!session.counter) {
  session.counter = 1
}

println """
<html>
    <head>
        <title>Groovy Servlet</title>
    </head>
    <body>
Hello, ${request.remoteHost}: ${session.counter} 
<br/>
${new Date()}
    </body>
</html>
"""
session.counter = session.counter + 1


String json = new URL("http://paris.sopac.org/maps/search/api").getText()
def slurper = new JsonSlurper()
def r = slurper.parseText(json)
def ids = r.rows.id
def titles = r.rows.title
def owner = r.rows.owner
def abstracts = r.rows.abstract

println owner