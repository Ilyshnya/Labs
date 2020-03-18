package com.company.Serviec;

import com.company.MyCollection.MyList;
import com.company.Patterns.Command.Reader.Readerimpl.CsvFileReader;
import com.company.Person.AbstractPerson;
import com.company.Person.ConcretePerson;
import lombok.Data;
import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.spi.LoggerFactory;


import javax.jws.WebService;
import java.lang.invoke.MethodHandles;
import java.util.ArrayList;
import java.util.List;

@Data
@WebService(endpointInterface = "com.company.Serviec.Wsdl")
public class PersonApi implements Wsdl {

    private MyList<AbstractPerson> personMyList;


    private String connectionString = "C:\\Users\\Ilyashnya\\IdeaProjects\\Lab2\\src\\main\\resources\\persons.csv";

    private static final Logger logger = LogManager.getLogger(PersonApi.class);

    @Override
    public String getHelloWorldAsString(String name) {
        return "Hello World JAX-WS " + name;
    }

    @Override
    public List<? extends AbstractPerson> getPersonById(int id) {
        logger.info("start getPersonbyId");
        try {
            logger.log(Level.WARN,"Небезопасный участок кода стартует ----");
            if (personMyList == null) {
                CsvFileReader reader = new CsvFileReader(";", connectionString);
                personMyList = reader.read();
            }

        return personMyList.searchBy(person -> person.getId() == id).toList();
        }
        catch(Exception e){
            logger.error("Ошибка " + e.getLocalizedMessage(), e);

        }
        return new ArrayList<>();
    }

    @Override
    public List<? extends AbstractPerson> getPersonsByParams(String param) {
        try {
            logger.info("Running the method: getPersonsByParams(String param)");

            if (personMyList == null) {
                CsvFileReader reader = new CsvFileReader(";", connectionString);
                personMyList = reader.read();
            }
            logger.info("The method finished: getPersonsByParams(String param)");
            return personMyList.searchBy(person -> person.getFirstName().equals(param)).toList();
        } catch (Exception e) {
            logger.error("Ошиб_Очка" + e.getMessage(), e);

        }

        return new ArrayList<>();
        //return  personMyList.searchBy(person -> person.getFirstName().equals(param)).toList();
    }

    @Override
    public List<? extends AbstractPerson> getPersonsByDivision(int id, String name) {
        logger.info("Running the method: getPersonsByDivision(int id, String name)");
        if (personMyList == null) {
            CsvFileReader reader = new CsvFileReader(";", connectionString);
            personMyList = reader.read();
        }
        logger.info("The method finished: getPersonsByDivision(int id, String name)");
        return personMyList.searchBy(person -> person.getDivision().getId().equals(id)
                && person.getDivision().getName().equalsIgnoreCase(name)).toList();
    }

}