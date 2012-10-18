package oc.wh40k.units.tl;

import oc.BuildaHQ;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerVater;

public class TLAssaultAircraft extends RuestkammerVater {

	OptionsUpgradeGruppe o1;
	
	OptionsEinzelUpgrade oe1;
	OptionsEinzelUpgrade oe2;
	OptionsEinzelUpgrade oe3;
	OptionsEinzelUpgrade oe4;
	
	OptionsUpgradeGruppe o2;
	
	OptionsUpgradeGruppe o3;
	
	OptionsUpgradeGruppe o4;
	
	OptionsEinzelUpgrade oe5;

	boolean paskSelected = false;

	public TLAssaultAircraft() {
		grundkosten = 0;
	}

  @Override
	public void initButtons(boolean... defaults) {
		add(ico = new oc.Picture("oc/wh40k/images/TLSiegeDefence.jpg"));
		

		ogE.addElement(new OptionsGruppeEintrag("Thunderbolt Fighter", 180));
		ogE.addElement(new OptionsGruppeEintrag("Lightning Fighter", 145));
		ogE.addElement(new OptionsGruppeEintrag("Vulture Gunship", 105));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		o1.setSelected(0, true);

		seperator();
		
		add(oe1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "4 Hellstrike missiles", 40));
		add(oe2 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "4 Bombs", 40));
		add(oe3 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "4 Hellfury missiles", 40));
		add(oe4 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "6 Skystrike missiles", 50));
		
		seperator();
		
		ogE.addElement(new OptionsGruppeEintrag("Autocannon", 0));
		ogE.addElement(new OptionsGruppeEintrag("2 Hellstrike missiles", 0));
		ogE.addElement(new OptionsGruppeEintrag("2 Bombs", 0));
		add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		o2.setAktiv(false);
		
		seperator();
		
		ogE.addElement(new OptionsGruppeEintrag("TL multilaser", 0));
		ogE.addElement(new OptionsGruppeEintrag("TL autocannon", 0));
		ogE.addElement(new OptionsGruppeEintrag("TL missile launchers", 10));
		ogE.addElement(new OptionsGruppeEintrag("TL lascannon", 20));
		ogE.addElement(new OptionsGruppeEintrag("2 multiple rocket pods", 20));
		add(o3 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		o3.setAktiv(false);
		
		seperator();
		
		ogE.addElement(new OptionsGruppeEintrag("2 Hellstrike missiles", 0));
		ogE.addElement(new OptionsGruppeEintrag("2 Hellfury missiles", 20));
		ogE.addElement(new OptionsGruppeEintrag("6 Bombs", 60));
		ogE.addElement(new OptionsGruppeEintrag("6 Hunter-killer missiles", 40));
		ogE.addElement(new OptionsGruppeEintrag("2 multiple rocket pods", 30));
		add(o4 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		o4.setAktiv(false);
		
		seperator();
		
		add(oe5 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "TL punisher cannon", 50));
		oe5.setAktiv(false);
		
		seperator();

		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Flare/Chaff launcher", 10));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Armoured cockpit", 20));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Illum flares", 5));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Infra-red targeting", 10));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Dist. paint scheme/decals","Distinctive paint scheme/decals", 10));
		
		
		sizeSetzen();
	}

  @Override
	public void refreshen() {
		if(!o1.isSelected()) o1.setSelected(0,true);

		oe1.setAktiv(o1.getSelectedIndex()==0 || o1.getSelectedIndex()==1);
		oe2.setAktiv(o1.getSelectedIndex()==0 || o1.getSelectedIndex()==1);
		oe3.setAktiv(o1.getSelectedIndex()==0 || o1.getSelectedIndex()==1);
		oe4.setAktiv(o1.getSelectedIndex()==0 || o1.getSelectedIndex()==1);
		
		o2.setAktiv(o1.getSelectedIndex()==1);
		if(!o2.isSelected()) o2.setSelected(0,true);
		
		o3.setAktiv(o1.getSelectedIndex()==2 && !oe5.isSelected());
		if(!o3.isSelected()) o3.setSelected(0,true);
		
		o4.setAktiv(o1.getSelectedIndex()==2 && !oe5.isSelected());
		if(!o4.isSelected()) o4.setSelected(0,true);
		
		oe5.setAktiv(o1.getSelectedIndex()==2);
	}
}
