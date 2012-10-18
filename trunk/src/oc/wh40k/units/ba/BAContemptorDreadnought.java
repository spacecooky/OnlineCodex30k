package oc.wh40k.units.ba;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class BAContemptorDreadnought extends Eintrag {

	OptionsUpgradeGruppe o1;
	OptionsUpgradeGruppe o2;

	public BAContemptorDreadnought() {
		name = "Contemptor Dreadnought";
		grundkosten = 175;

		add(ico = new oc.Picture("oc/wh40k/images/SMCybot.jpg"));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Blutfaust + Sbolter", "Blutfaust + Sturmbolter", 0));
		ogE.addElement(new OptionsGruppeEintrag("Blutfaust + SFlamer", "Blutfaust + Schwerer Flammenwerfer", 10));
		ogE.addElement(new OptionsGruppeEintrag("Blutfaust + Melter", 15));
		ogE.addElement(new OptionsGruppeEintrag("Blutklaue + Sbolter", "Blutklaue + Sturmbolter", 0));
		ogE.addElement(new OptionsGruppeEintrag("Blutklaue + SFlamer", "Blutklaue + Schwerer Flammenwerfer", 10));
		ogE.addElement(new OptionsGruppeEintrag("Blutklaue + Melter", 15));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Blutfaust + Sbolter", "Blutfaust + Sturmbolter", 0));
		ogE.addElement(new OptionsGruppeEintrag("Blutfaust + SFlamer", "Blutfaust + Schwerer Flammenwerfer", 10));
		ogE.addElement(new OptionsGruppeEintrag("Blutfaust + Melter", 15));
		ogE.addElement(new OptionsGruppeEintrag("Blutklaue + Sbolter", "Blutklaue + Sturmbolter", 0));
		ogE.addElement(new OptionsGruppeEintrag("Blutklaue + SFlamer", "Blutklaue + Schwerer Flammenwerfer", 10));
		ogE.addElement(new OptionsGruppeEintrag("Blutklaue + Melter", 15));
		ogE.addElement(new OptionsGruppeEintrag("Sync. Schwerer Bolter", "Synchronisierter Schwerer Bolter", 0));
		ogE.addElement(new OptionsGruppeEintrag("Sync. Schwerer Flamer", "Synchronisierter Schwerer Flammenwerfer", 0));
		ogE.addElement(new OptionsGruppeEintrag("Multimelter", 0));
		ogE.addElement(new OptionsGruppeEintrag("Frag Cannon", 0));
		ogE.addElement(new OptionsGruppeEintrag("Sync. Maschinenkanone", "Synchronisierte Maschinenkanone", 5));
		ogE.addElement(new OptionsGruppeEintrag("Plasmakanone", 10));
		ogE.addElement(new OptionsGruppeEintrag("Kheres Assault Cannon", "Kheres Pattern Assault Cannon", 15));
		ogE.addElement(new OptionsGruppeEintrag("Sync. Laserkanone", "Synchronisierte Laserkanone", 25));
		add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

		seperator();

		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Zusätzliche Panzerung", 15));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Suchscheinwerfer", 1));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Magna-Greifer", 15));

		complete();
	}

	@Override
	public void refreshen() {
                o1.alwaysSelected();
                o2.alwaysSelected();
                
                o1.setAktiv("Blutfaust + Melter", o1.isSelected("Blutfaust + Melter") || !o2.isSelected("Blutfaust + Melter") && !o2.isSelected("Blutklaue + Melter"));
                o1.setAktiv("Blutklaue + Melter", o1.isSelected("Blutklaue + Melter") || !o2.isSelected("Blutfaust + Melter") && !o2.isSelected("Blutklaue + Melter"));
                o2.setAktiv("Blutfaust + Melter", o2.isSelected("Blutfaust + Melter") || !o1.isSelected("Blutfaust + Melter") && !o1.isSelected("Blutklaue + Melter"));
                o2.setAktiv("Blutklaue + Melter", o2.isSelected("Blutklaue + Melter") || !o1.isSelected("Blutfaust + Melter") && !o1.isSelected("Blutklaue + Melter"));
	}
	
}
