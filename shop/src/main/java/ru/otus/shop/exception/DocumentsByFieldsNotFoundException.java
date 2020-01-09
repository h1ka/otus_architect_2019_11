package ru.otus.shop.exception;

import lombok.Data;
import lombok.Getter;

import java.util.Map;

/**
 * Происходит, когда не найдены объекты с типом <code>document</code> и полями/значениями <code>fields</code>
 */
@Getter
public class DocumentsByFieldsNotFoundException extends RuntimeException {

    private DocumentsByFieldsNotFoundObject obj;

    public DocumentsByFieldsNotFoundException(String document, Map<String, String> fields) {
        super(String.format("Error in getting '%s': %s", document, fields));
        DocumentsByFieldsNotFoundObject nobj = new DocumentsByFieldsNotFoundObject();
        nobj.setDocument(document);
        nobj.setFields(fields);
        this.obj = nobj;
    }

    @Data
    public static class DocumentsByFieldsNotFoundObject {

        /**
         * Название класса документа
         */
        private String document;

        /**
         * Названия/значения полей
         */
        private Map<String, String> fields;

    }

}
