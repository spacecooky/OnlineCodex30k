package oc.whfb.units.sk;

import oc.BuildaHQ;
import oc.CommonMagicItems;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppeUnique;
import oc.RuestkammerVater;

public class SKBanner extends RuestkammerVater {

	OptionsUpgradeGruppeUnique o1;
	boolean isAST = false;
	
	public SKBanner() {
		grundkosten = 0;
	}

	@Override
	public void initButtons(boolean... defaults) {
		// defaults[0] = max. 25 Punkte
		// defaults[1] = max. 50 Punkte
		// defaults[2] = max. 125 Punkte
		
		int maxCost = 0;
		if(defaults[0]) maxCost = 25;
		if(defaults[1]) maxCost = 50;
		if(defaults[2]) maxCost = 125;
		if(defaults[2]) isAST = true;

		if(maxCost >= 70) ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Std. der Gehörten Ratte"), BuildaHQ.translate("Heilige Standarte der Gehörnten Ratte"),  70));
		if(maxCost >= 50) ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Sturmbanner"), 50));		
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Std. der Klanüberlegenheit"), BuildaHQ.translate("Grossstandarte der Klanüberlegenheit"), 30));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Std. des triefenden Todes"), BuildaHQ.translate("Leichentuch des triefenden Todes"), 30));
		if(defaults[3])ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Seuchenbanner"), 30));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Banner des Tiefenreiches"), 25));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Zwergenhautbanner"), 15));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Std. der wimmelnden Horde"), BuildaHQ.translate("Banner der wimmelnden Horde"), 10));
		
		CommonMagicItems.addCommonBanner(ogE, maxCost, 25);
		
		add(o1 = new OptionsUpgradeGruppeUnique(ID, randAbstand, cnt, "", ogE));
		setUeberschrift(BuildaHQ.translate("Magische Standarten"));
		setHeadline(o1,BuildaHQ.translate("Magische Standarten"));

		sizeSetzen(100, 100, 285, KAMMER_HOEHE + cnt + 10);
	}

	@Override
	public void refreshen() {
	}
}
