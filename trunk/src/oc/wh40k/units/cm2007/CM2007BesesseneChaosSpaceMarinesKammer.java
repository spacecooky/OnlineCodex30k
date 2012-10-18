package oc.wh40k.units.cm2007;

import oc.AnzahlPanel;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerVater;

public class CM2007BesesseneChaosSpaceMarinesKammer extends RuestkammerVater {

	AnzahlPanel squad;
	OptionsEinzelUpgrade o1;
	OptionsUpgradeGruppe o2;
	OptionsUpgradeGruppe o3;
	OptionsEinzelUpgrade o4;
	OptionsEinzelUpgrade o5;
	OptionsUpgradeGruppe o6;
	OptionsUpgradeGruppe o7;
	OptionsUpgradeGruppe o8;

	public CM2007BesesseneChaosSpaceMarinesKammer() {
		
	}
	
	public void initButtons(boolean... defaults) {
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

		sizeSetzen();
	}

	@Override
	public void refreshen() {
	}
}
