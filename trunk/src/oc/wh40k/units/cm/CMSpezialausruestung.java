package oc.wh40k.units.cm;

import oc.BuildaHQ;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RefreshListener;
import oc.RuestkammerVater;

public class CMSpezialausruestung extends RuestkammerVater {

	OptionsUpgradeGruppe o1;
	OptionsUpgradeGruppe o2;

	boolean isTermi = false;
	boolean malDesNurgle = false;
	boolean reittierGesetzt = false;
	boolean entrySwitched=false;

	public CMSpezialausruestung() {
		grundkosten = 0;
	}

	@Override
	public void initButtons(boolean... defaults) {
		isTermi = defaults[0];
		malDesNurgle = defaults[1];
		
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Seuchengranaten"), 5));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Melterbomben"), 5));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Siegel der Verderbnis"), 25));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));
		o1.setMaxAnzahl(o1.getNumberOfOptions());
		
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Sprungmodul"), 15));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Chaosbike"), 20));
		add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));
		setUeberschrift("Spezielle Ausr�stung");
		sizeSetzen();
	}

	@Override
	public void refreshen() {
		o1.setAktiv(BuildaHQ.translate("Seuchengranaten"), malDesNurgle);
		o2.setAktiv(BuildaHQ.translate("Sprungmodul"), isTermi && !reittierGesetzt);
		o2.setAktiv(BuildaHQ.translate("Chaosbike"), isTermi && !reittierGesetzt);
	}

	@Override
	public Object getSpecialValue() {
		return (o1.getCurrentName());
	}
	
	@Override
	public void switchEntry(String name, boolean aktiv) {
		entrySwitched=false;
		if(name.equals( BuildaHQ.translate("Sprungmodul"))){ 
			if(isTermi!=aktiv){
				this.isTermi = aktiv;
				entrySwitched=true;
			}
		}
		if(name.equals( BuildaHQ.translate("Chaosbike"))){ 
			if(isTermi!=aktiv){
				this.isTermi = aktiv;
				entrySwitched=true;
			}
		}
		if(name.equals( BuildaHQ.translate("Seuchengranaten"))){ 
			if(malDesNurgle!=aktiv){
				this.malDesNurgle = aktiv;
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
