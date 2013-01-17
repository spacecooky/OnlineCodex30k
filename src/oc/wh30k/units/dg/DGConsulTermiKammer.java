package oc.wh30k.units.dg;

import oc.BuildaHQ;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerVater;

public class DGConsulTermiKammer extends RuestkammerVater {

	OptionsUpgradeGruppe o7, o8;
	OptionsUpgradeGruppe termiFK, termiNK;
	
	public DGConsulTermiKammer() {
		grundkosten = 0;
	}

	@Override
	public void initButtons(boolean... defaults) {
		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Combi-bolter", 0));
		ogE.addElement(new OptionsGruppeEintrag("Combi-flamer", 7));
		ogE.addElement(new OptionsGruppeEintrag("Combi-melta", 7));
		ogE.addElement(new OptionsGruppeEintrag("Combi-plasma", 7));
		ogE.addElement(new OptionsGruppeEintrag("Volkite charger", 7));
		add(termiFK = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "option", ogE));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Power weapon", 0));
		ogE.addElement(new OptionsGruppeEintrag("Power fist", 10));
		ogE.addElement(new OptionsGruppeEintrag("Lightning claw", 10));
		ogE.addElement(new OptionsGruppeEintrag("Deathshroud power scythe", 10));
		ogE.addElement(new OptionsGruppeEintrag("Chain fist", 15));
		ogE.addElement(new OptionsGruppeEintrag("Thunder hammer", 20));
		add(termiNK = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "option", ogE));
		
		ogE.addElement(new OptionsGruppeEintrag("Pair of lightning claws", 20));
		add(o7 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "option", ogE));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Chem-Munitions", 0));
		add(o8 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "option", ogE));

		
		
		sizeSetzen();
	}

	@Override
	public void refreshen() {
		
		termiNK.setAktiv(!o7.isSelected());
		termiFK.setAktiv(!o7.isSelected());
		o8.setAktiv(termiFK.isSelected(1) && !o7.isSelected());
		
		if (!termiFK.isSelected()) {
			termiFK.setSelected(0, true);
			}
		if (!termiNK.isSelected()) {
			termiNK.setSelected(0, true);
			}
			
	}



}
