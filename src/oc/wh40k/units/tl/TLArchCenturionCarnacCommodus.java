package oc.wh40k.units.tl;

import oc.BuildaHQ;
import oc.Eintrag;

public class TLArchCenturionCarnacCommodus extends Eintrag {

    public TLArchCenturionCarnacCommodus() {
        name = "Arch-Centurion Carnac Commodus";
        grundkosten = 105;

        add(ico = new oc.Picture("oc/wh40k/images/TLLugftHuron.jpg"));

        seperator();

        complete();
    }

    @Override
    public void refreshen() {
        setUnikat(true);
    }
}
