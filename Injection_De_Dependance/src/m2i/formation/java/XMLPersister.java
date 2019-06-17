package m2i.formation.java;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

public class XMLPersister implements IPersister {

	@Override
	public void persist(Object o, Class<?> to) {
		System.out.println("Sauvegarde au format XML");

		try {

			File file = new File("C:\\file.xml");
			JAXBContext jaxbContext = JAXBContext.newInstance(to);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

			// output pretty printed
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

			jaxbMarshaller.marshal(o, file);
			jaxbMarshaller.marshal(o, System.out);

		} catch (JAXBException e) {
			e.printStackTrace();
		}

	}

}
