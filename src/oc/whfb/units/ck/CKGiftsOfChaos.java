package oc.whfb.units.ck;

import oc.BuildaHQ;
import oc.OptionsEinzelUpgradeUnique;
import oc.RuestkammerVater;

public class CKGiftsOfChaos extends RuestkammerVater {

	OptionsEinzelUpgradeUnique[] o = new OptionsEinzelUpgradeUnique[12];

	private int maxCosts = 25;
	private boolean isMage = false;

	public CKGiftsOfChaos() {
		grundkosten = 0;
	}

	@Override
	public void initButtons(boolean... defaults) {
		isMage = defaults[3];

		if(defaults[0]) maxCosts = 25;
		if(defaults[1]) maxCosts = 50;
		if(defaults[2]) maxCosts = 100;

		if(maxCosts >= 75) add(o[0] = new OptionsEinzelUpgradeUnique(ID, randAbstand, cnt, "", BuildaHQ.translate("Ätherrüstung"), 75));
		if(maxCosts >= 60) add(o[1] = new OptionsEinzelUpgradeUnique(ID, randAbstand, cnt, "", BuildaHQ.translate("Tentakel des Tzeentch"), 60));
		if(maxCosts >= 40) add(o[2] = new OptionsEinzelUpgradeUnique(ID, randAbstand, cnt, "", BuildaHQ.translate("Dehnbarer Schlund"), 40));
		if(maxCosts >= 40) add(o[3] = new OptionsEinzelUpgradeUnique(ID, randAbstand, cnt, "", BuildaHQ.translate("Wort der Pein"), 40));
		if(maxCosts >= 35) add(o[4] = new OptionsEinzelUpgradeUnique(ID, randAbstand, cnt, "", BuildaHQ.translate("Teuflische Pracht"), 35));
		add(o[5] = new OptionsEinzelUpgradeUnique(ID, randAbstand, cnt, "", BuildaHQ.translate("Drittes Auge des Tzeentch"), 25));
		add(o[6] = new OptionsEinzelUpgradeUnique(ID, randAbstand, cnt, "", BuildaHQ.translate("Strom der Fäulnis"), 20));
		add(o[7] = new OptionsEinzelUpgradeUnique(ID, randAbstand, cnt, "", BuildaHQ.translate("Einlullender Duft"), 20));
		add(o[8] = new OptionsEinzelUpgradeUnique(ID, randAbstand, cnt, "", BuildaHQ.translate("Markerschütterndes Brüllen"), 20));
		add(o[9] = new OptionsEinzelUpgradeUnique(ID, randAbstand, cnt, "", BuildaHQ.translate("Begleiter"), 20));
		add(o[10] = new OptionsEinzelUpgradeUnique(ID, randAbstand, cnt, "", BuildaHQ.translate("Zorn des Blutgottes"), 20));
		add(o[11] = new OptionsEinzelUpgradeUnique(ID, randAbstand, cnt, "", BuildaHQ.translate("Ätzendes Blut"), 15));
		setUeberschrift(BuildaHQ.translate("Geschenke des Chaos"));
		sizeSetzen();
	}

	@Override
	public void refreshen() {
		double totalCosts = 0;
		for(int i=0; i<o.length; i++) {
			if(o[i] == null) continue;
			totalCosts += o[i].getKosten();
		}
		if(totalCosts > this.maxCosts) {
			setButtonState(false);
			showErrorMessage("Max. " + this.maxCosts + " " + BuildaHQ.translate("Punkte"));
		} else {
			setButtonState(true);
			hideErrorMessage();
			showErrorMessage( entferneNullNachkomma(totalCosts) + " / " + maxCosts + " " + BuildaHQ.translate("Punkte"));
		}

		o[5].setAktiv(isMage);
		o[9].setAktiv(isMage);
	}

	@Override
	public void specialAction(boolean... action) {
		isMage = action[0];
		refreshen();
	}

	@Override
	public Object getSpecialValue() {
		try {
			if(o[10].isSelected()) return BuildaHQ.translate("ZORN_DES_BLUTGOTTES");
		} catch(Exception ex) {
			// ignore
		}
		return "NULL";
	}

}
