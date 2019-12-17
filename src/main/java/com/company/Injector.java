package com.company;

import com.company.MyCollection.MyList;
import com.company.Patterns.SortStrategy.Strategyimpl.QuickSortStrategy;
import com.company.Person.AbstractPerson;
import lombok.Value;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.Properties;

public class Injector {

    public static <T> T inject(T object) throws  MyException {

        try {


            Properties appProps = new Properties();
            appProps.load(new FileInputStream("C:\\Users\\Ilyashnya\\IdeaProjects\\Lab2\\src\\main\\resources\\application.properties"));
            Class clas = Class.forName(appProps.getProperty("SortStrategy"));
            Field[] fields = object.getClass().getDeclaredFields();
            for (Field field : fields) {
                if (field.isAnnotationPresent(LabInject.class)) {
                    field.setAccessible(true);
                    field.set(object, clas.newInstance());
                    System.out.println(field.toString());
                }
            }
            return object;
        }
        catch (Exception e){
            throw new MyException(e.toString());
        }
    }

}
