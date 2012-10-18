package oc.wh40k.units.cm;

import oc.BuildaHQ;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.OptionsZaehlerGruppe;
import oc.RefreshListener;
import oc.RuestkammerVater;

public class CMWaffenUndArtefakte extends RuestkammerVater {

	OptionsUpgradeGruppe o1;
	OptionsZaehlerGruppe o2, o3;
    OptionsEinzelUpgrade schriftrollen;
    OptionsEinzelUpgrade dimensionsschlüssel;
    OptionsEinzelUpgrade handwaffe = null;
    OptionsEinzelUpgrade boltpistole = null;
    OptionsEinzelUpgrade bolter = null;
    OptionsEinzelUpgrade spezialWaffe = null;
    OptionsUpgradeGruppe psiWaffe = null;
    boolean fackelBool=false;
    boolean axtBool=false;
    boolean schwertBool=false;
    boolean kolbenBool=false;
    boolean schluesselBool=false;
    boolean rolleBool=false;
    boolean uniqueError=false;

	boolean malDesKhorne = false;
	boolean malDesTzeentch = false;
	boolean malDesNurgle = false;
	boolean malDesSlaanesh = false;

	boolean isChaosgeneral = false; //Handwaffe, Boltpistole 
	boolean isHexer = false;        //Psiwaffe, Boltpistole
	boolean isWarpschmied = false;  //Energieaxt, Boltpistole
	boolean isApostel = false;      //Energiestreitkolben, Boltpistole
    boolean isDaemon = false; //Seuchenmesser, Boltpistole, Bolter
	
	public CMWaffenUndArtefakte() {
		grundkosten = 0;
	}

