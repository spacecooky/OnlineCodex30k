package oc.wh30k.units.ih;

import oc.BuildaHQ;
import oc.OptionsEinzelUpgrade;
import oc.OptionsEinzelZaehler;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerStarter;
import oc.RuestkammerVater;

public class IHTransportKammerPod  extends RuestkammerVater {

	OptionsUpgradeGruppe o1, o2;

	public IHTransportKammerPod () {
            grundkosten = 35;
	}

	public void initButtons(boolean... defaults) {

		seperator();
		ogE.addElement(new OptionsGruppeEintrag("Drop Pod", 0));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
				
        sizeSetzen();
	}

	@Override
	public void refreshen() {
			
		if(!o1.isSelected()) o1.setSelected(0, true);	
	}
        
}