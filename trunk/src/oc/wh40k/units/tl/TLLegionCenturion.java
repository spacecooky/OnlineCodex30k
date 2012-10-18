package oc.wh40k.units.tl;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class TLLegionCenturion extends Eintrag {

	OptionsEinzelUpgrade boltgun;
	OptionsEinzelUpgrade boltpistol;
	
	OptionsUpgradeGruppe o1;

	public TLLegionCenturion() {
		name = "Legion Centurion";
		grundkosten = 55;

		
		add(ico = new oc.Picture("oc/wh40k/images/TLLegionCenturion.gif"));

		add(boltgun = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Boltgun", 0));
		add(boltpistol = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Boltpistol", 0));
		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Chainsword", 0));
		ogE.addElement(new OptionsGruppeEintrag("Combat Shield", 5));
		ogE.addElement(new OptionsGruppeEintrag("Storm Bolter", 5));
		ogE.addElement(new OptionsGruppeEintrag("Combi Melta", 10));
		ogE.addElement(new OptionsGruppeEintrag("Combi Plasma", 10));
		ogE.addElement(new OptionsGruppeEintrag("Combi Flamer", 10));
		ogE.addElement(new OptionsGruppeEintrag("Plasma Pistol", 15));
		ogE.addElement(new OptionsGruppeEintrag("Power Weapon", 15));
		ogE.addElement(new OptionsGruppeEintrag("Power Fist", 25));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

		seperator();

		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Melta Bombs", 5));
		
		complete();
	}

	@Override
	public void refreshen() {
		boltgun.setAktiv(!(boltpistol.isSelected() && o1.isSelected()));
		boltpistol.setAktiv(!(boltgun.isSelected() && o1.isSelected()));
		o1.setAktiv(!(boltpistol.isSelected() && boltgun.isSelected()));
		
		boltgun.setLegal(boltgun.isSelected());
		boltpistol.setLegal(boltpistol.isSelected());
		o1.setLegal(o1.isSelected());
	}

}
