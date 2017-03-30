package home.elitej.repository;


public interface Dao<E>{

    boolean create(E e);

    E selectById(int id);

    E update(E e);

    boolean removeById(int id);

}
