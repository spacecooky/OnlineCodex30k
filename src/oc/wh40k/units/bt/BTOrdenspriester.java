package oc.wh40k.units.bt;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerStarter;

public class BTOrdenspriester extends Eintrag {

	OptionsUpgradeGruppe o1;
	OptionsUpgradeGruppe o2;
	OptionsEinzelUpgrade oe1;
	RuestkammerStarter rkWargear;

	public BTOrdenspriester() {
		name = "Ordenspriester";
		überschriftSetzen = true;

		BuildaHQ.addToInformationVector("BTHQ", 1);
		BuildaHQ.addToInformationVector("BTKommandant", 1);
		BuildaHQ.addToInformationVector("BTOrdenspriester", 1);

		add(ico = new oc.Picture("oc/wh40k/images/BTOrdenspriester.jpg"));

		ogE.addElement(new OptionsGruppeEintrag("Reclusiarch", 95));
		ogE.addElement(new OptionsGruppeEintrag("Meister der Reinheit", 110));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		o1.setSelected(0, true);

		seperator();

		add(oe1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "An Komm-Trupp anschließen", "Angeschlossen an Kommandotrupp ", 0));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Rasender Angriff", 3));
		ogE.addElement(new OptionsGruppeEintrag("Gegenschlag", 3));
		ogE.addElement(new OptionsGruppeEintrag("Infiltratoren", 3));
		add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "option", ogE));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Cenobit", 10));
		add(new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 3));

		seperator();

		rkWargear = new RuestkammerStarter(ID, randAbstand, cnt, "BTArmoury", "");
		rkWargear.initKammer(true, false, false);
		rkWargear.setButtonText("Ausrüstung");
		add(rkWargear);

		complete();
	}

	@Override
	public void refreshen() {
		if(!o1.isSelected()) o1.setSelected(0, true);

		oe1.setAktiv( BuildaHQ.getCountFromInformationVector("BTKommandotrupp") > 0 );
		setEintragsCNT( oe1.isSelected() ? 0 : 1 );

		o2.setAktiv(oe1.isSelected() && oe1.isAktiv());
	}

	@Override
	public void deleteYourself() {
		BuildaHQ.addToInformationVector("BTHQ", -1);
		BuildaHQ.addToInformationVector("BTKommandant", -1);
		BuildaHQ.addToInformationVector("BTOrdenspriester", -1);
		super.deleteYourself();
	}

}
