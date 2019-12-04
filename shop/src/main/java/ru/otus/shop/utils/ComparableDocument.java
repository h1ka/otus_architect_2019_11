package ru.otus.shop.utils;

/**
 * Позволяет сортировать по полю документа
 */
public interface ComparableDocument {

    /**
     * Возвращает значение поля по его названию, который поддерживает интерфейс <code>Comparable</code>
     *
     * @param fieldName название поля
     * @return значение поля
     * @see Comparable
     */
    Comparable<?> fieldObjForSorting(String fieldName);

}
