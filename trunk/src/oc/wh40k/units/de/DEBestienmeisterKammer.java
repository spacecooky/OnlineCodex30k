package oc.wh40k.units.de;

import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerVater;

public class DEBestienmeisterKammer extends RuestkammerVater {

    OptionsZaehlerGruppe o1;
    OptionsZaehlerGruppe o2;
    OptionsZaehlerGruppe o3;
    OptionsUpgradeGruppe o4;

    Boolean hasWeapon = false;

	public DEBestienmeisterKammer() {
		grundkosten = 12;
	}

	@Override
	public void initButtons(boolean... defaults) {
        ogE.addElement(new OptionsGruppeEintrag("Khymäre", 12));
        add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 5));

        ogE.addElement(new OptionsGruppeEintrag("Klauenbestie", 40));
        add(o2 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));

        ogE.addElement(new OptionsGruppeEintrag("Sichelflügel-Schwarm", 15));
        add(o3 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 2));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Giftklinge", 5));
        ogE.addElement(new OptionsGruppeEintrag("Energiewaffe", 10));
        ogE.addElement(new OptionsGruppeEintrag("Peiniger", 20));
        add(o4 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "option", ogE));

		sizeSetzen();
	}

	@Override
	public void refreshen() {
        o1.setMaxAnzahl(!o2.isSelected() && !o3.isSelected() ? 5 : 0);
        o2.setMaxAnzahl(!o1.isSelected() && !o3.isSelected() ? 1 : 0);
        o3.setMaxAnzahl(!o1.isSelected() && !o2.isSelected() ? 2 : 0);

        hasWeapon = o4.isSelected();
	}

    @Override
    public Object getSpecialValue() {
        return this.hasWeapon;
    }

    @Override
    public void switchEntry(String name, boolean aktiv) {
        if(name.equals("WEAPON")) {
            o4.setAktiv(aktiv);
        }
        if(name.equals("CLEAR") && aktiv == true) {
            o4.deselectAll();
        }
    }

}
