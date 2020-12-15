package Depo;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public abstract class AbstractDepo {
    private ArrayList List = new ArrayList();
    Connection c;

    public AbstractDepo(Connection c) { this.c = c;}

    public <E> void Add(E obj) { List.add(obj); }
    public <E> void Deletee( E obj) { List.remove(obj); }
    public abstract void Read() throws SQLException;
    public ArrayList getList() { return List; }
    public <E> E findById(int id) {
        return (E) List.get(id);
    }
}
