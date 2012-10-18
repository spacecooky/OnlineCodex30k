/* Regeln zu finden unter:
 * http://www.games-workshop.com/MEDIA_CustomProductCatalog/m2430606_Apo_-_Dark_Eldar_-_Karneval_der_Schmerzen.pdf
 */

package oc.wh40k.units.de;

import java.util.Vector;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.RuestkammerStarter;

public class DEKarnevalderSchmerzen extends Eintrag {

	 
	OptionsEinzelUpgrade urienRakarth;
    Vector<RuestkammerStarter> haemonculi = new Vector<RuestkammerStarter>();//3+
    Vector<RuestkammerStarter> grotesquen = new Vector<RuestkammerStarter>();//3+

	public DEKarnevalderSchmerzen() {
		name = "Karneval der Schmerzen";
		grundkosten = 75;
        überschriftSetzen = true;

		add(ico = new oc.Picture("oc/wh40k/images/Heizakult.gif"));
		

        add(urienRakarth = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Urien Rakarth", 190));

		BuildaHQ.getChooserGruppe(2).removeSpezialAuswahl("Folterer");
		BuildaHQ.getChooserGruppe(3).addSpezialAuswahl("Folterer");

        BuildaHQ.addToInformationVector("DEHaemonculus", 1);
        BuildaHQ.addToInformationVector("DEUrienRakarth", 1);
        
        seperator();
	
        for(int i=0;i<4;i++){
        haemonculi.add(new RuestkammerStarter(ID, randAbstand, cnt, "DEKarnevalKammerHaemonculus", "Haemonkulus"));
        haemonculi.get(i).initKammer();
        add(haemonculi.get(i));
        haemonculi.get(i).setButtonText("Haemonculus");
        }
        
        seperator();
		
        for(int i=0;i<4;i++){
        grotesquen.add(new RuestkammerStarter(ID, randAbstand, cnt, "DEKarnevalKammerGrotesquen", "Grotesquen-Trupp", 1));
        grotesquen.get(i).initKammer();
        add(grotesquen.get(i));
        grotesquen.get(i).setButtonText("Grotesquen");
        }
        
    	complete();

	}

	public void refreshen() {
        urienRakarth.setSelected(true);
		
		adjustOptions(haemonculi,3,"DEKarnevalKammerHaemonculus", "Haemonculus",1,0);
        haemonculi.get(0).setAbwaehlbar(false);
        haemonculi.get(1).setAbwaehlbar(false);
        haemonculi.get(2).setAbwaehlbar(false);
		
		adjustOptions(grotesquen,3,"DEKarnevalKammerGrotesquen", "Grotesquen-Trupp",1+haemonculi.size(),1);
        grotesquen.get(0).setAbwaehlbar(false);
        grotesquen.get(1).setAbwaehlbar(false);
        grotesquen.get(2).setAbwaehlbar(false);

        for(int i=0;i<grotesquen.size();i++) {
            grotesquen.get(i).setUeberschriftTrotzNullKostenAusgeben(true);
        }

		aktualisiereKammerStarterLocation();
		
	}
	
	//Entfernt aus dem Vektor alle überzähligen nicht ausgewählten Einträge.
	//Fügt einen neuen auswählbaren Eintrag hinter dem letzten der gleichen Einheit ein, falls alle ausgewählt wurden.
	public void adjustOptions(Vector<RuestkammerStarter> starter, int minOptions, String unit, String unitName, int offset, int einrueck){
		
		
		for(int i=0;i<starter.size()-1 && starter.size()>(minOptions+1);i++){
			if(!starter.get(i).isSelected()){
				remove(starter.get(i));
				starter.remove(i);
				i--;
			}
		}
		
		if(starter.lastElement().isSelected()){
			RuestkammerStarter ruest = new RuestkammerStarter(ID, randAbstand, cnt, unit, unitName,einrueck);
			starter.add(ruest);
			ruest.initKammer();
			addAt(ruest, offset+starter.size()-1);
			ruest.setButtonText(unitName);
		}
	
	}
    
	@Override
	public void deleteYourself() {
		super.deleteYourself();

        BuildaHQ.addToInformationVector("DEHaemonculus", -1);
        BuildaHQ.addToInformationVector("DEUrienRakarth", -1);

        if(BuildaHQ.getCountFromInformationVector("DEHaemonculus") < 1) {
            BuildaHQ.getChooserGruppe(2).addSpezialAuswahl("Folterer");
            BuildaHQ.getChooserGruppe(3).removeSpezialAuswahl("Folterer");
        }
	}
	
	
}
