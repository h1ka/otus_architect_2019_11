package ru.otus.shop.exception;


import lombok.Data;
import lombok.Getter;

/**
 * Происходит, когда не найдел объект с типом <code>document</code> и идентификатором <code>id</code>
 */
@Getter
public class DocumentNotFoundException extends RuntimeException {

    private DocumentNotFoundObject obj;

    public DocumentNotFoundException(String document, Long id) {
        super(String.format("Document '%s' with ID '%s' is not found", document, id));
        DocumentNotFoundObject nobj = new DocumentNotFoundObject();
        nobj.setDocument(document);
        nobj.setId(id);
        this.obj = nobj;
    }

    @Data
    public static class DocumentNotFoundObject {

        /**
         * Название класса документа
         */
        private String document;

        /**
         * Идентификатор сущности
         */
        private Long id;

    }

}
