
GeonodeMaps m = new GeonodeMaps()

println """
<div style="margin-left:30px; margin-right:60px">
<h2 style="color: #008CB3">PCRAFI Maps</h2>
<p align="justify" style="background-color: lightgray; padding: 10px">
<b>Pacific Risk Information Systems (PaRIS)</b> is one of the largest collections of geospatial information for the Pacific island region. PaRIS was assembled to provide detailed probabilistic risk information for 15 Pacific island countries for a range of decision makers including disaster risk management agencies. The perils covered are tropical cyclones (wind, storm surge and rain) and earthquakes (ground shaking, tsunami). The countries covered are Cook Islands, Fiji, Kiribati, Marshall Islands, Federated States of Micronesia, Nauru, Niue, Palau, Papua New Guinea, Samoa, Solomon Islands, Timor Leste, Tonga, Tuvalu and Vanuatu.
<br/>
<a href="${m.getGeonodeURL()}">${m.getGeonodeURL()}</a>
</p>

"""
int counter  = 0
for (String[] maps : m.listMaps()){
  counter++ 
  println "<b>${counter}. <a style='text-decoration: none' href='show.groovy?id=" + maps[0] + "&title=" + maps[1] + "&abs="+ maps[2] + "&owner=" + maps[3] + "'>" +  maps[1] + "</a></b>"
  println "<br/>"
  println "<span style='margin-left:25px'><i>" + maps[2] + "</i></span><br/><br/>"
}

println """
</div>
"""