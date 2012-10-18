package oc.wh40k.units.tl;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsEinzelZaehler;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerStarter;

public class TLRenegadeMarauders extends Eintrag {

	AnzahlPanel renegades;
	
	OptionsEinzelUpgrade chief;
	OptionsUpgradeGruppe o1;
	OptionsZaehlerGruppe o2;
	OptionsZaehlerGruppe o3;
	OptionsEinzelZaehler brutes;
	RuestkammerStarter rkTransport;
	RuestkammerStarter rkTransport2;

	public TLRenegadeMarauders() {
		
	
		add(ico = new oc.Picture("oc/wh40k/images/TLRenegadeMarauders.jpg"));
		

		renegades = new AnzahlPanel(ID, randAbstand, cnt, "Renegade Marauders", 5, 10, 10);
		add(renegades);
		
		seperator();
		
		add(brutes = new OptionsEinzelZaehler(ID, randAbstand, cnt, "", "Brute", 2,30));
		
		seperator();
		
		ogE.addElement(new OptionsGruppeEintrag("Flamer", 5));
		ogE.addElement(new OptionsGruppeEintrag("Grenade launcher", 5));
		ogE.addElement(new OptionsGruppeEintrag("Sniper rifle", 5));
		ogE.addElement(new OptionsGruppeEintrag("Meltagun", 10));
		ogE.addElement(new OptionsGruppeEintrag("Heavy stubber", 10));
		ogE.addElement(new OptionsGruppeEintrag("Power weapon", 10));
		add(o2 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 2));
		
		seperator();
		
		add(chief = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Marauder Chief", 5));
		
		seperator();
		
		ogE.addElement(new OptionsGruppeEintrag("Bolt pistol", 5));
		ogE.addElement(new OptionsGruppeEintrag("Bolt gun", 5));
		ogE.addElement(new OptionsGruppeEintrag("Plasma pistol", 15));
		ogE.addElement(new OptionsGruppeEintrag("Power weapon", 10));
		ogE.addElement(new OptionsGruppeEintrag("Power fist", 15));
		add(o3 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "option", ogE, 2));

		seperator();
		
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Melta bombs", 5));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Refractor field", 10));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Demolition charge", 25));

		seperator();
		
		ogE.addElement(new OptionsGruppeEintrag("Stalkers",0));
		ogE.addElement(new OptionsGruppeEintrag("Murder Cultists",0));
		ogE.addElement(new OptionsGruppeEintrag("Hereteks",0));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "option", ogE, 1));
		
		seperator();

		rkTransport = new RuestkammerStarter(ID, randAbstand, cnt, "TLChimera", "Chimera Transport");
		rkTransport.initKammer(true);
		add(rkTransport);
		
		rkTransport2 = new RuestkammerStarter(ID, randAbstand, cnt, "TLArvusLighter", "Arvus Lighter");
		rkTransport2.initKammer(true);
		add(rkTransport2);

		complete();
	}

	// @OVERRIDE
	public void refreshen() {
		chief.setSelected(true);
		
		rkTransport2.setAktiv(((renegades.getModelle()+brutes.getAnzahl()*2)<=10 && !rkTransport.isSelected()));
		rkTransport.setAktiv(((renegades.getModelle()+brutes.getAnzahl()*2)<=12 && !rkTransport2.isSelected()));
	}

}
