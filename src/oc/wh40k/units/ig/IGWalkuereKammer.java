package oc.wh40k.units.ig;

import oc.OptionsEinzelZaehler;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerVater;

public class IGWalkuereKammer extends RuestkammerVater {

    OptionsUpgradeGruppe o1;
    OptionsUpgradeGruppe o2;

    public IGWalkuereKammer() {
        grundkosten = 100;
        name = "Walk�re";
    }

    @Override
    public void initButtons(boolean... defaults) {
        add(ico = new oc.Picture("oc/wh40k/images/IGWalkuereKammer.jpg"));

        ogE.addElement(new OptionsGruppeEintrag("Multilaser", 0));
        ogE.addElement(new OptionsGruppeEintrag("Laserkanone", 15));
        add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("2 Donnerkeilraketen", "Paar Donnerkeilraketen", 0));
        ogE.addElement(new OptionsGruppeEintrag("2 Salvenraketenwerfer", "Paar Salvenraketenwerfer", 30));
        add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();

        add(new OptionsEinzelZaehler(ID, randAbstand, cnt, "option", "2 Schwere Bolter", "Paar schwere Bolter", 3, 10));
        
        sizeSetzen();
    }

    @Override
    public void refreshen() {
        o1.alwaysSelected();
        o2.alwaysSelected();
    }
    
}
