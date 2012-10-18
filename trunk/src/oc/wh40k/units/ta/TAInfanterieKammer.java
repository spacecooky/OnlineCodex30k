package oc.wh40k.units.ta;

import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerVater;

public class TAInfanterieKammer extends RuestkammerVater {

	OptionsUpgradeGruppe o1;
	OptionsZaehlerGruppe o4;

	public TAInfanterieKammer() {
		grundkosten = 10;
	}

	public void initButtons(boolean... defaults) {
		if (defaults[0]) {
			add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Zielmarker", 10));
			seperator();
		}

		ogE.addElement(new OptionsGruppeEintrag("Zeremoniendolch", 5));
		ogE.addElement(new OptionsGruppeEintrag("Kyb. Drohnencontroller", 0));
		ogE.addElement(new OptionsGruppeEintrag("Kyb. Feuerleitsystem", 5));
		ogE.addElement(new OptionsGruppeEintrag("Kyb. multiple Zielerfassung", 5));
		ogE.addElement(new OptionsGruppeEintrag("Kyb. Nachtsichtgerät", 3));
		if(defaults.length > 1 && defaults[1]) {
			ogE.addElement(new OptionsGruppeEintrag("EMP-Granaten", 3));
		}
		add(o1 = new OptionsUpgradeGruppe(0, randAbstand, cnt, "", ogE, 100));
		o1.setPunkteLimitGruppe(true);

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Angriffsdrohne", 10));
		ogE.addElement(new OptionsGruppeEintrag("Schilddrohne", 15));
		ogE.addElement(new OptionsGruppeEintrag("Markerdrohne", 30));
		add(o4 = new OptionsZaehlerGruppe(0, randAbstand, cnt, "", ogE, 2));

		sizeSetzen();
	}

	@Override
	public void refreshen() {
		o1.setLegal("Kyb. Drohnencontroller", o4.isSelected() || (!o1.isSelected("Kyb. Drohnencontroller")));
		o4.setLegal(!o4.isSelected() || (o1.isSelected("Kyb. Drohnencontroller")));
	}

	@Override
	public Object getSpecialValue() {
		return (o1.isSelected("EMP-Granaten") ? "TRUE" : "FALSE");
	}
	
}


