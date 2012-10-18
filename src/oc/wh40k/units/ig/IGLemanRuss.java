package oc.wh40k.units.ig;

import oc.BuildaHQ;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerVater;

public class IGLemanRuss extends RuestkammerVater {

	OptionsUpgradeGruppe o1;
	OptionsUpgradeGruppe o2;
	OptionsUpgradeGruppe o3;
	OptionsEinzelUpgrade pask;
	OptionsEinzelUpgrade oe1;
	OptionsEinzelUpgrade oe2;

	boolean paskSelected = false;

	public IGLemanRuss() {
		grundkosten = 0;
	}

  @Override
	public void initButtons(boolean... defaults) {
		add(ico = new oc.Picture("oc/wh40k/images/IGLemanRuss.jpg"));
		

		ogE.addElement(new OptionsGruppeEintrag("Leman Russ Kampfpanzer", 150));
		ogE.addElement(new OptionsGruppeEintrag("Leman Russ Exterminator", 150));
		ogE.addElement(new OptionsGruppeEintrag("Leman Russ Vernichter", 155));
		ogE.addElement(new OptionsGruppeEintrag("Leman Russ Linienbrecher", 160));
		ogE.addElement(new OptionsGruppeEintrag("Leman Russ Belagerer", 165));
		ogE.addElement(new OptionsGruppeEintrag("Leman Russ Vollstrecker", 180));
		ogE.addElement(new OptionsGruppeEintrag("Leman Russ Exekutor", 190));
		ogE.addElement(new OptionsGruppeEintrag("LR Annihilator [FW/IAA2]","Leman Russ Annihilator [Imperial Armour Apocalypse II]", 130)); //from IAA 2
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		o1.setSelected(0, true);

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Schwerer Bolter", 0));
		ogE.addElement(new OptionsGruppeEintrag("Schwerer Flamer", "Schwerer Flammenwerfer", 0));
		ogE.addElement(new OptionsGruppeEintrag("Laserkanone", 15));
		add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		o2.setSelected(0, true);

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("2 Schwere Bolter", "Paar schwere Bolter", 20));
		ogE.addElement(new OptionsGruppeEintrag("2 Schwere Flammenwerfer", "Paar schwere Flammenwerfer", 20));
		ogE.addElement(new OptionsGruppeEintrag("2 Multimelter", "Paar Multimelter", 30));
		ogE.addElement(new OptionsGruppeEintrag("2 Plasmakanonen", "Paar Plasmakanonen", 40));
		add(o3 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

		seperator();

		add(oe1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Sturmbolter", 10));
		add(oe2 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Maschinengewehr", 10));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Suchkopfrakete", 10));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Bulldozerschaufel", 10));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Zusätzliche Panzerung", 15));

		seperator();

		add(pask = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Ritter-Kommandant Pask", 50));

		sizeSetzen();
	}

  @Override
	public void refreshen() {
		if(!o1.isSelected()) o1.setSelected(0,true);
        if(!o2.isSelected()) o2.setSelected(0,true);

		oe1.setAktiv(!oe2.isSelected());
		oe2.setAktiv(!oe1.isSelected());

		// Unique entry: Commander Pask
		boolean paskGlobal = ( BuildaHQ.getCountFromInformationVector("IGPask") > 0 ? true : false );
		if(paskGlobal && !paskSelected) pask.setAktiv(false);
		else pask.setAktiv(true);

		if(pask.isSelected()) {
			paskSelected = true;
			BuildaHQ.addToInformationVector("IGPask", 1);
		} else {
			if(paskSelected) {
				paskSelected = false;
				BuildaHQ.setInformationVectorValue("IGPask", 0);
			}
		}
	}

  public void deleteYourself() {
      super.deleteYourself();
      if(pask.isSelected()) BuildaHQ.setInformationVectorValue("IGPask", 0);
  }

}
