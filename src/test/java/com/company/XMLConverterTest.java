package com.company;

import com.company.MyCollection.MyList;
import com.company.Patterns.Command.Reader.Readerimpl.CsvFileReader;
import com.company.Person.AbstractPerson;
import com.company.Person.ConcretePerson;
import com.company.Person.Division.Divisionimpl;
import com.company.Serviec.PersonApi;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.joda.time.LocalDate;
import org.junit.jupiter.api.Test;



import ru.vsu.lab.entities.enums.Gender;


import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.XMLEventWriter;
import javax.xml.transform.TransformerException;
import javax.xml.ws.Endpoint;
import java.io.*;
import java.io.StringWriter;
import java.math.BigDecimal;


import static org.junit.jupiter.api.Assertions.*;

class XMLConverterTest {

    private static final Logger logger = LogManager.getLogger(XMLConverterTest.class);
    @Test
    void test()  {
        logger.info("Metho JaxbConverter test");

     try {
         MyList<AbstractPerson> personMyList;

         CsvFileReader reader = new CsvFileReader(
                 ";",
                 "C:\\Users\\Ilyashnya\\IdeaProjects\\Lab2\\src\\main\\resources\\persons.csv");
         personMyList = reader.read();
         XMLConverter xmlConverter = new XMLConverter("pers.xml");
         xmlConverter.jaxbConv(personMyList);
     }
     catch (Exception e){
         logger.error("Ошибка "+e.getLocalizedMessage(), e.fillInStackTrace());
     }
    }

    @Test
    void test1() throws TransformerException, ParserConfigurationException {
        MyList<AbstractPerson> personMyList;
        CsvFileReader reader = new CsvFileReader(
                ";",
                "C:\\Users\\Ilyashnya\\IdeaProjects\\Lab2\\src\\main\\resources\\persons.csv");
        personMyList = reader.read();
        XMLConverter c=new XMLConverter("per.xml");
        c.domConv(personMyList);
    }

    @Test
    void test4() throws TransformerException, ParserConfigurationException {
        Endpoint.publish("http://localhost:9999/ws/hello", new PersonApi());

    }

    public static void main(String[] args) {
        logger.info("Metho JaxbConverter test");

        Endpoint.publish("http://localhost:9999/ws/hello", new PersonApi());
    }

}