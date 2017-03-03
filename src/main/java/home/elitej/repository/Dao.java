package home.elitej.repository;


public interface Dao<Entity>{

    boolean create(Entity entity);

    Entity selectById(int id);

    Entity update(Entity entity);

    boolean removeById(int id);

}
