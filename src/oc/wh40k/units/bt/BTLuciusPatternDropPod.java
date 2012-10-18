package oc.wh40k.units.bt;

import oc.Eintrag;

public class BTLuciusPatternDropPod extends Eintrag {

    public BTLuciusPatternDropPod() {
        name = "Lucius Pattern Drop Pod";
        grundkosten = 65;

        add(ico = new oc.Picture("oc/wh40k/images/BTLuciusPatternDrop.jpg"));

        complete();
    }

    @Override
    public void refreshen() {
    }
    
}
