package oc.wh40k.units.tl;

import oc.Eintrag;

public class TLLuciusPatternDropPod extends Eintrag {

    public TLLuciusPatternDropPod() {
        name = "Lucius Pattern Drop Pod";
        grundkosten = 65;

        add(ico = new oc.Picture("oc/wh40k/images/TLLuciusPatternDrop.jpg"));

        complete();
    }

    @Override
    public void refreshen() {
    }
    
}
