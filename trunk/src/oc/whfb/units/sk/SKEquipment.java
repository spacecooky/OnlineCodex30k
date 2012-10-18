package oc.whfb.units.sk;

import oc.BuildaHQ;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerVater;

public class SKEquipment extends RuestkammerVater {

	OptionsUpgradeGruppe o1;
	OptionsUpgradeGruppe o2;
	OptionsUpgradeGruppe o3;

	boolean commander = false;

	public SKEquipment() {
		grundkosten = 0;
	}

	@Override
	public void initButtons(boolean... defaults) {
		// defaults[0] = warlord
		// defaults[1] = chieftain
		// defaults[2] = engineer
		// defaults[3] = plague priest

		this.commander = (defaults[0]);
		
		if(defaults[0]||defaults[1]){
			
			ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Zweihandwaffe"), this.commander ? 6 : 4));
			ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Hellebarde"), this.commander ? 3 : 2));
			ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Zusätzliche Handwaffe"), this.commander ? 3 : 2));
				
			add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
			setHeadline(o1, BuildaHQ.translate("Ausrüstung"));
	
			seperator();
			
			add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Schild"), this.commander ? 3 : 2));
		}
		else if(defaults[2]){
			ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Warlockmodifizierte Waffe"), 45));
			ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Warpsteinpistole"), 8));
			ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Warpsteinmuskete"), 15));
			
			add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
			setHeadline(o1, BuildaHQ.translate("Ausrüstung"));
	
		}
		else if(defaults[3]){
			ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Seuchenschleuder"), 16));
			ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Flegel"), 4));
			ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Zusätzliche Handwaffe"), 2));
			
			add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
			setHeadline(o1, BuildaHQ.translate("Ausrüstung"));
			
		}
		setUeberschrift(BuildaHQ.translate("Ausrüstung"));
		sizeSetzen(100, 100, 285, KAMMER_HOEHE + cnt + 10);
	}

	@Override
	public void refreshen() {
	}

}
