package oc.wh40k.units.ne;

import oc.BuildaHQ;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerVater;

public class NEKommandogleiterKammer extends RuestkammerVater {

    OptionsUpgradeGruppe weapons;

    public NEKommandogleiterKammer() {
        grundkosten = 80;
    }

    @Override
    public void initButtons(boolean... defaults) {
        add(ico = new oc.Picture("oc/wh40k/images/NEKommandogleiter.jpg"));
        

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Tesla-Kanone", 0));
        ogE.addElement(new OptionsGruppeEintrag("Gauss-Kanone", 0));
        add(weapons = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        sizeSetzen();
    }

    @Override
    public void refreshen() {
        if (!weapons.isSelected()) {
            weapons.setSelected(0, true);
        }
    }
}
