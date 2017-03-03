package home.elitej.service;

public interface AbstractService<Entity> {

    boolean create(Entity entity);

    Entity selectById(int id);

    Entity update(Entity entity);

    boolean removeById(int id);
}
