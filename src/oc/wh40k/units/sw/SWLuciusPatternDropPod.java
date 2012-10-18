package oc.wh40k.units.sw;

import oc.Eintrag;

public class SWLuciusPatternDropPod extends Eintrag {

    public SWLuciusPatternDropPod() {
        name = "Lucius Pattern Drop Pod";
        grundkosten = 65;

        add(ico = new oc.Picture("oc/wh40k/images/SWLuciusPatternDrop.jpg"));

        complete();
    }

    @Override
    public void refreshen() {
    }
    
}
