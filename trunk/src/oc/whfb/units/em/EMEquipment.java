package oc.whfb.units.em;

import oc.BuildaHQ;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerVater;

public class EMEquipment extends RuestkammerVater {

	OptionsUpgradeGruppe o1;
	OptionsUpgradeGruppe o2;
	OptionsUpgradeGruppe o3;

	boolean commander = false;
	
	public EMEquipment() {
		grundkosten = 0;
	}

	@Override
	public void initButtons(boolean... defaults) {
		// defaults[0] = Saurus Hornnacken Veteran
		// defaults[1] = Saurus Hornnacken
		// defaults[2] = Skink H�uptling
		
		this.commander = defaults[0];
		
		if(this.commander || defaults[1]){
		
			ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Speer"), this.commander ? 8 : 4));
			ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Zweihandwaffe"), this.commander ? 12 : 6));
			ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Hellebarde"), this.commander ? 8 : 4));
			ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Zus�tzliche Handwaffe"), this.commander ? 8 : 4));
			add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
			setHeadline(o1, BuildaHQ.translate("Ausr�stung"));
				
			seperator();

			add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Schild"), this.commander ? 6 : 3));
			add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Leichte R�stung"), this.commander ? 10 : 5));
				
			seperator();
		}
		else{
			ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Speer"), 4));
			ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Blasrohr"), 8));
			ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Wurfspeer"), 8));
			ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Zus�tzliche Handwaffe"), 4));
			add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
			setHeadline(o1, BuildaHQ.translate("Ausr�stung"));
				
			seperator();
	
			add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Schild"), 2));
			add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Leichte R�stung"), 2));
	
			seperator();			
		}
		setUeberschrift(BuildaHQ.translate("Ausr�stung"));
		sizeSetzen();
	}

	@Override
	public void refreshen() {
	}

}
