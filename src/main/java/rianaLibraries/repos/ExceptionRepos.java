package rianaLibraries.repos;

public class ExceptionRepos {
    /**
     try {
     periodeMapper.insertPeriode(getTexts());
     sqlSession.commit();
     Refresh();
     closeButtonAction();
     }

     catch (PersistenceException e){
     /**Alert alert=new Alert(Alert.AlertType.ERROR);
     alert.setTitle("Error");
     alert.setHeaderText("Error");
    Throwable realCause= e.getCause();

                    if (realCause.getClass().getName().equals("org.postgresql.util.PSQLException")){
        if (((PSQLException) realCause).getSQLState().equals("23505")){
            //alert.setContentText("Le Code période que vous avez chosi est déjà utilisé. Veuillez choisir un autre.");
        }
    }
                    else{
        //alert.setContentText("Nom: "+e.getClass().getName()+" Message "+e.getMessage());
    }
    //alert.show();
}


                finally {
                        sqlSession.close();
                        }
     */
}
