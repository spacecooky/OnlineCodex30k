package oc.wh40k.units.ta;

import oc.BuildaHQ;
import oc.Eintrag;

public class TACommanderRalai extends Eintrag {

    public TACommanderRalai() {
        name = "Commander R'alai";
        grundkosten = 190;

        add(ico = new oc.Picture("oc/wh40k/images/TACommanderRalai.jpg"));
        

        complete();
    }

    @Override
    public void refreshen() {
        setUnikat(true);
    }

}
