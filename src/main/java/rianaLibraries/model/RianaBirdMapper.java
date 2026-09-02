package rianaLibraries.model;

public interface RianaBirdMapper<M> {
    M getAll();
    M get (String Code);
    M get (Integer Code);
    int insert (M m);
    int delete(String Code);
    int delete(Integer Code);
    int update(M m);
}
