package oc.wh30k.units.sh;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class SHEzekyleAbaddon extends Eintrag {
	
	OptionsUpgradeGruppe o1;

	public SHEzekyleAbaddon() {
		name = "Ezekyle Abaddon";
		grundkosten = 215;
		
		seperator();
		ogE.addElement(new OptionsGruppeEintrag("Combi-bolter", 0));
		ogE.addElement(new OptionsGruppeEintrag("Power sword", 0));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

		BuildaHQ.addToInformationVector("SHPraetor", 1);
		
		seperator();

		complete();
	}

	@Override
	public void refreshen() {
        setUnikat(true);
        if (!o1.isSelected()) {o1.setSelected(0, true);}
	}
	
	@Override
	public void deleteYourself() {
		
		BuildaHQ.addToInformationVector("SHPraetor", -1);
		super.deleteYourself();
	}
	

}
