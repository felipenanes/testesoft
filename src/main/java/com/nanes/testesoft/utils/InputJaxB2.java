package com.nanes.testesoft.utils;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class InputJaxB2 {
    public Object unmarshalFromFile(Class clazz, String fileXml) {
        JAXBContext context = null;
        try {
            context = JAXBContext.newInstance(clazz);
            return context.createUnmarshaller().unmarshal(
                    new FileInputStream(fileXml)
            );
        } catch (JAXBException | FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
