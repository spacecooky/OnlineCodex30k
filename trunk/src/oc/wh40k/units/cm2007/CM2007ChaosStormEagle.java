package oc.wh40k.units.cm2007;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class CM2007ChaosStormEagle extends Eintrag {

	OptionsUpgradeGruppe wpn;
	
	public CM2007ChaosStormEagle() {
		name = "Chaos Storm Eagle Assault Gunship";
		grundkosten = 205;

		add(ico = new oc.Picture("oc/wh40k/images/Stormtalon.gif"));
		
		ogE.addElement(new OptionsGruppeEintrag("TL heavy bolter","twinlinked heavy bolter", 0));
		ogE.addElement(new OptionsGruppeEintrag("Reaper autocannon", 0));
		ogE.addElement(new OptionsGruppeEintrag("TL multi-melta","twinlinked multi-melta", 15));
		add(wpn = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		
		seperator();
		
		ogE.addElement(new OptionsGruppeEintrag("4 Hellstrike missiles","4 wing-mounted Hellstrike missiles", 40));
		ogE.addElement(new OptionsGruppeEintrag("2 TL lascannons","2 wing-mounted twinlinked lascannons", 60));
		add(new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		
		seperator();
		
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "","Searchlight", 1));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "","Extra armour", 15));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "","Daemonic possesion", 20));
		
		complete();

	}

	public void refreshen() {
		if(!wpn.isSelected()){
			wpn.setSelected(0, true);
		}
	}
}
