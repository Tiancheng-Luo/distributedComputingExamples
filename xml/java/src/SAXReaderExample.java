import javax.xml.parsers.SAXParser;   import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;        import org.xml.sax.helpers.DefaultHandler;
import org.w3c.dom.Document;

public class SAXReaderExample extends DefaultHandler { //derive new class from DefaultHandler

  public static void main(final String argv[]) throws Throwable {   
    SAXParserFactory.newInstance()
                    .newSAXParser()
                    .parse("../xml/courseWithNamespace.xml", // parse the course document 
                           new SAXReaderExample());     
  }
  
  // implement one of the many event handler methods
  public void startElement(String uri, String localName, String qName, Attributes attributes) {
    System.out.print("<" + qName);
    for(int i = attributes.getLength(); (--i) >= 0; ) {
      System.out.print(" " + attributes.getQName(i) + "=" + attributes.getValue(i));
    }
    System.out.println(">");
  }
}