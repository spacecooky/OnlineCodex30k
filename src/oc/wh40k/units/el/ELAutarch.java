package oc.wh40k.units.el;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class ELAutarch extends Eintrag {

	OptionsUpgradeGruppe option1;
	OptionsUpgradeGruppe option2;
	OptionsUpgradeGruppe option3;
	OptionsUpgradeGruppe option4;

	public ELAutarch() {
		name = "Autarch";
		grundkosten = 70;


		add(ico = new oc.Picture("oc/wh40k/images/ELAutarch.gif"));
		

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Falkenflügel", 20));
		ogE.addElement(new OptionsGruppeEintrag("Warpsprunggenerator", 25));
		ogE.addElement(new OptionsGruppeEintrag("Eldar-Jetbike", 30));

		option1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE);
		add(option1);

		seperator();


		ogE.addElement(new OptionsGruppeEintrag("Bansheemaske", 3));
		ogE.addElement(new OptionsGruppeEintrag("Mandiblaster", 10));

		option2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE);
		add(option2);

		seperator();


		ogE.addElement(new OptionsGruppeEintrag("Energiewaffe", 10));
		ogE.addElement(new OptionsGruppeEintrag("Skorpionschwert", 5));
		ogE.addElement(new OptionsGruppeEintrag("Impulslanze", 20));

		option3 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE);
		add(option3);

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Jagdkatapult", 2));
		ogE.addElement(new OptionsGruppeEintrag("Monofilamentschleuder", 5));
		ogE.addElement(new OptionsGruppeEintrag("Fusionsstrahler", 10));
		ogE.addElement(new OptionsGruppeEintrag("Laserblaster", 1));
		ogE.addElement(new OptionsGruppeEintrag("Khaindar-Raketenwerfer", 25));

		option4 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE);
		add(option4);

		seperator();

		complete();
	}

	//@OVERRIDE
	public void refreshen() {
		if (option1.getCurrentName().equals("Eldar-Jetbike")) {
			option3.setAktiv("Impulslanze", true);
		} else {
			option3.setAktiv("Impulslanze", false);
		}
	}

}
