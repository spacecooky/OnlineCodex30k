package oc.wh40k.units.ta;

import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerVater;

public class TAHazardKammer extends RuestkammerVater {

	OptionsZaehlerGruppe o1;
	OptionsZaehlerGruppe o1def;
	OptionsUpgradeGruppe o2;
	OptionsZaehlerGruppe o3;

	public TAHazardKammer() {
		grundkosten = 75;
	}

	@Override
	public void initButtons(boolean... defaults) {
		ogE.addElement(new OptionsGruppeEintrag("Sync. Pulskanone", "Synchronisierte Pulskanone", 0));
		add(o1def = new OptionsZaehlerGruppe(0, randAbstand, cnt, "", ogE, 2));
		ogE.addElement(new OptionsGruppeEintrag("Phased Ion Gun", 10));
		ogE.addElement(new OptionsGruppeEintrag("Fusion Cascade", 15));
		ogE.addElement(new OptionsGruppeEintrag("Pulse Sub-Rifle", "Pulse Subminitions Rifle", 20));
		add(o1 = new OptionsZaehlerGruppe(0, randAbstand, cnt, "", ogE, 2));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Nachtsichtgerät", 5));
		ogE.addElement(new OptionsGruppeEintrag("Drohnencontroller", 10));
		ogE.addElement(new OptionsGruppeEintrag("Multiple Zielerfassung", 5));
		ogE.addElement(new OptionsGruppeEintrag("Schildgenerator", 25));
		add(o2 = new OptionsUpgradeGruppe(0, randAbstand, cnt, "", ogE));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Angriffsdrohne", 10));
		ogE.addElement(new OptionsGruppeEintrag("Schilddrohne", 15));
		ogE.addElement(new OptionsGruppeEintrag("Markerdrohne", 30));
		add(o3 = new OptionsZaehlerGruppe(0, randAbstand, cnt, "", ogE, 2));

		sizeSetzen();
	}

	@Override
	public void refreshen() {
		o1def.setMaxAnzahl(2 - o1.getAnzahl());
		o1def.setAnzahl(0, 2 - o1.getAnzahl());

		if(!o2.isSelected()) o2.setSelected(0, true); // mandatory selection
		o3.setMaxAnzahl(o2.isSelected("Drohnencontroller") ? 2 : 0);
	}

}
