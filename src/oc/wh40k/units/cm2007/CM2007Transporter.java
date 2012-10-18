package oc.wh40k.units.cm2007;

import oc.BuildaHQ;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerVater;

public class CM2007Transporter extends RuestkammerVater {

	OptionsEinzelUpgrade o1;
	OptionsEinzelUpgrade o2;
	OptionsEinzelUpgrade o3;
	OptionsUpgradeGruppe o4;
	OptionsUpgradeGruppe o5;

	public CM2007Transporter() {
        grundkosten = 0;
	}

	public void initButtons(boolean... defaults) {
		add(ico = new oc.Picture("oc/wh40k/images/ChaosRhinoKammer.gif"));

		seperator();

                ogE.addElement(new OptionsGruppeEintrag("Chaos Rhino", 35));
                add(o5 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

                seperator();

		add(o1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Bulldozerschaufel", 5));
		add(o2 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Zusätzliche Panzerung", 15));
		add(o3 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Dämonenmaschine", 20));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Synchronisierter Bolter", 5));
		ogE.addElement(new OptionsGruppeEintrag("Kombi-Melter", 10));
		ogE.addElement(new OptionsGruppeEintrag("Kombi-Plasmawerfer", 10));
		ogE.addElement(new OptionsGruppeEintrag("Kombi-Flammenwerfer", 10));
		ogE.addElement(new OptionsGruppeEintrag("Inferno-Raketenwerfer", 15));
		add(o4 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

		sizeSetzen();
	}

	public void refreshen() {
                o5.alwaysSelected();
	}

}
