package oc.wh40k.units.cm;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerStarter;

public class CMKhorneBerserker extends Eintrag {

	AnzahlPanel squad;
	OptionsZaehlerGruppe o1;
	OptionsZaehlerGruppe o1def;
	OptionsZaehlerGruppe o2;
    OptionsZaehlerGruppe o2def;
	OptionsEinzelUpgrade plasmapistole;
	OptionsUpgradeGruppe ikone;
	OptionsUpgradeGruppe vdlk;
	OptionsZaehlerGruppe o7;
    RuestkammerStarter champion;
    RuestkammerStarter chaosTransport;
	OptionsZaehlerGruppe ketten�xte;
    
	public CMKhorneBerserker() {
		//name = "Khorne-Berserker\n";
		grundkosten = 0;
		�berschriftSetzen = true;

		squad = new AnzahlPanel(ID, randAbstand, cnt, "Khorne-Berserker", 5, 20, 19);
		add(squad);

		add(ico = new oc.Picture("oc/wh40k/images/ChaosSpaceMarines.jpg"));	
			
		seperator();
		
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Ikone des Zorns", 15));
		
		seperator();
		
		ogE.addElement(new OptionsGruppeEintrag("Ketten�xte", "Ketten�xte", 3));
		add(ketten�xte = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 0));
		
		seperator();
		
		ogE.addElement(new OptionsGruppeEintrag("Plasmapistole", 15));
		add(o7 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 2));
		
		seperator();
				
		ogE.addElement(new OptionsGruppeEintrag("Veteranen", "Veteranen des Langen Krieges", 1));
		add(vdlk = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));

		seperator();

		champion = new RuestkammerStarter(ID, randAbstand, cnt, "CMChampion", "Berserkerchampion",1);
		// Besessen, Hexer, Slaanesh, Champion, Nurgle, Khorne
		champion.initKammer(false,false,false, false, false, true);
		champion.setUeberschriftTrotzNullKostenAusgeben(true);
		champion.setGrundkosten(10);
		add(champion);
		champion.setAbwaehlbar(false);
		seperator();
		
		chaosTransport = new RuestkammerStarter(ID, randAbstand, cnt, "CMTransporter", "Transporter");
		chaosTransport.initKammer(true, false);
		chaosTransport.setButtonText("Transporter");
		add(chaosTransport);
		
		BuildaHQ.addToInformationVector("CMBerserker", 1);
        BuildaHQ.getChooserGruppe(5).addSpezialAuswahl("[Forgeworld] Blood Slaughterer of Khorne");
		
		complete();
	}

	@Override
    public void deleteYourself() {
		BuildaHQ.addToInformationVector("CMBerserker", -1);
    	if(BuildaHQ.getCountFromInformationVector("CMDreadBerserker")<1 && BuildaHQ.getCountFromInformationVector("CMBerserker")<1){
    		BuildaHQ.getChooserGruppe(5).removeSpezialAuswahl("[Forgeworld] Blood Slaughterer of Khorne");
    	}
        super.deleteYourself();
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
		
		int subtractor = 1; // Sch�delchampion
		ketten�xte.setMaxAnzahl(squad.getModelle() - subtractor);
	}
}
