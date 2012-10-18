package oc.wh40k.units.ty;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class TYTervigon extends Eintrag {

	OptionsUpgradeGruppe o1;
	OptionsUpgradeGruppe o2;
	OptionsUpgradeGruppe o3;
	OptionsUpgradeGruppe o4;

	private boolean initDone = false;

	public TYTervigon() {
		name = "Tervigon";
		grundkosten = 160;

		add(ico = new oc.Picture("oc/wh40k/images/TYTervigon.jpg"));
		

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Sensenklauen", 5));
		ogE.addElement(new OptionsGruppeEintrag("Scherenklauen", 25));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

		seperator();

		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Adrenalindrüsen", 10));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Toxinkammern", 10));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Säureblut", 15));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Injektor", 15));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Toxisches Miasma", 15));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Regeneration", 30));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Stachelsalve", 0));
		ogE.addElement(new OptionsGruppeEintrag("Stachelhagel", 0));
		add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		o2.setSelected(0, true);

		seperator();

		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Katalyst", 15));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Aufpeitschen", 15));

		complete();
	}

	private void checkKategorie() {
		if(getKategorie() == 3) {
			BuildaHQ.addToInformationVector("TYTervigon", 1);
		}
		initDone = true;
	}

	@Override
	public void refreshen() {
		if(!o2.isSelected())
			o2.setSelected(0, true);

		// Work-around, since the kategory information is only available
		// *after* the first call of refreshen()
		if(!initDone && getKategorie() != 0) {
			checkKategorie();
		}

		if(getKategorie() == 3) {
			int ganten = BuildaHQ.getCountFromInformationVector("TYTermaganten");
			int tervigon = BuildaHQ.getCountFromInformationVector("TYTervigon");
			if(tervigon > ganten) {
				setFehlermeldung("Max. " + ganten + " Einheiten!");
			} else {
				setFehlermeldung("");
			}
		}
	}

	@Override
	public void deleteYourself() {
		super.deleteYourself();

		// Only if unit is selected as core
		if(getKategorie() == 3) {
			BuildaHQ.addToInformationVector("TYTervigon", -1);
		}
	}

}
