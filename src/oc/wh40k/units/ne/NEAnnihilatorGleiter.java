package oc.wh40k.units.ne;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class NEAnnihilatorGleiter extends Eintrag {
    
    OptionsUpgradeGruppe o1;
    
	public NEAnnihilatorGleiter() {
		name = "Annihilator-Gleiter";
		grundkosten = 90;

		add(ico = new oc.Picture("oc/wh40k/images/NEAnnihilatorGleiter.jpg"));
        
        seperator();
        
   		ogE.addElement(new OptionsGruppeEintrag("Tesla-Kanone", 0));
   		ogE.addElement(new OptionsGruppeEintrag("Gauss-Kanone", 0));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));

		complete();
	}

	@Override
	public void refreshen() {
        if(!o1.isSelected()) o1.setSelected(0, true);
	}

}
