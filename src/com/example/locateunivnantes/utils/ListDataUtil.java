package com.example.locateunivnantes.utils;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import com.example.locateunivnantes.utils.beans.Batiment;
import com.example.locateunivnantes.utils.beans.Salle;

/**
 * Classe pour récupérer les batiments et les salles depuis un fichier XML
 * @author Alex
 *
 */
public class ListDataUtil {

	public static List<Batiment> getListBatiments() {
		List<Batiment> listData = new ArrayList<Batiment>();

		try {
			//Fichier XML contenant la liste des batiments
			String xmlFile = "<?xml version=\"1.0\" encoding=\"utf-8\"?><fac><batiment num=\"14\"><etage num=\"2\"><salle nom=\"50\"/><salle nom=\"51\"/><salle nom=\"52\"/><salle nom=\"53\"/><salle nom=\"55\"/><salle nom=\"60\"/><salle nom=\"63\"/><salle nom=\"65\"/></etage><etage num=\"1\"><salle nom=\"40\"/><salle nom=\"41\"/><salle nom=\"42\"/><salle nom=\"43\"/><salle nom=\"44\"/><salle nom=\"45\"/><salle nom=\"46\"/><salle nom=\"47\"/><salle nom=\"48\"/><salle nom=\"49\"/></etage><etage num=\"0\"><salle nom=\"33\"/><salle nom=\"33.1\"/><salle nom=\"34\"/><salle nom=\"35\"/><salle nom=\"35.1\"/><salle nom=\"36\"/><salle nom=\"37\"/><salle nom=\"37.1\"/><salle nom=\"38\"/><salle nom=\"38.1\"/><salle nom=\"39\"/></etage></batiment><batiment num=\"15\"><etage num=\"1\"><salle nom=\"I121\"/><salle nom=\"I122\"/><salle nom=\"I123\"/><salle nom=\"I124\"/><salle nom=\"I125\"/></etage><etage num=\"0\"><salle nom=\"I011\"/><salle nom=\"I012\"/><salle nom=\"I019\"/></etage><etage num=\"-1\"><salle nom=\"I01\"/><salle nom=\"I02\"/><salle nom=\"I03\"/><salle nom=\"I04\"/><salle nom=\"I05\"/></etage></batiment></fac>";

			DocumentBuilderFactory dbFactory = DocumentBuilderFactory
					.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(new InputSource(new StringReader(
					xmlFile)));

			doc.getDocumentElement().normalize();

			NodeList nList = doc.getElementsByTagName("batiment");

			for (int temp = 0; temp < nList.getLength(); temp++) {

				Batiment b = new Batiment();

				Node nNode = nList.item(temp);

				Element eBatiment = (Element) nNode;
				String numBatiment = eBatiment.getAttribute("num");

				b.setNumero(numBatiment);

				NodeList nEtageList = nNode.getChildNodes();

				for (int temp2 = 0; temp2 < nEtageList.getLength(); temp2++) {

					Node nNodeEtage = nEtageList.item(temp2);

					Element eEtage = (Element) nNodeEtage;
					String numEtage = eEtage.getAttribute("num");

					NodeList nSalleList = nNodeEtage.getChildNodes();
							
					for (int temp3 = 0; temp3 < nSalleList.getLength(); temp3++) {

						Salle s = new Salle();

						Node nSalle = nSalleList.item(temp3);
						Element eSalle = (Element) nSalle;
						String nomSalle = eSalle.getAttribute("nom");

						s.setEtage(Integer.valueOf(numEtage));
						s.setNom(nomSalle);

						b.addSalle(s);

					}

				}

				listData.add(b);

			}
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return listData;
	}

	public static void prepareListData(List<String> listDataHeader,
			HashMap<String, List<String>> listDataChild) {

		List<Batiment> listBat = getListBatiments();
		
		System.out.println(listBat.toString());

		int i = 0;
		for (Batiment bat : listBat) {
			listDataHeader.add("Bât. " + bat.getNumero());

			List<String> salles = new ArrayList<String>();
			for (Salle salle : bat.getSalles()) {
				salles.add(salle.getNom());
			}

			listDataChild.put(listDataHeader.get(i), salles);
			i++;
		}

	}
}
