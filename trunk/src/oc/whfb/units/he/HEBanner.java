package oc.whfb.units.he;

import oc.BuildaHQ;
import oc.CommonMagicItems;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppeUnique;
import oc.RuestkammerVater;

public class HEBanner extends RuestkammerVater {

	OptionsUpgradeGruppeUnique o1;

	public HEBanner() {
		grundkosten = 0;
	}

	@Override
	public void initButtons(boolean... defaults) {
		// defaults[0] = max. 25 Punkte
		// defaults[1] = max. 50 Punkte
		// defaults[2] = max. 100 Punkte

		int maxCost = 0;
		if(defaults[0]) maxCost = 25;
		if(defaults[1]) maxCost = 50;
		if(defaults[2]) maxCost = 100;

		if(maxCost >= 80) ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Schlachtbanner"), 80));
		if(maxCost >= 60) ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Banner des Weltendrachens"), 60));
		if(maxCost >= 50) ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Zauberbanner"), 50));
		if(maxCost >= 45) ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Standarte der Balance"), 45));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Banner des arkanen Schutzes"), 25));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Löwenstandarte"), 25));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Banner von Ellyrion"), 15));
		
		CommonMagicItems.addCommonBanner(ogE, maxCost, 20);
		
		add(o1 = new OptionsUpgradeGruppeUnique(ID, randAbstand, cnt, "", ogE));
		setUeberschrift(BuildaHQ.translate("Magische Standarten"));
		sizeSetzen();
	}

	@Override
	public void refreshen() {
	
	}

}
