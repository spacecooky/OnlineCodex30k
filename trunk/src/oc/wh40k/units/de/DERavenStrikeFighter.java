package oc.wh40k.units.de;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;

public class DERavenStrikeFighter extends Eintrag {

    public DERavenStrikeFighter() {
        name = "Raven";
        grundkosten = 125;

        add(ico = new oc.Picture("oc/wh40k/images/DERaven.jpg"));
        
        add(new OptionsEinzelUpgrade(0, randAbstand, cnt, "", "Nachtfeld", 10));
        add(new OptionsEinzelUpgrade(0, randAbstand, cnt, "", "Flackerfeld", 10));

        complete();
    }

    @Override
    public void refreshen() {
    }

}
