package oc.wh40k.units.or;

import java.util.Vector;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.RuestkammerStarter;

public class ORGhazghkullsSchlaegerboyz extends Eintrag {

	 
	OptionsEinzelUpgrade ghazzie;
	OptionsEinzelUpgrade Munigrot;
    Vector<RuestkammerStarter> bosse = new Vector<RuestkammerStarter>();//3+
    Vector<RuestkammerStarter> gargbosse = new Vector<RuestkammerStarter>();//1+
    
	public ORGhazghkullsSchlaegerboyz() {
		name = "Ghazghkulls Schlägerboyz";
		grundkosten = 150;

		add(ico = new oc.Picture("oc/wh40k/images/Heizakult.gif"));
		
		
		add (ghazzie = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Ghazghkull", 225)); 
		add (Munigrot = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Munigrot", 3));

		seperator();
        
        for(int i=0;i<4;i++){
	        bosse.add(new RuestkammerStarter(ID, randAbstand, cnt, "ORGhazghkullsSchlaegerboyzKammerBosse", "Bosse",1));
	        bosse.get(i).initKammer();
	        add(bosse.get(i));
	        bosse.get(i).setButtonText("Bosse");
        }
        bosse.get(3).setAktiv(false);
        
        for(int i=0;i<2;i++){
            gargbosse.add(new RuestkammerStarter(ID, randAbstand, cnt, "ORGhazghkullsSchlaegerboyzKammerGargbosse", "Gargbosse",1));
            gargbosse.get(i).initKammer();
            add(gargbosse.get(i));
            gargbosse.get(i).setButtonText("Gargbosse");
        }
        gargbosse.get(1).setAktiv(false);
       
        
    	complete();

	}

	public void refreshen() {
		ghazzie.setSelected(true);
		
		adjustOptions(bosse,3,"ORGhazghkullsSchlaegerboyzKammerBosse", "Bosse",2,1);
		bosse.get(0).setLegal(bosse.get(0).isSelected());
		bosse.get(1).setLegal(bosse.get(1).isSelected());
		bosse.get(2).setLegal(bosse.get(2).isSelected());
		bosse.get(3).setAktiv(bosse.get(2).isSelected() && bosse.get(1).isSelected() && bosse.get(0).isSelected());
		bosse.get(0).setAktiv(true);
		bosse.get(1).setAktiv(true);
		bosse.get(2).setAktiv(true);
		
		adjustOptions(gargbosse,1,"ORGhazghkullsSchlaegerboyzKammerGargbosse", "Gargbosse",2+bosse.size(),1);
		gargbosse.get(0).setLegal(gargbosse.get(0).isSelected());
		gargbosse.get(1).setAktiv(gargbosse.get(0).isSelected());
		gargbosse.get(0).setAktiv(true);

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
	
	
}
