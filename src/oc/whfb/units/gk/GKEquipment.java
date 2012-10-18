package oc.whfb.units.gk;

import oc.BuildaHQ;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerVater;

public class GKEquipment extends RuestkammerVater {

	OptionsUpgradeGruppe o1;
	OptionsUpgradeGruppe o2;
	OptionsUpgradeGruppe o3;
	boolean commander = false;
	
	public GKEquipment() {
		grundkosten = 0;
	}

	public void initButtons(boolean... defaults) {
		// defaults[0] = Gruftprinz
		// defaults[1] = Gruftkönig
		// defaults[2] = Gruftherold
				
		this.commander = defaults[1];
						
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Flegel"), this.commander ? 6 : 4));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Zweihandwaffe"), this.commander ? 6 : 4));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Speer"), this.commander ? 3 : 2));
		if (defaults[2]){
			ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Hellebarde"), 2));
		}
		
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		setHeadline(o1, BuildaHQ.translate("Ausrüstung"));
			
		seperator();

		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Schild"), this.commander ? 3 : 2));	
		
		seperator();
				
		setUeberschrift(BuildaHQ.translate("Ausrüstung"));
		sizeSetzen(100, 100, 285, KAMMER_HOEHE + cnt + 10);
	}
	
	public void refreshen() {
		
	}

}
