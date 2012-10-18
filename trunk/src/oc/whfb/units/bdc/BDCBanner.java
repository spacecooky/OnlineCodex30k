package oc.whfb.units.bdc;

import oc.BuildaHQ;
import oc.CommonMagicItems;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppeUnique;
import oc.RuestkammerVater;

public class BDCBanner extends RuestkammerVater {

	OptionsUpgradeGruppeUnique o1;
	boolean isAST = false;

	public BDCBanner() {
		grundkosten = 0;
	}

	@Override
	public void initButtons(boolean... defaults) {
		// defaults[0] = max. 25  Punkte
		// defaults[1] = max. 50  Punkte
		// defaults[2] = max. 100 Punkte
		
		int maxCost = 0;
		if(defaults[0]) maxCost = 25;
		if(defaults[1]) maxCost = 50;
		if(defaults[2]) maxCost = 125;
		if(defaults[2]) isAST = true;

		if(maxCost >= 75) ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Das Bestienbanner"), 75));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Rosttotem"), 50));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Menschenfluchstd."), BuildaHQ.translate("Menschenfluchstandarte"), 35));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Das Frevelbanner"), 20));
		
		CommonMagicItems.addCommonBanner(ogE, maxCost, 25);
		
		add(o1 = new OptionsUpgradeGruppeUnique(ID, randAbstand, cnt, "", ogE));
		setUeberschrift(BuildaHQ.translate("Magische Standarten"));
		sizeSetzen();
	}

	@Override
	public void refreshen() {
		
	}

}
