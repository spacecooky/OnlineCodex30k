package oc.whfb.units.og2004;

import oc.BuildaHQ;
import oc.CommonMagicItems;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppeUnique;
import oc.RuestkammerVater;

public class OG2004Banner extends RuestkammerVater {

	OptionsUpgradeGruppeUnique o1;
	boolean isAST = false;

	public OG2004Banner() {
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

		if(maxCost > 60) ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Drachenhaut"), 60));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Lumpenbanner"), 35));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Kannibalentotem"), 25));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Rhinoxstandarte"), 20));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Runenschlund"), 20));
		
		CommonMagicItems.addCommonBanner(ogE, maxCost, 25);	
		
		add(o1 = new OptionsUpgradeGruppeUnique(ID, randAbstand, cnt, "", ogE));
		setUeberschrift(BuildaHQ.translate("Magische Standarten"));
		sizeSetzen();
	}

	@Override
	public void refreshen() {
		if(!isAST) if(!o1.isSelected()) o1.setSelected(0, true); 
		
	}

}
