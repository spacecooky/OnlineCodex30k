package oc.whfb.units.gk;

import oc.BuildaHQ;
import oc.CommonMagicItems;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppeUnique;
import oc.RuestkammerVater;

public class GKBanner extends RuestkammerVater {

	OptionsUpgradeGruppeUnique o1;
	
	public GKBanner() {
		grundkosten = 0;
	}

	@Override
	public void initButtons(boolean... defaults) {
		// defaults[0] = max. 25 Punkte
		// defaults[1] = max. 50 Punkte
		// defaults[2])= max. 100 Punkte
		// defaults[3] = AST yes/no
		// defaults[4] = Grabwächter

		int maxCost = 0;
		if(defaults[0]) maxCost = 25;
		if(defaults[1]) maxCost = 50;
		if(defaults[2]) maxCost = 100;
		
		if(maxCost >= 90) ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Banner der Verborgenen Toten"), 90));
		if(maxCost >= 50) ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Standarte der Ewigen Legion"), 50));
		
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
