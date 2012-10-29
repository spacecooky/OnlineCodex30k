package oc.wh30k.units.dg;

import java.util.Vector;

import oc.BuildaHQ;
import oc.Chooser;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerStarter;

public class DGApothecary extends Eintrag {

	OptionsUpgradeGruppe o1, o2, o3;

	boolean added = false;

	public DGApothecary() {
		name = "Apothecary";
		grundkosten = 45;

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Chainsword", 0));
		ogE.addElement(new OptionsGruppeEintrag("Power sword", 15));;
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		
		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Augury scanner", 5));
		ogE.addElement(new OptionsGruppeEintrag("Combi-weapon", 10));
		ogE.addElement(new OptionsGruppeEintrag("Volkite charger", 10));
		add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		
		seperator();
		
		ogE.addElement(new OptionsGruppeEintrag("Artificer armour", 10));
		add(o3 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		
		complete();
	}

	@Override
	public void refreshen() {
		setEintragsCNT(this.calculateEntryCount());

		if (!o1.isSelected()) o1.setSelected(0, true);
		
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
			if(chooser.getEintrag() instanceof DGApothecary) {
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
