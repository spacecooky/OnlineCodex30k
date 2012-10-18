package oc.whfb.units.or;

import oc.BuildaHQ;
import oc.CommonMagicItems;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppeUnique;
import oc.RuestkammerVater;

public class ORBanner extends RuestkammerVater {

	OptionsUpgradeGruppeUnique o1;
	
	int maxCost = 50;
	boolean isOrc = false;
	boolean isGoblin = false;
	boolean isNightGoblin = false;
	boolean isAST = false;	

	public ORBanner() {
		grundkosten = 0;
	}

	@Override
	public void initButtons(boolean... defaults) {
		isOrc = defaults[0];
		isGoblin = defaults[1];
		isNightGoblin = defaults[2];
		
		try { 
			isAST = defaults[3]; 
			maxCost = 150;
		} catch (Exception e) { 
			isAST = false; 
		}

		if( isAST ) {
			ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Morks Kriegsbanner"), 100));
			ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Spinnenbanner"), 85));
			ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Halbmondbanner"), 50));
		}
		
		CommonMagicItems.addCommonBanner(ogE, maxCost, 35);
		
		add(o1 = new OptionsUpgradeGruppeUnique(ID, randAbstand, cnt, "", ogE));
		setUeberschrift(BuildaHQ.translate("Magische Standarten"));
		sizeSetzen(100, 100, 285, KAMMER_HOEHE + cnt + 10);
	}

	@Override
	public void refreshen() {
		if( isAST ) {
			o1.setAktiv(BuildaHQ.translate("Halbmondbanner"), isNightGoblin);
			o1.setAktiv(BuildaHQ.translate("Spinnenbanner"), isGoblin);
		}
	}

	@Override
	public void specialAction(boolean... action) {
		isNightGoblin = action[0];
		isGoblin = action[1];
		refreshen();
	}

}
