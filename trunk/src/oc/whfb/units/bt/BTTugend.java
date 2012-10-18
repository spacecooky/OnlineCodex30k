package oc.whfb.units.bt;

import oc.BuildaHQ;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppeVows;
import oc.RuestkammerVater;
import oc.whfb.armies.VOLKBretonia;

public class BTTugend extends RuestkammerVater {

	OptionsUpgradeGruppeVows oTugend;

	private int maxCosts = 25;
	
	public BTTugend() {
		grundkosten = 0;
	}

	@Override
	public void initButtons(boolean... defaults) {
		if(defaults[0]) maxCosts = 50;
		
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Tugend des ritterlichen Zorns"), 40));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Tugend der Tapferkeit"), 40));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Tugend der Entsagung"), 40));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Tugend d. ungest. Ritters"), BuildaHQ.translate("Tugend des ungestümen Ritters"), 35));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Tugend des ritterlichen Ideals"), 35));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Tugend der Sturheit"), 35));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Tugend des Heldenmuts"), 30));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Tugend der Pflicht"), 30));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Tugend des Selbstvertrauens"), 25));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Tugend der Tjoste"), 25));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Tugend d. ritterl. Verachtung"), BuildaHQ.translate("Tugend der ritterlichen Verachtung"), 20));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Tugend der Reinheit"), 20));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Tugend der Barmherzigkeit"), 10));	
		
		add(oTugend = new OptionsUpgradeGruppeVows(ID, randAbstand + 10, cnt, "", ogE));
		setHeadline(oTugend, BuildaHQ.translate("Tugenden"));
		setUeberschrift(BuildaHQ.translate("Tugenden"));
		sizeSetzen();
	}

	@Override
	public void refreshen() {
		refreshVows();
		
		double totalCosts = oTugend.getKosten();
		if(totalCosts > this.maxCosts) {
			setButtonState(false);
			showErrorMessage("Max. " + this.maxCosts + " " + BuildaHQ.translate("Punkte"));
		} else {
			setButtonState(true);
			hideErrorMessage();
			showErrorMessage( entferneNullNachkomma(totalCosts) + " / " + maxCosts + " " + BuildaHQ.translate("Punkte"));
		}
	}
	
	public int getKost(String txt, int kost){
		if(!VOLKBretonia.Vows.containsKey(txt))return kost;
		int i = VOLKBretonia.Vows.get(txt);		
		return i * kost;
	}
	
	public void refreshVows(){
		String txt = BuildaHQ.translate("Tugend des ritterlichen Zorns");
		int cost = 40;
		if(!oTugend.isSelected(txt))oTugend.setPreis(txt,  getKost(txt, cost));

		txt = BuildaHQ.translate("Tugend der Tapferkeit");
		cost = 40;
		if(!oTugend.isSelected(txt))oTugend.setPreis(txt,  getKost(txt, cost));
		
		txt = BuildaHQ.translate("Tugend der Entsagung");
		cost = 40;
		if(!oTugend.isSelected(txt))oTugend.setPreis(txt,  getKost(txt, cost));
		
		txt = BuildaHQ.translate("Tugend d. ungest. Ritters");
		cost = 35;
		if(!oTugend.isSelected(txt))oTugend.setPreis(txt,  getKost(txt, cost));
		
		txt = BuildaHQ.translate("Tugend des ritterlichen Ideals");
		cost = 35;
		if(!oTugend.isSelected(txt))oTugend.setPreis(txt,  getKost(txt, cost));
		
		txt = BuildaHQ.translate("Tugend der Sturheit");
		cost = 35;
		if(!oTugend.isSelected(txt))oTugend.setPreis(txt,  getKost(txt, cost));
		
		txt = BuildaHQ.translate("Tugend des Heldenmuts");
		cost = 30;
		if(!oTugend.isSelected(txt))oTugend.setPreis(txt,  getKost(txt, cost));
		
		txt = BuildaHQ.translate("Tugend der Pflicht");
		cost = 30;
		if(!oTugend.isSelected(txt))oTugend.setPreis(txt,  getKost(txt, cost));
		
		txt = BuildaHQ.translate("Tugend des Selbstvertrauens");
		cost = 25;
		if(!oTugend.isSelected(txt))oTugend.setPreis(txt,  getKost(txt, cost));
		
		txt = BuildaHQ.translate("Tugend der Tjoste");
		cost = 25;
		if(!oTugend.isSelected(txt))oTugend.setPreis(txt,  getKost(txt, cost));
		
		txt = BuildaHQ.translate("Tugend d. ritterl. Verachtung");
		cost = 20;
		if(!oTugend.isSelected(txt))oTugend.setPreis(txt,  getKost(txt, cost));
		
		txt = BuildaHQ.translate("Tugend der Reinheit");
		cost = 20;
		if(!oTugend.isSelected(txt))oTugend.setPreis(txt,  getKost(txt, cost));
		
		txt = BuildaHQ.translate("Tugend der Barmherzigkeit");
		cost = 10;
		if(!oTugend.isSelected(txt))oTugend.setPreis(txt,  getKost(txt, cost));
	}

}
