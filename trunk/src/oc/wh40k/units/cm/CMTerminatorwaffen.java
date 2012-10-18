package oc.wh40k.units.cm;

import oc.BuildaHQ;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.OptionsZaehlerGruppe;
import oc.RefreshListener;
import oc.RuestkammerVater;

public class CMTerminatorwaffen extends RuestkammerVater {

	OptionsZaehlerGruppe o1;
	OptionsZaehlerGruppe o2;
	OptionsUpgradeGruppe o3;
    OptionsEinzelUpgrade schriftrollen, handwaffe, kombibolter;
    
	boolean malDesKhorne = false;
	boolean malDesTzeentch = false;
	
	boolean isChaosgeneral = false; //Handwaffe, Kombibolter 
	boolean isHexer = false;        //Psiwaffe, Kombibolter

	public CMTerminatorwaffen() {
		grundkosten = 0;
	}

	@Override
	public void initButtons(boolean... defaults) {
		try {
			isChaosgeneral = defaults[1]; 
			isHexer = defaults[2];            
		} catch(Exception e) {}
		
		if(defaults[0]){
			//Termichamp
			add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Geschenk der Mutation", 10));
		}
		
		seperator();
		
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Kombibolter"), 0));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Kombi-Flammenwerfer"), 7));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Kombi-Melter"), 7));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Kombi-Plasmawerfer"), 7));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Energiewaffe"), 12));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Energieschwert"), 12));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Energieaxt"), 12));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Energielanze"), 12));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Energiestreitkolben"), 12));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Energieklaue"), 17));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Energiefaust"), 22));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Kettenfaust"), 27));
		add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));
		o1.setAnzahl(0, 1);
		
		seperator();
		
		if(isHexer) {
			ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Psiwaffe"), 0));
			ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Psischwert"), 0));
			ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Psiaxt"), 0));
			ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Psistab"), 0));
		} else{
			ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Energiewaffe"), 0));
			ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Energieschwert"), 0));
			ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Energieaxt"), 0));
			ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Energielanze"), 0));
			ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Energiestreitkolben"), 0));
		}
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Energieklaue"), 5));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Energiefaust"), 10));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Kettenfaust"), 15));
		add(o2 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));
		o2.setAnzahl(0, 1);
		sizeSetzen();
		
		seperator();
		
		if(isChaosgeneral || isHexer){
			ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Brandfackel von Skalathrax"), 30));
			ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Axt der blinden Wut"), 35));
			ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Das Mordschwert"), 35));
			ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Der schwarze Streikolben"), 45));
			add(o3 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));
			
			seperator();
			
			add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Dimensionsschlüssel"), 25));
			add(schriftrollen = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Schriftrollen des Magnus"), 45));
		}
		setUeberschrift("Termiwaffen und Artefakte");
		sizeSetzen();
	}

	@Override
	public void refreshen() {		
		if(isChaosgeneral || isHexer) {
			if(!o1.isSelected() || !o2.isSelected()){
				o3.setAktiv(true);
				schriftrollen.setAktiv(malDesTzeentch);
				o3.setAktiv(BuildaHQ.translate("Axt der blinden Wut"), malDesKhorne);
			} else {
				o3.setAktiv(false);
			}
		}
		int auswahlen=o1.getAnzahl()+o2.getAnzahl();
		if(o3!=null){
			auswahlen+=o3.getAnzahl();
			o3.setLegal(auswahlen>=2);
		}
		o1.setLegal(auswahlen>=2);
		o2.setLegal(auswahlen>=2);
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
	
	

}
