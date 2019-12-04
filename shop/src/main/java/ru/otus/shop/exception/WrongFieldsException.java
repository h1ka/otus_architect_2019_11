package ru.otus.shop.exception;

import lombok.Data;
import lombok.Getter;

import java.util.Map;

/**
 * Происходит, когда у объекта с типом <code>document</code> для полей установлены неверные значения.
 * Ключи <code>wrongFields</code> - названия полей.
 * Значения <code>wrongFields</code> - неверные значения.
 */
@Getter
public class WrongFieldsException extends RuntimeException {

    private WrongFieldsObject obj;

    public WrongFieldsException(String document, String id, Map<String, String> wrongFields) {
        super(String.format("Wrong fields in '%s' with id '%s': %s", document, id, wrongFields));
        WrongFieldsObject nobj = new WrongFieldsObject();
        nobj.setDocument(document);
        nobj.setId(id);
        nobj.setWrongFields(wrongFields);
        this.obj = nobj;
    }

    public WrongFieldsException(String document, Map<String, String> wrongFields) {
        super(String.format("Wrong fields in '%s': %s", document, wrongFields));
        WrongFieldsObject nobj = new WrongFieldsObject();
        nobj.setDocument(document);
        nobj.setWrongFields(wrongFields);
        this.obj = nobj;
    }

    @Data
    public static class WrongFieldsObject {

        /**
         * Название класса документа
         */
        private String document;

        /**
         * Идентификатор документа
         */
        private String id;

        /**
         * Названия/значения полей
         */
        private Map<String, String> wrongFields;

    }

}
