package oc.wh40k.units.sm;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class SMDeimosPatternPredatorExecutioner extends Eintrag {

	OptionsUpgradeGruppe wpn;
	
	public SMDeimosPatternPredatorExecutioner() {
		name = "Deimos Pattern Predator Executioner";
		grundkosten = 125;


		add(ico = new oc.Picture("oc/wh40k/images/PredatorExecutioner.gif"));
		
		ogE.addElement(new OptionsGruppeEintrag("Plasma Destroyer", 0));
		ogE.addElement(new OptionsGruppeEintrag("Heavy Conversion Beamer", 15));
		add(wpn = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		
		seperator();
		
		ogE.addElement(new OptionsGruppeEintrag("2 Heavy bolters","2 Heavy bolter sponsons", 25));
		ogE.addElement(new OptionsGruppeEintrag("2 Lascannons","2 Lascannon sponsons", 60));
		add(new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		
		seperator();
		
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "","Hunter-killer missile", 10));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "","Storm bolter", 10));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "","Dozer blade", 5));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "","Extra armour", 15));
		
	}

	public void refreshen() {
		if(!wpn.isSelected()){
			wpn.setSelected(0, true);
		}
	}
}
