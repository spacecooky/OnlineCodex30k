package oc.wh30k.units.we;

import oc.BuildaHQ;
import oc.OptionsEinzelUpgrade;
import oc.OptionsEinzelZaehler;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerStarter;
import oc.RuestkammerVater;

public class WEContemptorKammer  extends RuestkammerVater {

	OptionsUpgradeGruppe o0, o1, o2, o5;
	OptionsZaehlerGruppe o3, o4;
	RuestkammerStarter rkTransport;

	public WEContemptorKammer () {
            grundkosten = 175;
	}

	public void initButtons(boolean... defaults) {


		seperator();
		
		ogE.addElement(new OptionsGruppeEintrag("Twin heavy bolter", "Twin-linked heavy bolter", 0));
		ogE.addElement(new OptionsGruppeEintrag("Multi-melta", 0));
		ogE.addElement(new OptionsGruppeEintrag("Twin autocannon", "Twin-linked autocannon", 5));
		ogE.addElement(new OptionsGruppeEintrag("Plasma cannon", 10));
		ogE.addElement(new OptionsGruppeEintrag("Assault cannon", "Kheres Pattern assault cannon", 15));
		ogE.addElement(new OptionsGruppeEintrag("Twin-linked lascannon", 25));
		ogE.addElement(new OptionsGruppeEintrag("Heavy conversion beamer", 35));
		ogE.addElement(new OptionsGruppeEintrag("Dreadnought ccw", "Dreadnought close combat weapon", 0));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		
		seperator();
		
		ogE.addElement(new OptionsGruppeEintrag("Dreadnought ccw", "Dreadnought close combat weapon", 0));
		ogE.addElement(new OptionsGruppeEintrag("Chainfist", 10));
		ogE.addElement(new OptionsGruppeEintrag("Multi-melta", 0));		
		ogE.addElement(new OptionsGruppeEintrag("Twin autocannon", "Twin-linked autocannon", 10));
		ogE.addElement(new OptionsGruppeEintrag("Plasma cannon", 10));
		ogE.addElement(new OptionsGruppeEintrag("Assault cannon", "Kheres Pattern assault cannon", 15));
		ogE.addElement(new OptionsGruppeEintrag("Twin-linked lascannon", 25));
		add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));	
		
		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Twin-linked bolter", 0));
		add(o3 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));	
		ogE.addElement(new OptionsGruppeEintrag("Heavy flamer", 10));
		ogE.addElement(new OptionsGruppeEintrag("Plasma blaster", 20));
		ogE.addElement(new OptionsGruppeEintrag("Graviton gun", 15));
		ogE.addElement(new OptionsGruppeEintrag("Melta gun", 15));
		add(o4 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));
		
		seperator();
		
		ogE.addElement(new OptionsGruppeEintrag("Extra armour", 10));
		ogE.addElement(new OptionsGruppeEintrag("Havoc launcher", "Carapace-mounted havoc launcher", 15));
		add(o5 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 2));	
		
		seperator();

		rkTransport = new RuestkammerStarter(ID, randAbstand, cnt, "WETransporterKammer", "Transport");
		//Rhino, Pod, Dreadclaw, Phobos, Spartan
		rkTransport.initKammer(false, false, true, false, false);
		rkTransport.setButtonText("Dedicated transport");
		add(rkTransport);
		
        sizeSetzen();
	}

	@Override
	public void refreshen() {
			if (!o1.isSelected()) o1.setSelected(0, true);
			if (!o2.isSelected()) o2.setSelected(0, true);
			
			int Zaehler1;
			int Zaehler2;
			
			if (o1.isSelected("Dreadnought close combat weapon")) 
				{Zaehler1 = 1;}
			else
				{Zaehler1 = 0;}
			
			if (o2.isSelected("Dreadnought close combat weapon") || (o2.isSelected("Chainfist"))) 
			{Zaehler2 = 1;}
			else
			{Zaehler2 = 0;}
			
			o3.setMaxAnzahl(Zaehler1 + Zaehler2 - o4.getAnzahl());
			o3.setAnzahl(0, Zaehler1 + Zaehler2 - o4.getAnzahl());
			o4.setMaxAnzahl(Zaehler1 + Zaehler2);
						
	}
        
}