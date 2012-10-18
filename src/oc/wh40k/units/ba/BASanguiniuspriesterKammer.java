package oc.wh40k.units.ba;

import oc.BuildaHQ;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RefreshListener;
import oc.RuestkammerVater;

public class BASanguiniuspriesterKammer extends RuestkammerVater {

	OptionsEinzelUpgrade corbulo;
	OptionsEinzelUpgrade termi;
	OptionsEinzelUpgrade mb;
	OptionsUpgradeGruppe o1;
	OptionsUpgradeGruppe o2;
	OptionsUpgradeGruppe o3;

	boolean added = false;

	public BASanguiniuspriesterKammer() {
		grundkosten = 50;
	}

	public void initButtons(boolean... defaults) {
		add(corbulo = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Bruder Corbulo", "Upgrade zu Bruder Corbulo", 55));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Sturmbolter", 3));
		ogE.addElement(new OptionsGruppeEintrag("Flammenpistole", 10));
		ogE.addElement(new OptionsGruppeEintrag("Kombi-Flamer", 10));
		ogE.addElement(new OptionsGruppeEintrag("Kombi-Melter", 10));
		ogE.addElement(new OptionsGruppeEintrag("Kombi-Plasmawerfer", 10));
		ogE.addElement(new OptionsGruppeEintrag("Plasma-Pistole", 15));
		ogE.addElement(new OptionsGruppeEintrag("Infernus-Pistole", 15));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Energiewaffe", 15));
		ogE.addElement(new OptionsGruppeEintrag("Energieklaue", 15));
		ogE.addElement(new OptionsGruppeEintrag("Energiefaust", 25));
		add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

		seperator();

		add(termi = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Terminator-Rüstung", "Terminator-Rüstung, Energiewaffe, Blutkelch", 35));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Sprungmodul", 25));
		ogE.addElement(new OptionsGruppeEintrag("Space Marine Bike", 35));
		add(o3 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

		seperator();

		add(mb = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Melterbomben", 5));

		sizeSetzen();
	}

	@Override
	public void refreshen() {
		o1.setAktiv(!corbulo.isSelected() && !termi.isSelected());
		o2.setAktiv(!corbulo.isSelected() && !termi.isSelected());
		o3.setAktiv(!corbulo.isSelected() && !termi.isSelected());
		mb.setAktiv(!corbulo.isSelected());
		termi.setAktiv(!corbulo.isSelected());

		if (!added && corbulo.isSelected()) {
			BuildaHQ.addToInformationVector("BACorbulo", 1);
			added = true;
			RefreshListener.fireRefresh();
		} else if (added && !corbulo.isSelected()) {
			BuildaHQ.addToInformationVector("BACorbulo", -1);
			added = false;
			RefreshListener.fireRefresh();
		}

		boolean corbuloCheck = BuildaHQ.getCountFromInformationVector("BACorbulo") < 2;
		corbulo.setLegal(corbuloCheck);
		setButtonState(corbuloCheck);
	}

}
