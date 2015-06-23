package dk.jarry;

import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import org.junit.Test;
import org.junit.Before;

/**
 *
 * @author Michael Bornholdt Nielsen mni@jarry.dk
 */
public class DukeTest {

    private JAXBContext context;

    @Before
    public void init() throws JAXBException {
        this.context = JAXBContext.newInstance(Duke.class);
    }

    @Test
    public void test() throws JAXBException {
        
        Duke duke = new Duke("Java", 20);

        Marshaller m = this.context.createMarshaller();
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        m.marshal(duke, new File("duke.xml"));
        
        Unmarshaller unmarshaller = this.context.createUnmarshaller();
        Object unmarshalled = unmarshaller.unmarshal(new File("duke.xml"));
        
        System.out.println(unmarshalled);       

    }

}
