package oc.wh40k.units.ba;

import java.util.Vector;

import oc.BuildaHQ;
import oc.Chooser;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class BASanguiniuspriester extends Eintrag {

	OptionsEinzelUpgrade termi;
	OptionsEinzelUpgrade mb;
	OptionsUpgradeGruppe o1;
	OptionsUpgradeGruppe o2;
	OptionsUpgradeGruppe o3;

	boolean added = false;

	public BASanguiniuspriester() {
		name = "Sanguiniuspriester";
		grundkosten = 50;

		add(ico = new oc.Picture("oc/wh40k/images/BASanguiniuspriester.jpg"));

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

		add(termi = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Terminator-Rüstung", "Terminator-Rüstung und Energiewaffe", 35));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Sprungmodul", 25));
		ogE.addElement(new OptionsGruppeEintrag("Space Marine Bike", 35));
		add(o3 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

		seperator();

		add(mb = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Melterbomben", 5));

		complete();
	}

	@Override
	public void refreshen() {
		setEintragsCNT(this.calculateEntryCount());

		o1.setAktiv(!termi.isSelected());
		o2.setAktiv(!termi.isSelected());
		o3.setAktiv(!termi.isSelected());
	}

	@Override
	public void deleteYourself() {
		super.deleteYourself();
	}

	/**
	 * eintragsCNT berechnen
	 * @return eintragsCNT
	 */
	private double calculateEntryCount() {
		double count = 0.0;
		Vector<Chooser> allChooser = BuildaHQ.getChooserGruppe(2).getmC();
		for(Chooser chooser : allChooser) {
			if(chooser.getEintrag() instanceof BASanguiniuspriester || chooser.getEintrag() instanceof BABruderCorbulo) {
				count += 1;
			}
		}

		// merhfache von 3 beachten
		double adder = 1.0;
		double checkCount = count;
		while(checkCount > 3) {
			checkCount = checkCount - 3.0;
			adder++;
		}
		
		return adder / (count == 0.0 ? 1.0 : count);
	}

}
