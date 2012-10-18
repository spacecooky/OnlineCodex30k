package oc.wh40k.units.ba;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelZaehler;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.OptionsZaehlerGruppe;

public class BATechmarine extends Eintrag {

    OptionsUpgradeGruppe o1;
    OptionsUpgradeGruppe o2;
    OptionsUpgradeGruppe o3;
    OptionsZaehlerGruppe o4;
    OptionsEinzelZaehler oe;

    public BATechmarine() {
        name = "Tech-Marine";
        grundkosten = 50;

        add(ico = new oc.Picture("oc/wh40k/images/BATechMarine.jpg"));
        

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Servo-Arm", 0));
        ogE.addElement(new OptionsGruppeEintrag("Sprungmodul", 0));
        ogE.addElement(new OptionsGruppeEintrag("Servo-Harnisch", 25));
        add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
        o1.setSelected(0, true);

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Sturmbolter", 3));
        ogE.addElement(new OptionsGruppeEintrag("Kombi-Flammenwerfer", 10));
        ogE.addElement(new OptionsGruppeEintrag("Kombi-Melter", 10));
        ogE.addElement(new OptionsGruppeEintrag("Kombi-Plasmawerfer", 10));
        ogE.addElement(new OptionsGruppeEintrag("Plasma-Pistole", 15));
        add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Energiewaffe", 15));
        ogE.addElement(new OptionsGruppeEintrag("Energiehammer", 30));
        add(o3 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();

        add(oe = new OptionsEinzelZaehler(ID, randAbstand, cnt, "", "Servitor", 5, 15));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Schwerer Bolter", 20));
        ogE.addElement(new OptionsGruppeEintrag("Multimelter", 30));
        ogE.addElement(new OptionsGruppeEintrag("Plasmakanone", 30));
        add(o4 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "option", ogE, 0));

        complete();
    }

    @Override
    public void refreshen() {
        if (!o1.isSelected()) {
            o1.setSelected(0, true);
        }
        o4.setMaxAnzahl(oe.getAnzahl() < 2 ? oe.getAnzahl() : 2);
    }
    
}
