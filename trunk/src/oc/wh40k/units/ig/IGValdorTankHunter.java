package oc.wh40k.units.ig;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class IGValdorTankHunter extends Eintrag {

        OptionsUpgradeGruppe o1;

	public IGValdorTankHunter() {
		name = "Valdor Tank Hunter";
		grundkosten = 320;


		add(ico = new oc.Picture("oc/wh40k/images/ValdorTankHunter.gif"));
		


        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Radarsuchkopfrakete", 10));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Bulldozerschaufel", 10));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "zusätzlicher Sturmbolter", 10));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "zusätzliches Maschinengewehr", 10));

        seperator();

		ogE.addElement(new OptionsGruppeEintrag("Maschinengewehre", "Seitenkuppeln mit Maschinengewehren", 0));
		ogE.addElement(new OptionsGruppeEintrag("schwere Bolter", "Seitenkuppeln mit schweren Boltern", 5));
		ogE.addElement(new OptionsGruppeEintrag("schwere Flamer", "Seitenkuppeln mit schweren Flammenwerfern", 5));
		ogE.addElement(new OptionsGruppeEintrag("Maschinenkanonen", "Seitenkuppeln mit Maschinenkanonen", 10));
		ogE.addElement(new OptionsGruppeEintrag("Laserkanonen", "Seitenkuppeln mit Laserkanonen", 15));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));
                
		complete();

	}

	public void refreshen() {
            o1.alwaysSelected();
	}
}
