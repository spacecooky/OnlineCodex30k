package oc.wh40k.units.ta;

import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerVater;

public class TAShasvreKammer extends RuestkammerVater {

	OptionsEinzelUpgrade fb;
	OptionsUpgradeGruppe o1;
	OptionsUpgradeGruppe o3;
	OptionsZaehlerGruppe o4;

	public TAShasvreKammer() {
		grundkosten = 5;
	}

	@Override
	public void initButtons(boolean... defaults) {
		// Only for Ghost boss
		if(defaults.length >= 2 && defaults[1]) {
			add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Zielmarker", 10));
		}
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Zeremoniendolch", 5));

		seperator();

		if(defaults[0]) ogE.addElement(new OptionsGruppeEintrag("Peilmarker", 15));
		ogE.addElement(new OptionsGruppeEintrag("Kyb. Nachtsichtgerät", 3));
		ogE.addElement(new OptionsGruppeEintrag("Kyb. Drohnencontroller", 0));
		ogE.addElement(new OptionsGruppeEintrag("Kyb. Feuerleitsystem", 5));
		ogE.addElement(new OptionsGruppeEintrag("Kyb. multiple Zielerfassung", 5));
		add(o3 = new OptionsUpgradeGruppe(0, randAbstand, cnt, "", ogE, 100));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Angriffsdrohne", 10));
		ogE.addElement(new OptionsGruppeEintrag("Schilddrohne", 15));
		ogE.addElement(new OptionsGruppeEintrag("Markerdrohne", 30));
		add(o4 = new OptionsZaehlerGruppe(0, randAbstand, cnt, "", ogE, 2));

		sizeSetzen();
	}

    @Override
    public Object getSpecialValue() {
        if(o3.isSelected("Kyb. Drohnencontroller")) return("Kyb. Drohnencontroller");
        else return("");
    }

    @Override
	public void switchEntry(String name, boolean aktiv) {
		if(o3.contains(name)) o3.setAktiv(name, aktiv);
	}

    @Override
	public void refreshen() {
		if(o3.isSelected("Kyb. Drohnencontroller")) {
			o4.setAktiv(true);
			o3.setLegal("Kyb. Drohnencontroller", o4.isSelected());
		} else {
			o3.setLegal("Kyb. Drohnencontroller", true);
			o4.setAktiv(false);
		}
	}

}
