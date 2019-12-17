package com.company.Person.Division;


import ru.vsu.lab.entities.IDivision;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Divisionimpl implements IDivision {

    private Integer id;
    private String name;
    private static Set<IDivision> list=new HashSet<>();

    public static Set<IDivision> getList(){
        return list;
    }

    public Divisionimpl(){

    }
    public Divisionimpl(Integer id,String name){
        this.name=name;
        this.id=id;

    }
    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id=id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name=name;
    }

    public static Divisionimpl equals(String name){
        for (IDivision d:list){
            if( d.getName().equalsIgnoreCase(name))
                return  (Divisionimpl) d;
        }
        return null;
    }

    @Override
    public int hashCode() {

        return name.toCharArray().hashCode();
    }



}
