package oc.wh40k.units.de;

import oc.BuildaHQ;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerVater;

public class DESchattenbarke extends RuestkammerVater {

    OptionsUpgradeGruppe weapons;

    public DESchattenbarke() {
        grundkosten = 60;
    }

    @Override
    public void initButtons(boolean... defaults) {
        add(ico = new oc.Picture("oc/wh40k/images/DESchattenbarke.jpg"));
        

        ogE.addElement(new OptionsGruppeEintrag("Schattenlanze", 0));
        ogE.addElement(new OptionsGruppeEintrag("Schattenkanone", 0));
        add(weapons = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();

        add(new OptionsEinzelUpgrade(0, randAbstand, cnt, "", "Schocksporn", 5));
        add(new OptionsEinzelUpgrade(0, randAbstand, cnt, "", "Terrorgas-Granatwerfer", 5));
        add(new OptionsEinzelUpgrade(0, randAbstand, cnt, "", "Verbesserte �thersegel", 5));
        add(new OptionsEinzelUpgrade(0, randAbstand, cnt, "", "Bremstriebwerke", 5));
        add(new OptionsEinzelUpgrade(0, randAbstand, cnt, "", "Fangketten", 5));
        add(new OptionsEinzelUpgrade(0, randAbstand, cnt, "", "Grausige Troph�en", 5));
        add(new OptionsEinzelUpgrade(0, randAbstand, cnt, "", "Toxinklingen", 5));
        add(new OptionsEinzelUpgrade(0, randAbstand, cnt, "", "Splitterwaffen-Vorrat", 10));
        add(new OptionsEinzelUpgrade(0, randAbstand, cnt, "", "Nachtfeld", 10));
        add(new OptionsEinzelUpgrade(0, randAbstand, cnt, "", "Flackerfeld", 10));

        sizeSetzen();
    }

    @Override
    public void refreshen() {
        if (!weapons.isSelected()) {
            weapons.setSelected(0, true);
        }
    }

}
