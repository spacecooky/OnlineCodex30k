package oc.wh40k.units.tl;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerStarter;

public class TLAuxiliaArmsmenCadre extends Eintrag {

	AnzahlPanel armsmen;
	
	OptionsEinzelUpgrade master;
	OptionsZaehlerGruppe o1;
	OptionsZaehlerGruppe o2;
	OptionsZaehlerGruppe o3;
	OptionsZaehlerGruppe o4;
	RuestkammerStarter rkTransport;

	public TLAuxiliaArmsmenCadre() {
		
	
		add(ico = new oc.Picture("oc/wh40k/images/TLAuxiliaArmsmenCadre.jpg"));
		

		armsmen = new AnzahlPanel(ID, randAbstand, cnt, "Armsmen", 10, 20, 5);
		add(armsmen);
		
		seperator();
		
		ogE.addElement(new OptionsGruppeEintrag("Flamer", 5));
		ogE.addElement(new OptionsGruppeEintrag("Grenade Launcher", 5));
		ogE.addElement(new OptionsGruppeEintrag("Meltagun", 10));
		ogE.addElement(new OptionsGruppeEintrag("Heavy Stubber", 10));
		add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));
		
		seperator();
		
		ogE.addElement(new OptionsGruppeEintrag("Heavy bolter", 10));
		ogE.addElement(new OptionsGruppeEintrag("Autocannon", 10));
		ogE.addElement(new OptionsGruppeEintrag("Heavy flamer", 15));
		ogE.addElement(new OptionsGruppeEintrag("Missile launcher", 15));
		add(o2 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));
		
		seperator();
		
		ogE.addElement(new OptionsGruppeEintrag("Shotgun", 0));
		ogE.addElement(new OptionsGruppeEintrag("CC Weapon","Close combat weapon", 0));
		add(o4 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "option", ogE, 9));
		
		seperator();
		
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Krak grenades", 10));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Carapace armour", 25));
		
		seperator();
		
		add(master = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Master at Arms", 0));
		
		seperator();
		
		ogE.addElement(new OptionsGruppeEintrag("Bolt pistol", 5));
		ogE.addElement(new OptionsGruppeEintrag("Plasma pistol", 15));
		ogE.addElement(new OptionsGruppeEintrag("Power weapon", 10));
		ogE.addElement(new OptionsGruppeEintrag("Power fist", 15));
		add(o3 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "option", ogE, 2));

		seperator();
		
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Melta bombs", 5));

		seperator();

		rkTransport = new RuestkammerStarter(ID, randAbstand, cnt, "TLChimera", "Chimera Transport");
		rkTransport.initKammer(true);
		add(rkTransport);
		
		complete();
	}

	// @OVERRIDE
	public void refreshen() {
		master.setSelected(true);
		o2.setMaxAnzahl(armsmen.getModelle()/10);
		o4.setMaxAnzahl(armsmen.getModelle()-o2.getAnzahl()*2-o1.getAnzahl()-1);
		
		rkTransport.setAktiv(armsmen.getModelle()<13);
		
	}

}
