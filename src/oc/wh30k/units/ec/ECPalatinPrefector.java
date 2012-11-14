package oc.wh30k.units.ec;

import oc.BuildaHQ;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerVater;

public class ECPalatinPrefector extends RuestkammerVater {

	OptionsUpgradeGruppe o1, o2, o3, o4, o6a, o7a, o7b, o7c, o8a, o8b;
	OptionsZaehlerGruppe o5;
	
	boolean isVeteran = false;
	boolean isDestroyer = false;
	boolean isTerminator = false;
	boolean isTactical = false;
	boolean isAssault = false;

	public ECPalatinPrefector() {
		grundkosten = 0;
	}

	@Override
	public void initButtons(boolean... defaults) {
		
		
		ogE.addElement(new OptionsGruppeEintrag("Plasma pistol", 15));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		ogE.addElement(new OptionsGruppeEintrag("Melta-bombs", 5));
		add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		sizeSetzen();
	}

	@Override
	public void refreshen() {
	
	}



}
