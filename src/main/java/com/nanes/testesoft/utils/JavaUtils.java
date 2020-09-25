package com.nanes.testesoft.utils;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.lang.reflect.Field;

public class JavaUtils {

    /**
     * PT-BR: Método serve para dar update em campos especificos de uma entidade
     * Copy properties object to another object.
     * This method ignore null fields.
     *
     * @param oldObject this is a old object that will be complemented.
     * @param newObject this is a new object that will pass your
     *                  information to the old object.
     *
     * @return {@link T} old object with new properties.
     * */
    public static <T> T copyProperties(T oldObject, T newObject) {
        try {
            Field[] oldObjectFields = oldObject.getClass().getDeclaredFields();
            Field[] newObjectFields = newObject.getClass().getDeclaredFields();

            for (Field oldField : oldObjectFields) {
                oldField.setAccessible(true);
                for (Field newField : newObjectFields) {
                    newField.setAccessible(true);
                    if (newField.get(newObject) != null) {
                        if (oldField.getName().equals(newField.getName())) {
                            oldField.set(oldObject, newField.get(newObject));
                        }
                    }
                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return oldObject;
    }
}