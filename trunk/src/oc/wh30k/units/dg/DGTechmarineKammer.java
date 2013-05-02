package oc.wh30k.units.dg;

import oc.BuildaHQ;
import oc.OptionsEinzelUpgrade;
import oc.OptionsEinzelZaehler;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerStarter;
import oc.RuestkammerVater;

public class DGTechmarineKammer  extends RuestkammerVater {

	OptionsUpgradeGruppe o1, o2, o3, o4;
	OptionsZaehlerGruppe o5, o6;
	RuestkammerStarter rkTransport;

	public DGTechmarineKammer () {
            grundkosten = 45;
	}

	public void initButtons(boolean... defaults) {


		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Power axe", 0));
		ogE.addElement(new OptionsGruppeEintrag("Thunder hammer", 15));;
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		
		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Nuncio-vox", 10));
		ogE.addElement(new OptionsGruppeEintrag("Augury scanner", 5));
		ogE.addElement(new OptionsGruppeEintrag("Master-crafted bolter", 5));
		ogE.addElement(new OptionsGruppeEintrag("Combi-flamer", 10));
		ogE.addElement(new OptionsGruppeEintrag("Combi-melta", 10));
		ogE.addElement(new OptionsGruppeEintrag("Combi-plasma", 10));
		ogE.addElement(new OptionsGruppeEintrag("Volkite charger", 10));
		ogE.addElement(new OptionsGruppeEintrag("Plasma pistol", 15));
		ogE.addElement(new OptionsGruppeEintrag("Graviton gun", 15));;
		add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		
		seperator();
		
		ogE.addElement(new OptionsGruppeEintrag("Melta bombs", 5));
		ogE.addElement(new OptionsGruppeEintrag("Rad grenades", 10));
		ogE.addElement(new OptionsGruppeEintrag("Cyber familiar", 15));
		ogE.addElement(new OptionsGruppeEintrag("Chem-Munitions", 0));
		add(o3 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 4));
		
		seperator();
		
		ogE.addElement(new OptionsGruppeEintrag("Servo-arm", 0));
		ogE.addElement(new OptionsGruppeEintrag("Conversion beamer", 35));
		add(o4 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		
		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Servo-automata", 12));
		add(o5 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 4));
		
		ogE.addElement(new OptionsGruppeEintrag("Lascutter", 5));
		ogE.addElement(new OptionsGruppeEintrag("Power fist", 15));
		ogE.addElement(new OptionsGruppeEintrag("Flamer", 5));
		ogE.addElement(new OptionsGruppeEintrag("Rotor cannon", 10));
		add(o6 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "option", ogE, 4));
		
		seperator();

		rkTransport = new RuestkammerStarter(ID, randAbstand, cnt, "DGTransporterKammer", "Dedicated transport");
		//Rhino, Pod, Phobos, Spartan
		rkTransport.initKammer(true, false, false, false);
		rkTransport.setButtonText("Dedicated transport");
		add(rkTransport);
		
        sizeSetzen();
	}

	@Override
	public void refreshen() {
		if (!o1.isSelected()) o1.setSelected(0, true);
		if (!o4.isSelected()) o4.setSelected(0, true);
		
		o3.setAktiv(3, o2.isSelected(3) || o6.isSelected("Flamer"));
		
		o6.setMaxAnzahl(o5.getAnzahl());
	}
        
}