package oc.wh40k.units.el;

import oc.BuildaHQ;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerVater;

public class ELRunenleserKammer extends RuestkammerVater {

	public ELRunenleserKammer() {
		grundkosten = 25;
	}

	boolean Phantom;

	OptionsEinzelUpgrade o3;
	OptionsEinzelUpgrade o4;

	public void initButtons(boolean... defaults) {
		Phantom = defaults[1];

		add(ico = new oc.Picture("oc/wh40k/images/ELRunenleser.jpg"));
		

		add(o4 = new OptionsEinzelUpgrade(0, randAbstand, cnt, "", "Phantomseher", 6));
		add(new OptionsEinzelUpgrade(0, randAbstand, cnt, "", "Runenspeer", 3));

		seperator(5);

		add(o3 = new OptionsEinzelUpgrade(0, randAbstand, cnt, "", "Eldar-Jetbike", 20));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Nebelschleier", 15));
		ogE.addElement(new OptionsGruppeEintrag("Flammen der Wut", 10));
		ogE.addElement(new OptionsGruppeEintrag("Stählerne Entschlossenheit", 5));
		ogE.addElement(new OptionsGruppeEintrag("Khaines Segen", 15));

		add(new OptionsUpgradeGruppe(0, randAbstand, cnt, "", ogE));

		if (defaults.length > 0) {
			if (defaults[0]) {
				o3.setAktiv(false);
				grundkosten += 20;
			}
			if (defaults[1]) {
				o4.setSelected(true);
			}
		}


		sizeSetzen();
	}

	// @OVERRIDE
	public void refreshen() {
		if (Phantom) {
				o4.setSelected(true);
			}
	}
	
}
