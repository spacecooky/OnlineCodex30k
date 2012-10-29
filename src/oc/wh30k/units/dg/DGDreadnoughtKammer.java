package oc.wh30k.units.dg;

import oc.BuildaHQ;
import oc.OptionsEinzelUpgrade;
import oc.OptionsEinzelZaehler;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerVater;

public class DGDreadnoughtKammer  extends RuestkammerVater {

	OptionsUpgradeGruppe o1, o2;
	OptionsZaehlerGruppe o3, o4;

	public DGDreadnoughtKammer () {
            grundkosten = 125;
	}

	public void initButtons(boolean... defaults) {


		seperator();
		
		ogE.addElement(new OptionsGruppeEintrag("Twin heavy bolter", "Twin-linked heavy bolter", 0));
		ogE.addElement(new OptionsGruppeEintrag("Multi-melta", 0));
		ogE.addElement(new OptionsGruppeEintrag("Twin autocannon", "Twin-linked autocannon", 10));
		ogE.addElement(new OptionsGruppeEintrag("Twin missile launcher", "Twin-linked missile launcher", 10));
		ogE.addElement(new OptionsGruppeEintrag("Plasma cannon", 10));
		ogE.addElement(new OptionsGruppeEintrag("Flamestorm cannon", 15));
		ogE.addElement(new OptionsGruppeEintrag("Twin-linked lascannon", 25));
		ogE.addElement(new OptionsGruppeEintrag("Dreadnought ccw", "Dreadnought close combat weapon", 0));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		seperator();
		
		ogE.addElement(new OptionsGruppeEintrag("Dreadnought ccw", "Dreadnought close combat weapon", 0));
		ogE.addElement(new OptionsGruppeEintrag("Chainfist", 10));
		ogE.addElement(new OptionsGruppeEintrag("Siege Wrecker", 10));
		ogE.addElement(new OptionsGruppeEintrag("Twin autocannon", "Twin-linked autocannon", 10));
		ogE.addElement(new OptionsGruppeEintrag("Twin missile launcher", "Twin-linked missile launcher", 15));
		add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));	
		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Twin-linked bolter", 0));
		add(o3 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));	
		ogE.addElement(new OptionsGruppeEintrag("Heavy flamer", 10));
		ogE.addElement(new OptionsGruppeEintrag("Plasma blaster", 20));
		ogE.addElement(new OptionsGruppeEintrag("Graviton gun", 20));
		ogE.addElement(new OptionsGruppeEintrag("Melta gun", 15));
		add(o4 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));
		
        sizeSetzen();
	}

	@Override
	public void refreshen() {
			if (!o1.isSelected()) o1.setSelected(0, true);
			if (!o2.isSelected()) o2.setSelected(0, true);
			
			o3.setMaxAnzahl(!o2.isSelected("Twin-linked autocannon") && !o2.isSelected("Twin-linked missile launcher") ?1:0 + (o1.isSelected("Dreadnought close combat weapon")?1:0) - o4.getAnzahl());
			o3.setAnzahl(0, !o2.isSelected("Twin-linked autocannon") && !o2.isSelected("Twin-linked missile launcher") ?1:0 + (o1.isSelected("Dreadnought close combat weapon")?1:0) - o4.getAnzahl());
			o4.setMaxAnzahl(!o2.isSelected("Twin-linked autocannon") && !o2.isSelected("Twin-linked missile launcher") ?1:0 + (o1.isSelected("Dreadnought close combat weapon")?1:0));
    		
	}
        
}