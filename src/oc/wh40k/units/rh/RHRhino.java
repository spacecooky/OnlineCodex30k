package oc.wh40k.units.rh;

import oc.BuildaHQ;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerVater;

public class RHRhino extends RuestkammerVater {

	OptionsUpgradeGruppe o1;

	public RHRhino() {
		grundkosten = 35;
	}

	@Override
	public void initButtons(boolean... defaults) { // [0] = kostenlos? [1] = Razorback?
		
		name="Rhino";
		add(ico = new oc.Picture("oc/wh40k/images/RHRhino.jpg"));
		
		ogE.addElement(new OptionsGruppeEintrag("TL Bolter","Twinlinked Bolter", 5));
		ogE.addElement(new OptionsGruppeEintrag("Combi-Melta", 10));
		ogE.addElement(new OptionsGruppeEintrag("Combi-Flamer", 10));
		ogE.addElement(new OptionsGruppeEintrag("Combi-Plasma", 10));
		ogE.addElement(new OptionsGruppeEintrag("Havoc Launcher", 15));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "option", ogE));
		
		seperator();
		
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Demonic possesion", 20));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Dozer blade", 5));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Extra armour", 15));
		
		sizeSetzen();
	}

	@Override
	public void refreshen() {
	}	
}
