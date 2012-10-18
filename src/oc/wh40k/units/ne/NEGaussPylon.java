package oc.wh40k.units.ne;

import oc.Eintrag;

public class NEGaussPylon extends Eintrag {

    public NEGaussPylon() {
        name = "Gauss Pylon";
        grundkosten = 420;

        add(ico = new oc.Picture("oc/wh40k/images/GaussPylon.gif"));

        complete();
    }

    @Override
    public void refreshen() {
    }
    
}
