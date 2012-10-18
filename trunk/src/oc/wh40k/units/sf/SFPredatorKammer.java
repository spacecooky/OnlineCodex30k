package oc.wh40k.units.sf;

import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerVater;

public class SFPredatorKammer extends RuestkammerVater {

	OptionsUpgradeGruppe o1;

	public SFPredatorKammer() {
		grundkosten = 60;
        }
        
        public void initButtons(boolean... defaults) {
		add(ico = new oc.Picture("oc/wh40k/images/SFPredatorKammer.jpg"));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Maschinenkanone", 0));
		ogE.addElement(new OptionsGruppeEintrag("Sync. Laserkanone", "Synchronisierte Laserkanone", 45));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

		seperator(8);

		ogE.addElement(new OptionsGruppeEintrag("2 Schwere Bolter", "Zwei Seitenkuppeln mit schweren Boltern",25));
		ogE.addElement(new OptionsGruppeEintrag("2 Laserkanonen", "Zwei Seitenkuppeln mit Laserkanonen", 60));
		add(new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

		seperator(8);

		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Sturmbolter", 10));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Radarsuchkopfrakete", 10));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Bulldozerschaufel", 5));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Zusätzliche Panzerung", 15));

		sizeSetzen();
	}

	@Override
	public void refreshen() {
                o1.alwaysSelected();
	}
	
}
