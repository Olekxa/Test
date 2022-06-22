package xml;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.StringWriter;

public class WriteXML {
    public static void main(String[] args) {
        try {
            // create an instance of `JAXBContext`
            JAXBContext context = JAXBContext.newInstance(Book.class);

            // create an instance of `Marshaller`
            Marshaller marshaller = context.createMarshaller();

            // enable pretty-print XML output
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            // write XML to `StringWriter`
            StringWriter sw = new StringWriter();

            // create `Book` object
            Book book = new Book(17L, "Head First Java", "ISBN-45565-45",
                    new Author(5L, "Bert", "Bates"));

            // convert book object to XML
            marshaller.marshal(book, sw);

            // print the XML
            System.out.println(sw.toString());

        } catch (JAXBException ex) {
            ex.printStackTrace();
        }

    }
}
