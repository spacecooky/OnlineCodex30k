package oc.wh30k.units.ec;

import oc.BuildaHQ;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerVater;

public class ECConsulTermiKammer extends RuestkammerVater {

	OptionsUpgradeGruppe o7, o8;
	OptionsUpgradeGruppe termiFK, termiNK;
	boolean isConsul = false;
	boolean isLibrarian = false;
	
	
	public ECConsulTermiKammer() {
		grundkosten = 0;
	}

	@Override
	public void initButtons(boolean... defaults) {
		
		if(defaults[0]) isConsul = true;
		if(defaults[1]) isLibrarian = true;
		
		seperator();

		if (isConsul) {
			ogE.addElement(new OptionsGruppeEintrag("Combi-bolter", 0));
			ogE.addElement(new OptionsGruppeEintrag("Combi-flamer", 7));
			ogE.addElement(new OptionsGruppeEintrag("Combi-melta", 7));
			ogE.addElement(new OptionsGruppeEintrag("Combi-plasma", 7));
			ogE.addElement(new OptionsGruppeEintrag("Volkite charger", 7));
			add(termiFK = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "option", ogE));

			seperator();

			ogE.addElement(new OptionsGruppeEintrag("Power weapon", 0));
			ogE.addElement(new OptionsGruppeEintrag("Power fist", 5));
			ogE.addElement(new OptionsGruppeEintrag("Lightning claw", 5));
			ogE.addElement(new OptionsGruppeEintrag("Chain fist", 10));
			ogE.addElement(new OptionsGruppeEintrag("Thunder hammer", 10));
			add(termiNK = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "option", ogE));
		
			ogE.addElement(new OptionsGruppeEintrag("Pair of lightning claws", 15));
			add(o7 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "option", ogE));
					
			seperator();

			ogE.addElement(new OptionsGruppeEintrag("Sonic Shrieker", 5));
			add(o8 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "option", ogE));
			}

		else if (isLibrarian) {
			ogE.addElement(new OptionsGruppeEintrag("Combi-bolter", 0));
			ogE.addElement(new OptionsGruppeEintrag("Combi-flamer", 7));
			ogE.addElement(new OptionsGruppeEintrag("Combi-melta", 7));
			ogE.addElement(new OptionsGruppeEintrag("Combi-plasma", 7));
			ogE.addElement(new OptionsGruppeEintrag("Volkite charger", 7));
			add(termiFK = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "option", ogE));

			seperator();

			ogE.addElement(new OptionsGruppeEintrag("Force axe", 0));
			ogE.addElement(new OptionsGruppeEintrag("Force stave", 0));
			ogE.addElement(new OptionsGruppeEintrag("Force sword", 0));
			add(termiNK = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "option", ogE));
			}
		
			seperator();

			ogE.addElement(new OptionsGruppeEintrag("Sonic Shrieker", 5));
			add(o8 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "option", ogE));
		
		sizeSetzen();
	}

	@Override
	public void refreshen() {
		
		if (isConsul) {
		termiNK.setAktiv(!o7.isSelected());
		termiFK.setAktiv(!o7.isSelected());
		
		if (!termiFK.isSelected()) {
			termiFK.setSelected(0, true);
			}
		if (!termiNK.isSelected()) {
			termiNK.setSelected(0, true);
			}
		}
		
		if (isLibrarian) {
						
			if (!termiFK.isSelected()) {
				termiFK.setSelected(0, true);
				}
			if (!termiNK.isSelected()) {
				termiNK.setSelected(0, true);
				}
			}
	}



}