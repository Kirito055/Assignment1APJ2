package model;

import java.util.List;

public interface Read <T> {

    public List<T> Read(String path);
}
