package oc.whfb.units.de;

import oc.BuildaHQ;
import oc.OptionsEinzelUpgrade;
import oc.OptionsEinzelUpgradeUnique;
import oc.RuestkammerVater;

public class DEGiftsOfKhaine extends RuestkammerVater {

	OptionsEinzelUpgrade[] o = new OptionsEinzelUpgrade[9];
	OptionsEinzelUpgradeUnique[] oU = new OptionsEinzelUpgradeUnique[2];

	private int maxCosts = 25;

	public DEGiftsOfKhaine() {
		grundkosten = 0;
	}

	@Override
	public void initButtons(boolean... defaults) {
		// defaults[0] = Hexenkriegerinnen
		// defaults[1] = Todexhexe
		// defaults[2] = Assassine

		if(defaults[0]) maxCosts = 25;
		if(defaults[1]) maxCosts = 50;
		if(defaults[2]) maxCosts = 75;

		if(maxCosts >= 30 && defaults[2]) add(o[0] = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Todessplitter"), 30));
		if(maxCosts >= 30) add(o[1] = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Tanz der Verdammnis"), 30));
		if(maxCosts >= 30) add(o[2] = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Berührung des Todes"), 30));
		if(defaults[0] || defaults[1]) add(o[0] = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Hexenbräu"), 25));
		add(o[3] = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Rune des Khaine"), 25));
		add(o[4] = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Geste des Khaine"), 15));
		add(o[5] = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Kriegsschrei des Khaine"), 10));

		seperator();

		add(o[6] = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Blutfeuer"), 25));
		add(o[7] = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Schwarzer Lotus"), 20));
		add(o[8] = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Höllendrachengift"), 10));

		seperator();

		if(maxCosts >= 75) add(oU[0] = new OptionsEinzelUpgradeUnique(ID, randAbstand, cnt, "", BuildaHQ.translate("Höllendrachenschwert"), 75));
		if(defaults[2]) add(oU[1] = new OptionsEinzelUpgradeUnique(ID, randAbstand, cnt, "", BuildaHQ.translate("Zwielichtmantel"), 20));
		setUeberschrift(BuildaHQ.translate("Geschenke des Khaine"));
		sizeSetzen();
	}

	@Override
	public void refreshen() {
		double totalCosts = 0;
		for(int i=0; i<o.length; i++) {
			if(o[i] == null) continue;
			totalCosts += o[i].getKosten();
		}
		
		for(int i=0; i<oU.length; i++) {
			if(oU[i] == null) continue;
			totalCosts += oU[i].getKosten();
		}
		if(totalCosts > this.maxCosts) {
			setButtonState(false);
			showErrorMessage("Max. " + this.maxCosts + " " + BuildaHQ.translate("Punkte"));
		} else {
			setButtonState(true);
			hideErrorMessage();
			showErrorMessage( entferneNullNachkomma(totalCosts) + " / " + maxCosts + " " + BuildaHQ.translate("Punkte"));
		}
	}

	@Override
	public void specialAction(boolean... action) {
		// If AST is selectd, disable magic items in "Gifts of Khaine" list
		if(action[0]) {
			if(oU[0] != null) oU[0].setAktiv(false);
			if(oU[1] != null) oU[1].setAktiv(false);
		} else {
			if(oU[0] != null) o[0].setAktiv(true);
			if(oU[1] != null) o[1].setAktiv(true);
		}
	}
}
