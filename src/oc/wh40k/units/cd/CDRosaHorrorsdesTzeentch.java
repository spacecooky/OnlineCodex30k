package oc.wh40k.units.cd;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.RefreshListener;

public class CDRosaHorrorsdesTzeentch extends Eintrag {

	AnzahlPanel CDRosaHorrorsdesTzeentch;
	OptionsEinzelUpgrade Wechselbalg;

	boolean WechselbalgSelected = false;

	public CDRosaHorrorsdesTzeentch() {

		name = "Rosa Horrors des Tzeentch";

		grundkosten = 0;

		CDRosaHorrorsdesTzeentch = new AnzahlPanel(ID, randAbstand, cnt, "Rosa Horrors des Tzeentch", 5, 20, 17);
		add(CDRosaHorrorsdesTzeentch);
		add(ico = new oc.Picture("oc/wh40k/images/CDRosaHorrorsdesTzeentch.gif"));

		seperator();

		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Blitz des Tzeentch", 10));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Chaosikone", 25));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Instrument des Chaos", 5));
		add(Wechselbalg = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Der Wechselbalg", 5));

		seperator();

        BuildaHQ.getChooserGruppe(1).addSpezialAuswahl("[Forgeworld] Aetaos'rau'keres - Slayer of Souls");

		complete();

	}

	public void deleteYourself() {  // WICHTIG: wird nicht beim Volkwechseln ausgeführt. Dafür wird BuildaHQ.leereChooserGruppenArray(); aufgerufen, was das ersetzt

        BuildaHQ.getChooserGruppe(1).removeSpezialAuswahl("[Forgeworld] Aetaos'rau'keres - Slayer of Souls");

		if (WechselbalgSelected) {
			BuildaHQ.addToInformationVector("CDWechselbalg", -1);
		}

		super.deleteYourself();

	}

	@Override
	public void refreshen() {
		
		// Unique entry: Wechselbalg
		if (WechselbalgSelected != Wechselbalg.isSelected()) {
			WechselbalgSelected = !WechselbalgSelected;

			if (WechselbalgSelected) {
				BuildaHQ.addToInformationVector("CDWechselbalg", 1);
			} else {
				BuildaHQ.addToInformationVector("CDWechselbalg", -1);
			}
			RefreshListener.fireRefresh();
		}
					
		Wechselbalg.setLegal(BuildaHQ.getCountFromInformationVector("CDWechselbalg") < 2 || !Wechselbalg.isSelected());
		
	}
}
