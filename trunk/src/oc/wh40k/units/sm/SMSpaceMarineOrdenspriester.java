package oc.wh40k.units.sm;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OnlineCodex;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class SMSpaceMarineOrdenspriester extends Eintrag {

	OptionsUpgradeGruppe o1;
	OptionsEinzelUpgrade termi;
	OptionsUpgradeGruppe o2;
	OptionsUpgradeGruppe t1;

	public SMSpaceMarineOrdenspriester() {
		name = "Space Marine Ordenspriester";
		grundkosten = 100;

		add(ico = new oc.Picture("oc/wh40k/images/SMSpaceMarineOrdenspriester.jpg"));
		
		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Sturmbolter", 3));
		ogE.addElement(new OptionsGruppeEintrag("Kombi-Flamer", 15));
		ogE.addElement(new OptionsGruppeEintrag("Kombi-Melter", 15));
		ogE.addElement(new OptionsGruppeEintrag("Kombi-Plasmawerfer", 15));
		ogE.addElement(new OptionsGruppeEintrag("Energiefaust", 15));
		ogE.addElement(new OptionsGruppeEintrag("Plasma-Pistole", 15));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Sprungmodul", 15));
		if(!OnlineCodex.getInstance().isCurrentArmy(oc.wh40k.armies.VOLKSiegeVanguardIA10.class)) {
                    ogE.addElement(new OptionsGruppeEintrag("Space Marine Bike", 35));
                }
		add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

		seperator();

		add(termi = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Terminator-Rüstung", 30));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Kombi-Flamer", 5));
		ogE.addElement(new OptionsGruppeEintrag("Kombi-Melter", 5));
		ogE.addElement(new OptionsGruppeEintrag("Kombi-Plasmawerfer", 5));
		add(t1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "option", ogE));

		seperator();

		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Melterbomben", 5));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Digitalwaffen", 10));

		complete();
	}

	@Override
	public void refreshen() {
		o1.setAktiv(!termi.isSelected());
		o2.setAktiv(!termi.isSelected());
		t1.setAktiv(termi.isSelected());
	}

}
