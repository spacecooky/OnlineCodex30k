package oc.whfb.units.vf;

import oc.BuildaHQ;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerVater;

public class VFEquipment extends RuestkammerVater {

	OptionsUpgradeGruppe o1;
	
	public VFEquipment() {
		grundkosten = 0;
	}

	@Override
	public void initButtons(boolean... defaults) {
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Handwaffe") + " & " + BuildaHQ.translate("Schild") , 0));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Zusätzliche Handwaffe"), 0));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Zweihandwaffe"), 0));
		
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		
		setHeadline(o1, BuildaHQ.translate("Ausrüstung"));
		setUeberschrift(BuildaHQ.translate("Ausrüstung"));
		sizeSetzen(100, 100, 285, KAMMER_HOEHE + cnt + 10);
	}

	@Override
	public void refreshen() {
		o1.alwaysSelected();
	}
	
	public void setZweihaender(boolean gw){
		o1.setAktiv(BuildaHQ.translate("Zweihandwaffe"), gw);
	}
	
	public boolean getZweihaender() {
        return o1.isSelected(BuildaHQ.translate("Zweihandwaffe"));
    }

}
