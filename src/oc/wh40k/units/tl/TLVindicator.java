package oc.wh40k.units.tl;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;

public class TLVindicator extends Eintrag {

	public TLVindicator() {
		name = "Vindicator";
		grundkosten = 115;

		BuildaHQ.addToInformationVector("TLSupport", 1);
		
		add(ico = new oc.Picture("oc/wh40k/images/SMVindicator.jpg"));

		seperator();

		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Sturmbolter", 10));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Radar-Suchkopfrakete", 10));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Bulldozerschaufel", 5));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Belagerungsschild", 10));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Zusätzliche Panzerung", 15));
		
		complete();
	}

	@Override
	public void refreshen() {
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
