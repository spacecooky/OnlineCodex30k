package oc.whfb.units.de;

import oc.BuildaHQ;
import oc.CommonMagicItems;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppeUnique;
import oc.RuestkammerVater;

public class DEBanner extends RuestkammerVater {

	OptionsUpgradeGruppeUnique o1;
	boolean isAST = false;

	public DEBanner() {
		grundkosten = 0;
	}

	@Override
	public void initButtons(boolean... defaults) {
		// defaults[0] = max. 25 Punkte
		// defaults[1] = max. 50 Punkte
		// defaults[2] = max. 125 Punkte
		// defaults[3] = Korsaren

		int maxCost = 0;
		if(defaults[0]) maxCost = 25;
		if(defaults[1]) maxCost = 50;
		if(defaults[2]) maxCost = 125;
		if(defaults[2]) isAST = true;

		if(maxCost >= 125) ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Banner von Nagarythe"), 125));
		if(maxCost >= 75) ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Hydrabanner"), 75));
		if(maxCost >= 40) ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Banner des Grauens"), 40));
		if(maxCost >= 35) ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Blutstandarte"), 35));
		if(maxCost >= 35) ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Standarte von Hag Graef"), 35));
		if(defaults[3]) ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Seedrachenstandarte"), 25));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Banner des Mordens"), 25));		
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Banner der Kaltblütigkeit"), 15));
		
		CommonMagicItems.addCommonBanner(ogE, maxCost, 25);
		
		add(o1 = new OptionsUpgradeGruppeUnique(ID, randAbstand, cnt, "", ogE, true));
		setUeberschrift(BuildaHQ.translate("Magische Standarten"));
		sizeSetzen();
	}

	@Override
	public void refreshen() {
		
	}

}
