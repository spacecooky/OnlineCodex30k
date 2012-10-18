package oc.wh40k.units.de;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;

public class DEArchon extends Eintrag {

    OptionsZaehlerGruppe o1;
    OptionsEinzelUpgrade oe1;
    OptionsEinzelUpgrade oe2;

    public DEArchon() {
        name = "Archon";
        grundkosten = 60;

        BuildaHQ.addToInformationVector("DEHQ", 1);
        BuildaHQ.addToInformationVector("DEArchon", 1);

        add(ico = new oc.Picture("oc/wh40k/images/DEArchon.jpg"));
        

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Giftklinge", 5));
        ogE.addElement(new OptionsGruppeEintrag("Schattenpistole", 15));
        ogE.addElement(new OptionsGruppeEintrag("Energiewaffe", 15));
        ogE.addElement(new OptionsGruppeEintrag("Schattenkatapult", 15));
        ogE.addElement(new OptionsGruppeEintrag("Peiniger", 20));
        ogE.addElement(new OptionsGruppeEintrag("Schockpeitsche", 20));
        ogE.addElement(new OptionsGruppeEintrag("Staubklinge", 35));
        add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 2));

        seperator();

        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Impulsminen", 5));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Geisterharnisch", 10));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Kampfdrogen", 10));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Seelenfalle", 10));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Dschinnklinge", 20));
        add(oe1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Klonfeld", 20));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Wahngaswerfer", 25));
        add(oe2 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Schattenfeld", 30));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Portalfokus", 35));

        complete();
    }

    @Override
    public void deleteYourself() {
        super.deleteYourself();
        BuildaHQ.addToInformationVector("DEHQ", -1);
        BuildaHQ.addToInformationVector("DEArchon", -1);
    }

    @Override
    public void refreshen() {
        oe1.setAktiv(!oe2.isSelected());
        oe2.setAktiv(!oe1.isSelected());
    }
    
}
