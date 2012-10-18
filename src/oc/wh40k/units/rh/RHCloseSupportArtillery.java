package oc.wh40k.units.rh;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsEinzelZaehler;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class RHCloseSupportArtillery extends Eintrag {

	OptionsUpgradeGruppe o1;
	OptionsUpgradeGruppe o2;
	OptionsUpgradeGruppe o3;
	OptionsEinzelUpgrade oe1;
	OptionsEinzelUpgrade oe2;
	OptionsEinzelUpgrade oe3;
	OptionsEinzelUpgrade oe4;
	OptionsEinzelUpgrade oe5;
	OptionsEinzelUpgrade oe6;
	OptionsEinzelUpgrade oe7;
	OptionsEinzelUpgrade oe8;

	boolean paskSelected = false;

	public RHCloseSupportArtillery() {
		grundkosten = 0;
		name = "Close Support Artillery";
		überschriftSetzen=true;
	
		add(ico = new oc.Picture("oc/wh40k/images/RHCloseSupportArtillery.jpg"));
		

		ogE.addElement(new OptionsGruppeEintrag("Basilisk", 125));
		ogE.addElement(new OptionsGruppeEintrag("Medusa", 135));
		ogE.addElement(new OptionsGruppeEintrag("Griffon", 75));
		ogE.addElement(new OptionsGruppeEintrag("Manticore", 160));
		ogE.addElement(new OptionsGruppeEintrag("Hydra", 75));
		ogE.addElement(new OptionsGruppeEintrag("Bombard [IA3]", 145));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		o1.setSelected(0, true);

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Heavy bolter", 0));
		ogE.addElement(new OptionsGruppeEintrag("Heavy flamer", 0));
		add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		o2.setSelected(0, true);

		seperator();

		add(oe4 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Enclosed crew compartment", 15));
		add(oe1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Storm bolter", 10));
		add(oe2 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Heavy stubber", 10));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Hunter-killer missile", 10));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Dozer blade", 10));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Extra armour", 15));
		add(oe3 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Bastion breacher shells", 5));
		add(oe5 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Siege shells", 10)); 
		add(oe6 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Camo netting", 30)); 
		add(oe7 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Search lights", 1)); 
		add(oe8 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Smoke launcher",5));
		
		complete();
	}

	// @OVERRIDE
	public void refreshen() {
        if(!o1.isSelected()) o1.setSelected(0,true);
        if(!o2.isSelected()) o2.setSelected(0,true);
		
		oe1.setAktiv(!oe2.isSelected());
		oe2.setAktiv(!oe1.isSelected());
		oe3.setAktiv(o1.isSelected("Medusa"));
		oe4.setAktiv(o1.isSelected("Medusa") || o1.isSelected("Basilisk") || o1.isSelected("Griffon"));
		oe5.setAktiv(o1.isSelected("Bombard [IA3]"));
		oe7.setAktiv(o1.isSelected("Bombard [IA3]"));
		oe8.setAktiv(o1.isSelected("Bombard [IA3]"));
		oe6.setPreis(o1.isSelected("Hydra") ? 20 : 30);
	}

}
