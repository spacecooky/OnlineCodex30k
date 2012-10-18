package oc.wh40k.units.cm;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerStarter;

public class CMSeuchenmarines extends Eintrag {

	AnzahlPanel squad;
	OptionsUpgradeGruppe vdlk;
	OptionsZaehlerGruppe o7;
    RuestkammerStarter champion;
    RuestkammerStarter chaosTransport;
    
	public CMSeuchenmarines() {
		//name = "Seuchenmarines\n";
		grundkosten = 0;
		�berschriftSetzen = true;

		squad = new AnzahlPanel(ID, randAbstand, cnt, "Seuchenmarines", 5, 20, 24);
		add(squad);

		add(ico = new oc.Picture("oc/wh40k/images/ChaosSpaceMarines.jpg"));	
			
		seperator();
		
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Ikone der Verzweiflung", 10));
		
		seperator();
		
		ogE.addElement(new OptionsGruppeEintrag("Plasmapistole", 15));
		ogE.addElement(new OptionsGruppeEintrag("Flammenwerfer", 5));
		ogE.addElement(new OptionsGruppeEintrag("Melter", 10));
		ogE.addElement(new OptionsGruppeEintrag("Plasmawerfer", 15));
		add(o7 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 2));
		
		seperator();
				
		ogE.addElement(new OptionsGruppeEintrag("Veteranen", "Veteranen des Langen Krieges", 1));
		add(vdlk = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));

		seperator();

		champion = new RuestkammerStarter(ID, randAbstand, cnt, "CMChampion", "Seuchenchampion",1);
		// Besessen, Hexer, Slaanesh, Champion, Nurgle, Khorne
		champion.initKammer(false,false,false, false, true, false);
		champion.setUeberschriftTrotzNullKostenAusgeben(true);
		add(champion);
		champion.setAbwaehlbar(false);
		seperator();

		seperator();
		
		chaosTransport = new RuestkammerStarter(ID, randAbstand, cnt, "CMTransporter", "Transporter");
		chaosTransport.initKammer(true, false);
		chaosTransport.setButtonText("Transporter");
		add(chaosTransport);
		
		BuildaHQ.getChooserGruppe(4).addSpezialAuswahl("[Forgeworld] Blight Drones of Nurgle");
        BuildaHQ.getChooserGruppe(2).addSpezialAuswahl("[Forgeworld] Plague Ogryns");
        BuildaHQ.getChooserGruppe(5).addSpezialAuswahl("[Forgeworld] Plague Hulk of Nurgle");
		
        BuildaHQ.addToInformationVector("CMPlague", 1);
        
		complete();
	}

	@Override
	public void refreshen() {
		
		int count = squad.getModelle();
		
		vdlk.setPreis("Veteranen des Langen Krieges", 1 * count);
		
        if(!champion.isSelected()) champion.setSelected(true);

		chaosTransport.getPanel().setLocation(
			(int) chaosTransport.getPanel().getLocation().getX(),
			(int) chaosTransport.getPanel().getLocation().getY() + chaosTransport.getPanel().getSize().height + 5
		);
		
		chaosTransport.getPanel().setLocation(
				(int) chaosTransport.getPanel().getLocation().getX(),
				(int) champion.getPanel().getLocation().getY() + champion.getPanel().getSize().height + 5
	    );
	}
	
	@Override
    public void deleteYourself() {
		BuildaHQ.addToInformationVector("CMPlague", -1);
    	
    	if(BuildaHQ.getCountFromInformationVector("CMDreadPlague")<1 && BuildaHQ.getCountFromInformationVector("CMPlague")<1){
	        BuildaHQ.getChooserGruppe(4).removeSpezialAuswahl("[Forgeworld] Blight Drones of Nurgle");
	        BuildaHQ.getChooserGruppe(2).removeSpezialAuswahl("[Forgeworld] Plague Ogryns");
	        BuildaHQ.getChooserGruppe(5).removeSpezialAuswahl("[Forgeworld] Plague Hulk of Nurgle");
    	}
        super.deleteYourself();
    }
}
