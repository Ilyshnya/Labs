package com.company;

import com.company.Person.AbstractPerson;

import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;
@XmlType(name = "company")
@XmlRootElement
public class Company {
    @XmlElementWrapper(name="wild-animals", nillable = true)
    public List<AbstractPerson> people;

    public Company(List<AbstractPerson> people) {
        this.people = people;
    }

    public Company() {
    }
}
