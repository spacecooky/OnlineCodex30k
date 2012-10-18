package oc.wh40k.units.ta;

import java.util.Vector;

import oc.Eintrag;
import oc.RuestkammerStarter;

public class TAKrootSoeldnersippe extends Eintrag {
	
    Vector<RuestkammerStarter> jagdsippe = new Vector<RuestkammerStarter>();//1+
    RuestkammerStarter reiter1; 
    RuestkammerStarter reiter2; 
    RuestkammerStarter reiter3; 
    RuestkammerStarter riesen; 
    
	public TAKrootSoeldnersippe() {
		name = "Kroot-Söldnersippe";
		grundkosten = 30;

		add(ico = new oc.Picture("oc/wh40k/images/KrootSoeldnersippe.gif"));
		
        for(int i=0;i<2;i++){
        	jagdsippe.add(new RuestkammerStarter(ID, randAbstand, cnt, "TAKrootJagdtruppKammer", "Jagdsippe",0));
        	jagdsippe.get(i).initKammer();
	        add(jagdsippe.get(i));
	        jagdsippe.get(i).setButtonText("Jagdsippe");
        }
        jagdsippe.get(1).setAktiv(false);
        
        reiter1 = new RuestkammerStarter(ID, randAbstand, cnt, "TAKnarlocRiderHerdKammer", "Knarloc Rider Herd");
        reiter1.initKammer();
		add(reiter1);
		
		reiter2 = new RuestkammerStarter(ID, randAbstand, cnt, "TAKnarlocRiderHerdKammer", "Knarloc Rider Herd");
        reiter2.initKammer();
		add(reiter2);
		
		reiter3 = new RuestkammerStarter(ID, randAbstand, cnt, "TAKnarlocRiderHerdKammer", "Knarloc Rider Herd");
        reiter3.initKammer();
		add(reiter3);
       
		riesen = new RuestkammerStarter(ID, randAbstand, cnt, "TAGreatKnarlocPackKammer", "Great Knarloc Pack");
		riesen.initKammer();
		add(riesen);
		
    	complete();

	}

	public void refreshen() {
		
		boolean legal=(jagdsippe.size()-1 + (reiter1.isSelected()?1:0) + (reiter2.isSelected()?1:0) + (reiter3.isSelected()?1:0) + (riesen.isSelected()?1:0))>=3;
		
		adjustOptions(jagdsippe,1,"TAKrootJagdtruppKammer", "Jagdsippe",0,0);
		jagdsippe.get(0).setLegal(jagdsippe.get(0).isSelected() && legal);
		jagdsippe.get(1).setAktiv(jagdsippe.get(0).isSelected());
		jagdsippe.get(0).setAktiv(true);
		
		for(int i=1;i<jagdsippe.size();i++){
			jagdsippe.get(i).setLegal(legal);
		}
		
		reiter1.setLegal(legal);
		reiter2.setLegal(legal);
		reiter3.setLegal(legal);
		riesen.setLegal(legal);

		int aeltCount=0;
		for(int i=0;i<jagdsippe.size();i++){
			TAKrootJagdtruppKammer mb2 = (TAKrootJagdtruppKammer)jagdsippe.get(i).getKammer();
			aeltCount += mb2.rkBoss2.isSelected()?1:0;
		}
		
		if(aeltCount==0 || aeltCount>1){
			setFehlermeldung("1 Ältester");
		} else{
			setFehlermeldung("");
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
	
	
}
