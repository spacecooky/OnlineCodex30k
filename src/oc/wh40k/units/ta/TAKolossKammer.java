package oc.wh40k.units.ta;

import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerVater;

public class TAKolossKammer extends RuestkammerVater {

	OptionsUpgradeGruppe o1;
	OptionsUpgradeGruppe o2;
	OptionsUpgradeGruppe o3;
	OptionsZaehlerGruppe o4;
	boolean[] defaults;

	public TAKolossKammer() {
		grundkosten = 70;
	}

	@Override
	public void initButtons(boolean... defaults) {
		this.defaults = defaults;

		ogE.addElement(new OptionsGruppeEintrag("Schwärmer-System", "Schwärmer-Raketensystem", 0));
		ogE.addElement(new OptionsGruppeEintrag("Sync. Plasmabeschleuniger", "Synchronisierter Plasmabeschleuniger", 10));
		add(o1 = new OptionsUpgradeGruppe(0, randAbstand, cnt, "", ogE));
		o1.setSelected(0, true);

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Stabilisatorsystem", 10));
		ogE.addElement(new OptionsGruppeEintrag("Nachtsichtgerät", 3));
		ogE.addElement(new OptionsGruppeEintrag("Drohnencontroller", 0));
		ogE.addElement(new OptionsGruppeEintrag("Feuerleitsystem", 5));
		ogE.addElement(new OptionsGruppeEintrag("Schildgenerator", 20));
		ogE.addElement(new OptionsGruppeEintrag("Multiple Zielerfassung", 5));
		ogE.addElement(new OptionsGruppeEintrag("Verb. Zielerfassung", "Verbesserte Zielerfassung", 10));
		add(o2 = new OptionsUpgradeGruppe(0, randAbstand, cnt, "", ogE));
		o2.setSelected(0, true);

		if(defaults[0]) {
			seperator();

			ogE.addElement(new OptionsGruppeEintrag("Zeremoniendolch", 5));
			ogE.addElement(new OptionsGruppeEintrag("Kyb. Nachtsichtgerät", 3));
			ogE.addElement(new OptionsGruppeEintrag("Kyb. Drohnencontroller", 0));
			ogE.addElement(new OptionsGruppeEintrag("Kyb. Feuerleitsystem", 5));
			ogE.addElement(new OptionsGruppeEintrag("Kyb. multiple Zielerfassung", 5));
			add(o3 = new OptionsUpgradeGruppe(0, randAbstand, cnt, "", ogE, 100));
		}

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Angriffsdrohne", 10));
		ogE.addElement(new OptionsGruppeEintrag("Schilddrohne", 15));
		ogE.addElement(new OptionsGruppeEintrag("Markerdrohne", 30));
		add(o4 = new OptionsZaehlerGruppe(0, randAbstand, cnt, "", ogE, 2));

		sizeSetzen();
	}

	@Override
	public void refreshen() {
		if(!o1.isSelected()) o1.setSelected(0, true);
		if(!o2.isSelected()) o2.setSelected(0, true);

		o2.setLegal("Drohnencontroller", o4.isSelected() || (!o2.isSelected("Drohnencontroller")));
		o2.setLegal(o2.isSelected());
		o4.setLegal(!o4.isSelected() || (o2.isSelected("Drohnencontroller")));

		if(defaults[0] && o3.isSelected("Kyb. Drohnencontroller")) {
			o4.setLegal(true);
			o3.setLegal("Kyb. Drohnencontroller", o4.isSelected());
		}
	}

}
