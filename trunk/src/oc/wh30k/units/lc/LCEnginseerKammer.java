package oc.wh30k.units.lc;

import oc.BuildaHQ;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerVater;

public class LCEnginseerKammer extends RuestkammerVater {

	OptionsUpgradeGruppe o1;
	
	public LCEnginseerKammer() {
		grundkosten = 20;
	}

	@Override
	public void initButtons(boolean... defaults) {
				
		ogE.addElement(new OptionsGruppeEintrag("Nuncio-vox", 10));
		ogE.addElement(new OptionsGruppeEintrag("Augury scanner", 5));
		ogE.addElement(new OptionsGruppeEintrag("Volkite charger", 10));
		ogE.addElement(new OptionsGruppeEintrag("Cortex Controller", 15));
		ogE.addElement(new OptionsGruppeEintrag("Graviton gun", 5));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 5));
				
		sizeSetzen();
	}

	@Override
	public void refreshen() {		
			
	}



}
