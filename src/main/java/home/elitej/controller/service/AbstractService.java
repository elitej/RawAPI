package home.elitej.controller.service;

public interface AbstractService<E> {

    /**
     * Saves passed entity in storage and returns true if saving was successful
     * @param e the entity for save in storage
     * @return true if saving was successful
     */
    boolean create(E e);

    /**
     * Receives id and then retrieves and returns the entity with same id from storage
     * @param id the entity that need retrieve
     * @return the entity with id equal passed id
     */
    E selectById(int id);

    /**
     * Receives the entity and then updates entity with same id in storage
     * @param e the entity for update in storage
     * @return updated entity
     */
    E update(E e);

    /**
     * Removes from storage the entity with passed id and returns true if removing was successful
     * @param id the entity that need remove
     * @return true if removing was successful
     */
    boolean removeById(int id);
}
