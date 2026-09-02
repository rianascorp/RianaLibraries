package rianaLibraries.repos;

public class GroupedValidation {

    /*
    *  validator.createCheck()
                .withMethod(c->{
                    String codePeriode=c.get("codeField");
                    if (codePeriode.isEmpty() || codePeriode.isBlank()){
                        c.error("Le code période ne doit pas être vide!");
                    }
                })
                .dependsOn("codeField",CodePeriodeTextField.textProperty())
                .decorates(CodePeriodeTextField)
                .immediate();

        validator.createCheck()
                        .withMethod(c->{
                            String codePeriode=c.get("codeField");
                            if(isDuplicate(codePeriode)){
                                c.error("Le Code période que vous avez chosi est déjà utilisé. Veuillez choisir un autre.");
                            }
                        })
                .dependsOn("codeField",CodePeriodeTextField.textProperty())
                .decorates(CodePeriodeTextField)
                .immediate();

        validator.createCheck()
                .withMethod(c->{
                    String numPeriode=c.get("numField");
                    if (!isNumeric(numPeriode)){
                        c.error("Le champ Numéro de Période doit contenir un nombre entier entre 1 et 6 (comprises).");
                    }
                })
                .dependsOn("numField",NumPeriodeTextField.textProperty())
                .decorates(NumPeriodeTextField)
                .immediate();

        validator.createCheck()
                .withMethod(c->{
                    String dateDebut=c.get("dDebut");
                    if (!datePickerValid(dateDebut)){
                        c.error("Le Champ Date Début doit contenir une Date de format jj/mm/aaaa");
                    }
                })
                .dependsOn("dDebut",DateDebutDatePicker.getEditor().textProperty())
                .decorates(DateDebutDatePicker)
                .immediate();

        validator.createCheck()
                .withMethod(c->{
                    String dateFin=c.get("dFin");
                    if (!datePickerValid(dateFin)){
                        c.error("Le Champ Date Fin doit contenir une Date de format jj/mm/aaaa");
                    }
                })
                .dependsOn("dFin",DateFinDatePicker.getEditor().textProperty())
                .decorates(DateFinDatePicker)
                .immediate();

        validator.createCheck()
                .withMethod(c->{
                    String dateDebutCompo=c.get("dDebutCompo");
                    if (!dateDebutCompo.isEmpty() || !dateDebutCompo.isBlank()){
                        if (!datePickerValid(dateDebutCompo)){
                            c.error("Le format du champ Date Début Composition doit être jj/mm/aa");
                        }
                    }
                })
                .dependsOn("dDebutCompo",DateDebutCompoDatePicker.getEditor().textProperty())
                .decorates(DateDebutCompoDatePicker)
                 .immediate();

        validator.createCheck()
                .withMethod(c->{
                    String dateFinCompo=c.get("dFinCompo");
                    if (!dateFinCompo.isEmpty() || !dateFinCompo.isBlank()){
                        if (!datePickerValid(dateFinCompo)){
                            c.error("Le format du champ Date Fin Composition doit être jj/mm/aa");
                        }
                    }
                })
                .dependsOn("dFinCompo",DateFinCompoDatePicker.getEditor().textProperty())
                .decorates(DateFinCompoDatePicker)
                .immediate();

        validator.createCheck()
                .withMethod(c->{
                    String remarques=c.get("remarques");
                    if(remarques.length()>500){
                        c.error("La champ Remarques doit contenir au plus 500 caractères.");
                    }
                })
                .dependsOn("remarques",RemarquesTextArea.textProperty())
                .decorates(RemarquesTextArea)
                .immediate();
    }

    private boolean isNumeric(String input){
        try {
            Integer.parseInt(input);
        }
        catch (NumberFormatException fe){
            return false;
        }
        if (Integer.parseInt(input)<1 || Integer.parseInt(input)>6){
            return false;
        }
        else {
            return true;
        }
    }

    private boolean isDuplicate(String code){
        for (Periode periode:model.getMList()){
            if (code.equals(periode.getCodePeriode())){
                return true;
            }
        }
        return false;
    }*/
}
