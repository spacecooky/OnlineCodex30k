package oc.wh40k.units.or;

import java.util.Vector;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.Eintrag;
import oc.RuestkammerStarter;

public class ORStampfaMob extends Eintrag {

	 
	AnzahlPanel Stampfas;//0+
	AnzahlPanel BMStampfas;//0+
	AnzahlPanel EvilEye;//0+
	AnzahlPanel GoffRR;//0+
	AnzahlPanel GoffKS;//0+
    Vector<RuestkammerStarter> aufmotz = new Vector<RuestkammerStarter>();//0+

	public ORStampfaMob() {
		name = "Stampfa Mob\n";
		grundkosten = 200;

		add(ico = new oc.Picture("oc/wh40k/images/StampfaMob.gif"));
		
		
		add(Stampfas = new AnzahlPanel(ID, randAbstand, cnt, "Stampfa", "Stampfas", 0, 2147483647, 600));
		add(BMStampfas = new AnzahlPanel(ID, randAbstand, cnt, "Big Mek Stampfa", "Big Mek Stampfas", 0, 2147483647, 650));
		add(EvilEye = new AnzahlPanel(ID, randAbstand, cnt, "Evil Eye in da Sky", 0, 2147483647, 650));
		add(GoffRR = new AnzahlPanel(ID, randAbstand, cnt, "Goff Rok'n'Rolla", 0, 2147483647, 520));
		add(GoffKS = new AnzahlPanel(ID, randAbstand, cnt, "Goff Klau'nstampfa", 0, 2147483647, 450));
		
        seperator(20);
		
        aufmotz.add(new RuestkammerStarter(ID, randAbstand, cnt, "ORStampfaMobKammerAufgemotztaStampfa", "Aufgemotza Stampfa"));
        aufmotz.get(0).initKammer();
        add(aufmotz.get(0));
        aufmotz.get(0).setButtonText("Aufgemotza Stampfa");
        
    	complete();

	}

	public void refreshen() {
		
		adjustOptions(aufmotz,0,"ORStampfaMobKammerAufgemotztaStampfa", "Aufgemotza Stampfa",5,0);
		
		int mobSize =Stampfas.getModelle()+ BMStampfas.getModelle()+ EvilEye.getModelle()+ GoffRR.getModelle()+ GoffKS.getModelle()+aufmotz.size()-1;
		
		Stampfas.setLegal(mobSize>=3);
		BMStampfas.setLegal(mobSize>=3);
		EvilEye.setLegal(mobSize>=3);
		GoffRR.setLegal(mobSize>=3);
		GoffKS.setLegal(mobSize>=3);
		
		for(int i=0;i<aufmotz.size();i++){
			aufmotz.get(i).setLegal(mobSize>=3);
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
