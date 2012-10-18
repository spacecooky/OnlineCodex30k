package oc.wh40k.units.or;

import java.util.Vector;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.RuestkammerStarter;

public class ORHeizakult extends Eintrag {

	 
	
    RuestkammerStarter waaaghboss; //1
    RuestkammerStarter bosse; //0-1 
    Vector<RuestkammerStarter> buggies = new Vector<RuestkammerStarter>();//2+
    Vector<RuestkammerStarter> biker = new Vector<RuestkammerStarter>();//2+
    Vector<RuestkammerStarter> bigmeks = new Vector<RuestkammerStarter>();//0+ 
    Vector<RuestkammerStarter> trukkboyz = new Vector<RuestkammerStarter>();//0+ 

	public ORHeizakult() {
		name = "Heizakult";
		grundkosten = 50;

		add(ico = new oc.Picture("oc/wh40k/images/Heizakult.gif"));
		
		
		waaaghboss = new RuestkammerStarter(ID, randAbstand, cnt, "ORHeizakultKammerWaaaghboss", "Waaaghboss");
		waaaghboss.initKammer();
		add(waaaghboss);
		waaaghboss.setButtonText("Waaaghboss");
		
		seperator(20);
        
        bosse = new RuestkammerStarter(ID, randAbstand, cnt, "ORHeizakultKammerBosse", "Bosse",1);
        bosse.initKammer();
        add(bosse);
        bosse.setButtonText("Bosse");
        
        seperator(20);
	
        for(int i=0;i<3;i++){
        buggies.add(new RuestkammerStarter(ID, randAbstand, cnt, "ORHeizakultKammerBuggies", "Buggies"));
        buggies.get(i).initKammer();
        add(buggies.get(i));
        buggies.get(i).setButtonText("Buggies");
        }
        buggies.get(2).setAktiv(false);
        
        seperator(20);
		
        for(int i=0;i<3;i++){
        biker.add(new RuestkammerStarter(ID, randAbstand, cnt, "ORHeizakultKammerBiker", "Waaaghbiker"));
        biker.get(i).initKammer();
        add(biker.get(i));
        biker.get(i).setButtonText("Waaaghbiker");
        }
        biker.get(2).setAktiv(false);
        
        seperator(20);

        bigmeks.add(new RuestkammerStarter(ID, randAbstand, cnt, "ORHeizakultKammerBigmek", "Bigmek",1));
        bigmeks.get(0).initKammer();
        add(bigmeks.get(0));
        bigmeks.get(0).setButtonText("Bigmek");
        
        seperator(20);

        trukkboyz.add(new RuestkammerStarter(ID, randAbstand, cnt, "ORHeizakultKammerBoyz", "Trukk-Boyz",1));
        trukkboyz.get(0).initKammer();
        add(trukkboyz.get(0));
        trukkboyz.get(0).setButtonText("Trukk-Boyz");
        
    	complete();

	}

	public void refreshen() {
		waaaghboss.setLegal(waaaghboss.isSelected());
		
		adjustOptions(buggies,2,"ORHeizakultKammerBuggies", "Buggies",2,0);
		buggies.get(0).setLegal(buggies.get(0).isSelected());
		buggies.get(1).setLegal(buggies.get(1).isSelected());
		buggies.get(2).setAktiv(buggies.get(1).isSelected() && buggies.get(0).isSelected());
		buggies.get(0).setAktiv(true);
		buggies.get(1).setAktiv(true);
		
		adjustOptions(biker,2,"ORHeizakultKammerBiker", "Waaaghbiker",2+buggies.size(),0);
		biker.get(0).setLegal(biker.get(0).isSelected());
		biker.get(1).setLegal(biker.get(1).isSelected());
		biker.get(2).setAktiv(biker.get(1).isSelected() && biker.get(0).isSelected());
		biker.get(0).setAktiv(true);
		biker.get(1).setAktiv(true);
		
		adjustOptions(bigmeks,0,"ORHeizakultKammerBigmek", "Bigmek",2+buggies.size()+biker.size(),1);
		
		adjustOptions(trukkboyz,0,"ORHeizakultKammerBoyz", "Trukk-Boyz",2+buggies.size()+biker.size()+bigmeks.size(),1);
		
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
