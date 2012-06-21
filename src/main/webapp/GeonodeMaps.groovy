import groovy.json.JsonSlurper

class GeonodeMaps {


	String geonode_url = "http://paris.sopac.org/"

	def getGeonodeURL(){ 
	  return geonode_url 
	}

	ArrayList<String[]> listMaps(){
		//id, title, abstract
		String json = new URL(geonode_url + "maps/search/api").getText()
		def slurper = new JsonSlurper()
		def r = slurper.parseText(json)
		def ids = r.rows.id
		def titles = r.rows.title
		def owner = r.rows.owner
		def abstracts = r.rows.abstract
		def list = new ArrayList<String[]>()
		for (int i = 0; i < ids.size(); i++){
			def result = new String[4]
			String a = abstracts[i] + " "
			if (a.trim().equals("")) a = titles[i]
			result[0] = ids[i]
			result[1] = titles[i]
			result[2] = a
			result[3] = owner[i]
			list.add(result)

		}
		println list.size()
		return list
	}

	ArrayList<String> getLayers(String id){
		String json = ""
		new URL(geonode_url + "maps/${id}/view").eachLine{ l ->
			if (l.contains("defaultSourceType")){
				l = l.trim()
				l = l.substring(2, l.length())
				l = l.substring(0, l.length() - 2)
				json = l
			}
		}
		def slurper = new JsonSlurper()
		def r = slurper.parseText(json)
		def names = r.map.layers.name
		def list = new ArrayList<String>()
		for (String n : names) {
			if (n.startsWith("geonode:")){
				list.add(n.replace("geonode:", "").trim())
			}
		}
		//list.each {println it}
		//println list.size()
		return list
	}



}
