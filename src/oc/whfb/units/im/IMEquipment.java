package oc.whfb.units.im;

import oc.BuildaHQ;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerVater;

public class IMEquipment extends RuestkammerVater {

	OptionsUpgradeGruppe o1;
	OptionsUpgradeGruppe o2;
	OptionsUpgradeGruppe o3;
	OptionsEinzelUpgrade oe1;
	OptionsEinzelUpgrade oe2;

	boolean commander = false;

	public IMEquipment() {
		grundkosten = 0;
	}

	@Override
	public void initButtons(boolean... defaults) {
		// defaults[0] = erzlektor
		// defaults[1] = general
		// defaults[2] = hauptmann
		// defaults[3] = Meistertechnikus
		// defaults[4] = Siegmarpriester
		
		this.commander = defaults[0] || defaults[1];
		
		if(!defaults[3]){
			if(!defaults[2])ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Zusätzliche Handwaffe"), this.commander ? 6 : 4));
			ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Zweihandwaffe"), this.commander ? 6 : 4));
			if(!defaults[3]&&!defaults[0]&&!defaults[4]){
				ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Lanze"), this.commander ? 6 : 4));
				if(!defaults[1])ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Hellebarde"), this.commander ? 6 : 4));
			}					
			add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
	
			seperator();
		}
		if(!defaults[3])add(oe1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Schild"), this.commander ? 3 : 2));
		
		if(!defaults[3]&&!defaults[0]&&!defaults[4]){
			if(defaults[2]){
				ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Langbogen"), 10));
				ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Muskete"), 10));
				add(o3 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
			}else if(defaults[1]){
				add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Langbogen"), 10));
				add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Muskete"), 10));
			}
			add(oe2 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Pistole"), this.commander ? 9 : 6));
		}
		if(defaults[3]){
			ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Bündelmuskete"), 15));
			ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Bündelpistole"), 10));
			ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Granatenbüchse"), 10));
			ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Hochland Langbüchse"), 20));
			add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
			
			seperator();
			
			if(defaults[3])add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Taubenbombe"), 25));
		}
		
		seperator();

		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Leichte Rüstung"), this.commander ? 3 : 2));
		if(!defaults[3])ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Schwere Rüstung"), this.commander ? 6 : 4));
		if(!defaults[3]&&!defaults[0]&&!defaults[4])ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Plattenrüstung"), this.commander ? 12 : 8));
		
		add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		setUeberschrift(BuildaHQ.translate("Ausrüstung"));
		sizeSetzen(100, 100, 285, KAMMER_HOEHE + cnt + 10);
	}

	@Override
	public void refreshen() {
		
	}
	
	public void specialAction(boolean... action) {
		
		try {//Waffen
			o1.setAktiv("Lanze", !action[0]);
			o1.setAktiv("Zweihandwaffe", !action[0]);
			o1.setAktiv("Hellebarde", !action[0]);
			oe1.setAktiv(!action[0]);
			o3.setAktiv("Langbogen", !action[0]);
			o3.setAktiv("Muskete", !action[0]);
			oe2.setAktiv(!action[0]);
			
		} catch(Exception ex) {
			// ignore
		}
		
		refreshen();
	}

}
