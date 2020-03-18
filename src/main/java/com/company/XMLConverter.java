package com.company;


import com.company.MyCollection.MyList;
import com.company.Person.AbstractPerson;
import com.company.Person.ConcretePerson;


import org.apache.log4j.Logger;
import org.apache.log4j.spi.LoggerFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.*;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import java.io.File;
import java.lang.invoke.MethodHandles;

public class XMLConverter {

    String fileName;
    private static final Logger logger = Logger.getLogger(XMLConverter.class);

    public XMLConverter(String fileName) {
        this.fileName = fileName;
    }

    public void jaxbConv(MyList<AbstractPerson> personList) throws JAXBException {
        logger.info("On method jaxbConv");
        JAXBContext context = JAXBContext.newInstance(ConcretePerson.class, Company.class);
        Marshaller marshaller = context.createMarshaller();
        // устанавливаем флаг для читабельного вывода XML в JAXB
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        var com = new Company(personList.toList());
        marshaller.marshal(com, new File(fileName));
    }

    public void domConv(MyList<AbstractPerson> personList) throws ParserConfigurationException, TransformerException {
        var pers = personList.toList();
        Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
        Element company = document.createElement("company");
        document.appendChild(company);
        for (var p : pers) {

            // Элemeнт типa staff            
            Element staff = document.createElement("person");
            company.appendChild(staff);
            //   Oпpeдeляem идeнтифиkaтop coтpyдниka   

            Element id = document.createElement("id");
            id.setTextContent(p.getId().toString());
            staff.appendChild(id);

            Element firstname = document.createElement("firstname");
            firstname.setTextContent(p.getFirstName());
            staff.appendChild(firstname);

            Element gender = document.createElement("gender");
            gender.setTextContent(p.getGender().toString());
            staff.appendChild(gender);

            Element div = document.createElement("division");
            div.setTextContent(p.getDivision().getName());
            staff.appendChild(div);

            Element sal = document.createElement("salary");
            sal.setTextContent(p.getSalary().toString());
            staff.appendChild(sal);
        }
        Transformer transformer = TransformerFactory.newInstance().newTransformer();
        DOMSource source = new DOMSource(document);
        StreamResult result = new StreamResult( new File(fileName));
        transformer.transform(source, result);


    }
}
