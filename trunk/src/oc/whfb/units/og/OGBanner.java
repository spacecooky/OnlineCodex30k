package oc.whfb.units.og;

import oc.BuildaHQ;
import oc.CommonMagicItems;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppeUnique;
import oc.RuestkammerVater;

public class OGBanner extends RuestkammerVater {

	OptionsUpgradeGruppeUnique o1;
	boolean isAST = false;

	public OGBanner() {
		grundkosten = 0;
	}

	@Override
	public void initButtons(boolean... defaults) {
		// defaults[0] = max. 50 Punkte
		// defaults[1] = max. 100 Punkte

		int maxCost = 0;
		if(defaults[0]) maxCost = 50;
		if(defaults[1]) maxCost = 100;
		if(defaults[1]) isAST = true;

		if(maxCost >= 60) ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Runenschlund"), 60));
		if(maxCost >= 50) ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Drachenhautbanner"), 50));
		
		CommonMagicItems.addCommonBanner(ogE, maxCost, 35);	
		
		add(o1 = new OptionsUpgradeGruppeUnique(ID, randAbstand, cnt, "", ogE));
		setUeberschrift(BuildaHQ.translate("Magische Standarten"));
		sizeSetzen(100, 100, 285, KAMMER_HOEHE + cnt + 10);
	}

	@Override
	public void refreshen() {
		setButtonState(BuildaHQ.noErrors);
	}

}
