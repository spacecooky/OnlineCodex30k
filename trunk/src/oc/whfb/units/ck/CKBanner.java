package oc.whfb.units.ck;

import oc.BuildaHQ;
import oc.CommonMagicItems;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppeUnique;
import oc.RuestkammerVater;

public class CKBanner extends RuestkammerVater {

	OptionsUpgradeGruppeUnique o1;
	boolean isAST = false;
	boolean isZorn = false;

	public CKBanner() {
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

		if(maxCost >= 125) ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Banner der Götter"), 125));
		if(maxCost >= 75) ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Totem der Verdammnis"), 75));
		if(maxCost >= 45) ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Banner des Zorns"), 45));
		if(maxCost >= 40) ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Fluchstandarte"), 40));
		if(maxCost >= 35) ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Banner der Wut"), 35));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Verfaultes Leichentuch"), 25));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Standarte der Leidenschaft"), 20));
		
		CommonMagicItems.addCommonBanner(ogE, maxCost, 25);
		
		add(o1 = new OptionsUpgradeGruppeUnique(ID, randAbstand, cnt, "", ogE));
		setUeberschrift(BuildaHQ.translate("Magische Standarten"));
		sizeSetzen();
	}
	
	@Override
	public void refreshen() {
		if ( isZorn && isAST ) {
			o1.setAktiv(false);
		} else {
			o1.setAktiv(true);
		}	
	}

	@Override
	public void specialAction(boolean... action) {
		super.specialAction(action);
		
		isZorn = action[0];
		
		refreshen();
	}
}
