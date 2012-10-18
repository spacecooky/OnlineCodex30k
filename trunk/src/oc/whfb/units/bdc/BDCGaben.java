package oc.whfb.units.bdc;

import oc.BuildaHQ;
import oc.OptionsEinzelUpgradeUnique;
import oc.RuestkammerVater;

public class BDCGaben extends RuestkammerVater {

	OptionsEinzelUpgradeUnique oe2;
	OptionsEinzelUpgradeUnique oe3;
	OptionsEinzelUpgradeUnique oe4;
	OptionsEinzelUpgradeUnique oe5;
	OptionsEinzelUpgradeUnique oe6;	
	OptionsEinzelUpgradeUnique oe7;
	OptionsEinzelUpgradeUnique oe8;
	
	int maxCosts = 50;

	public BDCGaben() {
		grundkosten = 0;
	}

	@Override
	public void initButtons(boolean... defaults) {
		cnt = randAbstand;
		
		add(oe2 = new OptionsEinzelUpgradeUnique(ID, randAbstand, cnt, "", BuildaHQ.translate("Schneckenhaut"), 30));
		add(oe3 = new OptionsEinzelUpgradeUnique(ID, randAbstand, cnt, "", BuildaHQ.translate("Vielarmige Bestie"), 20));
		add(oe4 = new OptionsEinzelUpgradeUnique(ID, randAbstand, cnt, "", BuildaHQ.translate("Gewaltige Hauer"), 15));
		add(oe5 = new OptionsEinzelUpgradeUnique(ID, randAbstand, cnt, "", BuildaHQ.translate("Verwachsene Haut"), 15));
		add(oe6 = new OptionsEinzelUpgradeUnique(ID, randAbstand, cnt, "", BuildaHQ.translate("Rune der wahren Bestie"), 15));
		add(oe7 = new OptionsEinzelUpgradeUnique(ID, randAbstand, cnt, "", BuildaHQ.translate("Übernatürliche Sinne"), 10));
		add(oe8 = new OptionsEinzelUpgradeUnique(ID, randAbstand, cnt, "", BuildaHQ.translate("Schattenfell"), 5));
		
		setUeberschrift(BuildaHQ.translate("Gaben des Chaos"));
		sizeSetzen();
	}

	@Override
	public void refreshen() {
		double totalCosts = oe2.getKosten() + oe3.getKosten() + oe4.getKosten()
		+ oe5.getKosten() + oe6.getKosten() + oe7.getKosten() + oe8.getKosten();

		if(totalCosts > 50) {
			setButtonState(false);
			showErrorMessage("Max. " + maxCosts + " Punkte");
		} else {
			setButtonState(true);
			hideErrorMessage();
			showErrorMessage( entferneNullNachkomma(totalCosts) + " / " + maxCosts + " " + BuildaHQ.translate("Punkte"));
		}
	}
}
