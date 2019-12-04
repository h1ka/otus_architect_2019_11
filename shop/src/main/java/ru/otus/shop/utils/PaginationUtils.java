package ru.otus.shop.utils;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.*;
import ru.otus.shop.exception.WrongFieldsException;
import ru.otus.shop.web.request.PaginationParams;
import ru.otus.shop.web.request.SortParams;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

import static java.util.Optional.ofNullable;

/**
 * Утилитарный класс для пагинации и сортировки
 */
public class PaginationUtils {

    private PaginationUtils() {
    }

    /**
     * Создаёт запрос с пагинацией
     *
     * @param paginationParams параметры пагинации
     * @return запрос
     */
    public static Pageable createPageRequest(PaginationParams paginationParams) {
        return PageRequest.of(paginationParams.getPage(), paginationParams.getCount());
    }

    /**
     * Создаёт запрос с пагинацией и сортировкой
     *
     * @param paginationParams параметры пагинации
     * @param sortParams       параметры сортировки
     * @return запрос
     */
    public static Pageable createPageRequest(PaginationParams paginationParams, SortParams sortParams) {
        if (sortParams.getDirection() != null && StringUtils.isNotBlank(sortParams.getField())) {
            return PageRequest.of(paginationParams.getPage(), paginationParams.getCount(), sortParams.getDirection(), sortParams.getField());
        } else {
            return createPageRequest(paginationParams);
        }
    }

    /**
     * Возвращает отсортированную страницу объектов
     *
     * @param list             список объектов для сортировки
     * @param defaultFieldName название поля, по которому надо сортировать, если оно не указано в параметрах сортировки
     * @param paginationParams параметры пагинации
     * @param sortParams       параметры сортировки
     * @param <T>              тип объекта, который можно отсортировать
     * @return отсортированная страница объектов
     * @see PaginationParams
     * @see SortParams
     */
    public static <T extends ComparableDocument> Page<T> getSortedPage(List<T> list, String defaultFieldName, PaginationParams paginationParams, SortParams sortParams) {
        paginationParams = ofNullable(paginationParams).orElse(new PaginationParams());
        sortParams = ofNullable(sortParams)
                .map(v -> {
                    v.setField(ofNullable(v.getField()).orElse(defaultFieldName));
                    return v;
                })
                .orElse(new SortParams(defaultFieldName));
        sort(list, sortParams);
        Pageable pageable = PaginationUtils.createPageRequest(paginationParams, sortParams);
        int start = (int) pageable.getOffset();
        int end = Math.min((start + pageable.getPageSize()), list.size());
//        if (end <= start) {
//            throw new IllegalArgumentException(String.format("fromIndex(%d) > toIndex(%d)", start, end));
//        }
        return new PageImpl<>(list.subList(start, end), pageable, list.size());
    }

    /**
     * Сортирует список объектов
     *
     * @param list       список объектов для сортировки
     * @param sortParams параметры сортировки
     * @param <T>        тип объекта, который можно отсортировать
     */
    @SuppressWarnings("unchecked")
    private static <T extends ComparableDocument> void sort(List<T> list, SortParams sortParams) {
        Function<T, Comparable> func = (T no) -> no.fieldObjForSorting(sortParams.getField());
        Sort.Direction direction = sortParams.getDirection();
        switch (direction) {
            case ASC: {
                list.sort(Comparator.comparing(func::apply, Comparator.nullsLast(Comparator.naturalOrder())));
                break;
            }
            case DESC: {
                list.sort(Comparator.comparing(func::apply, Comparator.nullsLast(Comparator.naturalOrder())).reversed());
                break;
            }
            default: {
                throw new WrongFieldsException(SortParams.class.getName(), Collections.singletonMap("direction", direction.name()));
            }
        }
    }
}


