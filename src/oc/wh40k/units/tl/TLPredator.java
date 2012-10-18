package oc.wh40k.units.tl;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class TLPredator extends Eintrag {

	OptionsUpgradeGruppe o1;

	public TLPredator() {
		name = "Predator";
		grundkosten = 60;

		BuildaHQ.addToInformationVector("TLSupport", 1);
		
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
		
		complete();
	}

	@Override
	public void refreshen() {
		if (!o1.isSelected()) {
			o1.setSelected("Maschinenkanone", true);
		}
		
		int selectedSquads = BuildaHQ.getCountFromInformationVector("TLSupport");
		int possibleSquads = BuildaHQ.getCountFromInformationVector("TLEnableHeavySupport");
		if(selectedSquads > possibleSquads) {
			setFehlermeldung("SM-Unterstützung > " + possibleSquads + "!");
		} else {
			setFehlermeldung("");
		}
		
	}

	@Override
	public void deleteYourself() {
		BuildaHQ.addToInformationVector("TLSupport", -1);
		super.deleteYourself();
	}
	
}
