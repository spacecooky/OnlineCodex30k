package oc.wh40k.units.de;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.OptionsZaehlerGruppe;

public class DESuccubus extends Eintrag {

    OptionsZaehlerGruppe o1;
    OptionsUpgradeGruppe o2;

    public DESuccubus() {
        name = "Succubus";
        grundkosten = 65;

        BuildaHQ.addToInformationVector("DEHQ", 1);
        
        add(ico = new oc.Picture("oc/wh40k/images/DESuccubus.jpg"));
        

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Giftklinge", 5));
        ogE.addElement(new OptionsGruppeEintrag("Schattenpistole", 15));
        ogE.addElement(new OptionsGruppeEintrag("Energiewaffe", 15));
        ogE.addElement(new OptionsGruppeEintrag("Peiniger", 20));
        ogE.addElement(new OptionsGruppeEintrag("Schockpeitsche", 20));
        add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 2));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Hydraklingen", 5));
        ogE.addElement(new OptionsGruppeEintrag("Dornennetz & Pfähler", 5));
        ogE.addElement(new OptionsGruppeEintrag("Klingenpeitschen", 10));
        add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();

        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Impulsminen", 5));

        complete();
    }

    @Override
    public void refreshen() {
        o1.setAktiv(!o2.isSelected());
        o2.setAktiv(!o1.isSelected());

        o1.setLegal("Schattenpistole", o1.getAnzahl("Schattenpistole") < 2);
    }

	@Override
	public void deleteYourself() {
		super.deleteYourself();
        BuildaHQ.addToInformationVector("DEHQ", -1);
	}

}
