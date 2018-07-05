import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.TransformerException;

import org.xml.sax.SAXException;

public class Main {
	 public static void main(String[] args) throws TransformerException {
		    SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
		    try {
		        SAXParser saxParser = saxParserFactory.newSAXParser();
		        ReadSaxXML handler = new ReadSaxXML();
		        saxParser.parse(new File("employees.xml"), handler);
		        //Get Employees list
		        List<Angajat> empList = handler.getAngajati();
		        //print employee information
		        for(Angajat emp : empList)
		            System.out.println(emp); 		
		        
		        
		        WriteDomXML domWriter = new WriteDomXML();
		        domWriter.createXMLFrom(empList, "pAngajati.xml");
		    } catch (ParserConfigurationException | SAXException | IOException e) {
		        e.printStackTrace();
		    }
	 }
}
