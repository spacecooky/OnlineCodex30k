package oc.whfb.units.em;

import oc.BuildaHQ;
import oc.CommonMagicItems;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppeUnique;
import oc.RuestkammerVater;

public class EMBanner extends RuestkammerVater {

	OptionsUpgradeGruppeUnique o1;
	boolean isAST = false;
	boolean isSkinkAST = false;

	public EMBanner() {
		grundkosten = 0;
	}

	@Override
	public void initButtons(boolean... defaults) {
		// defaults[0] = max. 25 Punkte
		// defaults[1] = max. 50 Punkte
		// defaults[2] = AST yes/no
		// defaults[3] = Skink AST

		int maxCost = 0;
		if(defaults[0]) maxCost = 25;
		if(defaults[1]) maxCost = 50;
		if(defaults[2]) {
			isAST = true;
			maxCost = 100;
		}
		if(defaults[3]){
			isSkinkAST = true;
			maxCost = 100;
		}

		if(maxCost >= 50) ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Totem der Vorhersehung"), 50));
		if(maxCost >= 50) ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Tafel der Herrschaft"), 50));
		if(maxCost >= 40) ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Sonnenstandarte des Chotek"), 40));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Huanchis gesegnetes Totem"), 25));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Jaguarstandarte"), 25));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Skavenfellbanner"), 25));
		
		CommonMagicItems.addCommonBanner(ogE, maxCost, 25);
		
		add(o1 = new OptionsUpgradeGruppeUnique(ID, randAbstand, cnt, "", ogE));
		setUeberschrift(BuildaHQ.translate("Magische Standarten"));
		sizeSetzen();
	}

	@Override
	public void refreshen() {
		o1.setAktiv("Skavenfellbanner", isSkinkAST);
	}

}
