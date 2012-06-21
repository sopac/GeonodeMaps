
String id = params.id
GeonodeMaps m = new GeonodeMaps()

println "<h2>" + params.title + "</h2>"
println "<h3>" + params.abs + "</h3>"
println "<i>Author</i>: " + params.owner

println """

<table><tr>
<td valign="top">
<iframe style="border: none;" height="600" width="800" src="http://paris.sopac.org/maps/${id}/embed"></iframe>
</td>
<td>
"""

for (String layer : m.getLayers(id)){
 println "<b>" + layer + "</b><br/>"
 println """

<img src="http://paris.sopac.org/geoserver/wms?REQUEST=GetLegendGraphic&VERSION=1.0.0&FORMAT=image/png&LAYER=${layer}"/>
<br/>
 """
}


println """
</td></tr></table>

<FORM>
<INPUT TYPE="button" value="Print" onClick="window.print()">
</FORM>
<a href="${m.getGeonodeURL()}/maps/${id}/view" target="_blank">${m.getGeonodeURL()}/maps/${id}/view</a>
"""