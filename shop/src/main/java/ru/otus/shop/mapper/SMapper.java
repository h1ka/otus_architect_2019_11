package ru.otus.shop.mapper;

import org.springframework.data.domain.Page;

import java.util.Collection;
import java.util.List;

/**
 * Абстрактный маппер
 * объектов информационного
 * взаимодействия
 *
 * @param<DOC> документ MongoDB
 * @param<DTO> Объект DTO
 * для сущности
 */

public interface SMapper<DOC, DTO> {


    /**
     * Преобразует DTO в документ
     *
     * @param dto объект
     * @return документ
     */
    DOC toDocument(DTO dto);

    /**
     * Преобразует документ в DTO
     *
     * @param document документ
     * @return объект
     */
    DTO toDto(DOC document);

    /**
     * Получает из маппера объекты DTO для коллекции документов
     *
     * @param documents коллекция документов
     * @return список объектов DTO
     */
    List<DTO> createDTOs(Collection<DOC> documents);

    /**
     * Получает из маппера постраничный список объектов DTO для постраничного списка документов
     *
     * @param documents постраничный списка документов
     * @return постраничный список объектов DTO
     */
    Page<DTO> createDTOs(Page<DOC> documents);

}
