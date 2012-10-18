package oc.wh40k.units.tl;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerStarter;

public class TLLegionSpaceMarineCohort extends Eintrag {

	AnzahlPanel marines;
	
	OptionsEinzelUpgrade sergeant;
	OptionsZaehlerGruppe o2;
	OptionsZaehlerGruppe o3;
	RuestkammerStarter rkTransport;

	public TLLegionSpaceMarineCohort() {
		
	
		add(ico = new oc.Picture("oc/wh40k/images/TLLegionSpaceMarineCohort.jpg"));
		

		marines = new AnzahlPanel(ID, randAbstand, cnt, "Space Marines", 10, 20, 15);
		add(marines);
		
		seperator();
		
		ogE.addElement(new OptionsGruppeEintrag("Flamer", 5));
		ogE.addElement(new OptionsGruppeEintrag("Meltagun", 10));
		ogE.addElement(new OptionsGruppeEintrag("Plasma gun", 15));
		ogE.addElement(new OptionsGruppeEintrag("Power weapon", 10));
		ogE.addElement(new OptionsGruppeEintrag("Heavy bolter", 10));
		ogE.addElement(new OptionsGruppeEintrag("Missile Launcher", 15));
		add(o2 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 2));
		
		seperator();
		
		add(sergeant = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Veteran Sergeant", 0));
		
		seperator();
		
		ogE.addElement(new OptionsGruppeEintrag("Chainsword", 0));
		ogE.addElement(new OptionsGruppeEintrag("Storm bolter", 5));
		ogE.addElement(new OptionsGruppeEintrag("Combi-plasma", 10));
		ogE.addElement(new OptionsGruppeEintrag("Combi-flamer", 10));
		ogE.addElement(new OptionsGruppeEintrag("Combi-melta", 10));
		ogE.addElement(new OptionsGruppeEintrag("Plasma pistol", 15));
		ogE.addElement(new OptionsGruppeEintrag("Power weapon", 15));
		ogE.addElement(new OptionsGruppeEintrag("Power fist", 25));
		add(o3 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "option", ogE, 2));

		seperator();
		
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Melta bombs", 5));

		seperator();

		rkTransport = new RuestkammerStarter(ID, randAbstand, cnt, "TLRhinoKammer", "Rhino");
		rkTransport.initKammer(false, true);
		rkTransport.setButtonText("Rhino");
		add(rkTransport);

		BuildaHQ.addToInformationVector("TLEnableHeavySupport", 1);
        BuildaHQ.getChooserGruppe(5).addSpezialAuswahl("Devastor Trupp");
        BuildaHQ.getChooserGruppe(5).addSpezialAuswahl("Salvenkanone");
        BuildaHQ.getChooserGruppe(5).addSpezialAuswahl("Land Raider");
        BuildaHQ.getChooserGruppe(5).addSpezialAuswahl("Land Raider Crusader");
        BuildaHQ.getChooserGruppe(5).addSpezialAuswahl("Land Raider Redeemer");
        BuildaHQ.getChooserGruppe(5).addSpezialAuswahl("Predator");
        BuildaHQ.getChooserGruppe(5).addSpezialAuswahl("Whirlwind");
        BuildaHQ.getChooserGruppe(5).addSpezialAuswahl("Vindicator");
        BuildaHQ.getChooserGruppe(5).addSpezialAuswahl("[IA Experimental] Spartan Assault Tank");
		
		complete();
	}

	@Override
    public void deleteYourself() {
        BuildaHQ.addToInformationVector("TLEnableHeavySupport", -1);
        if(BuildaHQ.getCountFromInformationVector("TLEnableHeavySupport")==0){
	        BuildaHQ.getChooserGruppe(5).removeSpezialAuswahl("Devastor Trupp");
	        BuildaHQ.getChooserGruppe(5).removeSpezialAuswahl("Salvenkanone");
	        BuildaHQ.getChooserGruppe(5).removeSpezialAuswahl("Land Raider");
	        BuildaHQ.getChooserGruppe(5).removeSpezialAuswahl("Land Raider Crusader");
	        BuildaHQ.getChooserGruppe(5).removeSpezialAuswahl("Land Raider Redeemer");
	        BuildaHQ.getChooserGruppe(5).removeSpezialAuswahl("Predator");
	        BuildaHQ.getChooserGruppe(5).removeSpezialAuswahl("Whirlwind");
	        BuildaHQ.getChooserGruppe(5).removeSpezialAuswahl("Vindicator");
	        BuildaHQ.getChooserGruppe(5).removeSpezialAuswahl("[IA Experimental] Spartan Assault Tank");
        }
            
        super.deleteYourself();
       
           
        
    }
	
	// @OVERRIDE
	public void refreshen() {
		sergeant.setSelected(true);
		rkTransport.setAktiv(marines.getModelle()==10);
		o2.setMaxAnzahl(marines.getModelle()/5);
		
	}

}
