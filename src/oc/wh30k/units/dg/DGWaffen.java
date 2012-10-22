package oc.wh30k.units.dg;

import oc.BuildaHQ;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.OptionsZaehlerGruppe;
import oc.RefreshListener;
import oc.RuestkammerVater;

public class DGWaffen extends RuestkammerVater {

	OptionsUpgradeGruppe o1, o4, o4b, o5, o5b;
	OptionsZaehlerGruppe o2, o3;
    OptionsEinzelUpgrade boltpistole = null;
    OptionsEinzelUpgrade spezialWaffe = null;
    OptionsUpgradeGruppe psiWaffe = null;
    OptionsUpgradeGruppe chainsword = null;
    OptionsUpgradeGruppe boltpistols = null;
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
    
    boolean isChaplain = false;
    boolean isForgelord = false;
    boolean isLegionCenturion = false;
    boolean isLegionChampion = false;
    boolean isLegionPraetor = false;
    boolean isLibrarian = false;
    boolean isMasterofsignal = false;
    boolean isMoritat = false;
    boolean isPrimusmedicae = false;
    boolean isSiegebreaker = false;
    boolean isVigilator = false;
	
	public DGWaffen() {
		grundkosten = 0;
	}

	@Override
	public void initButtons(boolean... defaults) {
		try {
			isChaplain = defaults[0]; 
			isForgelord = defaults[1];       
			isLegionCenturion = defaults[2]; 
			isLegionChampion = defaults[3];      
			isLegionPraetor = defaults[4];    
			isLibrarian = defaults[5]; 
			isMasterofsignal = defaults[6];        
			isMoritat = defaults[7];  
			isPrimusmedicae = defaults[8];      
			isSiegebreaker = defaults[9];  
			isVigilator = defaults[10]; 
			
		} catch(Exception e) {}
		
	    if(!isLibrarian && !isChaplain) {
	    	ogE.addElement(new OptionsGruppeEintrag("Chainsword", 0));
			ogE.addElement(new OptionsGruppeEintrag("Combat blade", 0));
			add(chainsword = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
			chainsword.setSelected(0, true);
	    } else if(isLibrarian) {
			ogE.addElement(new OptionsGruppeEintrag("Force weapon", 0));
			ogE.addElement(new OptionsGruppeEintrag("Force axe", 0));
			ogE.addElement(new OptionsGruppeEintrag("Force sword", 0));
			ogE.addElement(new OptionsGruppeEintrag("Force stave", 0));
			add(psiWaffe = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
			psiWaffe.setSelected(0, true);
	    } else if(isChaplain) {
	    	add(spezialWaffe = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Crozius Arcanum", 0));
	    	spezialWaffe.setSelected(true);
	    	ogE.addElement(new OptionsGruppeEintrag("Chainsword", 0));
			ogE.addElement(new OptionsGruppeEintrag("Combat blade", 0));
			add(chainsword = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
			chainsword.setSelected(0, true);
	    }
	    
	    if(!isMoritat){
		    add(boltpistole = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Bolt pistol", 0));
		    boltpistole.setSelected(true);
	    } else if(isMoritat) {
	    	ogE.addElement(new OptionsGruppeEintrag("Bolt pistol", 0));
			ogE.addElement(new OptionsGruppeEintrag("2 bolt pistols", 0));
			add(boltpistols= new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
			boltpistols.setSelected(0, true);
	    } 
	    
	    seperator();
	   
	    if (!isMasterofsignal && !isMoritat && !isVigilator && !isLegionPraetor){
	    	ogE.addElement(new OptionsGruppeEintrag("Volkite Serpenta", 5));
	    	ogE.addElement(new OptionsGruppeEintrag("Plasma pistol", 15));
	    	ogE.addElement(new OptionsGruppeEintrag("Archaeotech pistol", 20));
	    	ogE.addElement(new OptionsGruppeEintrag("Heavy chainsword", 10));
	    	ogE.addElement(new OptionsGruppeEintrag("Charnabal sabre", 10));
	    	ogE.addElement(new OptionsGruppeEintrag("Power weapon", 15));
	    	ogE.addElement(new OptionsGruppeEintrag("Power fist", 20));
	    	ogE.addElement(new OptionsGruppeEintrag("Single lightning claw", 20));
	    	ogE.addElement(new OptionsGruppeEintrag("Thunder hammer", 25));
	    	ogE.addElement(new OptionsGruppeEintrag("Paragon blade", 25));
	    	add(o4 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 0));
		
	    	ogE.addElement(new OptionsGruppeEintrag("Pair of lightning claws", 25));
	    	add(o4b = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 0));
	    }
	    else if (isLegionPraetor){
	    	ogE.addElement(new OptionsGruppeEintrag("Volkite Serpenta", 5));
	    	ogE.addElement(new OptionsGruppeEintrag("Plasma pistol", 15));
	    	ogE.addElement(new OptionsGruppeEintrag("Archaeotech pistol", 20));
	    	ogE.addElement(new OptionsGruppeEintrag("Heavy chainsword", 10));
	    	ogE.addElement(new OptionsGruppeEintrag("Charnabal sabre", 10));
	    	ogE.addElement(new OptionsGruppeEintrag("Power weapon", 15));
	    	ogE.addElement(new OptionsGruppeEintrag("Power fist", 20));
	    	ogE.addElement(new OptionsGruppeEintrag("Single lightning claw", 20));
	    	ogE.addElement(new OptionsGruppeEintrag("Thunder hammer", 25));
	    	ogE.addElement(new OptionsGruppeEintrag("Paragon blade", 25));
	    	add(o4 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 0));
		
	    	ogE.addElement(new OptionsGruppeEintrag("Pair of lightning claws", 25));
	    	add(o4b = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 0));
	    }
	    else if (isMasterofsignal || isMoritat || isVigilator){
		    ogE.addElement(new OptionsGruppeEintrag("Volkite Serpenta", 5));
			ogE.addElement(new OptionsGruppeEintrag("Plasma pistol", 15));
			ogE.addElement(new OptionsGruppeEintrag("Archaeotech pistol", 20));
			ogE.addElement(new OptionsGruppeEintrag("Heavy chainsword", 10));
			ogE.addElement(new OptionsGruppeEintrag("Charnabal sabre", 10));
			ogE.addElement(new OptionsGruppeEintrag("Power weapon", 15));
			add(o4 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 0));
		 }
		
		seperator();
		
		if(!isMasterofsignal && !isVigilator && !isMoritat) {
			ogE.addElement(new OptionsGruppeEintrag("Bolter", 2));
			ogE.addElement(new OptionsGruppeEintrag("Combi-weapon", 10));
			ogE.addElement(new OptionsGruppeEintrag("Volkite charger", 10));
			add(o5 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		} 
		else if(isMasterofsignal || isMoritat) {
			ogE.addElement(new OptionsGruppeEintrag("Volkite charger", 10));
			add(o5 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		} 
		else if(isVigilator) {
			ogE.addElement(new OptionsGruppeEintrag("Bolter", 0));
			add(o5b = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
			o5b.setSelected(0, true);
			ogE.addElement(new OptionsGruppeEintrag("Combi-weapon", 10));
			ogE.addElement(new OptionsGruppeEintrag("Volkite charger", 10));
			add(o5 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		} 
		
		setUeberschrift("Weapons");
		sizeSetzen();
	}

	@Override
	public void refreshen() {
				
		
		int waffenoptionen = 0;
		int substractor = 0;
		
		if(!isLibrarian && !isMoritat) {
			if(chainsword.isSelected() && boltpistole.isSelected()) { substractor = 2; }
			else if(chainsword.isSelected() || boltpistole.isSelected()) { substractor = 1; }
			
			waffenoptionen = 2 - substractor - o4.getAnzahl();
			
			if(waffenoptionen < 0) waffenoptionen = 0;
			
			if(waffenoptionen > 1) waffenoptionen = 1;
			
			o4.setMaxAnzahl(waffenoptionen);
			
			if (o4b.isSelected()) {
				chainsword.setAktiv(false);
				boltpistole.setAktiv(false);
				o4.setAktiv(false);
			}
			
				
			/*boolean legal = ((boltpistole.isSelected()?1:0) + (handwaffe.isSelected()?1:0) + o1.getAnzahl() + o2.getAnzahl() + o3.getAnzahl())==2;
			boltpistole.setLegal(legal);
			handwaffe.setLegal(legal);
			o1.setLegal(legal);
			o2.setLegal(legal);
			o3.setLegal(legal);*/
		}
		
		if(isLibrarian) {
			if(boltpistole.isSelected()) { substractor = 2; }
			else if(!boltpistole.isSelected()) { substractor = 1; }
			
			waffenoptionen = 2 - substractor - o4.getAnzahl();
			
			if(waffenoptionen < 0) waffenoptionen = 0;
			
			if(waffenoptionen > 1) waffenoptionen = 1;
			
			o4.setMaxAnzahl(waffenoptionen);
			
			o4b.setAktiv(false);
			
			/*boolean legal = ((boltpistole.isSelected()?1:0) + (psiWaffe.isSelected()?1:0) + o1.getAnzahl() + o2.getAnzahl() + o3.getAnzahl())==2;
			boltpistole.setLegal(legal);
			psiWaffe.setLegal(legal);
			o1.setLegal(legal);
			o2.setLegal(legal);
			o3.setLegal(legal);*/
		}
		
		if(isMoritat) {
			if(chainsword.isSelected() && boltpistols.isSelected(1)) { substractor = 2; }
			else if(chainsword.isSelected() || boltpistols.isSelected(0)) { substractor = 1; }
			
			waffenoptionen = 2 - substractor - o4.getAnzahl();
			
			if(waffenoptionen < 0) waffenoptionen = 0;
			
			if(waffenoptionen > 1) waffenoptionen = 1;
			
			o4.setMaxAnzahl(waffenoptionen);
			
			if (o4b.isSelected()) {
				chainsword.setAktiv(false);
				boltpistols.isSelected(0);
				o4.setAktiv(false);
			}
			
				
			/*boolean legal = ((boltpistole.isSelected()?1:0) + (handwaffe.isSelected()?1:0) + o1.getAnzahl() + o2.getAnzahl() + o3.getAnzahl())==2;
			boltpistole.setLegal(legal);
			handwaffe.setLegal(legal);
			o1.setLegal(legal);
			o2.setLegal(legal);
			o3.setLegal(legal);*/
		}
		
		/*if(isWarpschmied || isApostel) {

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
		}*/
		
	}

	@Override
	public Object getSpecialValue() {
		return 0;
	}
	
	@Override
	public void switchEntry(String name, boolean aktiv) {
	    boolean entrySwitched=false;
	    
		/*if(name.equals( BuildaHQ.translate("Axt der blinden Wut"))){ 
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
			}*/
		
		if(entrySwitched){
			//Aktualisisert alle Einträge, auch die, welche diese Rüstkammer enthält.
			//Sonst werden dort zwar beim abwählen von Malen die Punkte korrekt berechnet, 
			//der Text aber nicht aktualisiert.
			RefreshListener.fireRefresh();
		}
	}
	
	@Override
	public void deleteYourself() {
		
		/*if(fackelBool==true){
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
				
		super.deleteYourself();*/
	}
	
}
