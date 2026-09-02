package rianaLibraries;

public class Tricks {
    private Integer number;

    public Integer nextCode(Integer lastCode){
        if (lastCode ==null)
        {
            number=1;
        }
        else{
            number=lastCode+1;
        }
        return number;
    }


}
