package rianaLibraries.person.base;

public interface SexMapper {

    Sex getAll();
    Sex getSexe(Integer code);
    int insertSexe(Sex sexe);
    int deleteSexe(Integer code);
    int updateSexe(Sex sexe);
}
