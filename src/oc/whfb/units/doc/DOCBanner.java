package oc.whfb.units.doc;

import oc.BuildaHQ;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerVater;

public class DOCBanner extends RuestkammerVater {

	OptionsUpgradeGruppe o1;
	boolean isAST = false;
	boolean khorne = false;
	boolean tzeentch = false;
	boolean nurgle = false;
	boolean slaanesh = false;

	public DOCBanner() {
		grundkosten = 0;
	}

	@Override
	public void initButtons(boolean... defaults) {
		// defaults[0] = isAST
		// defaults[1] = Khorne
		// defaults[2] = Tzeentch
		// defaults[1] = Nurgle
		// defaults[1] = Slaanesh

		if(defaults[0]) isAST = true;
		if(defaults[1]) khorne = true;
		if(defaults[2]) tzeentch = true;
		if(defaults[3]) nurgle = true;
		if(defaults[4]) slaanesh = true;

		if(isAST){
			ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Standarte d. ruhm. Chaos"), BuildaHQ.translate("Standarte des ruhmreichen Chaos"), 125));
			ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Höllenfeuerbanner"), 100));
			ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Ikone d. Verzweiflung"), BuildaHQ.translate("Große Ikone der Verzweiflung"), 75));
			ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Standarte d. Magiever."), BuildaHQ.translate("Standarte der Magieverweigerung"), 50));
			ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Banner d. unheiligen Sieges"), BuildaHQ.translate("Banner des unheiligen Sieges"), 50));
		}
		else if(khorne){
			ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Ikone d. ewigen Krieges"), BuildaHQ.translate("Ikone des ewigen Krieges"), 25));
			ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Schädelikone"), 25));
		}
		else if(tzeentch){
			ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Banner des Wandels"), 25));
			ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Ikone der Zauberei"), 15));
		}
		else if(nurgle){
			ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Ikone d. immerw. Virulenz"), BuildaHQ.translate("Ikone der immerwährenden Virulenz"), 25));
			ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Standarte d. schl. Fäulnis"), BuildaHQ.translate("Standarte der schleichenden Fäulnis"),  25));
		}
		else if(slaanesh){
			ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Banner der Extase"), 25));
			ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Sirenenstandarte"), 25));
		}
		
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		setUeberschrift(BuildaHQ.translate("Dämonische Ikonen"));
		sizeSetzen();
	}

	@Override
	public void refreshen() {
	}

}
