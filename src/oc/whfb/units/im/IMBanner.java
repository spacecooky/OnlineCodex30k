package oc.whfb.units.im;

import oc.BuildaHQ;
import oc.CommonMagicItems;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppeUnique;
import oc.RuestkammerVater;

public class IMBanner extends RuestkammerVater {

	OptionsUpgradeGruppeUnique o1;
	boolean isAST = false;
	boolean isKnightlyOrder = false;

	public IMBanner() {
		grundkosten = 0;
	}

	@Override
	public void initButtons(boolean... defaults) {

		int maxCost = 50;
		if(defaults[0]) maxCost = 25;
		if(defaults[1]) maxCost = 50;
		if(defaults[2]) maxCost = 125;
		if(defaults[2]) isAST = true;
		
		try {
			isKnightlyOrder = defaults[3];
		} catch (Exception e) {
			isKnightlyOrder = false;
		}

		if(maxCost >= 100)ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Imperiales Banner"), 100));
		if(maxCost >= 60)ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Banner des Sigismund"), 60));
		if(maxCost >= 55)ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Greifenstandarte"), 55));
		if(isKnightlyOrder && maxCost >= 50)ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Dämonentöterstandarte"), 50));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Standarte des arkanen Schutzes"), 30));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Banner des Heldenmutes"), 30));
		if(defaults[0])ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Standarte des Stahls"), 20));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Banner der Pflicht"), 10));
		
		CommonMagicItems.addCommonBanner(ogE, maxCost, 25);
		
		add(o1 = new OptionsUpgradeGruppeUnique(ID, randAbstand, cnt, "", ogE));
		setUeberschrift(BuildaHQ.translate("Magische Standarten"));
		sizeSetzen(100, 100, 285, KAMMER_HOEHE + cnt + 10);
	}

	@Override
	public void refreshen() {
		setButtonState(BuildaHQ.noErrors);
	}

}
