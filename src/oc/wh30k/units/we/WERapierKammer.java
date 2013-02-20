package oc.wh30k.units.we;

import oc.BuildaHQ;
import oc.OptionsEinzelUpgrade;
import oc.OptionsEinzelZaehler;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerVater;

public class WERapierKammer  extends RuestkammerVater {

	OptionsUpgradeGruppe o1;

	public WERapierKammer () {
            grundkosten = 40;
	}

	public void initButtons(boolean... defaults) {


		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Quad heavy bolter", 0));
		ogE.addElement(new OptionsGruppeEintrag("Laser destroyer array", 15));
		ogE.addElement(new OptionsGruppeEintrag("Quad mortar", 20));
		ogE.addElement(new OptionsGruppeEintrag("Graviton cannon", 35));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		
		
        sizeSetzen();
	}

	@Override
	public void refreshen() {
		if (!o1.isSelected()) o1.setSelected(0, true);
	}
        
}