package oc.wh40k.units.da;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerStarter;

public class DAPredator extends Eintrag {

	OptionsUpgradeGruppe o1;
    OptionsEinzelUpgrade ia2;
    OptionsEinzelUpgrade oe1;
    OptionsEinzelUpgrade oe2;
	RuestkammerStarter techmarine;

	public DAPredator() {
		name = "Predator";
		grundkosten = 70;

		add(ico = new oc.Picture("oc/wh40k/images/DAPredator.gif"));

		seperator();

        add(ia2 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "IA2 Update Regeln", "Imperial Armour 2 Update Regeln", 0));

        seperator();

		ogE.addElement(new OptionsGruppeEintrag("Maschinenkanone", 0));
		ogE.addElement(new OptionsGruppeEintrag("Sync. Laserkanone", "Synchronisierte Laserkanone", 35));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("2 Schwere Bolter", "Seitenkuppeln mit Schweren Boltern", 25));
		ogE.addElement(new OptionsGruppeEintrag("2 Laserkanonen", "Seitenkuppeln mit Laserkanonen", 60));
		add(new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

		seperator();

        add(oe1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Sturmbolter", 5));
        add(oe2 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Radarsuchkopfrakete", 15));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Bulldozerschaufel", 5));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Zusätzliche Panzerung", 15));

		seperator();

		techmarine = new RuestkammerStarter(ID, randAbstand, cnt, "DATechmarineKammer", "Techmarine");
		techmarine.initKammer();
		add(techmarine);

		complete();
	}

	@Override
	public void refreshen() {
        if(ia2.isSelected()) {
            grundkosten = 60;
            o1.setPreis(1, 45);
            oe1.setPreis(10);
            oe2.setPreis(10);
            techmarine.setAktiv(false);
        } else {
            grundkosten = 70;
            o1.setPreis(1, 35);
            oe1.setPreis(5);
            oe2.setPreis(15);
            techmarine.setAktiv(true);
        }


		if (!o1.isSelected()) {
			o1.setSelected("Maschinenkanone", true);
		}

        if(ia2.isSelected() && o1.isSelected("Maschinenkanone")) {
            name = "Predator Destructor";
        } else if(ia2.isSelected() && o1.isSelected("Synchronisierte Laserkanone")) {
            name = "Predator Annihilator";
        } else {
            name = "Predator";
        }
	}

}
