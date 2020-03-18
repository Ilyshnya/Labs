package com.company.Serviec;

import com.company.Person.AbstractPerson;
import com.company.Person.ConcretePerson;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import java.lang.invoke.MethodHandles;
import java.util.List;

@WebService
@SOAPBinding(style = SOAPBinding.Style.DOCUMENT, use= SOAPBinding.Use.LITERAL)
public interface Wsdl{


    @WebMethod
    String getHelloWorldAsString(String name);

    @WebMethod
    List<? extends AbstractPerson> getPersonById(int id);

    @WebMethod
    List<? extends AbstractPerson> getPersonsByParams(String param);

    @WebMethod
    List<? extends AbstractPerson> getPersonsByDivision(int id ,String name);
}