	@Override
	public void initButtons(boolean... defaults) {
		try {
			isChaosgeneral = defaults[0]; 
			isHexer = defaults[1];        
			isWarpschmied = defaults[2];  
			isApostel = defaults[3];      
			isDaemon = defaults[4];     
		} catch(Exception e) {}
		
	    if(isChaosgeneral || isDaemon) {
	    	add(handwaffe = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Handwaffe", 0));
	    	handwaffe.setSelected(true);
	    } else if(isHexer) {
			ogE.addElement(new OptionsGruppeEintrag("Psiwaffe", 0));
			ogE.addElement(new OptionsGruppeEintrag("Psistab", 0));
			ogE.addElement(new OptionsGruppeEintrag("Psischwert", 0));
			ogE.addElement(new OptionsGruppeEintrag("Psiaxt", 0));
			add(psiWaffe = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
			psiWaffe.setSelected(0, true);
	    } else if(isWarpschmied) {
	    	add(spezialWaffe = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Energieaxt", 0));
	    	spezialWaffe.setSelected(true);
	    } else if(isApostel) {
	    	add(spezialWaffe = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Energiestreitkolben", 0));
	    	spezialWaffe.setSelected(true);
	    } 
	    
	    if(!isDaemon){
		    add(boltpistole = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Boltpistole", 0));
		    boltpistole.setSelected(true);
	    }
	    
	    seperator();
	   
		ogE.addElement(new OptionsGruppeEintrag("Kettenaxt", 8));
		ogE.addElement(new OptionsGruppeEintrag("Energieklaue", 15));
		ogE.addElement(new OptionsGruppeEintrag("Energiewaffe", 15));
		ogE.addElement(new OptionsGruppeEintrag("Energieschwert", 15));
		ogE.addElement(new OptionsGruppeEintrag("Energieaxt", 15));
		ogE.addElement(new OptionsGruppeEintrag("Energielanze", 15));
		ogE.addElement(new OptionsGruppeEintrag("Energiestreitkolben", 15));
		ogE.addElement(new OptionsGruppeEintrag("Energiefaust", 25));
		add(o3 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 0));
		seperator();
		
		ogE.addElement(new OptionsGruppeEintrag("Kombibolter", 3));
		ogE.addElement(new OptionsGruppeEintrag("Kombi-Flammenwerfer", 10));
		ogE.addElement(new OptionsGruppeEintrag("Kombi-Melter", 10));
		ogE.addElement(new OptionsGruppeEintrag("Kombi-Plasmawerfer", 10));
		ogE.addElement(new OptionsGruppeEintrag("Plasmapistole", 15));
		add(o2 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 0));
		
		seperator();
		
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Brandfackel von Skalathrax"), 30));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Axt der blinden Wut"), 35));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Das Mordschwert"), 35));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Der schwarze Streikolben"), 45));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 0));
		setUeberschrift("Waffen und Artefakte");
		sizeSetzen();
		
		seperator();
		
		add(dimensionsschlüssel = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Dimensionsschlüssel"), 25));
		add(schriftrollen = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Schriftrollen des Magnus"), 45));
	}

	@Override
	public void refreshen() {
		schriftrollen.setAktiv(malDesTzeentch);
		
		
		int nahkampfwaffen = 0;
		int fernkampfwaffen = 0;
		int artefakte = 0;
		int substractor = 0;
		
		if(isChaosgeneral) {
			if(handwaffe.isSelected() && boltpistole.isSelected()) { substractor = 2; }
			else if(handwaffe.isSelected() || boltpistole.isSelected()) { substractor = 1; }
			else if(!handwaffe.isSelected() && !boltpistole.isSelected()) { substractor = 0; }
			
			nahkampfwaffen = 2 - substractor - o2.getAnzahl() - o1.getAnzahl();
			fernkampfwaffen = 2 - substractor - o3.getAnzahl() - o1.getAnzahl();
			artefakte = 2 - substractor - o2.getAnzahl() - o3.getAnzahl();
			
			if(nahkampfwaffen < 0) nahkampfwaffen = 0;
			if(fernkampfwaffen < 0) fernkampfwaffen = 0;
			if(artefakte < 0) artefakte = 0;
			
			if(fernkampfwaffen > 1) fernkampfwaffen = 1;
			if(artefakte > 1) artefakte = 1;
			
			o3.setMaxAnzahl(nahkampfwaffen);
			o2.setMaxAnzahl(fernkampfwaffen);
			
			
			o1.setAktiv(artefakte>0);
			o1.setAktiv(BuildaHQ.translate("Axt der blinden Wut"), malDesKhorne && artefakte>0);
			o1.setMaxAnzahl(artefakte);
				
			boolean legal = ((boltpistole.isSelected()?1:0) + (handwaffe.isSelected()?1:0) + o1.getAnzahl() + o2.getAnzahl() + o3.getAnzahl())==2;
			boltpistole.setLegal(legal);
			handwaffe.setLegal(legal);
			o1.setLegal(legal);
			o2.setLegal(legal);
			o3.setLegal(legal);
		}
		
		if(isHexer) {
			if(!psiWaffe.isSelected()) nahkampfwaffen = 1;
			
			if(psiWaffe.isSelected() && boltpistole.isSelected()) { substractor = 2; }
			else if(psiWaffe.isSelected() || boltpistole.isSelected()) { substractor = 1; }
			else if(!psiWaffe.isSelected() && !boltpistole.isSelected()) { substractor = 0; }
			
			nahkampfwaffen = 2 - substractor - o2.getAnzahl() - o1.getAnzahl();
			fernkampfwaffen = 2 - substractor - o3.getAnzahl() - o1.getAnzahl();
			artefakte = 2 - substractor - o2.getAnzahl() - o3.getAnzahl();
			
			if(nahkampfwaffen < 0) nahkampfwaffen = 0;
			if(fernkampfwaffen < 0) fernkampfwaffen = 0;
			if(artefakte < 0) artefakte = 0;
			
			if(nahkampfwaffen > 1) nahkampfwaffen = 1;
			if(fernkampfwaffen > 1) fernkampfwaffen = 1;
			if(artefakte > 1) artefakte = 1;
			
			if(!boltpistole.isSelected()) { 
				o3.setMaxAnzahl(nahkampfwaffen); 
			} else {
				o3.setMaxAnzahl(0);
			}
			o2.setMaxAnzahl(fernkampfwaffen);
			o1.setMaxAnzahl(artefakte);
			o1.setAktiv(BuildaHQ.translate("Axt der blinden Wut"), false);
			
			boolean legal = ((boltpistole.isSelected()?1:0) + (psiWaffe.isSelected()?1:0) + o1.getAnzahl() + o2.getAnzahl() + o3.getAnzahl())==2;
			boltpistole.setLegal(legal);
			psiWaffe.setLegal(legal);
			o1.setLegal(legal);
			o2.setLegal(legal);
			o3.setLegal(legal);
		}
		
		if(isWarpschmied || isApostel) {

			o3.setAktiv(false);
			
			if(spezialWaffe.isSelected() && boltpistole.isSelected()) { substractor = 2; }
			else if(spezialWaffe.isSelected() || boltpistole.isSelected()) { substractor = 1; }
			else if(!spezialWaffe.isSelected() && !boltpistole.isSelected()) { substractor = 0; }
			
			fernkampfwaffen = 2 - substractor - o1.getAnzahl();
			artefakte = 2 - substractor - o2.getAnzahl();
			
			if(fernkampfwaffen < 0) fernkampfwaffen = 0;
			if(artefakte < 0) artefakte = 0;
			
			if(fernkampfwaffen > 1) fernkampfwaffen = 1;
			if(artefakte > 1) artefakte = 1;
			
			o2.setMaxAnzahl(fernkampfwaffen);
			
			o1.setAktiv(artefakte>0);
			o1.setAktiv(BuildaHQ.translate("Axt der blinden Wut"), malDesKhorne && artefakte>0);
			o1.setMaxAnzahl(artefakte);
			
			boolean legal = ((boltpistole.isSelected()?1:0) + (spezialWaffe.isSelected()?1:0) + o1.getAnzahl() + o2.getAnzahl())==2;
			boltpistole.setLegal(legal);
			spezialWaffe.setLegal(legal);
			o1.setLegal(legal);
			o2.setLegal(legal);
		}
		
		if(isDaemon){
			o3.setAktiv(false);
			o2.setAktiv(false);
			
			if(!handwaffe.isSelected()){
				artefakte = 1;
			} else {
				artefakte = 0;
				if(o1.isSelected()){
					int index = o1.getSelectedIndex();
					o1.setSelected(index, false);
				}
			}
			
			o1.setAktiv(artefakte>0);
			o1.setAktiv(BuildaHQ.translate("Axt der blinden Wut"), malDesKhorne && artefakte>0);
			o1.setMaxAnzahl(artefakte);
			
			boolean legal = ((handwaffe.isSelected()?1:0) + o1.getAnzahl())==1;
			handwaffe.setLegal(legal);
			o1.setLegal(legal);
		}
		
	    //Einzigartige Gegenstände
		if(o1.isSelected("Brandfackel von Skalathrax")){
			if(fackelBool==false){
				fackelBool=true;
				BuildaHQ.addToInformationVector("CMFackel", 1);
			}
		} else if(!o1.isSelected("Brandfackel von Skalathrax")) {
			if(fackelBool==true){
				fackelBool=false;
				BuildaHQ.addToInformationVector("CMFackel", -1);
			}
		}
		
		if(o1.isSelected("Axt der blinden Wut")){
			if(axtBool==false){
				axtBool=true;
				BuildaHQ.addToInformationVector("CMAxt", 1);
			}
		} else if(!o1.isSelected("Axt der blinden Wut")) {
			if(axtBool==true){
				axtBool=false;
				BuildaHQ.addToInformationVector("CMAxt", -1);
			}
		}
		
		if(o1.isSelected("Das Mordschwert")){
			if(schwertBool==false){
				schwertBool=true;
				BuildaHQ.addToInformationVector("CMSchwert", 1);
			}
		} else if(!o1.isSelected("Das Mordschwert")) {
			if(schwertBool==true){
				schwertBool=false;
				BuildaHQ.addToInformationVector("CMSchwert", -1);
			}
		}
		
		if(o1.isSelected("Der schwarze Streikolben")){
			if(kolbenBool==false){
				kolbenBool=true;
				BuildaHQ.addToInformationVector("CMKolben", 1);
			}
		} else if(!o1.isSelected("Der schwarze Streikolben")) {
			if(kolbenBool==true){
				kolbenBool=false;
				BuildaHQ.addToInformationVector("CMKolben", -1);
			}
		}
		
		if(dimensionsschlüssel.isSelected()){
			if(schluesselBool==false){
				schluesselBool=true;
				BuildaHQ.addToInformationVector("CMSchluessel", 1);
			}
		} else if(!dimensionsschlüssel.isSelected()) {
			if(schluesselBool==true){
				schluesselBool=false;
				BuildaHQ.addToInformationVector("CMSchluessel", -1);
			}
		}
		
		if(schriftrollen.isSelected()){
			if(rolleBool==false){
				rolleBool=true;
				BuildaHQ.addToInformationVector("CMRolle", 1);
			}
		} else if(!schriftrollen.isSelected()) {
			if(rolleBool==true){
				rolleBool=false;
				BuildaHQ.addToInformationVector("CMRolle", -1);
			}
		}
		
		if(BuildaHQ.getCountFromInformationVector("CMFackel")>1 ||
				BuildaHQ.getCountFromInformationVector("CMAxt")>1 ||
				BuildaHQ.getCountFromInformationVector("CMSchwert")>1 ||
				BuildaHQ.getCountFromInformationVector("CMKolben")>1 ||
				BuildaHQ.getCountFromInformationVector("CMSchluessel")>1 ||
				BuildaHQ.getCountFromInformationVector("CMRolle")>1){
				uniqueError=true;
		}else{
			uniqueError=false;
		}
		
	}

	@Override
	public Object getSpecialValue() {
		return 0;
	}
	
	@Override
	public void switchEntry(String name, boolean aktiv) {
	    boolean entrySwitched=false;
	    
		if(name.equals( BuildaHQ.translate("Axt der blinden Wut"))){ 
			if(malDesKhorne!=aktiv){
				this.malDesKhorne = aktiv;
				entrySwitched=true;
			}
		}
		
		if(name.equals( BuildaHQ.translate("Schriftrollen des Magnus"))){ 
				if(malDesTzeentch!=aktiv){
					this.malDesTzeentch = aktiv;
					entrySwitched=true;
				}
			}
		
		if(entrySwitched){
			//Aktualisisert alle Einträge, auch die, welche diese Rüstkammer enthält.
			//Sonst werden dort zwar beim abwählen von Malen die Punkte korrekt berechnet, 
			//der Text aber nicht aktualisiert.
			RefreshListener.fireRefresh();
		}
	}
	
	@Override
	public void deleteYourself() {
		
		if(fackelBool==true){
			fackelBool=false;
			BuildaHQ.addToInformationVector("CMFackel", -1);
		}
					
		if(axtBool==true){
			axtBool=false;
			BuildaHQ.addToInformationVector("CMAxt", -1);
		}
					
		if(schwertBool==true){
			schwertBool=false;
			BuildaHQ.addToInformationVector("CMSchwert", -1);
		}
					
		if(kolbenBool==true){
			kolbenBool=false;
			BuildaHQ.addToInformationVector("CMKolben", -1);
		}
						
		if(schluesselBool==true){
			schluesselBool=false;
			BuildaHQ.addToInformationVector("CMSchluessel", -1);
		}
				
		if(rolleBool==true){
			rolleBool=false;
			BuildaHQ.addToInformationVector("CMRolle", -1);
		}
				
		super.deleteYourself();
	}
	
}
