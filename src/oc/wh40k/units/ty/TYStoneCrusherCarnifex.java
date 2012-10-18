package oc.wh40k.units.ty;

import oc.BuildaHQ;
import oc.Eintrag;

public class TYStoneCrusherCarnifex extends Eintrag {

    public TYStoneCrusherCarnifex() {
        name = "Stone-Crusher Carnifex";
        grundkosten = 195;

        add(ico = new oc.Picture("oc/wh40k/images/TYStoneCrusherCarnifex.gif"));
        

        complete();
    }

    @Override
    public void refreshen() {
    }
    
}
