package dk.jarry;

import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.namespace.QName;
import javax.xml.transform.stream.StreamSource;
import org.junit.Test;
import org.junit.Before;

/**
 *
 * @author Michael Bornholdt Nielsen mni@jarry.dk
 */
public class ToDoTest {

    private JAXBContext context;

    @Before
    public void init() throws JAXBException {
        this.context = JAXBContext.newInstance(ToDo.class);
    }

    @Test
    public void test() throws JAXBException {

        ToDo toDo = new ToDo(20, "HeadLine", "Bla bla bla");

        Marshaller m = this.context.createMarshaller();
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

        QName qName = new QName("dk.jarry.ToDo", "ToDo");
        JAXBElement<ToDo> rootM = new JAXBElement<>(qName, ToDo.class, toDo);
        m.marshal(rootM, new File("toDo.xml"));

        Unmarshaller unmarshaller = this.context.createUnmarshaller();
        JAXBElement<ToDo> rootUm = unmarshaller.unmarshal(new StreamSource(new File("toDo.xml")), ToDo.class);
                  
        System.out.println(rootUm.getValue().toString());
    }

}
