package oc.wh40k.units.cm2007;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerStarter;

public class CM2007BesesseneChaosSpaceMarines extends Eintrag {

	AnzahlPanel squad;
	OptionsEinzelUpgrade o1;
	OptionsUpgradeGruppe o2;
	OptionsUpgradeGruppe o3;
	OptionsEinzelUpgrade o4;
	OptionsEinzelUpgrade o5;
	OptionsUpgradeGruppe o6;
	OptionsUpgradeGruppe o7;
	OptionsUpgradeGruppe o8;
	RuestkammerStarter rkRaider;

	public CM2007BesesseneChaosSpaceMarines() {
		name = "Besessene Chaos Space Marines";
		grundkosten = 0;

		squad = new AnzahlPanel(ID, randAbstand, cnt, "Besessene CSM", 5, 20, 26, "Besessene Chaos Space Marines");
		add(squad);

		add(ico = new oc.Picture("oc/wh40k/images/PossessedChaosSpaceMarines.gif"));
		

		seperator();

		add(o1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Aufstrebender Champion", "Upgrade zum Aufstrebenden Champion", 10));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Ikone d. Glorreichen Chaos", "Ikone des Glorreichen Chaos", 5));
		ogE.addElement(new OptionsGruppeEintrag("Ikone des Slaanesh", 20));
		ogE.addElement(new OptionsGruppeEintrag("Ikone des Khorne", 30));
		ogE.addElement(new OptionsGruppeEintrag("Ikone des Nurgle", 50));
		ogE.addElement(new OptionsGruppeEintrag("Ikone des Tzeentch", 40));

		add(o6 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

		seperator();

		rkRaider = new RuestkammerStarter(ID, randAbstand, cnt, "CMTransporter", "Transporter");
		rkRaider.initKammer();
		rkRaider.setButtonText("Transporter");
		add(rkRaider);

		complete();
	}

	@Override
	public void refreshen() {
	}
}
