package oc.wh30k.units.lc;

import oc.BuildaHQ;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerVater;

public class LCMyrmidonLordKammer extends RuestkammerVater {

	OptionsZaehlerGruppe 	o1;
	OptionsUpgradeGruppe 	o2;
	
	boolean isSecutor = false;
	boolean isDestructor = false;

	public LCMyrmidonLordKammer() {
		grundkosten = 50;
	}

	@Override
	public void initButtons(boolean... defaults) {
		
		if(defaults[0]) isSecutor = true;
		if(defaults[1]) isDestructor = true;
				
		if (isSecutor) {
			
			seperator();		
			ogE.addElement(new OptionsGruppeEintrag("Maxim bolter", 10));
			ogE.addElement(new OptionsGruppeEintrag("Volkite Charger", 10));
			ogE.addElement(new OptionsGruppeEintrag("Graviton gun", 15));
			ogE.addElement(new OptionsGruppeEintrag("Irad-cleanser", 20));
			ogE.addElement(new OptionsGruppeEintrag("Phased plasma fusil", 20));
			add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 2));
			}
				
		else if (isDestructor) {
			
			seperator();		
			ogE.addElement(new OptionsGruppeEintrag("Volkite Culverin", 25));
			ogE.addElement(new OptionsGruppeEintrag("Photon thruster cannon", 35));
			ogE.addElement(new OptionsGruppeEintrag("Irradiation engine", 35));
			ogE.addElement(new OptionsGruppeEintrag("Conversion beamer", 35));
			add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
			}		
		
		
		sizeSetzen();
	}

	@Override
	public void refreshen() {
		if (isSecutor) {
			boolean legal = (o1.getAnzahl() == o1.getMaxAnzahl());
			o1.setLegal(legal);
			}	
		
		else if (isDestructor) {
			if (!o2.isSelected()) {o2.setSelected(0, true);}
			}
		
		
		
	}



}
