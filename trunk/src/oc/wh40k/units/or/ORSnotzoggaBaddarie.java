package oc.wh40k.units.or;

import java.util.Vector;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.RuestkammerStarter;

public class ORSnotzoggaBaddarie extends Eintrag {

	Vector<RuestkammerStarter> Snotlingherde = new Vector<RuestkammerStarter>();//1+
    Vector<RuestkammerStarter> bigmeks = new Vector<RuestkammerStarter>();//3+ 

	public ORSnotzoggaBaddarie() {
		name = "Snotzogga-Baddarie";
		grundkosten = 75;

		add(ico = new oc.Picture("oc/wh40k/images/Snotzogga-Baddarie.gif"));
		
		
		for(int i=0;i<4;i++){
			bigmeks.add(new RuestkammerStarter(ID, randAbstand, cnt, "ORSnotzoggaBaddarieKammerBigmek", "Bigmek"));
	        bigmeks.get(i).initKammer();
	        add(bigmeks.get(i));
	        bigmeks.get(i).setButtonText("Bigmek");
		}
		bigmeks.get(3).setAktiv(false);
		
        seperator(20);
	
        for(int i=0;i<2;i++){
        Snotlingherde.add(new RuestkammerStarter(ID, randAbstand, cnt, "ORSnotzoggaBaddarieKammerSnotlingherde", "Snotlingherde"));
        Snotlingherde.get(i).initKammer();
        add(Snotlingherde.get(i));
        Snotlingherde.get(i).setButtonText("Snotlingherde");
        }
        Snotlingherde.get(1).setAktiv(false);
        
    	complete();

	}

	public void refreshen() {

		adjustOptions(bigmeks,3,"ORSnotzoggaBaddarieKammerBigmek", "Bigmek",0,0);
		bigmeks.get(0).setLegal(bigmeks.get(0).isSelected());
		bigmeks.get(1).setLegal(bigmeks.get(1).isSelected());
		bigmeks.get(2).setLegal(bigmeks.get(2).isSelected());
		bigmeks.get(3).setAktiv(bigmeks.get(2).isSelected() && bigmeks.get(1).isSelected() && bigmeks.get(0).isSelected());
		bigmeks.get(0).setAktiv(true);
		bigmeks.get(1).setAktiv(true);
		bigmeks.get(2).setAktiv(true);
		
		adjustOptions(Snotlingherde,2,"ORSnotzoggaBaddarieKammerSnotlingherde", "Snotlingherde",bigmeks.size(),0);
		Snotlingherde.get(0).setLegal(Snotlingherde.get(0).isSelected());
		Snotlingherde.get(1).setAktiv(Snotlingherde.get(0).isSelected());
		Snotlingherde.get(0).setAktiv(true);
		
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
