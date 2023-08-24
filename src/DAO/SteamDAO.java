/* Decompiler 2ms, total 253ms, lines 18 */
package dao;

import java.util.List;

public abstract class SteamDAO<Entity, KeyType> {
   abstract public void insert(Entity entity);
    abstract public void update(Entity entity);
    abstract public void delete(KeyType key);
    abstract public List<Entity> selectAll();
    abstract public Entity selectById(KeyType key);
    abstract protected List<Entity> selectBySQL(String sql, Object...args);
    abstract protected List<Entity> SelectByType_combobox();
}