package oc.wh40k.units.cm;

import oc.BuildaHQ;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RefreshListener;
import oc.RuestkammerVater;

public class CMChaosbelohnungen extends RuestkammerVater {

	OptionsUpgradeGruppe o1;
	OptionsUpgradeGruppe o2;

	boolean malDesKhorne = false;
	boolean malDesTzeentch = false;
	boolean malDesNurgle = false;
	boolean malDesSlaanesh = false;
	boolean isTermi = false;
	boolean isDemon = false;
	boolean bikeGesetzt = false;

	public CMChaosbelohnungen() {
		grundkosten = 0;
	}

	@Override
	public void initButtons(boolean... defaults) {
		malDesKhorne = defaults[0];
		malDesTzeentch = defaults[1];
		malDesNurgle = defaults[2];
		malDesSlaanesh = defaults[3];
		isTermi = defaults[4];
		isDemon = defaults[5];

		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Warpblut"), 5));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Geschenk der Mutation"), 10));
		if(!isDemon){ //D�monen m�ssen sich keinen 5+ Retter kaufen
			ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Aura dunkler Pracht"), 15));
		}
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Kampf-Homunkulus"), 15));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Zauber-Homunkulus"), 15));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE ,1));
		o1.setMaxAnzahl(o1.getNumberOfOptions());
		setUeberschrift("Gaben des Chaos");
		sizeSetzen();
		
		seperator();
		
		if(!isTermi)
		{
			ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Moloch des Khorne"), 35));
			ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Flugd�mon des Tzeentch"), 30));
			ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("S�nfte des Nurgle"), 40));
			ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Slaaneshpferd"), 20));
			add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));
			//setUeberschrift("Reittiere");
			sizeSetzen();
		}
		
	}

	@Override
	public void refreshen() {
		o2.setAktiv(BuildaHQ.translate("Moloch des Khorne"), malDesKhorne && !bikeGesetzt);
		o2.setAktiv(BuildaHQ.translate("Flugd�mon des Tzeentch"), malDesTzeentch && !bikeGesetzt);
		o2.setAktiv(BuildaHQ.translate("S�nfte des Nurgle"), malDesNurgle && !bikeGesetzt);
		o2.setAktiv(BuildaHQ.translate("Slaaneshpferd"), malDesSlaanesh && !bikeGesetzt);
		
		if(!malDesKhorne){
			o2.setSelected("Moloch des Khorne", false);
		}
		
		if(!malDesTzeentch){
			o2.setSelected("Flugd�mon des Tzeentch", false);
		}
		
		if(!malDesNurgle){
			o2.setSelected("S�nfte des Nurgle", false);
		}
		
		if(!malDesSlaanesh){
			o2.setSelected("Slaaneshpferd", false);
		}
	}

	@Override
	public Object getSpecialValue() {
		return (o1.getCurrentName());
	}
	
	@Override
	public void switchEntry(String name, boolean aktiv) {
		boolean entrySwitched=false;
		
		if(name.equals( BuildaHQ.translate("Moloch des Khorne"))){ 
			if(malDesKhorne!=aktiv){
				this.malDesKhorne = aktiv;
				entrySwitched=true;
			}
		} 
		
		if(name.equals( BuildaHQ.translate("Flugd�mon des Tzeentch"))){ 
			if(malDesTzeentch!=aktiv){
				this.malDesTzeentch = aktiv;
				entrySwitched=true;
			}
		}
		
		if(name.equals( BuildaHQ.translate("S�nfte des Nurgle"))){ 
			if(malDesNurgle!=aktiv){
				this.malDesNurgle = aktiv;
				entrySwitched=true;
			}
		}
		
		if(name.equals( BuildaHQ.translate("Slaaneshpferd"))){ 
			if(malDesSlaanesh!=aktiv){
				this.malDesSlaanesh = aktiv;
				entrySwitched=true;
			}
		}
		if(entrySwitched){
			//Aktualisisert alle Eintr�ge, auch die, welche diese R�stkammer enth�lt.
			//Sonst werden dort zwar beim abw�hlen von Malen die Punkte korrekt berechnet, 
			//der Text aber nicht aktualisiert.
			RefreshListener.fireRefresh();
		}
	}
}
