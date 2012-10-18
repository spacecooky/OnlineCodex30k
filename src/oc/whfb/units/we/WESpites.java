package oc.whfb.units.we;

import oc.BuildaHQ;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppeUnique;
import oc.RuestkammerVater;

public class WESpites extends RuestkammerVater {

	OptionsUpgradeGruppeUnique o1;

	int maxCosts = 100;
	boolean isTree = false;

	public WESpites() {
		grundkosten = 0;
	}

	@Override
	public void initButtons(boolean... defaults) {
		if(defaults[0]) maxCosts = 50;
		if(defaults[1]) isTree = true;

		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Schreckensfeen"), 50));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Wirrlichter"), 25));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Blutfeen"), 25));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Giftfeen"), 25));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Spinnlinge"), 25));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Elmsfeuer"), 25));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Schicksalsschwestern"), 25));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Flimmerlichter"), 25));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Fluchfeen"), 25));
		add(o1 = new OptionsUpgradeGruppeUnique(ID, randAbstand, cnt, "", ogE, 1));
		setUeberschrift(BuildaHQ.translate("Feen"));
		sizeSetzen();
	}

	@Override
	public void refreshen() {
		if(isTree) o1.setMaxAnzahl(9);
		else o1.setMaxAnzahl(1);
		double totalCosts = o1.getKosten();
		if(totalCosts > maxCosts) {
			showErrorMessage("Max. " + entferneNullNachkomma(maxCosts) + " "+BuildaHQ.translate("Punkte"));
			setButtonState(false);
		} else {
			showErrorMessage( entferneNullNachkomma(totalCosts) + " / " + maxCosts + " " + BuildaHQ.translate("Punkte"));
			setButtonState(true);
		}
	}
}
