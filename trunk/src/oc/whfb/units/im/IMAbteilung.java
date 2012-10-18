package oc.whfb.units.im;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.OptionsEinzelUpgrade;
import oc.RuestkammerVater;

public class IMAbteilung extends RuestkammerVater {
	
	AnzahlPanel squad1;
	AnzahlPanel squad2;
	AnzahlPanel squad3;
	AnzahlPanel squad4;
	AnzahlPanel squad5;
	AnzahlPanel squad6;
	AnzahlPanel squad7;
	
	int anzahl;
	int anz1 = 0;
	int anz2 = 0;
	int anz3 = 0;

	public int getAnzahl() {
		return anzahl;
	}

	public void setAnzahl(int anzahl) {
		this.anzahl = anzahl;
	}

	public IMAbteilung() {
		grundkosten = 0;
	}
	
	OptionsEinzelUpgrade oeS1;
	OptionsEinzelUpgrade oeS2;

	@Override
	public void initButtons(boolean... defaults) {
		//FIXMEGP: beim Klonen erhält man immer die falsche Anzahl, aber nur bei der 1sten Abteilung... 
		squad1 = new AnzahlPanel(ID, randAbstand, cnt, BuildaHQ.translate("Bogenschützen"), 0, 3, 8);
		squad1.setGrundkosten(0);
		add(squad1);
		
		squad2 = new AnzahlPanel(ID, randAbstand, cnt, BuildaHQ.translate("Armbrustschützen"), 0, 3, 8);
		squad2.setGrundkosten(0);
		add(squad2);
		
		squad3 = new AnzahlPanel(ID, randAbstand, cnt, BuildaHQ.translate("Hellebardenträger"), 0, 3, 5);
		squad3.setGrundkosten(0);
		add(squad3);
		
		seperator();
		
		add(oeS1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Schilde"), 1));
		
		seperator();
		
		squad4 = new AnzahlPanel(ID, randAbstand, cnt, BuildaHQ.translate("Freischärler"), 0, 3, 5);
		squad4.setGrundkosten(0);
		add(squad4);
		
		squad5 = new AnzahlPanel(ID, randAbstand, cnt, BuildaHQ.translate("Musketenschützen"), 0, 3, 8);
		squad5.setGrundkosten(0);
		add(squad5);
		
		squad6 = new AnzahlPanel(ID, randAbstand, cnt, BuildaHQ.translate("Speerträger"), 0, 3, 5);
		squad6.setGrundkosten(0);
		add(squad6);
		
		seperator();
		
		add(oeS2 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Schilde"), 1));
		
		seperator();
		
		squad7 = new AnzahlPanel(ID, randAbstand, cnt, BuildaHQ.translate("Schwertkämpfer"), 0, 3, 6);
		squad7.setGrundkosten(0);
		add(squad7);
		setUeberschrift(BuildaHQ.translate("Imperiale Abteilungen"));
		sizeSetzen(200, 200, 385, KAMMER_HOEHE + cnt + 10);
	}

	@Override
	public void refreshen() {
		switchOtherSquadsOn();
		
		squad1.setMaxModelle(anzahl/2 >= 5 ? anzahl/2 : 0);
		if(squad1.getModelle() > 0){
			switchOffOtherSquads(1);
		}
		squad2.setMaxModelle(anzahl/2 >= 5 ? anzahl/2 : 0);
		if(squad2.getModelle() > 0){
			switchOffOtherSquads(2);
		}
		squad3.setMaxModelle(anzahl/2 >= 5 ? anzahl/2 : 0);
		if(squad3.getModelle() > 0){
			switchOffOtherSquads(3);
		}
		squad4.setMaxModelle(anzahl/2 >= 5 ? anzahl/2 : 0);
		if(squad4.getModelle() > 0){
			switchOffOtherSquads(4);
		}
		squad5.setMaxModelle(anzahl/2 >= 5 ? anzahl/2 : 0);
		if(squad5.getModelle() > 0){
			switchOffOtherSquads(5);
		}
		squad6.setMaxModelle(anzahl/2 >= 5 ? anzahl/2 : 0);
		if(squad6.getModelle() > 0){
			switchOffOtherSquads(6);
		}
		squad7.setMaxModelle(anzahl/2 >= 5 ? anzahl/2 : 0);
		if(squad7.getModelle() > 0){
			switchOffOtherSquads(7);
		}
		
		if(squad3.getModelle()!=0)oeS1.setPreis(squad3.getModelle() * 1);
		if(squad6.getModelle()!=0)oeS2.setPreis(squad6.getModelle() * 1);
		
		oeS1.setAktiv(squad3.isSelected());
		oeS2.setAktiv(squad6.isSelected());
			
		if((squad1.getModelle() < 5 && squad1.getModelle() > 0) || 
		   (squad2.getModelle() < 5 && squad2.getModelle() > 0)	||
		   (squad3.getModelle() < 5 && squad3.getModelle() > 0) ||
		   (squad4.getModelle() < 5 && squad4.getModelle() > 0) ||
		   (squad5.getModelle() < 5 && squad5.getModelle() > 0) ||
		   (squad6.getModelle() < 5 && squad6.getModelle() > 0) ||
		   (squad7.getModelle() < 5 && squad7.getModelle() > 0)){
			showErrorMessage(BuildaHQ.translate("min. 5 Modelle"));
			setButtonState(false);				
		}else{
			showErrorMessage("");
			setButtonState(true);
		}		
	}
	
	public void switchOffOtherSquads(int i){
		squad1.setAbschaltbar(i == 1 ? false : true);
		squad2.setAbschaltbar(i == 2 ? false : true);
		squad3.setAbschaltbar(i == 3 ? false : true);
		squad4.setAbschaltbar(i == 4 ? false : true);
		squad5.setAbschaltbar(i == 5 ? false : true);
		squad6.setAbschaltbar(i == 6 ? false : true);
		squad7.setAbschaltbar(i == 7 ? false : true);		
	}
	
	public void switchOtherSquadsOn(){
		squad1.setAbschaltbar(false);
		squad2.setAbschaltbar(false);
		squad3.setAbschaltbar(false);
		squad4.setAbschaltbar(false);
		squad5.setAbschaltbar(false);
		squad6.setAbschaltbar(false);
		squad7.setAbschaltbar(false);		
	}
}
