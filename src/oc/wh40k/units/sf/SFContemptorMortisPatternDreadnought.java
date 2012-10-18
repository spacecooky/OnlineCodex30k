package oc.wh40k.units.sf;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class SFContemptorMortisPatternDreadnought extends Eintrag {

	OptionsUpgradeGruppe o1;

	public SFContemptorMortisPatternDreadnought() {
		name = "Contemptor Mortis Pattern Dreadnought";
		grundkosten = 155;

		add(ico = new oc.Picture("oc/wh40k/images/SMCybot.jpg"));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Sync. Schwere Bolter", "Zwei synchronisierter Schwere Bolter", 0));
		ogE.addElement(new OptionsGruppeEintrag("Multimelter", "Zwei Multimelter", 0));
		ogE.addElement(new OptionsGruppeEintrag("Sync. Maschinenkanonen", "Zwei synchronisierte Maschinenkanone", 10));
		ogE.addElement(new OptionsGruppeEintrag("Plasmakanonen", "Zwei Plasmakanonen", 20));
		ogE.addElement(new OptionsGruppeEintrag("Kheres Assault Cannons", "Zwei Kheres Pattern Assault Cannons", 25));
		ogE.addElement(new OptionsGruppeEintrag("Sync. Laserkanonen", "Zwei synchronisierte Laserkanonen", 30));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

		seperator();

		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Zus�tzliche Panzerung", 15));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Suchscheinwerfer", 1));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Cyclone Missile Launcher", "Carapace-mounted Cyclone Missile Launcher", 35));

		complete();
	}

	@Override
	public void refreshen() {
                o1.alwaysSelected();
	}
	
}
