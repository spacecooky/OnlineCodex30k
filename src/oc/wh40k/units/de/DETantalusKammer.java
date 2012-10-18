package oc.wh40k.units.de;

import oc.BuildaHQ;
import oc.OptionsEinzelUpgrade;
import oc.RuestkammerVater;

public class DETantalusKammer extends RuestkammerVater {

    public DETantalusKammer() {
        grundkosten = 215;
    }

    @Override
    public void initButtons(boolean... defaults) {
        add(ico = new oc.Picture("oc/wh40k/images/DETantalus.jpg"));
        

        add(new OptionsEinzelUpgrade(0, randAbstand, cnt, "", "Schocksporn", 5));
        add(new OptionsEinzelUpgrade(0, randAbstand, cnt, "", "Terrorgas-Granatwerfer", 5));
        add(new OptionsEinzelUpgrade(0, randAbstand, cnt, "", "Bremstriebwerke", 5));
        add(new OptionsEinzelUpgrade(0, randAbstand, cnt, "", "Grausige Trophäen", 5));
        add(new OptionsEinzelUpgrade(0, randAbstand, cnt, "", "Nachtfeld", 10));

        sizeSetzen();
    }

    @Override
    public void refreshen() {
    }

}
