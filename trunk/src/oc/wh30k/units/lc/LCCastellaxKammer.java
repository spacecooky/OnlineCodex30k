package oc.wh30k.units.lc;

import oc.BuildaHQ;
import oc.OptionsEinzelUpgrade;
import oc.OptionsEinzelZaehler;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerVater;

public class LCCastellaxKammer  extends RuestkammerVater {

	OptionsUpgradeGruppe o1, o3;
	OptionsZaehlerGruppe o2a, o2;

	public LCCastellaxKammer () {
            grundkosten = 85;
	}

	public void initButtons(boolean... defaults) {


		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Mauler bolt cannon", 0));
		ogE.addElement(new OptionsGruppeEintrag("Darkfire cannon", 20));
		ogE.addElement(new OptionsGruppeEintrag("Multi-melta", 0));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		
		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Bolter", 0));
		add(o2a = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 2));
		
		ogE.addElement(new OptionsGruppeEintrag("Flamer", 5));
		add(o2 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 2));
		
		seperator();
		
		ogE.addElement(new OptionsGruppeEintrag("Shock chargers", 0));
		ogE.addElement(new OptionsGruppeEintrag("Battle-automata power blades", 10));
		ogE.addElement(new OptionsGruppeEintrag("Siege wrecker", 20));
		add(o3 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		
        sizeSetzen();
	}

	@Override
	public void refreshen() {
		int wrecker = 0;
		
		if (!o1.isSelected()) o1.setSelected(0, true);
		if (!o3.isSelected()) o3.setSelected(0, true);
		
		if (o3.isSelected(2)) {wrecker = 1;}
		else {wrecker = 0;}
		
		o2a.setMaxAnzahl(2-o2.getAnzahl()- wrecker);
		o2.setMaxAnzahl(2- wrecker);
		o2a.setAnzahl(0, o2a.getMaxAnzahl());
		
	}
        
}