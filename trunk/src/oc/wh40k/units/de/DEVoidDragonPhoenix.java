package oc.wh40k.units.de;

import oc.BuildaHQ;
import oc.Eintrag;

public class DEVoidDragonPhoenix extends Eintrag {

    public DEVoidDragonPhoenix() {
        name = "Void Dragon Phoenix";
        grundkosten = 360;

        add(ico = new oc.Picture("oc/wh40k/images/DEVoidDragonPhoenix.jpg"));
        

        complete();
    }

    @Override
    public void refreshen() {
    }

}
