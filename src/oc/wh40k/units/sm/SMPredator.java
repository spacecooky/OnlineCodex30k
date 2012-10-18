package oc.wh40k.units.sm;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class SMPredator extends Eintrag {

	OptionsUpgradeGruppe o1;
	OptionsEinzelUpgrade chronus;

	boolean chronusSelected = false;

	public SMPredator() {
		name = "Predator";
		grundkosten = 60;

		add(ico = new oc.Picture("oc/wh40k/images/SMPredator.jpg"));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Maschinenkanone", 0));
		ogE.addElement(new OptionsGruppeEintrag("Sync. Laserkanone", "Synchronisierte Laserkanone", 45));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		o1.setSelected("autocannon", true);

		seperator(8);

		ogE.addElement(new OptionsGruppeEintrag("2 Schwere Bolter", 25));
		ogE.addElement(new OptionsGruppeEintrag("2 Laserkanonen", 60));
		add(new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

		seperator(8);

		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Sturmbolter", 10));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Radarsuchkopfrakete", 10));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Bulldozerschaufel", 5));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Zusätzliche Panzerung", 15));
		add(chronus = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Antaro Chronus", 70));

		complete();
	}

	@Override
	public void refreshen() {
		if (!o1.isSelected()) {
			o1.setSelected("Maschinenkanone", true);
		}
		
		// Unique entry: Antaro Chronus
		boolean chronusGlobal = ( BuildaHQ.getCountFromInformationVector("SMChronus") > 0 ? true : false );
		if(chronusGlobal && !chronusSelected) chronus.setAktiv(false);
		else chronus.setAktiv(true);

		if(chronus.isSelected()) {
			chronusSelected = true;
			BuildaHQ.addToInformationVector("SMChronus", 1);
		} else {
			if(chronusSelected) {
				chronusSelected = false;
				BuildaHQ.setInformationVectorValue("SMChronus", 0);
			}
		}
	}

	@Override
	public void deleteYourself() {
		if(chronusSelected) {
			BuildaHQ.setInformationVectorValue("SMChronus", 0);
		}
		super.deleteYourself();
	}
	
}
